package bankaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JDBCDataSource {

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

	public static void trnRollback(Connection con) throws SQLException {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
