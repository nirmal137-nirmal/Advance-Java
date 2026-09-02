package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_db", "root", "nir13072001@N");
			
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			
			/*
			 * int i = stmt.
			 * executeUpdate("Create table orders(orderId int primary key, orderDate Date, amount double, status varchar(40), customerId  int)"
			 * );
			 */
			
			int i = stmt.executeUpdate("INSERT INTO orders (orderId, orderDate, amount, status, customerId) VALUES (1, '2026-01-10', 1500.50, 'Delivered', 101), (2, '2026-02-15', 2300.00, 'Pending', 102), (3, '2026-03-05', 999.99, 'Shipped', 103), (4, '2026-04-20', 4500.75, 'Delivered', 104), (5, '2026-05-12', 1200.00, 'Cancelled', 105), (6, '2026-06-25', 3500.25, 'Processing', 106)");
			
			con.commit();
			
			System.out.println("Table created Sucessfully ..." + i +  "Row Effected " );
		
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally {
			con.close();
		}
	}

}
