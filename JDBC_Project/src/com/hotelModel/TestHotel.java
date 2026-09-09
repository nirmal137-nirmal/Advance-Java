package com.hotelModel;

import java.util.Iterator;
import java.util.List;

import com.usermodel.UserModel;

public class TestHotel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}

	public static void testNextPk() throws Exception {

		UserModel model = new UserModel();

		model.nextPk();
	}

	public static void testAdd() {

		HotelModel model = new HotelModel();
		HotelBean bean = new HotelBean();

		bean.setHotelId(6);
		bean.setHotelName("Park Plaza");
		bean.setLocation("Lucknow");
		bean.setRating(6);
		bean.setContactNo("7418596320");

		model.add(bean);

	}

	public static void testUpdate() {
		HotelModel model = new HotelModel();
		HotelBean bean = new HotelBean();

		bean.setHotelName("Hotel Taj ");
		bean.setLocation("Mumbai");
		bean.setRating(8);
		bean.setContactNo("7418529630");
		bean.setHotelId(3);

		model.update(bean);
	}

	public static void testDelete() {

		HotelModel model = new HotelModel();

		model.delete(6);

	}
	
	public static void testSearch() throws Exception {
		HotelModel model = new HotelModel();
		HotelBean bean = new HotelBean();
		
		List list = model.search(bean, 1, 4);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			bean = (HotelBean) it.next();
			System.out.println("Hotel Id : " +bean.getHotelId());
			System.out.println("Hotel Name : " +bean.getHotelName());
			System.out.println("Hotel Location :" +bean.getLocation());
			System.out.println("Hotel Rating :" +bean.getRating());
			System.out.println("Hotel ContactNo : " +bean.getContactNo());
			
			System.out.println("----------------------------------------");
		}
		
	}

}
