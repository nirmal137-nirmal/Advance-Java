package com.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet_db", "root", "nir13072001@N");
		
		System.out.println("Connection Established Successfully.." + com.getCatalog());
		
		Statement stmt = com.createStatement();
		
		//ResultSet rs = stmt.executeQuery("Select * from marksheet ");
	
		// Top 3 
		//ResultSet rs = stmt.executeQuery("SELECT *, (phy + chm + maths) AS total " + "FROM marksheet " + "ORDER BY total DESC " + "LIMIT 3");
		
		// marit list
		ResultSet rs = stmt.executeQuery("SELECT *, (phy + chm + maths) AS total " + "FROM marksheet " + "ORDER BY total DESC");
		
		//ResultSet rs = stmt.executeQuery("Select *,(phy + chm + maths)as total from marksheet where phy>=33 and chm>=33 and maths>= 33 order by total desc limit 0,3 ");

		
		while(rs.next()) {
			System.out.println("Id : " + rs.getInt("id"));
			System.out.println("Roll No :  " +rs.getInt("rollNo"));
			System.out.println("Name : " + rs.getString("Name"));
			System.out.println("Physics :  " + rs.getInt("phy"));
			System.out.println("Chemistry : " + rs.getInt("chm"));
			System.out.println("Maths :  " + rs.getInt("maths"));
			int total = rs.getInt("phy") + rs.getInt("chm") + rs.getInt("maths");
			double percentage = (total / 3);
			System.out.println("Total :" +total);
			System.out.println("Percentage : " + percentage);
			
			System.out.println("--------------------------");
			
		}
		
	}
	
	

}
