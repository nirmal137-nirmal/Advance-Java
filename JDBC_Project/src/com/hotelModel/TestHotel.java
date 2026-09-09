package com.hotelModel;

import com.usermodel.UserModel;

public class TestHotel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
		testDelete();
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

}
