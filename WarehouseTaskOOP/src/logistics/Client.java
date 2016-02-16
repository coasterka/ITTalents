package logistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import exceptions.NonExistingProductException;
import exceptions.NotEnoughQuantityException;
import exceptions.WarehouseArgumentException;

public class Client implements Runnable {

	private Store store;

	@Override
	public void run() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int productCount = 0;

		List<String> productNames = new ArrayList<String>();

		for (Entry<String, ArrayList<Product>> productsList : store.getAllProducts().entrySet()) {
			for (Product product : productsList.getValue()) {
				productNames.add(product.getName());
				productCount++;
			}
		}

		int randomProductNameCoef = (int) (Math.random() * productCount);
		int randomProductQuantity = (int) (Math.random() * (4 - 1) + 1);

		Product randomProduct = null;
		
		try {
			randomProduct = new Product(productNames.get(randomProductNameCoef));
		} catch (WarehouseArgumentException e) {
			e.printStackTrace();
		}
		try {
			this.buyProduct(randomProduct, randomProductQuantity);
		} catch (WarehouseArgumentException | NotEnoughQuantityException | NonExistingProductException e) {
			e.printStackTrace();
		}
	}

	public void buyProduct(Product product, int quantity)
			throws WarehouseArgumentException, NotEnoughQuantityException, NonExistingProductException {
		Product workingProduct = null;
		if (product == null) {
			throw new WarehouseArgumentException("Product is not defined!");
		}
		if (quantity <= 0) {
			throw new WarehouseArgumentException("Desired quantity cannot be negative or = 0!");
		}
		for (Entry<String, ArrayList<Product>> productsList : this.store.getAllProducts().entrySet()) {
			for (Product currentProduct : productsList.getValue()) {
				if (product == currentProduct) {
					workingProduct = currentProduct;
					break;
				} else {
					throw new NonExistingProductException("There is no such product in the client's store!");
				}
			}
		}
		if (quantity > workingProduct.getQuantity()) {
			throw new NotEnoughQuantityException("There is not enough quantity from " + workingProduct.getName() + "!");
		}
		int newQuantity = workingProduct.getQuantity() - quantity;
		workingProduct.setQuantity(newQuantity);
		store.takeProductsFromWarehouse();
		System.out.println(
				Thread.currentThread().getName() + ": kupih si " + quantity + " broiki ot " + workingProduct.getName());
	}

}
