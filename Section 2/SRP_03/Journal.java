package SRP_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

	
	
	public class Journal // My personal thoughts
	{
		private final List<String> entries = new ArrayList<>();
		private static int count = 0;
		
		//Adding and removing 1.
		public void addEntry(String text)
		{
			entries.add("" + (++count) + ": " + text);
		}
		
		public void removeEntry(int index)
		{
			entries.remove(index);
		}
		
		@Override
		public String toString() {
			return String.join(System.lineSeparator(), entries);
		}
		
		
		//Persisting Journal and loading 2.
		public void save(String filename) throws FileNotFoundException
		{
			try (PrintStream out = new PrintStream(filename))
			{
				out.println(toString());
			}
		}
		
		public void load(String filename) {}
		public void load(URL url) {}
	}
	
	
	
	class Persistence // For serializing to file
	{
		public void saveToFile(Journal journal,
				String filename,
				boolean overwrite) throws FileNotFoundException {
			
			if (overwrite || new File(filename).exists()) {
				try (PrintStream out = new PrintStream(filename))
				{
					out.println(toString());
				}
			}
		}
//		We could separate concerns like such
//		public Journal load(String filename) {}
//		public Journal load(URL url) {}
//		Commented for it will compile
	}

	
	
	class Demo
	{
		public static void main(String[] args) throws Exception {
			Journal j = new Journal();
			    j.addEntry("I cried today");
			    j.addEntry("I ate a bug");
			    System.out.println(j);

			    Persistence p = new Persistence();
			    String filename = "c:\\temp\\journal.txt";
			    p.saveToFile(j, filename, true);

			    // windows!
			    Runtime.getRuntime().exec("notepad.exe " + filename);
			
		}
		
	}
