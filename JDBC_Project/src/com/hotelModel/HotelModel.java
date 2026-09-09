package com.hotelModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	// Search Method

	public static List search(HotelBean bean, int pageNo, int pageSize) throws Exception {

		Connection con = null;

		List<HotelBean> list = new ArrayList<HotelBean>();

		StringBuffer sql = new StringBuffer("Select * from hotel where 1=1"); // SQL Injection SQL Querry Ko Append Krne
																				// Ke liye

		try {
		if (bean != null) {

			if (bean.getHotelId() > 0) {
				sql.append(" and hotelId = " + bean.getHotelId());
			}
			if (bean.getHotelName() != null && bean.getHotelName().length() > 0) {
				sql.append("and hotelName like ' " + bean.getHotelName() + "% '");

			}
			if (bean.getLocation() != null && bean.getLocation().length() > 0) {
				sql.append("and location like '" + bean.getLocation() + "% '");
			}
			if (bean.getRating() > 0) {
				sql.append("and rating = " + bean.getRating());
			}
			if (bean.getContactNo() != null && bean.getContactNo().length() > 0) {
				sql.append("and location like '" + bean.getContactNo() + "% '");
			}

		}

		if(pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append(" limit " + index + " , " + pageSize);
		}
		
		System.out.println("sql ====> " + sql.toString());
		con =JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			bean = new HotelBean();
			bean.setHotelId(rs.getLong("hotelId"));
			bean.setHotelName(rs.getString("hotelName"));
			bean.setLocation(rs.getString("location"));
			bean.setRating(rs.getDouble("rating"));
			bean.setContactNo(rs.getString("contactNo"));
			list.add(bean);
		}
		}catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(con);
		}finally {
			JDBCDataSource.closeConnection(con);
		}
		return list;
	}

}
