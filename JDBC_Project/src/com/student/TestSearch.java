package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_db", "root", "nir13072001@N");
		
		System.out.println("Connection Established Successfully..." + comn.getCatalog());
		
		Statement stmt = comn.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from student");
		
		while(rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("mobileNo"));
			System.out.println(rs.getString("course"));
			
			System.out.println("---------------------------");
			
		}
	}

}
