package command_75_and_76;

import java.util.List;

import com.google.common.collect.Lists;

class BankAccount {
	private int balance;
	private int overdraftLimit = -500; // Limit for getting money out of bank.
	
	public void deposit(int ammount) {
		balance += ammount;
		System.out.println("Deposited " + ammount + ", balance is now " + balance);
	}

	// Withdrawing money form BankAccount.
	public boolean withdraw(int ammount) {

		if (balance - ammount >= overdraftLimit) {
			balance -= ammount;
			System.out.println("Withdrew " + ammount + ", balance is now " + balance);
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
		
		if (!succeeded) {
			return;
		}
		
		switch (action) {
		case DEPOSIT:
			account.withdraw(amount);
			break;
		case WITHDRAW:
			account.deposit(amount);
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
		
		//We will use bit hacky way to reverse list, for sake of emulating undo().
		for (Command bankAccountCommand : Lists.reverse(commands)) {
			bankAccountCommand.undo();
			System.out.println(ba);
		}
	}
}