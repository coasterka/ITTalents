package banktaskoop;
import java.util.ArrayList;

public class Bank {
	private static final int CLIENT_SALARY_PERCENTAGE_FOR_CREDIT = 50;
	private static final int PERCENTAGE_FOR_BANK_RESERVE = 10;
	private String name;
	private String address;
	private ArrayList<BankProduct> products;
	private ArrayList<Client> clients;
	private long money;
	private double bankReserve;

	public Bank(String name, String address) throws BankArgumentException {
		setName(name);
		setAddress(address);
		this.products = new ArrayList<BankProduct>();
		this.clients = new ArrayList<Client>();
		this.money = 1_000_000_000;
		this.bankReserve = calculateBankReserve();
	}

	public void acceptDeposit(Client client, Deposit deposit, double depositAmount) throws BankArgumentException {
		if (deposit == null) {
			throw new BankArgumentException("Deposit is not defined!");
		}
		if (depositAmount <= 0) {
			throw new BankArgumentException("Deposit amount can not be negative or = 0!");
		}
		if (client == null) {
			throw new BankArgumentException("Client can not be null!");
		}
		if (!this.clients.contains(client)) {
			this.clients.add(client);
		}
		this.money += depositAmount;
		double newReserve = this.bankReserve + (depositAmount * 90) / 100;
		this.setBankReserve(newReserve);
		this.products.add(deposit);
	}

	 public void payAllDepositsInterest() throws BankArgumentException {
		 for (BankProduct product : this.products) {
			 if (product instanceof Deposit) {
				 double newAmount = product.getMoneyAmount() + ((Deposit) product).calculateDepositInterest();
				 product.setMoneyAmount(newAmount);
				 this.money -= newAmount;
			 }
		 }
	 }

	public void giveCredit(Credit credit, Client client, double moneyAmount, int period)
			throws BankArgumentException, ClientException, NotEnoughMoneyException {
		if (credit == null) {
			throw new BankArgumentException("Credit is not defined!");
		}
		if (client == null) {
			throw new BankArgumentException("Client is not defined!");
		}
		credit.setMoneyAmount(moneyAmount);
		credit.setPeriod(period);
		double allCreditPayments = 0;
		double halfClientSalary = (client.getSalary() * CLIENT_SALARY_PERCENTAGE_FOR_CREDIT) / 100;
		for (Credit clientCredit : client.getCredits()) {
			allCreditPayments += clientCredit.getMontlyPayment();
		}
		if (allCreditPayments > halfClientSalary) {
			throw new ClientException("Client credit payments can not be more than "
					+ CLIENT_SALARY_PERCENTAGE_FOR_CREDIT + "% of his salary!");
		}
		if (credit.getMoneyAmount() > this.bankReserve) {
			throw new NotEnoughMoneyException("Credit amount is higher than the bank reserve!");
		}
//		for (BankProduct bankProduct : this.products) {
//			if (bankProduct instanceof Credit) {
//				if (!this.products.contains(bankProduct)) {
//					throw new BankArgumentException("The bank does not have this type of credit!");
//				}
//			}
//		}
		client.acceptCredit(credit);
		this.money -= credit.getMoneyAmount();
	}

	public BankProduct openDepositAccount(String name, double interest, int months) throws BankArgumentException {
		 return new Deposit(name, interest, months);
	}
	
	public BankProduct openCreditAccount(String name, double interest) throws BankArgumentException {
		return new Credit(name, interest);
	}

	public void acceptMoneyForCredit(double moneyAmount) {
		this.money += moneyAmount;
	}

	public double calculateBankReserve() {
		double bankReserve = 0;
		for (Client client : this.clients) {
			for (Deposit deposit : client.getDeposits()) {
				bankReserve += (deposit.getMoneyAmount() * PERCENTAGE_FOR_BANK_RESERVE) / 100;
			}
		}
		this.bankReserve = bankReserve;
		return bankReserve;
	}

	private void setName(String name) throws BankArgumentException {
		if (name == null || name.isEmpty()) {
			throw new BankArgumentException("Bank name can not be null or empty!");
		}
		this.name = name;
	}

	public ArrayList<Client> getClients() {
		return new ArrayList<Client>(this.clients);
	}

	public ArrayList<BankProduct> getProducts() {
		return new ArrayList<BankProduct>(this.products);
	}
	
	public double getBankReserve() {
		return this.bankReserve;
	}
	
	private void setBankReserve(double reserve) {
		this.bankReserve = reserve;
	}

	private void setAddress(String address) throws BankArgumentException {
		if (address == null || address.isEmpty()) {
			throw new BankArgumentException("Bank address can not be null or empty!");
		}
		this.address = address;
	}

	public long getMoney() {
		return this.money;
	}

}
