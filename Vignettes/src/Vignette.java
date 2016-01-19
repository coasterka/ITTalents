import java.util.Calendar;

public abstract class Vignette {
	private static final int ANNUAL_PRICE_COEF = 6;
	private static final int MONTHLY_PRICE_COEF = 10;
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	private static final int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH);
	private static final int CURRENT_DAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	private int day;
	private int month;
	private int year;
	private static String color;
	private Validity validity;
	private double price;
	
	public Vignette() {
		setDay(CURRENT_DAY);
		setMonth(CURRENT_MONTH);
		setYear(CURRENT_YEAR);
	}
	
	public Vignette(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	public Vignette(int day, int month, int year, Validity validity) {
		this(day, month, year);
		this.validity = validity;
	}
	
	public abstract int stickToWindscreen();
	public double takePrice() {
		return this.price;
	}
	
	//TODO
	public boolean isExpired() {
		boolean isExpired = false;
		
		return isExpired;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Price: " + this.price);
		sb.append("\n");
		sb.append("Color: " + this.color);
		return sb.toString();
	}
	
	public Validity getValidity() {
		return this.validity;
	}
	
	public void setValidity(Validity validity) {
		if (validity != null) {
			this.validity = validity;
		}
		else { 
			return;
		}
	}
	
	public double getPrice() {
		return this.price;
	}
	
	protected void setPrice(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Price can not be <= 0!");
		}
		if (this.validity == Validity.DAILY) {
			this.price = price;
		}
		else if (this.validity == validity.MONTLY) {
			this.price = price * MONTHLY_PRICE_COEF;
		}
		else {
			this.price = (price * MONTHLY_PRICE_COEF) * ANNUAL_PRICE_COEF;
		}
	}
	
	protected void setColor(String color) {
		if (color == null || color.isEmpty()) {
			throw new IllegalArgumentException("Color can not be null or empty!");
		}
		this.color = color;
	}
	
	public void setDay(int day) {
		if (day < 0 || day > 31) {
			throw new IllegalArgumentException("Day must be in range [1.. 31]!");
		}
		this.day = day;
	}


	public void setMonth(int month) {
		if (month < 0 || month > 12) {
			throw new IllegalArgumentException("Month must be in range [1.. 12]!");
		}
		this.month = month;
	}


	public void setYear(int year) {
		if (year < 1990 || year > CURRENT_YEAR) {
			throw new IllegalArgumentException("Month must be in range [1.. 12]!");
		}
		this.year = year;
	}
	
}
