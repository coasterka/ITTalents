import java.util.Arrays;

public class DemoClass {
	
	public static void main(String[] args) {
//		Person p1 = new Person("Pesho");
//		p1.setAge(22);
//		System.out.println(p1.getAge());
		TV tv1 = new TV(42, 5600, 1499.99, Color.BLACK, Brand.SONY, 5);
		TV tv2 = new TV(48, 5900, 1299.99, Color.WHITE, Brand.PHILIPS, 4);
		TV tv3 = new TV(21.6, 3100, 279.99, Color.BLACK, Brand.CROWN, 6);
		TV[] tvArr = { tv1, tv2, tv3 };
		Store store1 = new Store(tvArr);
		//System.out.println(Arrays.toString(tvArr));
		TV.sell(tv3, 4);
		//System.out.println(tv3);
		Dog dog1 = new Dog("black", 3, 20.7, "Ivan");
		System.out.println(dog1);
	}
}