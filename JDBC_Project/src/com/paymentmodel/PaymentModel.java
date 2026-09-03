package com.paymentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookmodelPstmt.BookModelBean;

public class PaymentModel {

	public static void createTable() throws Exception {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"create table payment (paymentId int primary key, amount double, paymentDate date, paymentMethod varchar(40), transactionId varchar(40))");

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Table Created Sucessfully .... ");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}

	public static PaymentBean nextpk() throws Exception {

		Connection con = null;
		int pk = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db", "root", "nir13072001@N");

			PreparedStatement pstmt = con.prepareStatement("Select max(paymentId) from payment ");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);

				System.out.println("created.....");

			}

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

		return null;
	}

	// add

	public void add(PaymentBean bean) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("insert into payment values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getPaymentId());
			pstmt.setDouble(2, bean.getAmount());
			pstmt.setDate(3, new java.sql.Date(bean.getPaymentDate().getTime()));
			pstmt.setString(4, bean.getPaymentMethod());
			pstmt.setString(5, bean.getTransactionID());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Inserted SucessFully... " + i + " Rows Effected");

		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();

		} finally {
			con.close();
		}

	}

	// Update

	public void update(PaymentBean bean) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"update payment set amount = ?, paymentDate = ?, paymentMethod = ?, transactionId = ? where paymentId = ?");

			pstmt.setDouble(1, bean.getAmount());
			pstmt.setDate(2, new java.sql.Date(bean.getPaymentDate().getTime()));
			pstmt.setString(3, bean.getPaymentMethod());
			pstmt.setString(4, bean.getTransactionID());
			pstmt.setInt(5, bean.getPaymentId());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Updated Successfully...." + i + " Row Effected");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}

	// Delete

	public void delete(int paymentId) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("delete from payment where paymentId = ? ");

			pstmt.setInt(1, paymentId);

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Data Deleted SuccessFully...." + i + " Row Effected ");
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}
	
	// Search

	public void Search(PaymentBean bean) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db", "root", "nir13072001@N");

			PreparedStatement pstmt = con.prepareStatement("Select * from payment");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.println("Payment Id  : " + rs.getInt("paymentId"));
				System.out.println("Amount :  " + rs.getDouble("amount"));
				System.out.println("Payment Date : " + rs.getDate("paymentDate"));
				System.out.println("Payment Method :" + rs.getString("paymentMethod"));
				System.out.println("Transaction ID " + rs.getString("transactionId"));

				System.out.println("-----------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}


}
