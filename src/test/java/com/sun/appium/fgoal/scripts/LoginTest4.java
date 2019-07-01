package com.sun.appium.fgoal.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.appium.fgoal.base.BaseClass;
import com.sun.appium.fgoal.pages.LoginPage2;
import com.sun.appium.fgoal.ultilities.CSVHelperLogin4;

/**
 *@author LE THI HA TC18 TC19 TC20 TC21 TC22 TC23 TC24
 *
 */
public class LoginTest4 extends BaseClass {

	LoginPage2 loginPage;

	
	@DataProvider
	private Object[][] loginDataProviderpaceBeginningEndPassword() {
		return CSVHelperLogin4.loadUser18();
	}
	
	@DataProvider
	private Object[][] loginDataProviderShortPassword() {
		return CSVHelperLogin4.loadUser19();
	}
	
	@DataProvider
	private Object[][] loginDataProviderLongPassword() {
		return CSVHelperLogin4.loadUser20();
	}
	
	@DataProvider
	private Object[][] loginDataProviderSpecialCharactersPassword() {
		return CSVHelperLogin4.loadUser21();
	}
	
	@DataProvider
	private Object[][] loginDataProviderSqlCharactersPassword() {
		return CSVHelperLogin4.loadUser22();
	}
	
	@DataProvider
	private Object[][] loginDataProviderHtmlCharactersPassword() {
		return CSVHelperLogin4.loadUser23();
	}
	
	@DataProvider
	private Object[][] loginDataProviderUppercaseLowercasePassword() {
		return CSVHelperLogin4.loadUser24();
	}
	
//	//TC18- Toast message => Pending
//	@Test(priority = 0,dataProvider = "loginDataProviderpaceBeginningEndPassword")
//	public void testUppercaseLowercaseUserName(String userName, String passWord) {
//		loginPage = new LoginPage2();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String spacePassword = loginPage.getPassword();
//		Assert.assertEquals(spacePassword, "Sai mật khẩu hoặc email");
//		loginPage.clearAllText();
//	}
	
//	//TC19
//	
//	@Test(priority = 1,dataProvider = "loginDataProviderShortPassword")
//	public void testLoginShortPassword(String userName, String passWord) {
//		loginPage = new LoginPage2();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String shortPassword = loginPage.getEmptyPasswordText();
//		Assert.assertEquals(shortPassword, "Password is too short");
//		loginPage.clearAllText();
//		
//	}
	
//	//TC20- Toast message => Pending 
//	
//	@Test(priority = 2,dataProvider = "loginDataProviderLongPassword")
//	public void testLoginNotExistedUserNam(String userName, String passWord) {
//		loginPage = new LoginPage2();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String longPassword = loginPage.getEmptyPasswordText();
//		Assert.assertEquals(longPassword, "The password may not be greater than 128 characters");
//		loginPage.clearAllText();
//	}
	
//	//TC21- Toast message => Pending  
//	@Test(priority = 3,dataProvider = "loginDataProviderSpecialCharactersPassword")
//	public void testLoginSpecialCharactersPassword(String userName, String passWord) {
//		loginPage = new LoginPage2();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String specialCharactersPassword = loginPage.getEmptyPasswordText();
//		Assert.assertEquals(specialCharactersPassword, "Sai mật khẩu hoặc email");
//		loginPage.clearAllText();
//	}
	
	//TC22- Toast message => Pending 
	
	@Test(priority = 4,dataProvider = "loginDataProviderSqlCharactersPassword")
	public void testLoginSqlCharactersPassword(String userName, String passWord) {
		loginPage = new LoginPage2();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String sqlCharactersPassword = loginPage.getEmptyPasswordText();
		Assert.assertEquals(sqlCharactersPassword, "Sai mật khẩu hoặc email");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.clearAllText();

	}
	

	
//	/* Wait search screen show */
//	WebDriverWait waitSearchScreen = new WebDriverWait(this.driver, 5);
//	waitSearchScreen.until(ExpectedConditions
//			.visibilityOf(driver.findElement(By.id("jp.ecstudio.chatworkandroid:id/search_src_text"))));
//
//	try {
//		searchEachCharacter(dataSearch);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
	//TC23- Toast message => Pending 
	
	@Test(priority = 5,dataProvider = "loginDataProviderHtmlCharactersPassword")
	public void testLoginHtmlCharactersPassword(String userName, String passWord) {
		loginPage = new LoginPage2();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String htmlCharactersPassword = loginPage.getEmptyPasswordText();
		Assert.assertEquals(htmlCharactersPassword, "Sai mật khẩu hoặc email");
		loginPage.clearAllText();
	}
	
	//TC24- Toast message => Pending 
	
	@Test(priority = 6,dataProvider = "loginDataProviderUppercaseLowercasePassword")
	public void testLoginUppercaseLowercasePassword(String userName, String passWord) {
		loginPage = new LoginPage2();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String uppercaseLowercasePassword = loginPage.getEmptyPasswordText();
		Assert.assertEquals(uppercaseLowercasePassword, "Sai mật khẩu hoặc email");
	}
}
