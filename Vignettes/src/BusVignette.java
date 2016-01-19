
public class BusVignette extends Vignette {

	private static final int TIME_FOR_STICKING_BUS_VIGNETTE = 20;
	private static final int PRICE_FOR_DAILY_BUS_VIGNETTE = 9;
	private static final String COLOR_OF_BUS_VIGNETTE = "yellow";

	public BusVignette() {
		super();
		this.setColor(COLOR_OF_BUS_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_BUS_VIGNETTE);
	}
	
	public BusVignette(int day, int month, int year) {
		super(day, month, year);
		this.setColor(COLOR_OF_BUS_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_BUS_VIGNETTE);
	}
	
	public BusVignette(int day, int month, int year, Validity validity) {
		super(day, month, year, validity);
		this.setColor(COLOR_OF_BUS_VIGNETTE);
		this.setPrice(PRICE_FOR_DAILY_BUS_VIGNETTE);
	}

	@Override
	public int stickToWindscreen() {
		return TIME_FOR_STICKING_BUS_VIGNETTE;		
	}

}
