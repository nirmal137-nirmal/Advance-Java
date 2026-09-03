package com.bookmodelPstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookModel {

	public static void createTable() throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "nir13072001@N");

			PreparedStatement pstmt = con.prepareStatement(
					"Create table book (bookId int primary key, title varchar(40), author varchar(40), price double, publicationYear int)");

			int i = pstmt.executeUpdate();

			System.out.println("Table Created SucessFully.....");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Create Primary key

	public BookModelBean nextPk() throws Exception {

		Connection con = null;
		int pk = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "nir13072001@N");

			PreparedStatement pstmt = con.prepareStatement("Select max(bookId) from book");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

			System.out.println("create");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return null;

	}

	// add method

	public void add(BookModelBean bean) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("insert into book values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getBookId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getAuthor());
			pstmt.setDouble(4, bean.getPrice());
			pstmt.setInt(5, bean.getPublicationYear());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Record Inserted Successfully...." + i + "  Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}

	// Update

	public void update(BookModelBean bean) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE book SET title = ?, author = ?, price = ?, publicationYear = ? WHERE bookId = ?");

			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getAuthor());
			pstmt.setDouble(3, bean.getPrice());
			pstmt.setInt(4, bean.getPublicationYear());
			pstmt.setInt(5, bean.getBookId());

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Record Updated Successfully....." + 1);

		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();

		} finally {
			con.close();
		}

	}
	
	//Delete

	public void delete(int bookId) throws Exception {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "nir13072001@N");

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("delete from book where bookId = ? ");

			pstmt.setInt(1, bookId);

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
	
	//Search
	
	public void Search(BookModelBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "nir13072001@N");
		
		PreparedStatement pstmt = con.prepareStatement("Select * from book");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("Book Id  : " + rs.getInt("bookId"));
			System.out.println("Book Title :  " + rs.getString("title"));
			System.out.println("Book Author : " + rs.getString("author"));
			System.out.println("Price :" +  rs.getDouble("price"));
			System.out.println("Publication Year " + rs.getInt("publicationYear"));
			
			System.out.println("-----------------------------------");
		}
		
		 
		
	}

}
