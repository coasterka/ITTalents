import exceptions.MusicStoreException;
import exceptions.NonExistingArgumentException;
import exceptions.ProductNotAvailableException;

public interface IStore extends Runnable {

	void sellInstrument(String nameOfInstrument, int quantity) throws MusicStoreException, NonExistingArgumentException, ProductNotAvailableException, InterruptedException;

	void receiveNewInstrument(String type, String nameOfInstrument, int quantity) throws MusicStoreException, NonExistingArgumentException;
	
	MusicInstrument getInstrumentByName(String nameOfInstrument) throws NonExistingArgumentException;
	
	double getMoney();
	
	void printInstrumentsOrderedByType();
	
	void printInstrumentsAlphabetically();
	
	void printInstrumentsOrderedByPrice(String orderDirection);
	
	void printAvailableInstruments();	
	
	void printSoldInstruments();
	
	void printProfit();
	
	void printMostSoldInstrument();
	
	void printLeastSoldInstrument();
	
}