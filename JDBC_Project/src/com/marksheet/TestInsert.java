package com.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet_db", "root",
				"nir13072001@N");

		System.out.println("Connection Established Successfully.." + com.getCatalog());

		Statement stmt = com.createStatement();
		
		int i = stmt.executeUpdate("insert into marksheet values(11, 111, 'pawan',45,85,45)");
		
		System.out.println("Data Inserted " + i + "Row Effected");

	}

}
