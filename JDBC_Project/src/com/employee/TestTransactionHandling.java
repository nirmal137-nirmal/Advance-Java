package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class TestTransactionHandling {

	public static void main(String[] args) throws Exception {

		Connection conn = null;
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db", "root", "nir13072001@N");
			
			//begin Transaction
			conn.setAutoCommit(false);
			
			//create Statement 
			Statement stmt = conn.createStatement();
			
			//Create Table
			
			int i = stmt.executeUpdate("Create Table employees_Details(id int primary key, name varchar(40), departmentId int, salart int)");
			
			//commit Transaction
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			
		}finally {
			conn.close();
		}

	}

}
