import java.util.HashMap;
import java.util.Map;

import exceptions.MusicStoreException;
import exceptions.NonExistingArgumentException;

public class Supplier {

	private Store store;

	public Supplier(IStore store2) throws MusicStoreException {
		setStore(store2);
		this.store.setSupplier(this);
	}

	public int deliverInstrument(String type, String name, int quantity) throws MusicStoreException, NonExistingArgumentException {
		if (type == null || type.isEmpty()) {
			throw new MusicStoreException("Product type cannot be null or empty!");
		}		
		if (name == null || name.isEmpty()) {
			throw new MusicStoreException("Product name cannot be null or empty!");
		}
		if (quantity <= 0) {
			throw new MusicStoreException("Quantity cannot be negative or = 0!");
		}
		if (store.getInstrumentByName(name) == null) {
			throw new NonExistingArgumentException("This product doesn't exist in the store catalog!");
		}
		int timeToDeliverProduct = (int) (Math.random() * 1000);
		store.receiveNewInstrument(type, name, quantity);
		return timeToDeliverProduct;	
	}

	private void setStore(IStore store) throws MusicStoreException {
		if (store == null) {
			throw new MusicStoreException("Store is not defined!");
		}
		this.store = (Store) store;
	}

}
