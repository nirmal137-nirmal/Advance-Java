package com.hotelModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hotelBundle.JDBCDataSource;

public class HotelModel {

	// NextPk

	public static void nextPk() {

		Connection con = null;
		int pk = 0;

		try {
			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Select max(id) from hotel");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}
			con.commit();

			System.out.println("Next Primary Key Createdl..");

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(con);
		} finally {
			JDBCDataSource.closeConnection(con);
		}
	}

	// ADD
	public static void add(HotelBean bean) {

		Connection con = null;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Insert into hotel values (?,?,?,?,?)");

			pstmt.setLong(1, bean.getHotelId());
			pstmt.setString(2, bean.getHotelName());
			pstmt.setString(3, bean.getLocation());
			pstmt.setDouble(4, bean.getRating());
			pstmt.setString(5, bean.getContactNo());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Inserted Successfully .." + i + " Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(con);
		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}

	// update

	public static void update(HotelBean bean) {

		Connection con = null;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"update hotel set hotelName = ?, location = ?, rating = ?, contactNo = ? where hotelId = ?");

			pstmt.setString(1, bean.getHotelName());
			pstmt.setString(2, bean.getLocation());
			pstmt.setDouble(3, bean.getRating());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setLong(5, bean.getHotelId());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Update Successfully... " + i + " Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(con);
		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}

	// Delete

	public static void delete(long hotelId) {

		Connection con = null;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Delete from hotel where hotelId = ?");

			pstmt.setLong(1, hotelId);

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Delete Successfully....");

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(con);
		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}

}
