package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws Exception {
		
		Connection comn = null;
		
		try {
			
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	    comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "nir13072001@N");
	    
	    comn.setAutoCommit(false);
		
		Statement stmt = comn.createStatement();
		
		/*
		 * int i = stmt.
		 * executeUpdate("Create table product(productId int primary key, productName varchar(40), price int, Quantity int, category varchar(40))"
		 * );
		 * 
		 * System.out.println("Table Created Successfully");
		 */
		
		int i = stmt.executeUpdate("insert into product (productID, productName, price, Quantity, category) values(101,'laptop', 55000, 10, 'electronic'),(102,'mobile', 25000, 20,'electronic'),(103, 'Shoes', 1500, 20500, 'footwear'),(104, 'watch', 5000, 15, 'Accessories'),(105, 'Backpack', 18000, 35, 'Bags')");
		
		comn.commit();
		
		System.out.println("Data Will be Inserted " + i + " Row Effected ");
		
		} catch (Exception e) {
			System.out.println("Exception "  + e.getMessage());
			
			comn.rollback();
			
		}finally {
			comn.close();
		}
	}

}
