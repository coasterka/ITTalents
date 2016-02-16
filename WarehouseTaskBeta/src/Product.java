import exceptions.WarehouseArgumentException;

public class Product {
	private String name;
	private int quantity;
	
	public Product() {
		
	}
	
	public Product(String name) throws WarehouseArgumentException {
		setName(name);
		setQuantity(0);
	}
	
	private void setName(String name) throws WarehouseArgumentException {
		if (name == null || name.isEmpty()) {
			throw new WarehouseArgumentException("Product name is not defined!");
		}
		this.name = name;
	}
	
	public void setQuantity(int quantity) throws WarehouseArgumentException {
		if (quantity < 0) {
			throw new WarehouseArgumentException("Product quantity cannot be negative!");
		}
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}
