package banktaskoop;

public class Deposit extends BankProduct {

	private static final int MAX_PERIOD_FOR_DEPOSIT = 60;
	private static final int MIN_PERIOD_FOR_DEPOSIT = 1;
	private double montlyPaidAmount;
	
	public Deposit(String name, double interest, int months) throws BankArgumentException {
		super(name, interest);
		super.setPeriod(months);
		setMonthlyPaidAmount();
	}

	public double calculateDepositInterest() {
		double interestPayment = 0;
		interestPayment = (this.getMoneyAmount() * this.getInterest()) / 100;
		return interestPayment;
	}
	
	private void setMonthlyPaidAmount() throws BankArgumentException {
		this.montlyPaidAmount = this.getInterest() * this.getPeriod() * 10;
	}
	
}
