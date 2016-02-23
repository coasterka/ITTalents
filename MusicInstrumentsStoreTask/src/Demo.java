import exceptions.MusicStoreException;
import exceptions.NonExistingArgumentException;
import exceptions.ProductNotAvailableException;

public class Demo {
	public static void main(String[] args)
			throws MusicStoreException, NonExistingArgumentException, ProductNotAvailableException, InterruptedException {

		IStore store = new Store();
//		store.printInstrumentsOrderedByType();
		
		store.receiveNewInstrument("Udarni", "marimba", 5);
		store.receiveNewInstrument("Elektronni", "elektricheska kitara", 35);
		
//		store.receiveNewInstrument("Udarni", "marimba", 2);
		
		store.getInstrumentByName("daire").setQuantity(0);
		store.getInstrumentByName("akordeon").setQuantity(0);
		store.getInstrumentByName("tuba").setQuantity(0);
		
		Supplier supplier = new Supplier(store);
		
		Thread storeThread = new Thread(store);
		storeThread.start();
		
		for (int i = 1; i <= 500; i++) {
			store.sellInstrument("trompet", 10);
		}
		
		
		store.sellInstrument("marimba", 10);
		store.sellInstrument("elektricheska kitara", 15);
		
		
		
		store.printSoldInstruments();
		store.printProfit();
		store.printMostSoldInstrument();
		store.printLeastSoldInstrument();
		
//		store.printInstrumentsAlphabetically();
//		store.printInstrumentsOrderedByPrice("asc");
//		store.printInstrumentsOrderedByPrice("desc");
		
//		store.printAvailableInstruments();

	}
}
