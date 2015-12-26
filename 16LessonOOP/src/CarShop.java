
public class CarShop {
	private Car[] cars;
	
	public CarShop(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Cars' count can not be negative or = 0!");
		}
		this.cars = new Car[capacity];
	}
	
	public void addCar(Car car) {
		if (car == null) {
			throw new IllegalArgumentException("Car is not defined!");
		}
		for (int i = 0; i < cars.length; i++) {
			//TODO: check if car shop is full
			if (cars[i] == null) {
				cars[i] = car;
				break;
			}
		}
	}
	
	public Car getNextCar() {
		Car nextCar = new Car();
		boolean shopIsEmpty = false;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null) {
				nextCar = cars[i];
				shopIsEmpty = false;
				break;
			}
			else {
				shopIsEmpty = true;
			}
		}
		if (shopIsEmpty) {
			System.out.println("The car shop is empty!");
		}
		return nextCar;
	}
	
	public void sellNextCar(Person buyer) {
		Car nextCar = new Car();
		boolean shopIsEmpty = false;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null) {
				nextCar = cars[i];
				shopIsEmpty = false;
				break;
			}
			else {
				shopIsEmpty = true;
			}
		}
		if (shopIsEmpty) {
			System.out.println("The car shop is empty!");
		}
		else {
			buyer.buyCar(nextCar);
			removeCar(nextCar);
		}
	}
	
	public boolean removeCar(Car car) {
		boolean isCarInThisShop = false;
		for (int i = 0; i < cars.length; i++) {
			if (car == cars[i]) {
				cars[i] = null;
				isCarInThisShop = true;
				break;
			}
			else {
				isCarInThisShop = false;
			}
		}
		if (isCarInThisShop == false) {
			System.out.println("This car is not in this shop!");
		}
		return isCarInThisShop;
	}
	
	public void showAllCarsInTheShop() {
		boolean shopIsEmpty = false;
		for (int i = 0; i < cars.length; i++) {
			System.out.print(i+1 + ": ");
			if (cars[i] != null) {
				shopIsEmpty = false;
				System.out.println(cars[i]);
			}
			else {
				System.out.println("Empty position");
				shopIsEmpty = true;
			}
		}
		if (shopIsEmpty) {
			System.out.println("The car shop is empty!");
		}
	}
}
