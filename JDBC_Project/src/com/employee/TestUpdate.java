package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/company_db", "root", "nir13072001@N");
		
		System.out.println("Connection Established SuccessFully..." + comn.getCatalog());
		
		
		Statement stmt = comn.createStatement();
		
		int i = stmt.executeUpdate("update employee set name = 'Nirmal' Where id = 105");
		
		System.out.println("Data Updated " + i + " Row - Effected ");
		
		
	}

}
