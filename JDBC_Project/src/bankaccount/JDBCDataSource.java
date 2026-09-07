package bankaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDataSource {
	
	public static Connection getconnection() throws Exception {
		
//		ResourceBundle rb = ResourceBundle.getBundle("com.");
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "nir13072001@N");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

}
