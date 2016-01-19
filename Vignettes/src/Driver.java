import java.util.Arrays;
import java.util.Calendar;

public class Driver {
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	private static final int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH);
	private static final int CURRENT_DAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	private String name;
	private Vehicle[] vehicles;
	private double money;
	private GasStation gasStation;
	
	public Driver() {
		
	}
	
	public Driver(String name, Vehicle[] vehicles, double money, GasStation gasStation) {
		setName(name);
		this.vehicles = vehicles;
		setMoney(money);
		setGasStation(gasStation);
	}
	
	public void buyVignettesForAllVehicles(Validity validity) {
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i].getVignette() == null) {
				buyVignette(vehicles[i], validity);
			}
		}
	}
	
	public void buyVignette(Vehicle vehicle, Validity validity) {
		boolean hasThisVehicle = false;
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicle == vehicles[i]) {
				hasThisVehicle = true;
				break;
			}
		}
		if (!hasThisVehicle) {
			System.out.println("This vehicle does not belond to this driver!");
			return;
		}
		if (vehicle.getVignette() != null && !vehicle.getVignette().isExpired()) {
			System.out.println("This vehicle already has a valid vignette!");
			return;
		}
		Vignette vignette = null;
		if (vehicle instanceof Car) {
			vignette = new CarVignette();
		}
		else if (vehicle instanceof Bus) {
			vignette = new BusVignette();
		}
		else {
			vignette = new TruckVignette();
		}
		
		if (this.money < vignette.getPrice()) {
			System.out.println("Driver does not have enough money!");
			return;
		}
		else {
			gasStation.sellVignette(this, vignette);
			this.money -= vignette.getPrice();
		}
		vignette.setValidity(validity);
		vehicle.setVignette(vignette);
	}
	
	public void getVehiclesWithExpiredVignettes() {
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i].getVignette().isExpired()) {
				System.out.println(vehicles[i]);
			}
		}
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Driver name can not be null or empty!");
		}
		this.name = name;
	}
	
	public void setMoney(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("Driver money can not be < 0!");
		}
		this.money = money;
	}
	
	public void setGasStation(GasStation gasStation) {
		if (gasStation == null) {
			throw new IllegalArgumentException("Gas station is not defined!");
		}
		this.gasStation = gasStation;
	}
	
	public void setVehicles(Vehicle[] vehicles) {
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] == null) {
				throw new IllegalArgumentException("Null vehicles can not be added!");
			}
		}
		this.vehicles = vehicles;
		//Arrays.copyOf(vehicles, vehicles.length);?
	}

	public double getMoney() {
		return this.money;
	}
	
}
