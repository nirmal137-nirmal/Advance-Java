package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_db ", "root", "nir13072001@N");
		
		System.out.println("Connection Established Successfully ." + comn.getCatalog());
		
		Statement stmt = comn.createStatement();
		
		int i = stmt.executeUpdate("update student set name = 'Rupesh' WHERE id = 105");
		
		System.out.println("Record Inserted " + i + "Row Effected");
		
	}

}
