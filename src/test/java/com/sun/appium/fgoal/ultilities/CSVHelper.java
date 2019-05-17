package com.sun.appium.fgoal.ultilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CSVHelper {
	private static final String path = System.getProperty("user.dir");
	private static Properties user = new Properties();
	static {
		try {
			user.load(new FileInputStream(new File( path + "/data/user.csv")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object[][] loadUser() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username");
		userData[0][1] = user.get("password");
		return userData;
	}
	
//	public static Object[][] loadUser(int nameIndex, int passIndex)
//	{
//		/*
//		 * 0 : Correct user name
//		 * 1 : Correct password
//		 * 2 : No name
//		 * 3 : No password
//		*/
//		Object[][] userData = new Object[1][4];
//		userData[0][nameIndex] = user.get("username");
//		userData[0][passIndex] = user.get("password");
//		return userData;
//	}
}