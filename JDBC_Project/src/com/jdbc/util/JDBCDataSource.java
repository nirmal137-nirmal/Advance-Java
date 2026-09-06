package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class JDBCDataSource {

	public static Connection getConnection() {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.system");

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

}