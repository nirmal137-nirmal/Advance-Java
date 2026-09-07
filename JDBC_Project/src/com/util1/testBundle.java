package com.util1;

import java.util.ResourceBundle;

public class testBundle {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.util1.app");
		
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
	}

}
