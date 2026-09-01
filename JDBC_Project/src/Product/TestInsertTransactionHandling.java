package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertTransactionHandling {
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "nir13072001@N");
			
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("insert into product values(105, 'Water Bottle', 500, 10, 'home'),(106,'Backpack', 1700, 3, 'Bags')");

			con.commit();
			
			System.out.println("In Product Table data Will be Inserted " + i + "Row Effected");
			
		} catch (Exception e) {
			
			System.out.println("Exception " + e.getMessage());
			
			con.rollback();
			
		}finally {
			con.close();
		}
	}

}
