package com.util1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class JDBCDataSource {
	

	public static Connection getConnection() {
		
		Connection con  = null;
		
		ResourceBundle rb = ResourceBundle.getBundle("com.util1.app");
		
		try {
			Class.forName(rb.getString("driver"));
			
			con = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
		
		return null;
		
		
		
	}

}
