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
}