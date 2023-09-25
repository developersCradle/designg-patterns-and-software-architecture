package SRP_03;

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
	
	
	class Demo
	{
		public static void main(String[] args) throws Exception {
			Journal j = new Journal();
			j.addEntry("I cried today");
			j.addEntry("I ate a bug");
			System.out.println(j);
			
		}
		
	}
