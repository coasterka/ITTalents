package logistics;

import exceptions.WarehouseArgumentException;

public class Product {
	
	private String name;
	private int quantity;
	
	public Product(String name) throws WarehouseArgumentException {
		setName(name);
	}
	
	private void setName(String name) throws WarehouseArgumentException {
		if (name == null || name.isEmpty()) {
			throw new WarehouseArgumentException("Product name can not be null or empty!");
		}
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) throws WarehouseArgumentException {
		if (quantity < 0) {
			throw new WarehouseArgumentException("Quantity can not be negative!");
		}
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return this.name + " " + this.quantity;
	}
	
	
	
	
}
