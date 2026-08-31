package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db", "root", "nir13072001@N");
		
		Statement stmt = comn.createStatement();
		
		int i = stmt.executeUpdate("Alter table customer change COLUMN adress  address varchar(40)");
		
		System.out.println("Column Name Updated Sucessfully... " + i + "Column Effected ");
	}

}
