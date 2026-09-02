package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_db" , "root", "nir13072001@N");
			
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("delete from orders where orderId = 6 ");
			
			System.out.println("Data Deleted Sucessfully ..." + i + "Row Effected");
			
			con.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally {
			con.close();
		}
	}

}
