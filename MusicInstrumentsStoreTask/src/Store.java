import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import exceptions.MusicStoreException;
import exceptions.NonExistingArgumentException;
import exceptions.ProductNotAvailableException;

public class Store implements IStore {

	private static final int STORE_INITIAL_MONEY = 100_000;
	private static final int MAX_STORE_PRODUCT_QUANTITY = 50;

	private double money;	
	private Map<String, TreeSet<MusicInstrument>> productsCatalog;

	public Store() throws MusicStoreException {
		this.money = STORE_INITIAL_MONEY;
		createProductCatalog();
	}

	@Override
	public void sellInstrument(String nameOfInstrument, int quantity)
			throws MusicStoreException, NonExistingArgumentException, ProductNotAvailableException {
		MusicInstrument currentInstrument = null;
		if (nameOfInstrument == null || nameOfInstrument.isEmpty()) {
			throw new MusicStoreException("Name of the desired instrument is not defined!");
		}
		if (quantity <= 0) {
			throw new MusicStoreException("Desired quantity cannot be negative or = 0!");
		}
		for (TreeSet<MusicInstrument> musicInstrumentsList : this.productsCatalog.values()) {
			for (MusicInstrument musicInstrument : musicInstrumentsList) {
				if (nameOfInstrument.equals(musicInstrument.getName())) {
					currentInstrument = musicInstrument;
					break;
				}
			}
			if (currentInstrument != null) {
				break;
			}
		}
		if (currentInstrument == null) {
			throw new NonExistingArgumentException("This instrument is not in the store products catalog!");
		}
		if (currentInstrument.getQuantity() <= 0) {
			throw new ProductNotAvailableException("This product is not available at the moment!");
		}
		double orderAmount = currentInstrument.getPrice() * quantity;
		this.money += orderAmount;
		int newQuantity = currentInstrument.getQuantity() - quantity;
		currentInstrument.setQuantity(newQuantity);
		System.out.printf("%d of %s sold for %.2f leva.\n", quantity, nameOfInstrument, orderAmount);
	}

	@Override
	public void receiveNewInstrument(String type, String nameOfInstrument, int quantity)
			throws MusicStoreException, NonExistingArgumentException {
		if (nameOfInstrument == null || nameOfInstrument.isEmpty()) {
			throw new MusicStoreException("Name of the new instrument is not defined!");
		}
		if (quantity <= 0) {
			throw new MusicStoreException("Quantity of the new instrument cannot be negative or = 0!");
		}
		boolean typeExists = false;

		for (String productType : this.productsCatalog.keySet()) {

			if (type.equals(productType)) {
				typeExists = true;
//				for (TreeSet<MusicInstrument> musicInstrumentsList : this.productsCatalog.values()) {
					// check if the product already exists
					for (MusicInstrument musicInstrument : this.productsCatalog.get(productType)) {
						if (nameOfInstrument.equals(musicInstrument.getName())) {
							throw new MusicStoreException("This product already exists in the store catalog!");
						}
					}

					MusicInstrument newInstrument = new MusicInstrument(nameOfInstrument, quantity);
					// new product is created
					this.productsCatalog.get(productType).add(newInstrument);
					System.out.printf(
							"Product \"%s\" with quantity %d and price %.2f successfully added to store catalog.\n",
							nameOfInstrument, quantity, newInstrument.getPrice());
					break;
//				}
//				break;
			}
		}
		// check if the product type exists in the product categories catalog
		if (!typeExists) {
			throw new NonExistingArgumentException("There is no such type in store type catalog!");
		}
	}

	@Override
	public void printInstrumentsOrderedByType() {
		for (Entry<String, TreeSet<MusicInstrument>> entry : this.productsCatalog.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			for (MusicInstrument musicInstrument : entry.getValue()) {
				System.out.print(musicInstrument.getName() + " ");
			}
			System.out.println();
		}
	}

	@Override
	public void printInstrumentsAlphabetically() {

		TreeSet<MusicInstrument> instrumentsOrderedAlphabetically = new TreeSet<MusicInstrument>();
		for (TreeSet<MusicInstrument> musictInstrumentsList : this.productsCatalog.values()) {
			for (MusicInstrument musicInstrument : musictInstrumentsList) {
				instrumentsOrderedAlphabetically.add(musicInstrument);
			}
		}
		for (MusicInstrument musicInstrument : instrumentsOrderedAlphabetically) {
			System.out.println(musicInstrument.getName());
		}
	}

