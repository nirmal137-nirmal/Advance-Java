package com.usermodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcConnection;

public class UserModel {

	// Create Table

	public static void crateTable() throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"Create Table user(id int primary key, firstName Varchar(40), lastName varchar(40), loginId varchar(40), dob date, password varchar(40) )");

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Table Created SuccessFully.... " + i + " Row Effected SucessFully");

		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}

	// Create Primary key

	public UserBean nextPk() throws Exception {

		Connection con = null;
		int pk = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Select max(id) from user");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

			con.commit();

			System.out.println("Primary key Created Successfully ");

		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();

		} finally {
			con.close();
		}

		return null;

	}

	// add Method

	public void add(UserBean bean) throws Exception {

		Connection con = null;

		UserBean existBean = findByLoginID(bean.getLoginId());
		if (existBean != null) {
			throw new RuntimeException("loginId already exist");
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("insert into user values(?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getPassword());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Inserted Successfully... " + i + " Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}

	// update Method

	public void update(UserBean bean) throws Exception {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"update user set firstName = ?, lastName = ?, loginId =?, dob =?, password =? where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getPassword());

			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();

			con.commit();
			System.out.println("Data Updated Successfully... " + i + " Row Effected");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
	}

	// Delete Method

	public void Delete(int id) throws Exception {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Delete from user where id = ?");

			pstmt.setInt(1, id);

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

	// find by Pk
	public UserBean findByPk(int id) throws Exception {

		Connection con = null;
		UserBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("select * from user where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setDob(rs.getDate("dob"));
				bean.setPassword(rs.getString("password"));
			}

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();

		} finally {
			con.close();
		}

		return bean;

	}

	// find by LoginId

	public UserBean findByLoginID(String loginId) throws Exception {

		Connection conn = null;
		UserBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("select * from user where loginId = ?");

			pstmt.setString(1, loginId);

			conn.commit();

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setDob(rs.getDate("dob"));
				bean.setPassword(rs.getString("password"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();

		}

		return bean;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {

		UserBean bean = new UserBean();

		bean = findByLoginID(loginId);

		if (bean != null && bean.getPassword().equals(password)) {
			return bean;
		}

		return null;

	}

	public List<UserBean> search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Connection con = null;

		List<UserBean> list = new ArrayList<UserBean>();

		StringBuffer sql = new StringBuffer("SELECT * FROM user WHERE 1 = 1 ");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" AND firstName LIKE '" + bean.getFirstName() + "%' ");
			}

			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" AND lastName LIKE '" + bean.getLastName() + "%' ");
			}

			if (bean.getLoginId() != null && bean.getLoginId().length() > 0) {
				sql.append(" AND loginId LIKE '" + bean.getLoginId() + "%' ");
			}

			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" AND dob = '" + new java.sql.Date(bean.getDob().getTime()) + "' ");
			}

			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" AND password LIKE '" + bean.getPassword() + "%' ");
			}
		}

		if (pageSize > 0) {

			int index = (pageNo - 1) * pageSize;

			sql.append(" LIMIT " + index + ", " + pageSize);
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata_db", "root", "nir13072001@N");
			
			

			System.out.println("SQL Search Query ====> " + sql.toString());

			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new UserBean();

				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setDob(rs.getDate("dob"));
				bean.setPassword(rs.getString("password"));

				list.add(bean);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
}
