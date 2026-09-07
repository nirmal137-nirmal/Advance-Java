package bankaccount;

import java.sql.SQLException;

public class TestBank {
	
	public static void main(String[] args) throws Exception {
		
//		testCreateTable();
//		testAdd();
//		testUpdate();
		testDelete();
	}
	
	public static void testCreateTable() throws Exception {
		
		BankModel model = new BankModel();
		
		model.createTable();
	}
	
	public static void testAdd() throws SQLException {
		
		BankModel model = new BankModel();
		BankBean bean = new BankBean();
		
		bean.setAccountNumber(958910110002509L);
		bean.setAccountHolderName("Pavan Mahajan");
		bean.setAccountType("Saving");
		bean.setBalance(710200.00);
		bean.setBranchName("Axis Bank");
		
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		
		BankModel model = new BankModel();
		BankBean bean = new BankBean();
		
		bean.setAccountNumber(97418529630152L);
		bean.setAccountType("Saving");
		bean.setBalance(7500000);
		bean.setBranchName("SBI Bank");
		bean.setAccountHolderName("Nirmal Fayake");
		
		model.update(bean);
	}
	
	public static void testDelete() throws Exception {
		BankModel model = new BankModel();
		
		
		model.delete(7418529630L);
	}
}
