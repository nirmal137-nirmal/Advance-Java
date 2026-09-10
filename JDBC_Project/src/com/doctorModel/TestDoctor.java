package com.doctorModel;


import java.util.Iterator;
import java.util.List;



public class TestDoctor {

	public static void main(String[] args) throws Exception {

//		testCreateTable();
//		testNextPk();
		testAdd();
//		testUpdate();
//		testDelete();
//		testSearch();
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

		bean.setDoctorName("Rohit Singh");
		bean.setSpecialization("Orthopedic");
		bean.setExperience(8);
		bean.setContactNumber("9876543214");
		bean.setDoctorId(5);

		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		DoctorModel Model = new DoctorModel();
		DoctorBean bean = new DoctorBean();

		bean.setDoctorName("Rohit Singh");
		bean.setSpecialization("Orthopedic");
		bean.setExperience(10);
		bean.setContactNumber("9876543214");
		bean.setDoctorId(5);

		Model.Update(bean);

	}

	public static void testDelete() throws Exception {

		DoctorModel model = new DoctorModel();
		DoctorBean bean = new DoctorBean();

		model.Delete(5);
	}

	public static void testSearch() throws Exception {

		DoctorModel model = new DoctorModel();
		DoctorBean bean = new DoctorBean();

		List list = model.search(bean, 1, 2);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (DoctorBean) it.next();
			System.out.println("Doctor Id : " +bean.getDoctorId());
			System.out.println("Doctor Name : " +bean.getDoctorName());
			System.out.println("Doctor Specialization : " + bean.getSpecialization());
			System.out.println("Doctor Experience : " + bean.getExperience());
			System.out.println("Doctor Contact NO : " +bean.getContactNumber());

			System.out.println("-----------------------");
		}
	}

}
