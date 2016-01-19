
public class CarVignette extends Vignette {
	
	private static final int TIME_FOR_STICKING_CAR_VIGNETTE = 5;
	private static final String COLOR_OF_CAR_VIGNETTE = "green";
	private static final int PRICE_FOR_DAILY_CAR_VIGNETTE = 5;

	public CarVignette() {
		super();
		this.setColor(COLOR_OF_CAR_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_CAR_VIGNETTE);
	}
	
	public CarVignette(int day, int month, int year) {
		super(day, month, year);
		this.setColor(COLOR_OF_CAR_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_CAR_VIGNETTE);
	}
	
	public CarVignette(int day, int month, int year, Validity validity) {
		super(day, month, year, validity);
		this.setColor(COLOR_OF_CAR_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_CAR_VIGNETTE);
	}

	@Override
	public int stickToWindscreen() {
		return TIME_FOR_STICKING_CAR_VIGNETTE;
	}
	
	
	
}
