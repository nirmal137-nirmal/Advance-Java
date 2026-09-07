package bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankModel {

	public static void createTable() throws Exception {

		Connection con = null;

		try {
			con = JDBCDataSource.getconnection();
			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"Create table bank (AccountNumber bigInt primary Key, AccountHolderName Varchar(40), AccountType Varchar(40), Balance Double, BranchName Varchar(40))");

			int i = pstmt.executeUpdate();

			con.commit();

			System.out.println("Table Created SuccessFully....");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}
 
	 // Add 
	public static void add(BankBean bean) throws SQLException {

		Connection con = null;

		try {
			con = JDBCDataSource.getconnection();
			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("Insert Into bank Values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getAccountNumber());
			pstmt.setString(2, bean.getAccountHolderName());
			pstmt.setString(3, bean.getAccountType());
			pstmt.setDouble(4, bean.getBalance());
			pstmt.setString(5, bean.getBranchName());

			int i = pstmt.executeUpdate();
			con.commit();

			System.out.println("Data Insert SuccessFully... " + i + " Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
	}
	// Update Mehtod 
	public static void update(BankBean bean) throws Exception {
		Connection con = null;

		try {
			con = JDBCDataSource.getconnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"Update Bank set AccountNumber = ? , AccountType = ?, Balance = ?, BranchName = ? Where AccountHolderName = ?");

			pstmt.setLong(1, bean.getAccountNumber());
			pstmt.setString(2, bean.getAccountType());
			pstmt.setDouble(3, bean.getBalance());
			pstmt.setString(4, bean.getBranchName());
			pstmt.setString(5, bean.getAccountHolderName());

			int i = pstmt.executeUpdate();
			con.commit();

			System.out.println("Data Updated SuccessFully..." + i + " Row Effected ");

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
	}
	
	// Delete
	
	public static void delete(long accountNumber) throws Exception {
		
		Connection con =  null ;
		
		try {
			con = JDBCDataSource.getconnection();
			
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement("Delete from bank where AccountNumber = ?");
			
			pstmt.setLong(1, accountNumber);
			
			int i = pstmt.executeUpdate();
			
			
			con.commit();
			System.out.println("Data Deleted SuccessFully... " + i + " Row Effected ");
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			
		}finally {
			con.close();
		}
	}
	
}
