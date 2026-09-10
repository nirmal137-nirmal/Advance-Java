package com.eventmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.doctorModel.DoctorBean;
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

	// Delete

	public static void delete(long eventId) {

		Connection con = null;

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Delete from Event Where eventid = ?");

			pstmt.setLong(1, eventId);

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Deleted Successfully..." + i + " Row Effected");

		} catch (Exception e) {
			JDBCDataSource.turnRollBack(con);
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}

	public List search(EventBean bean, int pageNo, int pageSize) throws Exception {

		StringBuffer sql = new StringBuffer("SELECT * FROM event WHERE 1=1");

		List<EventBean> list = new ArrayList<EventBean>();

		Connection con = null;

		try {

			if (bean != null) {

				// Event Id
				if (bean.getEventId() > 0) {
					sql.append(" AND eventId = " + bean.getEventId());
				}

				// Event Name
				if (bean.getEventName() != null && bean.getEventName().length() > 0) {

					sql.append(" AND eventName LIKE '" + bean.getEventName() + "%'");
				}

				// Event Date
				if (bean.getEventdate() != null) {
					sql.append(" AND eventDate = '" + bean.getEventdate() + "'");
				}
				
				// Venue
				if (bean.getVenue() != null && bean.getVenue().length() > 0) {

					sql.append(" AND venue LIKE '" + bean.getVenue() + "%'");
				}

				// Organizer
				if (bean.getOrganizer() != null && bean.getOrganizer().length() > 0) {

					sql.append(" AND organizer LIKE '" + bean.getOrganizer() + "%'");
				}
			}

			// Pagination
			if (pageSize > 0) {

				int index = (pageNo - 1) * pageSize;

				sql.append(" LIMIT " + index + ", " + pageSize);
			}

			System.out.println("sql ====> " + sql.toString());

			con = JDBCDataSource.getConnection();

			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new EventBean();

				bean.setEventId(rs.getLong("eventId"));
				bean.setEventName(rs.getString("eventName"));
				bean.setEventdate(rs.getDate("eventDate"));
				bean.setVenue(rs.getString("venue"));
				bean.setOrganizer(rs.getString("organizer"));

				list.add(bean);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (con != null) {
				con.close();
			}
		}

		return list;
	}
}
