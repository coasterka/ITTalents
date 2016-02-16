package logistics;

import java.util.ArrayList;
import java.util.List;

import exceptions.NonExistingProductException;
import exceptions.WarehouseArgumentException;

public class Demo {
	private static final int CLIENTS_COUNT = 9;
	private static final int STORE_COUNT = 3;

	public static void main(String[] args) throws WarehouseArgumentException, NonExistingProductException {
		Warehouse warehouse = Warehouse.getWarehouse();
		
		Provider provider = new Provider();
		
		List<Store> stores = new ArrayList<Store>();
		
		for (int i = 1; i <= STORE_COUNT; i++) {
			Store store = new Store("Store " + i);
			stores.add(store);
		}
		
		for (Store store : stores) {
			for (int i = 1; i <= (CLIENTS_COUNT / STORE_COUNT); i++) {
				Client client = new Client();
				Thread clientThread = new Thread(client, ("Client " + i));
				store.addClient(client);
				clientThread.start();
			}
		}
	}
}
