package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_db", "root","nir13072001@N");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from orders");
		
		while(rs.next()) {
			
			System.out.println(rs.getInt("orderId"));
			System.out.println(rs.getDate("orderDate"));
			System.out.println(rs.getDouble("amount"));
			System.out.println(rs.getString("status"));
			System.out.println(rs.getInt("customerId"));
			
			System.out.println("----------------------------");
			
		}
		
		
		
		
		
		
	}

}
