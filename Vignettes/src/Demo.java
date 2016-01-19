
public class Demo {
	public static void main(String[] args) {
		GasStation gasStation = new GasStation(20000);
		gasStation.printVignettes(5);
		double randomMoney = 0;
		double randomType = 0;
		
		Driver[] drivers = new Driver[20];
		Vehicle[] vehicles = new Vehicle[200];
		
		for (int i = 0; i < vehicles.length; i++) {
			randomType = Math.random();
			Vehicle currentVehicle = null;
			if (randomType < 0.33) {
				currentVehicle = new Car();
			}
			else if (randomType >= 0.33 || randomMoney < 0.67) {
				currentVehicle = new Bus();
			}
			else {
				currentVehicle = new Truck();
			}
			vehicles[i] = currentVehicle;
			System.out.println(currentVehicle);
		}
		
		for (int i = 0; i < drivers.length; i++) {
			randomMoney = Math.random() * 5000;
			Driver currentDriver = new Driver();
			currentDriver.setName("Driver " + i+1);
			currentDriver.setMoney(randomMoney);
			currentDriver.setGasStation(gasStation);
			for (int j = 0; j < vehicles.length; j++) {
				for (int j2 = 0; j2 < vehicles.length; j2+=10) {
					//TODO
					Vehicle[] currentDriverVehicles = new Vehicle[10];
					currentDriver.setVehicles(currentDriverVehicles);
				}
			}
			//System.out.printf("%.2f\n", currentDriver.getMoney());
		}
		
		for (int i = 0; i < drivers.length; i++) {
			if ((i + 1) % 3 == 0) {
				for (int j = 0; j < 5; j++) {
					int randomVehicle = (int)Math.random() * vehicles.length;
					//drivers[i].buyVignette(vehicles[randomVehicle], validity);
				}
			}
			else {
				//TODO: random validity
				drivers[i].buyVignettesForAllVehicles(Validity.DAILY);
			}
		}
		
//		Driver d = new Driver();
//		d.setMoney(300);
//		d.setVehicles(vehicles);
//		d.setGasStation(gasStation);
//		d.buyVignette(vehicles[3], Validity.DAILY);
//		System.out.println(d.getMoney());
		//d.getVehiclesWithExpiredVignettes();
	}
}
