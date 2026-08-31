package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db", "root", "nir13072001@N");
		
		System.out.println("Connection Establised Successfully...");
		
		Statement stmt = comn.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from Customer");
		
		while(rs.next()) {
			System.out.println("customer Id :" + rs.getInt("customerId"));
			System.out.println("Customer Name : " + rs.getString("customerName"));
			System.out.println("Customer Email :" + rs.getString("email"));
			System.out.println("Customer PhoneNumber : " +rs.getString("phoneNumber"));
			System.out.println("Customer address : " +rs.getString("adress"));
			System.out.println("--------------------------------------");
		}
	}

}
