package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String [] nirmal) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "nir13072001@N");
		
		Statement stmt = con.createStatement();
		
		int i = stmt.executeUpdate("delete from product where productId = 105");
		
		System.out.println("Row Deleted SuccessFully " + i + "row Effected");
	}

}
