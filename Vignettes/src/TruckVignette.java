
public class TruckVignette extends Vignette {

	private static final int TIME_FOR_STICKING_TRUCK_VIGNETTE = 10;
	private static final String COLOR_OF_TRUCK_VIGNETTE = "red";
	private static final int PRICE_FOR_DAILY_TRUCK_VIGNETTE = 7;

	public TruckVignette() {
		super();
		this.setColor(COLOR_OF_TRUCK_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_TRUCK_VIGNETTE);
	}
	
	public TruckVignette(int day, int month, int year) {
		super(day, month, year);
		this.setColor(COLOR_OF_TRUCK_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_TRUCK_VIGNETTE);
	}
	
	public TruckVignette(int day, int month, int year, Validity validity) {
		super(day, month, year, validity);
		this.setColor(COLOR_OF_TRUCK_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_TRUCK_VIGNETTE);
	}

	@Override
	public int stickToWindscreen() {
		return TIME_FOR_STICKING_TRUCK_VIGNETTE;		
	}

}
