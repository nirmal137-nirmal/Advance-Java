package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws Exception {
		
		// Step 1. Load Driver Class
				Class.forName("com.mysql.cj.jdbc.Driver");

				// step 2. Make Connection to the database
				Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "nir13072001@N");

				System.out.println("Connection Established Successflly ...." + comn.getCatalog());

				// step 3. create Statement and get ResultSet or insert, update and delete
				// records

				Statement stmt = comn.createStatement();

				// Step 4 get All Record

				int i = stmt.executeUpdate("DELETE FROM employee WHERE id = 4 ");
				
				System.out.println("record deleted " + i + " row Effected");
	}

}
