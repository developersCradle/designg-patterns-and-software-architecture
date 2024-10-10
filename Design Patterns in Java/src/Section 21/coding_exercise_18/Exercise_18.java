
package coding_exercise_18;


import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/*
    Observable Coding Exercise
	Imagine a game where one or more rats can attack a player. 
	Each individual rat has an attack  value of 1. However, rats attack as a swarm, so each rat's attack  value is equal to the total number of rats in play.

	Given that a rat enters play through the constructor and leaves play (dies) via its close()  method,
	please implement the Game and Rat classes so that, at any point in the game, the attack  value of a rat is always consistent.
 */

/* 
 * We are using such event for given system which in regards is applying Observer Design pattern with event system.
 */
class Event<T> {

	// adding to centralized event handler system
	private List<BiConsumer<Object, T>> consumers = new ArrayList<>();

	// takes consumer
	void subscribe(BiConsumer<Object, T> consumer) {
		consumers.add(consumer);
	}

	public void invoke(Object sender, T arg) {
		for (BiConsumer<Object, T> consumer : consumers)
			consumer.accept(sender, arg);
	}

}

class Game {

	// Game has these events that we can subscribe into!
	public Event<Void> ratEnters = new Event<>();
	public Event<Void> ratDies = new Event<>();
	public Event<Rat> notifyRat = new Event<>();
}

class Rat implements Closeable
{
  private Game game;
  public int attack = 1;

  public Rat(Game game)
  {
    this.game = game;
    game.ratEnters.subscribe((sender, arg) -> {
      if (sender != this)
      {
        ++attack;
        game.notifyRat.invoke(this, (Rat) sender);
      }
    });
    game.notifyRat.subscribe((sender, rat) -> {
      if (rat == this) ++attack;
    });
    game.ratDies.subscribe((sender, arg) -> --attack);
    game.ratEnters.invoke(this, null);
  }

  @Override
  public void close() throws IOException
  {
    // rat dies ;(
    game.ratDies.invoke(this, null);
  }
}
