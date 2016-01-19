import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

public class GasStation {
	private double dailyTurnover;
	private Vignette[] vignettes;
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	private static final int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH);
	private static final int CURRENT_DAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	
	public GasStation(double dailyTurnover) {
		setDailyTurnover(dailyTurnover);
		setVignettes();
	}
	
	public void sellVignette(Driver driver, Vignette vignette) {
		dailyTurnover += vignette.getPrice();
	}
	
	private void setDailyTurnover(double dailyTurnover) {
		if (dailyTurnover < 0) {
			throw new IllegalArgumentException("Daily turnover can not be < 0!");
		}
		this.dailyTurnover = dailyTurnover;
	}
	
	public void printVignettes(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(this.vignettes[i]);
		}
	}
	
	private void setVignettes() {
		this.vignettes = new Vignette[10000];
		double randomType = 0;
		double randomValidity = 0;
		for (int i = 0; i < vignettes.length; i++) {
			randomType = Math.random();
			randomValidity = Math.random();
			if (randomType < 0.33) {
				vignettes[i] = new CarVignette();
			}
			else if (randomType >= 0.33 || randomType < 0.66) {
				vignettes[i] = new TruckVignette();
			}
			else {
				vignettes[i] = new BusVignette();
			}
			generateRandomValidity(randomValidity, i);
		}
		 sortVignettes();
	}

	private void generateRandomValidity(double randomValidity, int i) {
		if (randomValidity < 0.33) {
			vignettes[i].setValidity(Validity.MONTLY);
		}
		else if (randomValidity >= 0.33 || randomValidity < 0.66) {
			vignettes[i].setValidity(Validity.DAILY);
		}
		else {
			vignettes[i].setValidity(Validity.ANNUAL);
		}
	}
	
	public Vignette[] sortVignettes() {
		double temp = 0;

		for(int i=0; i < vignettes.length; i++){
			for(int j=1; j < (vignettes.length - i); j++){
				if (vignettes[j-1].getPrice() > vignettes[j].getPrice()){
					//swap the elements!
					temp = vignettes[j-1].getPrice();
					vignettes[j-1] = vignettes[j];
					vignettes[j].setPrice(temp);
				}
			}
		}
		return vignettes;
	}
	
}