	@Override
	public void printInstrumentsOrderedByPrice(String orderDirection) {

		TreeSet<MusicInstrument> musicInstrumentsOrderedByPrice = new TreeSet<MusicInstrument>();

		// create Comparator object for ASC sorting
		Comparator<MusicInstrument> ascending = new Comparator<MusicInstrument>() {
			@Override
			public int compare(MusicInstrument i1, MusicInstrument i2) {
				if (i1.getPrice() > i2.getPrice()) {
					return 1;
				}
				if (i1.getPrice() < i2.getPrice()) {
					return -1;
				}
				return 0;
			}
		};

		// create Comparator object for DESC sorting
		Comparator<MusicInstrument> descending = new Comparator<MusicInstrument>() {
			@Override
			public int compare(MusicInstrument i1, MusicInstrument i2) {
				if (i1.getPrice() < i2.getPrice()) {
					return 1;
				}
				if (i1.getPrice() > i2.getPrice()) {
					return -1;
				}
				return 0;
			}
		};

		switch (orderDirection) {
		case "desc":
			musicInstrumentsOrderedByPrice = new TreeSet<MusicInstrument>(descending);
			break;
		default:
			musicInstrumentsOrderedByPrice = new TreeSet<MusicInstrument>(ascending);
			break;
		}
		for (TreeSet<MusicInstrument> musicInstrumentsList : this.productsCatalog.values()) {
			musicInstrumentsOrderedByPrice.addAll(musicInstrumentsList);
		}

		for (MusicInstrument musicInstrument : musicInstrumentsOrderedByPrice) {
			System.out.printf("%.2f %s\n", musicInstrument.getPrice(), musicInstrument.getName());
		}
	}

	@Override
	public void printAvailableInstruments() {

		for (TreeSet<MusicInstrument> musicInstrumentsList : this.productsCatalog.values()) {
			for (MusicInstrument musicInstrument : musicInstrumentsList) {
				if (musicInstrument.getQuantity() > 0) {
					System.out.printf("%d %s\n", musicInstrument.getQuantity(), musicInstrument.getName());
				}
			}
		}
	}

	@Override
	public MusicInstrument getInstrumentByName(String nameOfInstrument) throws NonExistingArgumentException {
		MusicInstrument currentInstrument = null;
		for (TreeSet<MusicInstrument> musicInstrumentsList : this.productsCatalog.values()) {
			for (MusicInstrument musicInstrument : musicInstrumentsList) {
				if (nameOfInstrument.equals(musicInstrument.getName())) {
					currentInstrument = musicInstrument;
					break;
				}
			}
			if (currentInstrument != null) {
				break;
			}
		}
		if (currentInstrument == null) {
			throw new NonExistingArgumentException("There is no such product in store's catalog!");
		}
		return currentInstrument;
	}

	private void createProductCatalog() throws MusicStoreException {

		this.productsCatalog = new TreeMap<String, TreeSet<MusicInstrument>>();

		MusicInstrument[] strunniArray = new MusicInstrument[] { new MusicInstrument("cigulka"),
				new MusicInstrument("viola"), new MusicInstrument("kontrabas"), new MusicInstrument("arfa"),
				new MusicInstrument("kitara"), new MusicInstrument("gydulka") };
		MusicInstrument[] udarniArray = new MusicInstrument[] { new MusicInstrument("barabani"),
				new MusicInstrument("tarambuka"), new MusicInstrument("typan"), new MusicInstrument("daire") };
		MusicInstrument[] duhoviArray = new MusicInstrument[] { new MusicInstrument("trompet"),
				new MusicInstrument("trombon"), new MusicInstrument("tuba"), new MusicInstrument("fleita"),
				new MusicInstrument("klarinet") };
		MusicInstrument[] klavishniArray = new MusicInstrument[] { new MusicInstrument("organ"),
				new MusicInstrument("piano"), new MusicInstrument("akordeon") };
		MusicInstrument[] elektronniArray = new MusicInstrument[] { new MusicInstrument("sintezator"),
				new MusicInstrument("bas-kitara"), new MusicInstrument("elektricheska cigulka") };

		TreeSet<MusicInstrument> strunniInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> udarniInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> duhoviInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> klavishniInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> elektronniInstr = new TreeSet<MusicInstrument>();

		strunniInstr.addAll(Arrays.asList(strunniArray));
		udarniInstr.addAll(Arrays.asList(udarniArray));
		duhoviInstr.addAll(Arrays.asList(duhoviArray));
		klavishniInstr.addAll(Arrays.asList(klavishniArray));
		elektronniInstr.addAll(Arrays.asList(elektronniArray));

		this.productsCatalog.put("Strunni", strunniInstr);
		this.productsCatalog.put("Udarni", udarniInstr);
		this.productsCatalog.put("Duhovi", duhoviInstr);
		this.productsCatalog.put("klavishni", klavishniInstr);
		this.productsCatalog.put("Elektronni", elektronniInstr);

		for (TreeSet<MusicInstrument> musicInstrumentList : this.productsCatalog.values()) {
			for (MusicInstrument musicInstrument : musicInstrumentList) {
				musicInstrument.setQuantity((int) (Math.random() * MAX_STORE_PRODUCT_QUANTITY));
			}
		}

	}
	
	public double getMoney() {
		return this.money;
	}

}
