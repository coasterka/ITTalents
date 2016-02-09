package banktaskoop;
import java.util.ArrayList;
import java.util.Collections;

public class Client {
	private static final int LONG_DEPOSIT_PERIOD = 12;
	private static final int SHORT_DEPOSIT_PERIOD = 3;
	private static final int MAX_PRODUCT_PERIOD = 60;
	private static final int MIN_PRODUCT_PERIOD = 1;
	private String name;
	private Bank bank;
	private String address;
	private double cash;
	private double salary;
	private ArrayList<Deposit> deposits;
	private ArrayList<Credit> credits;

	public Client(String name, Bank bank) throws BankArgumentException {
		setName(name);
		setBank(bank);
		setCash();
		setSalary();
		this.deposits = new ArrayList<Deposit>();
		this.credits = new ArrayList<Credit>();
	}

	public void openDeposit(Deposit deposit, double amount) throws BankArgumentException, ClientException {
		if (deposit == null) {
			throw new BankArgumentException("Deposit is not defined!");
		}
		if (amount <= 0) {
			throw new BankArgumentException("Deposit amount can not be negative or = 0!");
		}
		if (this.cash <= 0) {
			throw new ClientException("Client can not create a deposit while his cash is negative or = 0!");
		}
		if (amount > this.cash) {
			// throw new ClientException("Client does not have enough cash!");
			amount = this.cash;
		}
		deposit.setMoneyAmount(amount);
		this.cash -= amount;
		this.bank.acceptDeposit(this, deposit, amount);
		this.deposits.add(deposit);
	}

	public void askForCredit(Credit credit, double moneyAmount, int period)
			throws BankArgumentException, ClientException, NotEnoughMoneyException {
		if (credit == null) {
			throw new BankArgumentException("Credit is not defined!");
		}
		if (moneyAmount <= 0) {
			throw new BankArgumentException("Credit money amount can not be negative or = 0!");
		}
		if (period < MIN_PRODUCT_PERIOD || period > MAX_PRODUCT_PERIOD) {
			throw new BankArgumentException(
					"Credit period must be in range [" + MIN_PRODUCT_PERIOD + ".. " + MAX_PRODUCT_PERIOD + "]!");
		}
		this.bank.giveCredit(credit, this, moneyAmount, period);
	}

	public void acceptCredit(Credit credit) {
		this.cash += credit.getMoneyAmount();
	}

	public void payMoneyForCredit(Credit credit)
			throws ClientException, BankArgumentException, NotEnoughMoneyException {
		if (credit == null) {
			throw new BankArgumentException("Credit is not defined!");
		}
		if (!this.credits.contains(credit)) {
			throw new ClientException("This credit does not belong to this customer!");
		}
		if (this.cash < credit.getMontlyPayment()) {
			throw new NotEnoughMoneyException("Client does not have enough cash!");
		}
		this.cash -= credit.getMontlyPayment();
		double newCreditAmount = credit.getMoneyAmount() - credit.getMontlyPayment();
		credit.setMoneyAmount(newCreditAmount);
		this.bank.acceptMoneyForCredit(credit.getMontlyPayment());
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", cash=" + cash + ", salary=" + salary + ", deposits=" + deposits
				+ ", credits=" + credits + "]";
	}

	public ArrayList<Credit> getCredits() {
		return new ArrayList<Credit>(this.credits);
	}

	public ArrayList<Deposit> getDeposits() {
		return new ArrayList<Deposit>(this.deposits);
	}

	public double getSalary() {
		return this.salary;
	}

	private void setName(String name) throws BankArgumentException {
		if (name == null || name.isEmpty()) {
			throw new BankArgumentException("Client name can not be null or empty!");
		}
		this.name = name;
	}

	public double getCash() {
		return this.cash;
	}

	private void setCash() {
		double cash = Math.random() * 10000;
		this.cash = cash;
	}

	private void setSalary() {
		double salary = Math.random() * 10000;
		this.salary = salary;
	}

	private void setBank(Bank bank) throws BankArgumentException {
		if (bank == null) {
			throw new BankArgumentException("Client bank can not be null!");
		}
		this.bank = bank;
	}

}
