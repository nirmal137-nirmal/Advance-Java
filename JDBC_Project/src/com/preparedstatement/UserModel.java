package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserModel {

	public void add(int id, String firstName, String lastName, String loginId, String password, Date dob)
			throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "nir13072001@N");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into users values(?,?,?,?,?,?)");

			pstmt.setInt(1, id);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, loginId);
			pstmt.setString(5, password);
			pstmt.setDate(6, new java.sql.Date(dob.getTime()));

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record inserted successfully : " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}
	

	public void delete(int id) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:/user_db", "root", "nir13072001@N");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("Delete from users Where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Data Deleted Sucessfully..." + i + " Row Effected ");

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

}
