## Section 2: SOLID Design Principles.

SOLID Design Principles.

# What I Learned.

# 2. Overview.

- This course will be referring following books.
	
<img src="booksWhichWeAreBeUsing.PNG" alt="alt text" width="400"/>


# 3. Single Responsibility Principle (SRP)

- Single class should have **one** responsibility.

- When printing object we will connect every entry!

```
		@Override
		public String toString() {
			return String.join(System.lineSeparator(), entries);
		}
```

- Class following **Single Responsibility Principle**.

```
package SRP_02;

import java.util.ArrayList;
import java.util.List;

public class Journal // My personal thoughts
	{
	
	public static void main(String[] args) {
		Demo.main(args); 
	}
	
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

- Now this same class has **two concerns**.
1. **Adding** and **Removing** entries.
2. **Persisting Journal** and **Loading**. 

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

- If **in other hand** class has many **concerns!** We call this **GOD OBJECT**.

<img src="godObject.jpg" alt="alt text" width="400"/>
	
- [God Object](https://en.wikipedia.org/wiki/God_object).

- [Single-responsibility principle](https://en.wikipedia.org/wiki/Single-responsibility_principle).

- God object is VERY hard to **refactor** later on or **manage**.

Here is working version which would fit **Single Responsibility Principle**.

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

### Open-Closed Principle (OCP).

- We are implementing **OCP** with lens of Specification design pattern.
	- OCP + **Specification**(from Enterprise Engineering, not from **Gang of Four**) this design patterns.

- [Enterprise Engineering](https://en.wikipedia.org/wiki/Enterprise_engineering).

- Example of OCP principle.

```

public class AmazonWebStore {

	// Criterias for filttering in our AmazonWebStore
	
	enum Color
	{
		RED, GREEN, BLUE
	}
	enum Size {
		SMALL, MEDIUM, LARGE, YUGE
	}
	
	static class Product
	{
		public String name;
		public Color color;
		public Size size;
		
		
		public Product(String name, Color color, Size size)
		{
			this.name = name;
			this.color = color;
			this.size = size;
		}
	}
	 
	static class ProductFilter //Filter
	{
		
		// You can use lists or stream, you can choose
		public Stream<Product> filterByColor(List<Product> products,
				Color color) //Product of filter API
		{
			return products.stream().filter(p -> p.color == color);
		}
		
		// Manager comes in and asks to add filter by size you would need to write extra filter logic
		public Stream<Product> filterBySize(List<Product> products,
				Size size) //Product of filter API
		{
			return products.stream().filter(p -> p.size == size);
		}
		
		public Stream<Product> filterBySizeAndColor(
				List<Product> products,
				Size size,
				Color color)
		{
			return products.stream().filter(p -> p.size == size
					&& p.color == color);
		}
	}
	
	class Demo
	{
		public static void main(String[] args) {
			
			Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
			Product tree =  new Product("Tree", Color.GREEN, Size.LARGE);
			Product house = new Product("House", Color.BLUE, Size.LARGE);
			
			List<Product> products = List.of(apple, tree, house);
			
			ProductFilter pf = new ProductFilter();
			System.out.println("Green products (old): ");
			pf.filterByColor(products, Color.GREEN)
			.forEach(p -> System.out.println(
					" - " + p.name + " is green"));
		}
	}
}
```

- Here we are using old product filter.

- This is fine if you want to filter by **color** and **size** only. As soon manager wants more **filtering criteria** it will be harder since it's been tested, and we need to add new functionality to old class, which is violation **OCP**.

- Open close principle is open for extension and closed for modification.

```
package OCP_04;

import java.util.List;
import java.util.stream.Stream;

public class AmazonWebStore {

	// Criteria for filtering in our AmazonWebStore
	
	enum Color
	{
		RED, GREEN, BLUE
	}
	enum Size {
		SMALL, MEDIUM, LARGE, YUGE
	}
	
	static class Product
	{
		public String name;
		public Color color;
		public Size size;
		
		
		public Product(String name, Color color, Size size)
		{
			this.name = name;
			this.color = color;
			this.size = size;
		}
	}
	 
	static class ProductFilter// Filter
	{
		
		// You can use lists or stream, you can choose
		public Stream<Product> filterByColor(List<Product> products,
				Color color) //Product of filter API
		{
			return products.stream().filter(p -> p.color == color);
		}
		
