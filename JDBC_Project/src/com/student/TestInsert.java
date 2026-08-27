package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_db", "root",
				"nir13072001@N");

		System.out.println("Connection Established SuccessFully." + comn.getCatalog());

		Statement stmt = comn.createStatement();

		/*
		 * int i = stmt.
		 * executeUpdate("create table student(id int primary key, name varchar(40), email varchar(40), mobileNo varchar(10), course varchar(40))"
		 * );
		 * 
		 * System.out.println("Table created ");
		 */

		int i = stmt.executeUpdate("Insert into student values(101, 'Nirmal', 'nirmal@gmail.com', '9753570572', 'MCS'),(102,'Abhishek', 'abhishek@gmail.com', '4141758545','MCA'),(103, 'Nayan', 'nayan@gmail.com', '7485961237','BTech'),(104, 'Bhushan', 'bhushan@gmail.com', '1425367891','BBA'),(105, 'Rupeh', 'rupesh@gmail.com', '9617382689','LLB')");

		System.out.println("Record Inserted" + i + "Row Effected");

	}

}
