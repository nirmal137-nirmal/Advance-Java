package com.doctorModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.doctorBundle.JDBCDataSource;

public class DoctorModel {

	public static void createTable() throws Exception {

		Connection con = null;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"Create table Doctor(doctorId BigInt primary Key, DoctorName varchar(45), Specialization varchar(45), Experience Int, ContactNumber Varchar(45))");

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Table Created Successfully......");

		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
	}

	public DoctorBean nextPk() throws Exception {

		Connection con = null;
		long pk = 0;

		try {

			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Select max(doctorid) from Doctor");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getLong(1);

			}

			con.commit();

			System.out.println("Primary Key Created...");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

		return null;

	}
	
	public static void add(DoctorBean bean) throws Exception {
		
		Connection con = null;
		
		try {
			con = JDBCDataSource.getConnection();
			
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement("Insert Into doctor values (?,?,?,?,?)");
			
			pstmt.setLong(1, bean.getDoctorId());
			pstmt.setString(2, bean.getDoctorName());
			pstmt.setString(3, bean.getSpecialization());
			pstmt.setInt(4, bean.getExperience());
			pstmt.setString(5, bean.getContactNo());
			
			int i = pstmt.executeUpdate();
			
			con.commit();
			
			System.out.println("Data Inserted SuccessFully... " + i + " Row Effected ");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally {
			con.close();
		}
		
	}
}