		// Manager comes in and asks to add filter by size you would need to write extra filter logic
		public Stream<Product> filterBySize(List<Product> products,
				Size size) //Product of filter API
		{
			return products.stream().filter(p -> p.size == size);
		}
		
		public Stream<Product> filterBySizeAndColor(
				List<Product> products,
				Size size,
				Color color)
		{
			return products.stream().filter(p -> p.size == size
					&& p.color == color);
		}
	}
	
	interface Specification<T>
	{
		boolean isSatisfied(T item); // Return boolean if certain product satisfied criteria. T can be anything not needed to be product
	}
	
	interface Filter<T> //We can work with anything, but our case T will be product 
	{
		Stream<T> filter(List<T> items, Specification<T> spec); //List of items, with list of Specification<T> spec which we can filter with 
	}

	
	// We are using better filter
	static class BetterFilter implements Filter<Product>
	{

		@Override
		public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
			return items.stream().filter(p -> spec.isSatisfied(p));
		}
	}
	
	
	
	
	//With this approach we would do color specification
	static class ColorSpesification implements Specification<Product>
	{
		private Color color; // We will satisfy this color
		
		public ColorSpesification(Color color) {
			this.color = color;
		}
		
		@Override
		public boolean isSatisfied(Product item) {
			return item.color == color;
		}
		
	}
	
	// Same with size filtering with size
	class SizeSpesification implements Specification<Product>
	{
		private Size size;
			
		public SizeSpesification(Size size) {
			this.size = size;
		}
			
		@Override
		public boolean isSatisfied(Product item) {
			return item.size == size;
		}
			
	}
		
	
	
	class Demo
	{
		public static void main(String[] args) {
			
			Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
			Product tree =  new Product("Tree", Color.GREEN, Size.LARGE);
			Product house = new Product("House", Color.BLUE, Size.LARGE);
			
			List<Product> products = List.of(apple, tree, house);
			
			ProductFilter pf = new ProductFilter();
			System.out.println("Green products (old): ");
			pf.filterByColor(products, Color.GREEN)
			.forEach(p -> System.out.println(
					" - " + p.name + " is green"));
		
			
			
			// We are using better filter
			BetterFilter bf = new BetterFilter();
			System.out.println("Green products (new):");
			bf.filter(products, new ColorSpesification(Color.GREEN))
			.forEach(p -> System.out.println(
					" - " + p.name + " is green"));
			
		}
	}
}

```

- We are using combination using specification which combines two specification together.

- [Combination](https://www.freecodecamp.org/news/permutation-and-combination-the-difference-explained-with-formula-examples/).

- Last working solution for **OCP**.

```
package OCP_04;

import java.util.List;
import java.util.stream.Stream;

public class AmazonWebStore {

	// Criteria for filtering in our AmazonWebStore
	
	enum Color
	{
		RED, GREEN, BLUE
	}
	enum Size {
		SMALL, MEDIUM, LARGE, YUGE
	}
	
	static class Product
	{
		public String name;
		public Color color;
		public Size size;
		
		
		public Product(String name, Color color, Size size)
		{
			this.name = name;
			this.color = color;
			this.size = size;
		}
	}
	 
	static class ProductFilter// Filter
	{
		
		// You can use lists or stream, you can choose
		public Stream<Product> filterByColor(List<Product> products,
				Color color) //Product of filter API
		{
			return products.stream().filter(p -> p.color == color);
		}
		
		// Manager comes in and asks to add filter by size you would need to write extra filter logic
		public Stream<Product> filterBySize(List<Product> products,
				Size size) //Product of filter API
		{
			return products.stream().filter(p -> p.size == size);
		}
		
		public Stream<Product> filterBySizeAndColor(
				List<Product> products,
				Size size,
				Color color)
		{
			return products.stream().filter(p -> p.size == size
					&& p.color == color);
		}
	}
	
	interface Specification<T>
	{
		boolean isSatisfied(T item); // Return boolean if certain product satisfied criteria. T can be anything not needed to be product
	}
	
	interface Filter<T> //We can work with anything, but our case T will be product 
	{
		Stream<T> filter(List<T> items, Specification<T> spec); //List of items, with list of Specification<T> spec which we can filter with 
	}

	
	// We are using better filter
	static class BetterFilter implements Filter<Product>
	{

