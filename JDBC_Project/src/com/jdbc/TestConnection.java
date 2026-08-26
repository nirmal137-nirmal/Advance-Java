package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

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

		ResultSet rs = stmt.executeQuery("Select * from employee");

		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getDouble("Salary"));
			System.out.println(rs.getString("department"));
		}

	}

}
