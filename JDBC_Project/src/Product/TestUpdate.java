package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		
		Connection con= null;
		
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db","root", "nir13072001@N");
		
		con.setAutoCommit(false);
		
		Statement stmt = con.createStatement();
		
		con.commit();
		
		int i = stmt.executeUpdate("update product set productName = 'watches' where productId = 104 ");
		
		System.out.println("table will be Updated " + i + "Row Effected");
		
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			
		}finally {
			con.close();
		}
	}

}
