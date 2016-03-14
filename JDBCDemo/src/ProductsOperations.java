import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductsOperations {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/emag_db";

	static final String USER = "root";
	static final String PASS = "xp3R!aZL";

	private static Connection conn = null;
	private static Statement stmt = null;

	static void printAllProducts() {
		try {
			createConnection();
			createStatement();

			String sql;
			sql = "select p.product_id, b.brand_name, c.color_name, p.model " +
					"from products p " +
					"inner join brands b " +
					"on p.brand_id = b.brand_id " +
					"inner join colors c " +
					"on p.color_id = c.color_id;";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.printf("ID\tBrand\tColor\tModel\n");
			System.out.println("------------------------------");
			while (rs.next()) {
				int productId = rs.getInt("p.product_id");
				String brandName = rs.getString("b.brand_name");
				String colorName = rs.getString("c.color_name");
				String model = rs.getString("p.model");

				System.out.printf("%d\t", productId);
				System.out.printf("%s\t", brandName);
				System.out.printf("%s\t", colorName);
				System.out.printf("%s\n", model);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement();
			closeConnection();
		}
		System.out.println("Goodbye!");
	}

	// TODO: fix database - remove property_id from products; add product_id to properties
	public static void insertProduct(int brandId, int colorId, int categoryId, String model,
			String characteristics, double price, int qtyLeft) {

		try {
			createConnection();
			createStatement();

			StringBuilder sql = new StringBuilder();

			sql.append("insert into products values");
			sql.append(" (null, ");
			sql.append(brandId + ", ");
			sql.append(colorId + ", ");
			sql.append(categoryId + ", ");
			sql.append("\'" + model + "\', ");
			sql.append("\'" + characteristics + "\', ");
			sql.append(price + ", ");
			sql.append(qtyLeft + ");");

			stmt.executeUpdate(sql.toString());

			System.out.println("Inserted records into the table...");

			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement();
			closeConnection();
		}
		System.out.println("Goodbye!");
	}

	private static void createStatement() throws SQLException {
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
	}

	private static void createConnection() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}

	private static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void closeStatement() {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
