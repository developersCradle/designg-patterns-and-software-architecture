package WithEventClass_101;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

//Event will be something happening. 
public class Event<TArgs> {
	
	private int count = 0;
	// Map of subscribers.
	private Map<Integer, Consumer<TArgs>>
	handlers = new HashMap<>();
	
//	public Subscription addHandler(Consumer<TArgs> handaler)
//	{
//		
//	}
}
