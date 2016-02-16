package logistics;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import exceptions.NonExistingProductException;
import exceptions.WarehouseArgumentException;

public class Warehouse implements IWarehouse {

	private static final int PRODUCT_QUANTITY_FOR_TAKING = 5;

	private static final int NEW_PRODUCT_DELIVERY_QUANTITY = 25;

	private static final int MIN_WAREHOUSE_PRODUCT_QUANTITY = 5;

	private static final int START_PRODUCT_QUANTITY = 15;

	private static Warehouse theOnlyWarehouse = null;
	private Map<String, ArrayList<Product>> products;

	private Warehouse() throws WarehouseArgumentException {
		System.out.println("Syzdadoh si skladche.");
		this.products = new TreeMap<String, ArrayList<Product>>();
		fillWarehouseWithProductsForTheFirstTime();
	}

	public void reduceProductQuantity(Product product, int quantity)
			throws WarehouseArgumentException, NonExistingProductException {
		if (product == null) {
			throw new WarehouseArgumentException("Product is not defined!");
		}
		if (quantity <= 0) {
			throw new WarehouseArgumentException("Quantity cannot be negative or = 0!");
		}
		for (Entry<String, ArrayList<Product>> productsList : this.products.entrySet()) {
			for (Product currentProduct : productsList.getValue()) {
				if (product == currentProduct) {
					break;
				} else {
					throw new NonExistingProductException("There is no such product in the warehouse!");
				}
			}
		}
		if (product.getQuantity() < quantity) {
			System.err.println("There are not enough " + product.getName() + "s in the warehouse!");
			return;
		} else {
			int newQuantity = product.getQuantity() - quantity;
			product.setQuantity(newQuantity);
			System.out.println("Sklad: vzeha mi " + quantity + " broiki ot " + product.getName());
		}
	}

	private void fillWarehouseWithProductsForTheFirstTime() throws WarehouseArgumentException {
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
				product.setQuantity(START_PRODUCT_QUANTITY);
			}
		}
		System.out.println("Sklad: zarediha mi pyrvonachalni broiki ot vsichki produkti.");
		// check method
		// for (Entry<String, ArrayList<Product>> productList :
		// this.products.entrySet()) {
		// System.out.println(productList.getKey() + " " +
		// productList.getValue());
		// }
	}

	private boolean isProductDeficient(Product product) {
		boolean isDeficient = false;
		if (product.getQuantity() < MIN_WAREHOUSE_PRODUCT_QUANTITY) {
			return true;
		}
		return isDeficient;
	}

	@Override
	public void deliverProducts() throws WarehouseArgumentException {
		for (Entry<String, ArrayList<Product>> productList : this.products.entrySet()) {
			for (Product product : productList.getValue()) {
				if (isProductDeficient(product)) {
					product.setQuantity(NEW_PRODUCT_DELIVERY_QUANTITY);
					System.out.println("Sklad: zarediha mi " + NEW_PRODUCT_DELIVERY_QUANTITY + " broiki ot produkt "
							+ product.getName());
				}
			}
		}
	}

	@Override
	public void takeProduct(String productName) throws NonExistingProductException, WarehouseArgumentException {
		Product workingProduct = null;
		if (productName == null || productName.isEmpty()) {
			throw new WarehouseArgumentException("Product name can not be null or empty!");
		}
		for (Entry<String, ArrayList<Product>> productList : this.products.entrySet()) {
			for (Product product : productList.getValue()) {
				if (productName.equals(product.getName())) {
					workingProduct = product;
					break;
				} else {
					throw new NonExistingProductException("There is no such product in the warehouse!");
				}
			}
		}
		if (isProductDeficient(workingProduct)) {
			deliverProducts();
		}
		workingProduct.setQuantity(workingProduct.getQuantity() + PRODUCT_QUANTITY_FOR_TAKING);
		System.out.println("Sklad: vzeh si " + workingProduct.getQuantity() + " broiki ot " + workingProduct.getName());
	}
	
	public Map<String, ArrayList<Product>> getAllProducts() {
		return this.products;
	}

	public static Warehouse getWarehouse() throws WarehouseArgumentException {
		if (theOnlyWarehouse == null) {
			theOnlyWarehouse = new Warehouse();
		}
//		System.out.println("Sklad: syzdadoha me.");
		return theOnlyWarehouse;
	}

}
