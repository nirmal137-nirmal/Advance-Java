package com.hotelBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public final class JDBCDataSource {

	public static Connection getConnection() {

		Connection con = null;

		ResourceBundle rb = ResourceBundle.getBundle("com.hotelBundle.hotel");

		try {
			Class.forName(rb.getString("driver"));

			con = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void trnRollback(Connection con) {
		try {
			con.rollback();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
