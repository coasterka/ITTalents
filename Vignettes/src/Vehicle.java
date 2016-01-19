import java.util.Calendar;

public abstract class Vehicle {
	private static final int MAX_YEAR_OF_PRODUCTION = Calendar.getInstance().get(Calendar.YEAR);
	private static final int MIN_YEAR_OF_PRODUCTION = 1900;
	private String model;
	private Vignette vignette;
	private int yearOfProduction;
	private Driver driver;
	
	public Vehicle() {
		this.model = "Not defined";
		this.yearOfProduction = 2000;
	}
	
	public Vehicle(String model, int yearOfProduction) {
		setModel(model);
		setYearOfProduction(yearOfProduction);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Model: " + model);
		sb.append("\n");
		sb.append("Year of production: " + yearOfProduction);
		sb.append("\n");
		sb.append("Vignette: " + this.vignette);
		return sb.toString();
	}
	
	public Vignette getVignette() {
		return this.vignette;
	}
	
	public void setVignette(Vignette vignette) {
		if (vignette != null) {
			this.vignette = vignette;
		}
		else { 
			return;
		}
	}
	
	private void setModel(String model) {
		if (model == null || model.isEmpty()) {
			throw new IllegalArgumentException("Model can not be null or empty!");
		}
		this.model = model;
	}
	
	private void setYearOfProduction(int yearOfProduction) {
		if (yearOfProduction < MIN_YEAR_OF_PRODUCTION
				|| yearOfProduction > MAX_YEAR_OF_PRODUCTION) {
			throw new IllegalArgumentException("Year of production can not be less than "
				+ MIN_YEAR_OF_PRODUCTION + " or greater than " + MAX_YEAR_OF_PRODUCTION + "!");
		}
		this.yearOfProduction = yearOfProduction;
	}
}
