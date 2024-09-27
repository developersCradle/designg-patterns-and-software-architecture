package BUILDER_11;

import java.util.Iterator;

public class Builder {

	
	public static void main(String[] args) {
		String hello = "hello"; // String inside paragraph
		System.out.println("<p>" + hello + "</p>");
		
		
		
		String [] words = {"hello", "world"};
		
//		Here is how we are going to make concation when we are printing
//		
//		System.out.println(
//		"<ul>\n" + "<li>" + words[0] // and in the ends we could be using streams
//		);
// 		How to simplify this, BY USING BUILDERS!!

		
		
		
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