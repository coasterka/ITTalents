package logistics;

import exceptions.WarehouseArgumentException;

public class Provider implements IWarehouseObserver {
	
	private Warehouse warehouse;
	
	public Provider() throws WarehouseArgumentException {
		this.warehouse = Warehouse.getWarehouse();
	}

	public void deliverProducts() throws WarehouseArgumentException {
		this.warehouse.deliverProducts();
	}

}
