package com.doctorModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doctorBundle.JDBCDataSource;

public class DoctorModel {

	// Create Table
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

	// Create Pk
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

	// Add
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
			pstmt.setString(5, bean.getContactNumber());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Inserted SuccessFully... " + i + " Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}

	// Update

	public static void Update(DoctorBean bean) throws SQLException {
		Connection con = null;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"Update Doctor set DoctorName = ?, Specialization = ?, Experience = ?, ContactNumber = ? Where DoctorId = ? ");

			pstmt.setString(1, bean.getDoctorName());
			pstmt.setString(2, bean.getSpecialization());
			pstmt.setInt(3, bean.getExperience());
			pstmt.setString(4, bean.getContactNumber());
			pstmt.setLong(5, bean.getDoctorId());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Updated SuccessFully... " + i + " Row Effected...");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
	}

	// Delete

	public static void Delete(int doctorId) throws Exception {

		Connection con = null;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Delete From Doctor where DoctorId = ? ");

			pstmt.setInt(1, doctorId);

			int i = pstmt.executeUpdate();

			con.commit();
			System.out.println("Data Deleted Successfully... " + i + " Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}

	// Search

	public List search(DoctorBean bean, int pageNo, int pageSize) throws Exception {

		StringBuffer sql = new StringBuffer("Select * from doctor where 1=1");
		// Where 1=1 is sql Injection to used Sql Querry Append Karnr ke lite SQL
		// Injection Ka Use krte hai
		List<DoctorBean> list = new ArrayList<DoctorBean>();
		Connection con = null;

		try {

			if (bean != null) {
				if (bean.getDoctorId() > 0) {
					sql.append(" and doctorId = " + bean.getDoctorId());
				}

				if (bean.getDoctorName() != null && bean.getDoctorName().length() > 0) {
					sql.append("and doctorName like ' " + bean.getDoctorName() + "%'");
				}
				if (bean.getSpecialization() != null && bean.getSpecialization().length() > 0) {
					sql.append("and Specialization like ' " + bean.getSpecialization() + " % '");
				}

				if (bean.getExperience() > 0) {
					sql.append("and experience = " + bean.getExperience());
				}

				if (bean.getContactNumber() != null && bean.getContactNumber().length() > 0) {
					sql.append("and contactNumber = ' " + bean.getContactNumber() + " % '");

				}
			}

			if (pageSize > 0) {
				int index = (pageNo - 1) * pageSize;
				sql.append(" limit " + index + ", " + pageSize);
			}

			System.out.println("sql ====> " + sql.toString());
			con = JDBCDataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new DoctorBean();
				bean.setDoctorId(rs.getLong("DoctorId"));
				bean.setDoctorName(rs.getString("DoctorName"));
				bean.setSpecialization(rs.getString("Specialization"));
				bean.setExperience(rs.getInt("Experience"));
				bean.setContactNumber(rs.getString("ContactNumber"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return list;

	}
}
