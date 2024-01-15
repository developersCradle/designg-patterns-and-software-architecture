package BUILDER_OOP_12;

import java.util.ArrayList;
import java.util.Iterator;

public class Builder {
class HtmlElement
{
	public String name, text;
	public ArrayList<HtmlElement> elements = new ArrayList<>();
	private final int identSize = 2; // How many character is indented by
	private final String newLine = System.lineSeparator(); // Newline character

	public HtmlElement(String name, String text) {
		this.name = name;
		this.text = text;
	}

	@Override
	public String toString() { //Todo jäin tähän
	}
	
	
}
	
	
	
	public static void main(String[] args) {
		String hello = "hello"; // String inside paragraph
		System.out.println("<p>" + hello + "</p>");
		
		
		
		String [] words = {"hello", "world"};
		//This one, using StringBuilder 
		StringBuilder sb = new StringBuilder(); // Difference between other builder and string builder, in string builder, building happens in picewise(bit by bit) 
		sb.append("<ul>\n");
		for (String word : words)
		{
			sb.append(String.format(" <li>%s</li>\n", word));
		}
		sb.append("</ul>");
		System.out.println(sb);
}
}