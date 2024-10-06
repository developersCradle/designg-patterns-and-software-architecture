package WithEventClass_101;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Demo
{
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		Event<PropertyChangedEventArgs>.Subscription sub = person.propertyChanged.addHandler(x -> {
			System.out.println("Person's "
					+ x.propertyName + " has changed");
		});
		
		person.setAge(17);
		person.setAge(18);
		sub.close();
		person.setAge(20);
	}
}




/*
 * What kind of event is happening and related fields to it.
 */
class PropertyChangedEventArgs
{
	public Object source;
	public String propertyName;
	
	public PropertyChangedEventArgs(Object source, String propertyName) {
		this.source = source;
		this.propertyName = propertyName;
	}
	
}

class Person
{
	public Event<PropertyChangedEventArgs>
	propertyChanged = new Event<>();
	/*
	 * This is just for implying that Person has Event that you can subscribe into it when something have happened.
	 */
	
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		
		if (this.age == age) {
			return;
		}
		this.age = age;
		// We inform about information.
		propertyChanged.fire( new PropertyChangedEventArgs(this, "age"));
	}
}



// Event will be encapsulating something happening. 
class Event<TArgs> {
	
	private int count = 0;
	
	// Not list of subscribers, but Map of subscribers.
	private Map<Integer, Consumer<TArgs>>
	handlers = new HashMap<>();

	
	// Memento will be "Subscription" returned since its can be used for disconnecting from this event!
	public Subscription addHandler(Consumer<TArgs> handler)
	{
		int i = count; // cache i for now.
		handlers.put(count++, handler);
		return new Subscription(this, i);
		
	}
	
	// Firing the events
	public void fire(TArgs args)
	{
		for (Consumer<TArgs> handler : handlers.values()) {
			handler.accept(args);
		}
		
	}
	
	
	
//	We are using AutoCloseable so we can put it into try with resources.
	public class Subscription implements AutoCloseable
	{
		// reference which is part of.
		private Event<TArgs> event;
		private int id; // Will be index to the Map.
		
		public Subscription(Event<TArgs> event, int id) {
			this.event = event;
			this.id = id;
		}


		
		// We can close the subscription certain amount of time.
		@Override
		public void close() throws Exception {
			event.handlers.remove(id); // Removing from Map.
		}
		
	}
}

