package banktaskoop;

public class Credit extends BankProduct {

	private double montlyPayment;
	
	public Credit(String name, double interest)
			throws BankArgumentException {
		super(name, interest);
	}

	public double getMontlyPayment() {
		return this.montlyPayment;
	}

	@Override
	public void setMoneyAmount(double moneyAmount) throws BankArgumentException {
		if (moneyAmount <= 0) {
			throw new BankArgumentException("Credit money amount can not be negative or = 0!");
		}
		super.setMoneyAmount(moneyAmount);
	}

}
