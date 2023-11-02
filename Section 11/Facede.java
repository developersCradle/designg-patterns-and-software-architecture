
public class Facede {
	
	//Logs huge amount of data

	
	class Buffer
	{
		private char [] chracters;
		private int lineWidth; // Where line brakes are expected to be
		
		
		public Buffer(int lineHeight, int lineWidth) {
			this.lineWidth = lineWidth;
			this.chracters = new char[lineWidth * lineHeight];
		}
		
		public char charAt(int x, int y)
		{
			return chracters[y*lineWidth+x];
		}
	}
	
	class ViewPort
	{
		//2.55
		public ViewPort(Buffer buffer, int width, int height, int offsetX, int offsetY )
		{
			
		}
	}
}
