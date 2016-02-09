package banktaskoop;
import java.util.ArrayList;
import java.util.Iterator;

public class Demo {
	public static void main(String[] args) throws BankArgumentException, ClientException, NotEnoughMoneyException {
		ArrayList<Client> clients = new ArrayList<Client>();
		Deposit shortDeposit = new Deposit("Short deposit 1", 3, 3);
		Deposit longDeposit = new Deposit("Long deposit", 5, 12);
		Credit homeCredit = new Credit("Home credit", 6);
		Credit consumerCredit = new Credit("Consumer Credit", 10);
		Bank bank = new Bank("Random", "Bulgaria");
		Client c1 = new Client("Client 1", bank);
		Client c2 = new Client("Client 2", bank);
		Client c3 = new Client("Client 3", bank);
		Client c4 = new Client("Client 4", bank);
		Client c5 = new Client("Client 5", bank);
		Client c6 = new Client("Client 6", bank);
		Client c7 = new Client("Client 7", bank);
		Client c8 = new Client("Client 8", bank);
		Client c9 = new Client("Client 9", bank);
		Client c10 = new Client("Client 10", bank);
		clients.add(c1);
		clients.add(c2);
		clients.add(c3);
		clients.add(c4);
		clients.add(c5);
		clients.add(c6);
		clients.add(c7);
		clients.add(c8);
		clients.add(c9);
		clients.add(c10);
		for (Client client : clients) {
			int randomMoneyPercentage = (int) (Math.random() * (100 - 80) + 80);
			double randomDepositMoney = (randomMoneyPercentage * client.getCash()) / 100;
			int randomInterest = (int) (Math.random() * (15 - 2) + 2);
			int randomPeriod = (int) (Math.random() * (60 - 1) + 1);
			client.openDeposit(new Deposit("Random deposit", randomInterest, randomPeriod), randomDepositMoney);
			System.out.println(bank.getBankReserve());
		}
		System.out.println("Bank money: " + bank.getMoney());
		System.out.println("Bank reserve: " + bank.calculateBankReserve());
		System.out.println("Bank clients:");
		System.out.println(bank.getClients());
		System.out.println("Bank products: ");
		System.out.println(bank.getProducts());
		// the bank goes bankrupt sometimes
		for (Client client : bank.getClients()) {
			double randomCreditCoef = Math.random();
			double randomCreditAmount = (Math.random() * 1000);
			int randomCreditPeriod = (int) (Math.random() * (60 - 1) + 1);
			if (randomCreditCoef < 0.5) {
				client.askForCredit(homeCredit, randomCreditAmount, randomCreditPeriod);
			} else {
				client.askForCredit(consumerCredit, randomCreditAmount, randomCreditPeriod);
			}
		}
		System.out.println("Bank money after credit: " + bank.getMoney());
		System.out.println("Bank reserve after credit: " + bank.getBankReserve());
		
	
		
	}
}
