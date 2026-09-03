package com.paymentmodel;

import java.text.SimpleDateFormat;

public class TestPayment {

	public static void main(String[] args) throws Exception {

//		testCreate();
//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();

	}

	public static void testCreate() throws Exception {

		PaymentModel model = new PaymentModel();

		model.createTable();

	}

	public static void testNextPk() throws Exception {

		PaymentModel model = new PaymentModel();

		model.nextpk();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		PaymentModel model = new PaymentModel();
		PaymentBean bean = new PaymentBean();

		bean.setPaymentId(106);
		bean.setAmount(15000.21);
		bean.setPaymentDate(sdf.parse("2026-09-02"));
		bean.setPaymentMethod("UPI");
		bean.setTransactionID("TXN106GHI");

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		PaymentModel model = new PaymentModel();
		PaymentBean bean = new PaymentBean();

		bean.setPaymentId(104);
		bean.setAmount(35000.21);
		bean.setPaymentDate(sdf.parse("2026-09-02"));
		bean.setPaymentMethod("UPI");
		bean.setTransactionID("TXN106GHI");

		model.update(bean);

	}
	
	public static void testDelete() throws Exception {
		
		PaymentModel model = new PaymentModel();
		PaymentBean bean = new PaymentBean();
		
		model.delete(106);
		
	}
	
	public static void testSearch() throws Exception {
		
		PaymentModel model = new PaymentModel();
		PaymentBean bean = new PaymentBean();
		
		model.Search(bean);
	}

}
