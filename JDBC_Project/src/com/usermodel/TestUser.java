package com.usermodel;

import java.text.SimpleDateFormat;

public class TestUser {

	public static void main(String[] args) throws Exception {

//		testCreateTable();
//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();/
//		testFindByPk();
//		testFindByLogin();
		testAuthenticate();
		
	}

	public static void testCreateTable() throws Exception {

		UserModel model = new UserModel();

		model.crateTable();

	}

	public static void testNextPk() throws Exception {

		UserModel model = new UserModel();

		model.nextPk();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(1);
		bean.setFirstName("Nirmal");
		bean.setLastName("Fayake");
		bean.setLoginId("nirmal@gmail.com");
		bean.setDob(sdf.parse("2001-07-13"));
		bean.setPassword("nirmal@123");

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Nirmal");
		bean.setLastName("Fayake");
		bean.setLoginId("nirmal@gmail.com");
		bean.setDob(sdf.parse("2001-07-13"));
		bean.setPassword("nirmal@123");

		bean.setId(1);

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		model.Delete(5);

	}


	public static void testFindByPk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = model.findByPk(3);

		if (bean != null) {

			System.out.println("Id = " + bean.getId());
			System.out.println("First Name = " + bean.getFirstName());
			System.out.println("Last Name = " + bean.getLastName());
			System.out.println("Login Id = " + bean.getLoginId());
			System.out.println("DOB = " + bean.getDob());
			System.out.println("Password = " + bean.getPassword());

		} else {
			System.out.println("Record Not Found");
		}
	}
	
	public static void testFindByLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLoginID("nirmal@gmail.com");
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
		System.out.println(bean.getPassword());
		System.out.println(bean.getLoginId());

	}
	
	public static void testAuthenticate() throws Exception {

	    UserModel model = new UserModel();
	    UserBean bean = new UserBean();

	   bean = model.authenticate("nirmal@gmail.com", "nirmal@123");

	        System.out.println("Id = " + bean.getId());
	        System.out.println("First Name = " + bean.getFirstName());
	        System.out.println("Last Name = " + bean.getLastName());
	        System.out.println("Login Id = " + bean.getLoginId());
	        System.out.println("Date Of Birth : " + bean.getDob());

	    } 
	}
