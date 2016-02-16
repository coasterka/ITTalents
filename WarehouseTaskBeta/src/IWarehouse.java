
public interface IWarehouse {

	void productDelivery() throws InterruptedException;

	void takeProduct(String name);

	void printAllProducts();

}