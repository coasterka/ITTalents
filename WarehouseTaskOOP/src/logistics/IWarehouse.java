package logistics;

import exceptions.NonExistingProductException;
import exceptions.WarehouseArgumentException;

public interface IWarehouse {
	
	public void deliverProducts() throws WarehouseArgumentException;
	public void takeProduct(String productName) throws WarehouseArgumentException, NonExistingProductException;
	
}
