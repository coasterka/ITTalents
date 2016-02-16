import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import exceptions.WarehouseArgumentException;

public class Warehouse implements IWarehouse {

	private static final int MIN_WAREHOUSE_PRODUCT_QUANTITY = 3;

	private static final int WAREHOUSE_START_PRODUCT_QUANTITY = 15;

	private static IWarehouse theOnlyWarehouse = null;
	
	private Provider provider;

	private TreeMap<String, ArrayList<Product>> products;

	private Warehouse() throws WarehouseArgumentException {
		System.out.println("Warehouse created.");
		this.products = new TreeMap<String, ArrayList<Product>>();
		setProductsAtCreation();
		setProductQuantityAtCreation();
	}

	@Override
	public void productDelivery() throws InterruptedException {
		for (ArrayList<Product> productsList : this.products.values()) {
			for (Product product : productsList) {
				synchronized (product) {
					while (!(product.getQuantity() < MIN_WAREHOUSE_PRODUCT_QUANTITY)) {
						product.wait();
					}
//					this.provider.
				}
			}
		}
	}

	@Override
	public void takeProduct(String name) {

	}

	public static IWarehouse getWarehouse() throws WarehouseArgumentException {
		if (theOnlyWarehouse == null) {
			theOnlyWarehouse = new Warehouse();
		}

		return theOnlyWarehouse;
	}

	private void setProductsAtCreation() throws WarehouseArgumentException {
		addProductsAtCreation();
	}

	private void setProductQuantityAtCreation() throws WarehouseArgumentException {
		for (ArrayList<Product> productsList : this.products.values()) {
			for (Product product : productsList) {
				product.setQuantity(WAREHOUSE_START_PRODUCT_QUANTITY);
			}
		}
	}

	private void addProductsAtCreation() throws WarehouseArgumentException {
		addMeats();
		addVegetables();
		addFruits();
		setProductQuantityAtCreation();
	}

	private void addMeats() throws WarehouseArgumentException {
		List<Product> meats = new ArrayList<Product>();
		meats.add(new Product("Pork"));
		meats.add(new Product("Beef"));
		meats.add(new Product("Chicken"));
		this.products.put("Meats", (ArrayList<Product>) meats);
	}

	private void addVegetables() throws WarehouseArgumentException {
		List<Product> vegetables = new ArrayList<Product>();
		vegetables.add(new Product("Potato"));
		vegetables.add(new Product("Eggplant"));
		vegetables.add(new Product("Tomato"));
		this.products.put("Vegetables", (ArrayList<Product>) vegetables);
	}

	private void addFruits() throws WarehouseArgumentException {
		List<Product> fruits = new ArrayList<Product>();
		fruits.add(new Product("Banana"));
		fruits.add(new Product("Orange"));
		fruits.add(new Product("Apple"));
		this.products.put("Fruits", (ArrayList<Product>) fruits);
	}

	@Override
	public void printAllProducts() {
		for (Entry<String, ArrayList<Product>> productsWithType : this.products.entrySet()) {
			System.out.print(productsWithType.getKey() + ": ");
			for (Product product : productsWithType.getValue()) {
				System.out.print(product.getName() + " " + product.getQuantity() + " ");
			}
			System.out.println();
		}
	}

}
