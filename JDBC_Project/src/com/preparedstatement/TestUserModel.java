package com.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
		testDelete();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		model.add(114, "Sushil", "Mahajan", "sushil@gmail.com", "sushil123", sdf.parse("1998-02-15"));

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();
		model.delete(114);

	}

}
