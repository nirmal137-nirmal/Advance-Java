package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		
		try {
			
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db" , "root", "nir13072001@N");
		 
		 con.setAutoCommit(false);
		
		Statement stmt = con.createStatement();
		
		con.commit();
		
		ResultSet rs = stmt.executeQuery("Select * from product ");
		
		while(rs.next()) {
			System.out.println("Product Id :" + rs.getInt("productId"));
			System.out.println("Product Name : " + rs.getString("productName"));
			System.out.println("Product Price :" + rs.getString("price"));
			System.out.println("product Quantity :" + rs.getString("Quantity"));
			System.out.println("Product Category :" + rs.getString("category"));
			System.out.println("--------------------------------------------------");
		}
		
		} catch (Exception e) {
			
			System.out.println("Exception :" + e.getMessage());
			
			con.rollback();
			// TODO: handle exception
		}finally {
			con.close();
		}
	}

}
