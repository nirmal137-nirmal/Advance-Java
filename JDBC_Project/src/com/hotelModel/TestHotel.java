package com.hotelModel;

public class TestHotel {
	
	public static void main(String[] args) {
		
		testAdd();
	}
	
	public static void testAdd() {
		
		HotelModel model = new HotelModel();
		HotelBean bean = new HotelBean();
		
		bean.setHotelId(1);
		bean.setHotelName("Hotel Sayaji ");
		bean.setLocation("Indore");
		bean.setRating(5);
		bean.setContactNo("7418529630");
		
		model.add(bean);
		
	}

}
