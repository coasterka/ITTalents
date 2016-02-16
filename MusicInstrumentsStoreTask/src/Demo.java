import exceptions.MusicStoreException;
import exceptions.NonExistingArgumentException;
import exceptions.ProductNotAvailableException;

public class Demo {
	public static void main(String[] args)
			throws MusicStoreException, NonExistingArgumentException, ProductNotAvailableException {

		IStore store = new Store();
//		store.printInstrumentsOrderedByType();
		
		store.receiveNewInstrument("Udarni", "marimba", 1);
		store.receiveNewInstrument("Elektronni", "elektricheska kitara", 35);
		
//		store.receiveNewInstrument("Udarni", "marimba", 2);
		
		store.sellInstrument("trompet", 6);
		
		System.out.println(store.getMoney());
		
		store.printInstrumentsAlphabetically();
		
//		store.printInstrumentsAlphabetically();
//		store.printInstrumentsOrderedByPrice("asc");
//		store.printInstrumentsOrderedByPrice("desc");
		
//		store.printAvailableInstruments();

	}
}
