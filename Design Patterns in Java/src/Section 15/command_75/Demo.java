package command_75;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class BankAccount {
	private int balance;
	private int overdraftLimit = -500; // Limit for getting money out of bank.
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println("Deposited " + amount + ", balance is now " + balance);
	}

	// Withdrawing money form BankAccount.
	public boolean withdraw(int amount) {

		if (balance - amount >= overdraftLimit) {
			balance -= amount;
			System.out.println("Withdrew " + amount + ", balance is now " + balance);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "BankAccount{" + "balance=" + balance + "}";
	};
}

/*
 * Command is interface here because of the flexibility that it brings.
 */
interface Command {
	void call(); // Method for applying command to something.

	void undo();

}

class BankAccountCommand implements Command {
	private BankAccount account;// What kind Bank Account command will be operated on.

	// What kind action on BankAccount.
	public enum Action {
		DEPOSIT, WITHDRAW
	};

	private Action action;
	private int amount;
	private boolean succeeded; // Tells if transaction failed or not.
	
	public BankAccountCommand(BankAccount account, Action action, int amount) {
		this.account = account;
		this.action = action;
		this.amount = amount;
	}

	@Override
	public void call() {
		
		if (!succeeded) {
			return;
		}
		
		switch (action) {
		case DEPOSIT:
			succeeded = true;
			account.deposit(amount);
			break;
		case WITHDRAW:
			succeeded = account.withdraw(amount);
			// way of figuring if operation succeeded.
		}
	}

	@Override
	public void undo() {
		switch (action) {
		case DEPOSIT:
			account.deposit(amount);
			break;
		case WITHDRAW:
			account.withdraw(amount);
		}
	}

}

class Demo {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		System.out.println(ba);

		// List of commands for Command processor. So list of objects which represents operations.
		// List.of returns immutable list.
		List<BankAccountCommand> commands = List.of(new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
				new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000));
		
		for (Command bankAccountCommand : commands) {
			bankAccountCommand.call();
			System.out.println(ba);
		}
		
		System.out.println("Reversing list.");
		List<BankAccountCommand> listReversed =  new ArrayList<BankAccountCommand>(commands);
		listReversed.addAll(commands);
		
		//We will use bit hacky way to reverse list, for sake of emulating undo().
		Collections.reverse(listReversed); // Reverses the list, do it here since the old one is return immutable.
		
		for (Command bankAccountCommand : listReversed) {
			bankAccountCommand.undo();
			System.out.println(ba);
		}
	}
}