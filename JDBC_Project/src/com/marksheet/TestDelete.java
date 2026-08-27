package com.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet_db", "root", "nir13072001@N");

		System.out.println("Connection Established Successflly ...." + comn.getCatalog());

		Statement stmt = comn.createStatement();

		int i = stmt.executeUpdate("Delete From marksheet WHERE id = 11");

		System.out.println("record inserted " + i + "Row effected");

	}

}
