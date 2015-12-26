
public class Demo {
	
	public static void main(String[] args) {
		
		CarShop carShop = new CarShop(4);
		Car car1 = new Car("206", false, Color.BLUE, 6900);
		Car car2 = new Car("307", false, Color.RED, 2900);
		Car car3 = new Car("Laguna", false, Color.BLACK, 12900);
		Car car4 = new Car("Cellica", true, Color.SILVER, 22300);
		Car car5 = new Car("C4", false, Color.RED, 11100);
		
		carShop.addCar(car1);
		carShop.addCar(car2);
		carShop.addCar(car3);
		carShop.addCar(car4);
		
		Person p1 = new Person("Genadi", 123456789, true);
		p1.setMoney(70000);
		
		carShop.sellNextCar(p1); // sell car1 - 206; carShop[0] -> null
		
		System.out.println(carShop.getNextCar()); // print car2
		carShop.removeCar(car5); // no such car in the shop
		
		carShop.addCar(car5); // carShop[0] = car5
		carShop.sellNextCar(p1); // sell car5 - C4
		
		System.out.println();
		carShop.showAllCarsInTheShop(); // null, 307, Laguna, Cellica
		
		
		
//		Person p1 = new Person("Genadi", 123456789, true);
//		System.out.println(p1.getFriends().length);
//		System.out.println("p1 Age: " + p1.getAge());
//		System.out.println("p1 Weight: " + p1.getWeight());
//		System.out.println("p1 Name: " + p1.getName());
//		Person p2 = new Person("Marinka", 987654321, false);
//		p1.addFriend(p2);
//		Person p3 = new Person("Evgeni", 12121212, true);
//		p1.addFriend(p3);
//		Person p4 = new Person("Milka", 34363535, false);
//		p1.addFriend(p4);
//		System.out.println(Arrays.toString(p1.getFriends()));
//		
//		Car c1 = new Car();
//		Car c2 = new Car();
//		c1.setPrice(2000);
//		c2.setPrice(1800);
//		System.out.println(c1.isMoreExpensive(c2)); // 2000 > 1800 true
//		
//		c1.setColor(Color.BLACK);
//		
//		// sport car = false
//		System.out.println(c1.calculateCarPriceForScrap(6300.00));
//		
//		c1.setSportCar(true);
//		System.out.println(c1.calculateCarPriceForScrap(6300.00));
//		
//		p1.setMoney(7000);
//		
//		c1.setModel("Golf");
//		
//		p1.buyCar(c1);
//		System.out.println(p1.getMoney()); // 7000 - 2000 = 5000
//		
//		System.out.println(p1.getCar());		
	}
}