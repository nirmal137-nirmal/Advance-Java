package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] nirmal) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			Statement stmt = con.createStatement();

			int i = stmt.executeUpdate("delete from product where productId = 105");

			con.commit();

			System.out.println("Row Deleted SuccessFully " + i + "row Effected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			con.rollback();
		} finally {
			con.close();
		}
	}

}
