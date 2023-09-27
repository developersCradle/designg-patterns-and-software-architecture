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
