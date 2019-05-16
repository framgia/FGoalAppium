package com.sun.appium.fgoal.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.appium.fgoal.base.BaseClass;
import com.sun.appium.fgoal.pages.LoginPage;
import com.sun.appium.fgoal.ultilities.CSVHelper;

/**
 * @author CHIRAG
 *
 */
public class LoginTest extends BaseClass {

	LoginPage loginPage;

	@DataProvider
	private Object[][] loginDataProvider() {
		return CSVHelper.loadUser();
	}

	@Test(dataProvider = "loginDataProvider")
	public void testLogin(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		Assert.assertEquals(loginPage.getToolbarTitle(), "Chu Anh Tuan");
	}
}