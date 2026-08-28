package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db", "root", "nir13072001@N");
		
		System.out.println("Database connection Establish SuccessFully..." + comn.getCatalog());
		
		Statement stmt = comn.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from employee");
		
		while(rs.next()) {
			System.out.println("Employee Id : " + rs.getInt("id"));
			System.out.println("Employee Name :" + rs.getString("name"));
			System.out.println("Employee Department :" + rs.getString("department"));
			System.out.println("Employee Salary :" + rs.getInt("salary"));
			System.out.println("Employee City : " + rs.getString("city"));
			
			System.out.println("---------------------------------------------");
		}
		
		
		
	}

}
