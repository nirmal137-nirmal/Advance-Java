package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db", "root",
				"nir13072001@N");

		System.out.println("Connection Established Successfully.." + comn.getCatalog());

		Statement stmt = comn.createStatement();

		/*
		 * int i = stmt.executeUpdate(
		 * "create table customer(customerId int primary key, customerName varchar(40), email varchar(40), phoneNumber varchar(40), adress varchar(40))"
		 * );
		 * 
		 * System.out.println("Customer Table will be created" + i + "Table Created");
		 */

		/*
		 * int i = stmt.
		 * executeUpdate("Insert into customer values (101, 'Nirmal', 'nirmal@gmail.com', '9753570572', 'Indore'),(102, 'Rupesh', 'rupesh@gmail.com','9617382689','Pune'),(103,'Bhsuhan', 'bhushan@gmail.com', '9635715789', 'Pune'),(104, 'Jitendra', 'jitendra@gmail.com','7418529630', 'Pune')"
		 * );
		 * 
		 * System.out.println("Data Inserted Successfully" + i + "Row Effected ");
		 */
		
		ResultSet rs = stmt.executeQuery("Select * from customer");
		
		while(rs.next()) {
			
			System.out.println("Customer Id : " + rs.getInt("customerId"));
			System.out.println("Custoner Name : " + rs.getString("customerName"));
			System.out.println("Customer Email : " + rs.getString("email"));
			System.out.println("Customer Phone Number :" + rs.getString("phoneNumber"));
			System.out.println("Customer City :" + rs.getString("adress"));
			
			System.out.println("-----------------------------------------------------");
		}

	}

}
