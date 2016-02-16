import exceptions.WarehouseArgumentException;

public class Provider implements Runnable {

	private IWarehouse warehouse;
	
	public Provider() throws WarehouseArgumentException {
		this.warehouse = Warehouse.getWarehouse();
	}
	
	@Override
	public void run() {
		Product product = new Product();
	}

	
	
}
