import exceptions.MusicStoreException;
import exceptions.NonExistingArgumentException;
import exceptions.ProductNotAvailableException;

public interface IStore {

	void sellInstrument(String nameOfInstrument, int quantity) throws MusicStoreException, NonExistingArgumentException, ProductNotAvailableException;

	void printInstrumentsOrderedByType();
	
	void printInstrumentsAlphabetically();
	
	void printInstrumentsOrderedByPrice(String orderDirection);
	
	void printAvailableInstruments();

	MusicInstrument getInstrumentByName(String nameOfInstrument) throws NonExistingArgumentException;

	void receiveNewInstrument(String type, String nameOfInstrument, int quantity) throws MusicStoreException, NonExistingArgumentException;

	double getMoney();

}