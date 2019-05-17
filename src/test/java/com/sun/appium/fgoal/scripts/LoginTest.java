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
	
//	@DataProvider
//	private Object[][] loginDataProviderNoUserName() {
//		return CSVHelper.loadUser(2,1);
//	}
//	
//	@DataProvider
//	private Object[][] loginDataProviderNoPassword() {
//		return CSVHelper.loadUser(0,3);
//	}
//	
//	@DataProvider
//	private Object[][] loginDataProviderNoUserNameAndPassword() {
//		return CSVHelper.loadUser(2,3);
//	}
	
//	@Test(priority = 0,dataProvider = "loginDataProviderNoUserName")
//	public void testLoginNoUserName(String userName, String passWord) {
//		loginPage = new LoginPage();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String emptyEmail = loginPage.getEmptyEmailText();
//		Assert.assertEquals(emptyEmail, "Empty email");
//	}
//	
//	@Test(priority = 1,dataProvider = "loginDataProviderNoPassword")
//	public void testLoginNoPassword(String userName, String passWord) {
//		loginPage = new LoginPage();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String emptyPassword = loginPage.getEmptyPasswordText();
//		Assert.assertEquals(emptyPassword, "Empty password");
//	}
//	
//	@Test(priority = 2,dataProvider = "loginDataProviderNoUserNameAndPassword")
//	public void testLoginNoUserNameAndPassword(String userName, String passWord) {
//		loginPage = new LoginPage();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String emptyEmail = loginPage.getEmptyEmailText();
//		Assert.assertEquals(emptyEmail, "Empty email");
//		String emptyPassword = loginPage.getEmptyPasswordText();
//		Assert.assertEquals(emptyPassword, "Empty password");
//	}

	@Test(dataProvider = "loginDataProvider")
	public void testLogin(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		Assert.assertEquals(loginPage.getToolbarTitle(), "Le Thi Ha");
	}
}