		@Override
		public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
			return items.stream().filter(p -> spec.isSatisfied(p));
		}
	}
	
	
	
	
	//With this approach we would do color specification
	static class ColorSpesification implements Specification<Product>
	{
		private Color color; // We will satisfy this color
		
		public ColorSpesification(Color color) {
			this.color = color;
		}
		
		@Override
		public boolean isSatisfied(Product item) {
			return item.color == color;
		}
		
	}
	
	// Same with size filtering with size
	static class SizeSpesification implements Specification<Product>
	{
		private Size size;
			
		public SizeSpesification(Size size) {
			this.size = size;
		}
			
		@Override
		public boolean isSatisfied(Product item) {
			return item.size == size;
		}
			
	}
		
	static class AndSpesification<T> implements Specification<T> //Combinator to satisfy both
	{
		
		private Specification<T> first, second; //For both needs to be satisfied
		
		
		public AndSpesification(Specification<T> first, Specification<T> second) {
			this.first = first;
			this.second = second;
		}
		

		@Override
		public boolean isSatisfied(T item) {
			return first.isSatisfied(item) && second.isSatisfied(item);
		} // Now changed to satisfy both conditions
		

		
		
	}
	
	
	class Demo
	{
		public static void main(String[] args) {
			
			Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
			Product tree =  new Product("Tree", Color.GREEN, Size.LARGE);
			Product house = new Product("House", Color.BLUE, Size.LARGE); // This will satisfy last filtering
			
			List<Product> products = List.of(apple, tree, house);
			
			ProductFilter pf = new ProductFilter();
			System.out.println("Green products (old): ");
			pf.filterByColor(products, Color.GREEN)
			.forEach(p -> System.out.println(
					" - " + p.name + " is green"));
		
			
			
			// We are using better filter
			BetterFilter bf = new BetterFilter();
			System.out.println("Green products (new):");
			bf.filter(products, new ColorSpesification(Color.GREEN))
			.forEach(p -> System.out.println(
					" - " + p.name + " is green"));
			
			
			
			System.out.println("Large blue items:");
			bf.filter(products, 
					new AndSpesification<>(
							new ColorSpesification(Color.BLUE),
							new SizeSpesification(Size.LARGE)
					))
			.forEach(p -> System.out.println(
					" - " + p.name + " is large and blue"));
		}
	}
}

```

- **OCP** Is Open for **extension** and closed for **modification**.
- We will promise **not** modify `BetterFilter` and promise we will only **extend** functionality.

- In our context it means:
	**Closed for modifications:** We will not modify in any way `BetterFilter` after its done, tested and could be shipped to production.
	**Open for extension:** We are free to inherit or extends interfaces. If we want to extend functionality we can use our interfaces to do that.


```
	interface Specification<T>
	{
		boolean isSatisfied(T item); // Return boolean if certain product satisfied criteria. T can be anything not needed to be product
	}
	
	interface Filter<T> //We can work with anything, but our case T will be product 
	{
		Stream<T> filter(List<T> items, Specification<T> spec); //List of items, with list of Specification<T> spec which we can filter with 
	}

```

- Todo kertaa OCP.


### Liskov Substitution Principle(LSP).

- [LSP](https://en.wikipedia.org/wiki/Liskov_substitution_principle).


- You can substitute **base class** with **subclass**. You should be able to put subclass whiteout breaking the class.


```
package LSP_05;

public class Rectangle {
	
	
	protected int width, height;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle() {
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	public int getArea() {
		return width  * height;
	}
	
	class Square extends Rectangle
	{
		@Override
		public void setWidth(int width) {
			super.setWidth(width);
			super.setHeight(width);
		}

		@Override
		public void setHeight(int height) {
			super.setHeight(height);
			super.setWidth(height);
		}

		public Square() {
		}
		
		public Square(int size)
		{
			width = height = size;
					
		}
	}
	
	class Demo {

		
		
	}
	public static void main(String[] args) {
		
	}

}

```

```
		@Override
		public void setWidth(int width) {
			super.setWidth(width);
			super.setHeight(width);
		}

		@Override
		public void setHeight(int height) {
			super.setHeight(height);
			super.setWidth(height);
		}

```

- Making such overrides violates **Liskov Substitution Principle**(**LSP**) principle.

// Jäin 5:00