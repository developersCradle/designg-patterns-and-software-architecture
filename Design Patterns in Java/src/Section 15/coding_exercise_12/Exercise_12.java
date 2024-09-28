package coding_exercise_12;
// When returning test remember to remove package.

/*
 * 
 * Command Coding Exercise.
 * Implement the Account.process()  method to process different account commands. The rules are obvious:
 * 	- `success`  indicates whether the operation was successful
 * 	- You can only withdraw money if you have enough in your account.
 * 
 */


class Command {
	enum Action {
		DEPOSIT, WITHDRAW
	}

	public Action action;
	public int amount;
	public boolean success;

	public Command(Action action, int amount) {
		this.action = action;
		this.amount = amount;
	}
}

class Account {

	public int balance;

	public void process(Command command) {
		switch (command.action) {
		case DEPOSIT: {
			balance += command.amount;
			command.success = true;
			break;
		}
		case WITHDRAW: {
			command.success = balance >= command.amount;
			if (command.success) {
				balance -= command.amount;
			}
			break;
		}
		}
	}
}

class BankAccountCommand extends Command {

	private Account account;

	public BankAccountCommand(Action action, int amount) {
		super(action, amount);
		this.account = new Account();
	}
}

