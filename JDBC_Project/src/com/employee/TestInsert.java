package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {
		
	Class.forName ("com.mysql.cj.jdbc.Driver");
	
	Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db", "root", "nir13072001@N");
	
	System.out.println("Connection  Established Successfully...." + comn.getCatalog());
	
	Statement stmt = comn.createStatement();
	
	//int i = stmt.executeUpdate("create table employee(id int primary key, name varchar(40), department varchar(40), salary int , city varchar(40))");
	
	/*
	 * int i = stmt.
	 * executeUpdate("insert into employee values(101, 'Rupesh', 'IT', 25000, 'pune'),(102, 'Bhushan', 'IT', 20000, 'pune'),(103, 'Jitendra', 'Finance', 35100, 'Pune'),(104, 'Abhishek', 'Marketing', 18000, 'Indore'),(105, 'Nayan', 'TelePerformance', 13500, 'Indore')"
	 * );
	 * 
	 * System.out.println("Record Inserted " + i + "Row Effected");
	 */
	
	int i = stmt.executeUpdate("Select * from employee");
	
	System.out.println("Employee Table");
	
	}

}
