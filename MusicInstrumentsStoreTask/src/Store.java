import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import exceptions.MusicStoreException;
import exceptions.NonExistingArgumentException;
import exceptions.ProductNotAvailableException;

// class Store implements Runnable via the IStore interface
// which extends Runnable
public class Store implements IStore {

	private static final int NUMBER_OF_DELIVERED_INSTRUMENTS = 20;
	private static final int STORE_INITIAL_MONEY = 100_000;
	private static final int MAX_STORE_PRODUCT_QUANTITY = 50;

	private double money;
	private Map<String, TreeSet<MusicInstrument>> productsCatalog;

	private TreeMap<Integer, MusicInstrument> soldInstruments;
	private double profit;
	private Supplier supplier;

	public Store() throws MusicStoreException {
		this.money = STORE_INITIAL_MONEY;
		createProductCatalog();
		soldInstruments = new TreeMap<Integer, MusicInstrument>();
		profit = 0;
	}

	@Override
	public void run() {
		while (true) {
			// sleep for 15 sec (month)
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("---Montly delivery of products---");

			for (Entry<String, TreeSet<MusicInstrument>> entry : this.productsCatalog.entrySet()) {
				for (MusicInstrument instrument : entry.getValue()) {
					if (instrument.getQuantity() == 0) {
						try {
							instrument.setQuantity(NUMBER_OF_DELIVERED_INSTRUMENTS);
							System.err.println(
									"Delivered " + NUMBER_OF_DELIVERED_INSTRUMENTS + " of " + instrument.getName());
						} catch (MusicStoreException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	@Override
	public void sellInstrument(String nameOfInstrument, int quantity) throws MusicStoreException,
			NonExistingArgumentException, ProductNotAvailableException, InterruptedException {

		MusicInstrument currentInstrument = null;
		String currentInstrumentType = "";

		// check for invalid arguments
		if (nameOfInstrument == null || nameOfInstrument.isEmpty()) {
			throw new MusicStoreException("Name of the desired instrument is not defined!");
		}
		if (quantity <= 0) {
			throw new MusicStoreException("Desired quantity cannot be negative or = 0!");
		}

		// set working instrument and its type
		for (Entry<String, TreeSet<MusicInstrument>> entry : productsCatalog.entrySet()) {
			for (MusicInstrument instrument : entry.getValue()) {
				if (nameOfInstrument.equals(instrument.getName())) {
					currentInstrument = instrument;
					currentInstrumentType = entry.getKey();
					break; // break nested foreach if instrument is found
				}
			}
			// break outer foreach if instrument is found
			if (currentInstrument != null) {
				break;
			}
		}
		// throw error if the instrument is not in the product catalog
		if (currentInstrument == null) {
			throw new NonExistingArgumentException("This instrument is not in the store products catalog!");
		}
		if (currentInstrument.getQuantity() <= 0 || currentInstrument.getQuantity() < quantity) {
			// uncomment in case you want to throw an exception instead of
			// delivering
			// new product quantities
			// throw new ProductNotAvailableException("This product is not
			// available at the moment!");
			int timeToDeliver = supplier.deliverInstrument(currentInstrumentType, nameOfInstrument, quantity);
			System.err.println("\"" + currentInstrument.getName() + "\" is currently unavailable. Will be here in "
					+ timeToDeliver + " seconds.");
			Thread.sleep(timeToDeliver); // sleep for some time - to deliver the
											// product
		}
		if (currentInstrument.getPrice() == 0) {
			throw new MusicStoreException("Product's price is not defined!");
		}
		double orderAmount = currentInstrument.getPrice() * quantity;
		money += orderAmount;
		int newQuantity = currentInstrument.getQuantity() - quantity;
		currentInstrument.setQuantity(newQuantity);
		soldInstruments.put(quantity, currentInstrument);
		profit += (currentInstrument.getPrice() * quantity);
		System.out.printf("%d of %s sold for %.2f leva.\n", quantity, nameOfInstrument, orderAmount);
	}

	@Override
	public void printSoldInstruments() {
		if (soldInstruments.size() == 0) {
			System.out.println("The store hasn't sold any instruments.");
			return;
		}
		System.out.println("---Sold instruments---");
		for (Entry<Integer, MusicInstrument> entry : soldInstruments.entrySet()) {
			System.out.println(entry.getKey() + ", Instrument: " + entry.getValue().getName());
		}
	}

	@Override
	public void printProfit() {
		System.out.println("---Store profit---");
		System.out.printf("%.2f leva\n", profit);
	}

	@Override
	public void printMostSoldInstrument() {
		if (soldInstruments.size() == 0) {
			System.out.println("The store hasn't sold any instruments.");
			return;
		}
		System.out.println("---Most sold instrument---");
		System.out
				.println((soldInstruments.lastKey() + ", " + soldInstruments.get(soldInstruments.lastKey()).getName()));
	}

	@Override
	public void printLeastSoldInstrument() {
		if (soldInstruments.size() == 0) {
			System.out.println("The store hasn't sold any instruments.");
			return;
		}
		System.out.println("---Least sold instrument---");
		System.out.println(
				(soldInstruments.firstKey() + ", " + soldInstruments.get(soldInstruments.firstKey()).getName()));
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
				// check if the product already exists
				for (MusicInstrument musicInstrument : this.productsCatalog.get(productType)) {
					if (nameOfInstrument.equals(musicInstrument.getName())) {
						int newQuantity = musicInstrument.getQuantity() + quantity;
						musicInstrument.setQuantity(newQuantity);
						// throw new MusicStoreException("This product already
						// exists in the store catalog!");
					}
				}
				MusicInstrument newInstrument = new MusicInstrument(nameOfInstrument, quantity);
				// new product is created
				this.productsCatalog.get(productType).add(newInstrument);
				System.out.printf(
						"Product \"%s\" with quantity %d and price %.2f successfully added to store catalog.\n",
						nameOfInstrument, quantity, newInstrument.getPrice());
				break;
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

		TreeSet<MusicInstrument> strunniInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> udarniInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> duhoviInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> klavishniInstr = new TreeSet<MusicInstrument>();
		TreeSet<MusicInstrument> elektronniInstr = new TreeSet<MusicInstrument>();

		strunniInstr.addAll(Arrays.asList(new MusicInstrument("cigulka"), new MusicInstrument("viola"),
				new MusicInstrument("kontrabas"), new MusicInstrument("arfa"), new MusicInstrument("kitara"),
				new MusicInstrument("gydulka")));
		udarniInstr.addAll(Arrays.asList(new MusicInstrument("barabani"), new MusicInstrument("tarambuka"),
				new MusicInstrument("typan"), new MusicInstrument("daire")));
		duhoviInstr.addAll(Arrays.asList(new MusicInstrument("trompet"), new MusicInstrument("trombon"),
				new MusicInstrument("tuba"), new MusicInstrument("fleita"), new MusicInstrument("klarinet")));
		klavishniInstr.addAll(Arrays.asList(new MusicInstrument("organ"), new MusicInstrument("piano"),
				new MusicInstrument("akordeon")));
		elektronniInstr.addAll(Arrays.asList(new MusicInstrument("sintezator"), new MusicInstrument("bas-kitara"),
				new MusicInstrument("elektricheska cigulka")));

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

	public void setSupplier(Supplier supplier) throws MusicStoreException {
		if (supplier == null) {
			throw new MusicStoreException("Supplier is not defined!");
		}
		this.supplier = supplier;
	}

}
