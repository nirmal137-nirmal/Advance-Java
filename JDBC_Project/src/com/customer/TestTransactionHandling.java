package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {

	public static void main(String[] args) throws SQLException {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db", "root", "nir13072001@N");

			con.setAutoCommit(false); // Transaction begin

			Statement stmt = con.createStatement();

			int i = stmt.executeUpdate("Create Table Product(productId int primary Key, productName varchar(40), ExpiryDate Date)");
			
			con.commit(); // Commit Transaction

			System.out.println("Product Table will be created" + i + "Table Created");

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			
			con.rollback(); // Transaction roll back
		}finally {
			con.close();
		}
	}

}
