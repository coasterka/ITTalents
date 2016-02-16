package logistics;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import exceptions.NonExistingProductException;
import exceptions.WarehouseArgumentException;

public class Store {
	
	private static final int STORE_START_PRODUCT_QUANTITY = 10;
	private static final int PRODUCT_DELIVERY_QUANTITY = 10;
	private static final int MIN_STORE_PRODUCT_QUANTITY = 3;
	
	private Map<String, ArrayList<Product>> products;
	private ArrayList<Client> clients;
	private Warehouse warehouse;	
	private String name;
	
	public Store(String name) throws WarehouseArgumentException, NonExistingProductException {
		setName(name);
		this.products = new TreeMap<String, ArrayList<Product>>();
		this.clients = new ArrayList<Client>();
		this.warehouse = Warehouse.getWarehouse();
		fillStoreWithProductsForTheFirstTime();
	}
	
	public void fillStoreWithProductsForTheFirstTime() throws WarehouseArgumentException {
		ArrayList<Product> fruitsList = new ArrayList<Product>();
		ArrayList<Product> vegetablesList = new ArrayList<Product>();
		ArrayList<Product> meatsList = new ArrayList<Product>();
		fruitsList.add(new Product("Banana"));
		fruitsList.add(new Product("Orange"));
		fruitsList.add(new Product("Apple"));
		vegetablesList.add(new Product("Potato"));
		vegetablesList.add(new Product("Eggplant"));
		vegetablesList.add(new Product("Cucumber"));
		meatsList.add(new Product("Pork"));
		meatsList.add(new Product("Beef"));
		meatsList.add(new Product("Chicken"));
		this.products.put("FRUITS", fruitsList);
		this.products.put("VEGETABLES", vegetablesList);
		this.products.put("MEATS", meatsList);
		for (ArrayList<Product> productList : this.products.values()) {
			for (Product product : productList) {
				product.setQuantity(STORE_START_PRODUCT_QUANTITY);
			}
		}
		System.out.println(this.name + ": zarediha mi pyrvonachalni broiki ot vsichki produkti.");
	}
	
	public void takeProductsFromWarehouse() throws WarehouseArgumentException, NonExistingProductException {
		warehouse = Warehouse.getWarehouse();
		for (Entry<String, ArrayList<Product>> productsList : this.getAllProducts().entrySet()) {
			for (Product product : productsList.getValue()) {
				System.out.println(product.getQuantity());
				if (Store.isProductDeficient(product)) {
					warehouse.reduceProductQuantity(product, PRODUCT_DELIVERY_QUANTITY);
					int newQuantity = product.getQuantity() + PRODUCT_DELIVERY_QUANTITY;
					product.setQuantity(newQuantity);
					System.out.println("Store: Zaredih si magazina s " + product.getName());
				}
			}
		}
		warehouse.deliverProducts();
	}
	
	public void addClient(Client client) throws WarehouseArgumentException {
		if (client == null) {
			throw new WarehouseArgumentException("Client is not defined!");
		}
		this.clients.add(client);
	}
	
	public static boolean isProductDeficient(Product product) {
		boolean isDeficient = false;
		if (product.getQuantity() < MIN_STORE_PRODUCT_QUANTITY) {
			return true;
		}
		return isDeficient;
	}
	
	public Map<String, ArrayList<Product>> getAllProducts() {
		return this.products;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	private void setName(String name) throws WarehouseArgumentException {
		if (name == null || name.isEmpty()) {
			throw new WarehouseArgumentException("Store name cannot be null or empty!");
		}
		this.name = name;
	}
	
}
