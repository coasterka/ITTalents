package logistics;

import exceptions.WarehouseArgumentException;

public interface IWarehouseObserver {
	
	void deliverProducts() throws WarehouseArgumentException;
	
}
