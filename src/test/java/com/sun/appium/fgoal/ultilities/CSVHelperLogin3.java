package com.sun.appium.fgoal.ultilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CSVHelperLogin3 {
	private static final String path = System.getProperty("user.dir");
	private static Properties user = new Properties();
	static {
		try {
			user.load(new FileInputStream(new File( path + "/data/LeThiHa.csv")));
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
	
	public static Object[][] loadUser(int nameIndex, int passIndex)
	{
		/*
		 * 0 : Data
		 * 1 : No Data
		*/
		String name = null;
		if(nameIndex != 0)
		{
			name = (String) user.get("username");
		} else {
			name = (String) user.get("usernameEmpty");
		}
		String password = null;
		if(passIndex != 0)
		{
			password = (String) user.get("password");
		} else {
			password = (String) user.get("passwordEmpty");
		}
		Object[][] userData = new Object[1][2];
		userData[0][0] = name;
		userData[0][1] = password;
		return userData;
	}
	
	public static Object[][] loadUser08() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username08");
		userData[0][1] = user.get("password");
		return userData;
	}
	
	public static Object[][] loadUser09() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username09");
		userData[0][1] = user.get("password");
		return userData;
	}
	public static Object[][] loadUser13() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username13");
		userData[0][1] = user.get("password");
		return userData;
	}
	public static Object[][] loadUser14() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username");
		userData[0][1] = user.get("password14");
		return userData;
	}
	public static Object[][] loadUser15() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username15");
		userData[0][1] = user.get("password");
		return userData;
	}
	public static Object[][] loadUser16() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username16");
		userData[0][1] = user.get("password");
		return userData;
	}
	public static Object[][] loadUser17() {
		Object[][] userData = new Object[1][2];
		userData[0][0] = user.get("username17");
		userData[0][1] = user.get("password");
		return userData;
	}
}