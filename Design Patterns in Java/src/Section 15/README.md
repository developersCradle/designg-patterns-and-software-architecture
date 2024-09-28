## Section 15: Command.

Command pattern.

<img src="gandalf.jpg" alt="alt text" width="500"/>

# What I Learned.

# 74. Overview.  

<img src="motivation.PNG" alt="alt text" width="500"/>

1. In Java statements are **perishable**. Meaning once assignment or what ever operation is done, you **cannot** go back to original state.
2. We want **object** represent operation.
3. There is multiple uses for such **commands** such as GUI commands is sent to command processor. These commands can be stored or played reverse order.

<img src="command.PNG" alt="alt text" width="500"/>

# 75. Command.

 - Command pattern case, in context of **Bank Account**:

```
package command_75;

class BankAccount {
	private int balance;
	private int overdraftLimit = -500; // Limit for getting money out of bank.

	private void deposit(int amount) {
		balance += amount;
		System.out.println("Deposited " + amount + ", balance is now " + balance);
	}

	// Withdrawing money form BankAccount.
	private void withdraw(int amount) {

		if (balance - amount >= overdraftLimit) {
			balance -= amount;
			System.out.println("Withdrew " + amount + ", balance is now " + balance);
		}
	}

	@Override
	public String toString() {
		return "BankAccount{" + "balance=" + balance + "}";
	};
}

```
- We want to put some kind  of audit for this system.
    - We don't want to inject any kind of logging system here.
        - We want to process thing differently, we will use **Command** design pattern.  


- **Command Pattern in use**.

```
package command_75;

import java.util.List;

class BankAccount {
	private int balance;
	private int overdraftLimit = -500; // Limit for getting money out of bank.

	public void deposit(int amount) {
		balance += amount;
		System.out.println("Deposited " + amount + ", balance is now " + balance);
	}

	// Withdrawing money form BankAccount.
	public void withdraw(int amount) {

		if (balance - amount >= overdraftLimit) {
			balance -= amount;
			System.out.println("Withdrew " + amount + ", balance is now " + balance);
		}
	}

	@Override
	public String toString() {
		return "BankAccount{" + "balance=" + balance + "}";
	};
}


interface Command
{
	void call(); // Method for applying command to something.
}

class BankAccountCommand implements Command
{
	private BankAccount account;// What kind Bank Account command will be operated on.
	 
	 //What kind action on BankAccount. 
	 public enum Action
	 {
		 DEPOSIT, WITHDRAW;
	 }
	 
	 private Action action;
	 private int amount;

	 public BankAccountCommand(BankAccount account, Action action, int amount) {
			this.account = account;
			this.action = action;
			this.amount = amount;
		}

	@Override
	public void call() {
		switch (action) {
		case DEPOSIT: 
			account.deposit(amount);
			break;
		case WITHDRAW:
			account.withdraw(amount);
		}
	}
}

class Demo
{
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		System.out.println(ba);
		
		
		// List of commands for Command processor. So list of objects which represents operations.
		List<BankAccountCommand> commands = List.of(
				new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
				new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
				);
		
		for (BankAccountCommand bankAccountCommand : commands) {
			bankAccountCommand.call();
			System.out.println(ba);
		}
	}
}
```

# 76. Undo Operations

- In this chapter we are using revering function from **IIRC Lists is from the Guava library**. Remember to import it, or use some other way.

