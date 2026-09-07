package com.doctorModel;

public class TestDoctor {
	
	public static void main(String[] args) throws Exception {
		
//		testCreateTable();
//		testNextPk();
		testAdd();
	}
	
	public static void testCreateTable() throws Exception {
		
		DoctorModel model = new DoctorModel();
		
		model.createTable();
	}
	
	public static void testNextPk() throws Exception {
		
		DoctorModel model = new DoctorModel();
		
		model.nextPk();
	}
	
	public static void testAdd() throws Exception {
		
		DoctorModel model = new DoctorModel();
		DoctorBean bean = new DoctorBean();
		
		bean.setDoctorId(5);
		bean.setDoctorName("Rohit Singh");
		bean.setSpecialization("Orthopedic");
		bean.setExperience(8);
		bean.setContactNo("9876543214");
		
		model.add(bean);
	}

}
