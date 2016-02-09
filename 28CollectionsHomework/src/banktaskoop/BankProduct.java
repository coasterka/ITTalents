package banktaskoop;

public abstract class BankProduct {
	private static final int MAX_PRODUCT_PERIOD = 60;
	private static final int MIN_PRODUCT_PERIOD = 1;

	private String name;
	private double interest;
	private int months;
	private double moneyAmount;

	public BankProduct(String name, double interest) throws BankArgumentException {
		setName(name);
		setInterest(interest);
	}

	public double getMoneyAmount() {
		return this.moneyAmount;
	}

	@Override
	public String toString() {
		return "BankProduct [name=" + name + ", interest=" + interest + ", months=" + months + ", moneyAmount="
				+ moneyAmount + "]";
	}

	public int getPeriod() {
		return this.months;
	}

	public double getInterest() {
		return this.interest;
	}

	private void setName(String name) throws BankArgumentException {
		if (name == null || name.isEmpty()) {
			throw new BankArgumentException("Product name can not be null or empty!");
		}
		this.name = name;
	}

	protected void setPeriod(int months) throws BankArgumentException {
		if (months < MIN_PRODUCT_PERIOD || months > MAX_PRODUCT_PERIOD) {
			throw new BankArgumentException(
					"Bank product period must be in range [" + MIN_PRODUCT_PERIOD + ".. " + MAX_PRODUCT_PERIOD + "]!");
		}
		this.months = months;
	}

	protected void setInterest(double interest) throws BankArgumentException {
		if (interest < 0) {
			throw new BankArgumentException("Bank product interest can not be negative!");
		}
		this.interest = interest;
	}

	public void setMoneyAmount(double moneyAmount) throws BankArgumentException {
		// no validations:
		// can be negative if the product is credit
		this.moneyAmount = moneyAmount;
	}
}
