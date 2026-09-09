package com.hotelModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hotelBundle.JDBCDataSource;

public class HotelModel {
	
	// ADD
	public static void add (HotelBean bean) {
		
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
		}finally {
			JDBCDataSource.closeConnection(con);
		}
	
	}

}
