## Section 2: SOLID Design Principles

SOLID Design Principles

# What I Learned

### SRP (Single Responsibility Principle)

- Single class should have **one** responsibility

- When printing object we will connect every entry!

```
		@Override
		public String toString() {
			return String.join(System.lineSeparator(), entries);
		}
```

- Class following **Single Responsibility Principle**
```
public class Journal // My personal thoughts
	{
		private final List<String> entries = new ArrayList<>();
		private static int count = 0;
		
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
	}
	
	
	class Demo
	{
		public static void main(String[] args) {
			Journal j = new Journal();
			j.addEntry("I cried today");
			j.addEntry("I ate a bug");
			System.out.println(j);
			
		}
		
	}
```

- Now this same class has **two concerns**
1. **Adding** and **Removing** entries
2. **Persisting Journal** and **Loading** 

```
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
```

- This breaks the rule for **Single Responsibility Rule!**
    - We call this we have another **concern!**

- If in other hand class has many **concerns!** we call this **GOD OBJECT**

<img src="godObject.jpg" alt="alt text" width="400"/>

- [God Object](https://en.wikipedia.org/wiki/God_object)

- [Single-responsibility principle](https://en.wikipedia.org/wiki/Single-responsibility_principle)


- God object is VERY hard to **refactor** later on or **manage**

Here is working version which would fit **Single Responsibility Principle**

```
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
//		Commented for it would not compile
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
```

### Open-Closed Principle (OCP)