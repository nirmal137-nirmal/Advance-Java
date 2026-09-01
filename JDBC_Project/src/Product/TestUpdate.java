package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db","root", "nir13072001@N");
		
		Statement stmt = con.createStatement();
		
		int i = stmt.executeUpdate("update product set productName = 'watches' where productId = 104 ");
		
		System.out.println("table will be Updated " + i + "Row Effected");
	}

}
