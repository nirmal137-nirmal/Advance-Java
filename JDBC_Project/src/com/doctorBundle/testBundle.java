package com.doctorBundle;

import java.util.ResourceBundle;

public class testBundle {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.doctorBundle.app");
		
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
	}

}
