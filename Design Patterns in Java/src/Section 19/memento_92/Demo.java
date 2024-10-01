package memento_92;

// Memento or token, you can call it what you like.
class Memento // Memento should keep as immutable as possible, so it should be closed as possible.
{	
	public int balance;

	public Memento(int balance) {
		this.balance = balance;
	}	
}

class BankAccount {
	
	public int balance;
	
	BankAccount(int balance)
	{
		this.balance = balance;
	}
	
	// Memento allows us to roll back the given action. 
	public Memento deposit(int ammount) {
		balance += ammount;
		return new Memento(balance);
	}

	public void restore(Memento m)
	{
		balance = m.balance;
	}
	
	@Override
	public String toString() {
		return "BankAccount{" + "balance=" + balance + "}";
	};
}


class Demo {
	
	public static void main(String[] args) {
		
		BankAccount ba = new BankAccount(100);
		var memento1 = ba.deposit(50); // 150
		var memento2 = ba.deposit(25); // 175
		System.out.println(ba);

		// restore to m1
		ba.restore(memento1);
		System.out.println("Memento 1 " + ba);
		
		// restore to m2
		ba.restore(memento2);
		System.out.println("Memento 2 " + ba);
	}
}