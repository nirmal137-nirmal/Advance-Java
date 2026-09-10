package com.eventmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.eventBundle.JDBCDataSource;

public class EventModel {

	// Next primary key

	public static long nextPk() {

		Connection con = null;
		long pk = 0;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Select max(eventId) from event");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getLong(1);
			}

			con.commit();

			System.out.println("Next Primary key Will be Generated..");

		} catch (Exception e) {
			JDBCDataSource.turnRollBack(con);

			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		return pk + 1;
	}

	// add

	public static void add(EventBean bean) {

		Connection con = null;

		try {

			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("insert into event values (?,?,?,?,?)");

			pstmt.setLong(1, nextPk());
			pstmt.setString(2, bean.getEventName());
			pstmt.setDate(3, new java.sql.Date(bean.getEventdate().getTime()));
			pstmt.setString(4, bean.getVenue());
			pstmt.setString(5, bean.getOrganizer());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Update SuccessFully... " + i + " Row Effected.. ");

		} catch (Exception e) {
			JDBCDataSource.turnRollBack(con);
		} finally {
			JDBCDataSource.closeConnection(con);
		}
	}

	// update

	public static void update(EventBean bean) {

		Connection con = null;

		try {

			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"update Event set eventName = ?, eventDate =?, venue =?, organizer = ? where eventId = ?");

			pstmt.setString(1, bean.getEventName());
			pstmt.setDate(2, new java.sql.Date(bean.getEventdate().getTime()));
			pstmt.setString(3, bean.getVenue());
			pstmt.setString(4, bean.getOrganizer());
			pstmt.setLong(5, bean.getEventId());

			int i = pstmt.executeUpdate();
			con.commit();

			System.out.println("Data Updated Successfully...." + i + "Row Effected...");

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.turnRollBack(con);
		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}
}
