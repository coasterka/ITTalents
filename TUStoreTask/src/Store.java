public class Store {
	private String owner;
	private int yearFounded;
	private String storeSize;
	private TV[] tv;
	private Stove stove;
	private WashingMachine washingMachine;
	private Refrigerator refrigerator;
	
	public Store(TV[] tv) {
		this.tv = tv;
	}
	
	public TV[] getTV() {
		return this.tv;
	}
	
	public void setTV(TV[] tv) {
		this.tv = tv;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	private void setOwner(String owner) {
		this.owner = "Ivan Petrov";
	}
	
	public int getYearFounded() {
		return this.yearFounded;
	}
	
	private void setYearFounded(int yearFounded) {
		this.yearFounded = 1991;
	}
	
	public String getStoreSize() {
		return this.storeSize;
	}
	
	public void setStoreSize(String storeSize) {
		this.storeSize = storeSize;
	}
	
}