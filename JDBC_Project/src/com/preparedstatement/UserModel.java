package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserModel {
	
	// Create Table
	
	public void createTable() throws Exception {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "nir13072001@N");
			
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement("create table Employee(employeeId int primary key, employeeName varchar(40), department varchar(40), salary double)");
			
			int i = pstmt.executeUpdate();
			con.commit();
			System.out.println("table Created Sucessfully.....");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		}
		
	}
	
	// Insert Data Into Table

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
	
	// Delete Data form table
	

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

	public void update(int id, String firstName, String lastName, String loginId, String Password, Date dob) throws Exception {

		Connection con = null;
			
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE users SET firstName=?, lastName=?, loginId=?, password=?, dob=? WHERE id=?");
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, loginId);
			pstmt.setString(4, Password);
			pstmt.setDate(5, new java.sql.Date(dob.getTime()));
			pstmt.setInt(6, id);
			
			int i = pstmt.executeUpdate();
			con.commit();
			
			System.out.println("Data Updated Sucessfully " + i +  " Row Effected ");
		
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			
		}finally {
			con.close();
		}
	}

}
