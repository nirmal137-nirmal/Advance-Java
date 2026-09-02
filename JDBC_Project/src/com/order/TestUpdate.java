package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_db", "root", "nir13072001@N");
			
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("update orders set status = 'delivered' where orderId =  5 ");
			
			con.commit();
			
			System.out.println("Data updated Sucessfully.." + i +  "Row Effected");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
			
		}finally {
			
			con.close();
			
		}
		
	}

}
