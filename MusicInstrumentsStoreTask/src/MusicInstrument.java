import exceptions.MusicStoreException;

public class MusicInstrument implements Comparable<MusicInstrument> {
	
	private String name;
	private double price;
	private int quantity;
	
	public MusicInstrument(String name) throws MusicStoreException {
		setName(name);
		setPrice();
	}
	
	public MusicInstrument(String name, int quantity) throws MusicStoreException {
		this(name);
		setQuantity(quantity);
	}
	
	private void setName(String name) throws MusicStoreException {
		if (name == null || name.isEmpty()) {
			throw new MusicStoreException("Instrument name is not defined!");
		}
		this.name = name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	private void setPrice() {
		this.price = Math.random() * 2000;
	}
	
	public void setQuantity(int quantity) throws MusicStoreException {
		if (quantity < 0) {
			throw new MusicStoreException("Quantity cannot be negative!");
		}
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}

	@Override
	public int compareTo(MusicInstrument instrument) {
		return this.name.compareTo(((MusicInstrument) instrument).name);
	}
	
}
