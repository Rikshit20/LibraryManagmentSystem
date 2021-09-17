package com.Configure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Data_Connection {

	public static Connection c = null;

	public static String url = "jdbc:mysql://localhost:3306/library_managment_system";
	public static Scanner sc = new Scanner(System.in);

	public static Connection myConn() {
		System.out.println("Enter username:");
		String uname = sc.nextLine();
		System.out.println("Enter password");
		String pname = sc.nextLine();
		try {

			c = DriverManager.getConnection(url, uname, pname);
			System.out.println("Access Successful");
		} catch (Exception e) {
			System.out.println("Invalid username and password");

			e.printStackTrace();
		}
		return c;

	}

}
