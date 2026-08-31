package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db", "root", "nir13072001@N" );
		
		System.out.println("Connection Established Successfully....");
		
	    Statement stmt =  comn.createStatement();
	    
	    int i = stmt.executeUpdate("Delete from customer where customerId = 104" );
	    
	    System.out.println("Id Will be deleted " + i + " Row Effected");
		
		
	}

}
