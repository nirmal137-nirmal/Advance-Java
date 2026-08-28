package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db", "root", "nir13072001@N");
		
		System.out.println("Database Connection is Established SuccessFully..." + comn.getCatalog());
		
		Statement stmt = comn.createStatement();
		
		int i = stmt.executeUpdate("Delete from employee where id = 105");
		
		System.out.println("Data Deleted" + i + " Row Effected");
		
		
		
	}

}
