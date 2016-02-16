import exceptions.WarehouseArgumentException;

public class Demo {
	public static void main(String[] args) throws WarehouseArgumentException {
		IWarehouse w = Warehouse.getWarehouse();
		w.printAllProducts();
	}
}
