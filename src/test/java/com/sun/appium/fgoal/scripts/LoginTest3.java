package com.sun.appium.fgoal.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.appium.fgoal.base.BaseClass;
import com.sun.appium.fgoal.pages.LoginPage2;
import com.sun.appium.fgoal.ultilities.CSVHelperLogin3;

/**
 *@author LE THI HA TC08 TC09 TC13 TC14 TC15 TC16 TC17
 *
 */
public class LoginTest3 extends BaseClass {

	LoginPage2 loginPage;

	
	@DataProvider
	private Object[][] loginDataProviderUppercaseLowercaseUserName() {
		return CSVHelperLogin3.loadUser08();
	}
	
	@DataProvider
	private Object[][] loginDataProviderSpaceBeginningEndPassword() {
		return CSVHelperLogin3.loadUser09();
	}
	
	@DataProvider
	private Object[][] loginDataProviderNotExistedUserName() {
		return CSVHelperLogin3.loadUser13();
	}
	
	@DataProvider
	private Object[][] loginDataProviderNotExistedPassword() {
		return CSVHelperLogin3.loadUser14();
	}
	
	@DataProvider
	private Object[][] loginDataProviderSpecialCharactersUsername() {
		return CSVHelperLogin3.loadUser15();
	}
	
	@DataProvider
	private Object[][] loginDataProviderHtmlCharactersUsername() {
		return CSVHelperLogin3.loadUser16();
	}
	
	@DataProvider
	private Object[][] loginDataProviderSqlCharactersUsername() {
		return CSVHelperLogin3.loadUser17();
	}
	
//	//TC08
//	@Test(priority = 0,dataProvider = "loginDataProviderUppercaseLowercaseUserName")
//	public void testUppercaseLowercaseUserName(String userName, String passWord) {
//		loginPage = new LoginPage2();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		Assert.assertEquals(loginPage.getToolbarTitle(), "Le Thi Ha");
//		loginPage.clearAllText();
//	}
//	
//	//TC09
//	
//	@Test(priority = 1,dataProvider = "loginDataProviderSpaceBeginningEndPassword")
//	public void testLoginSpaceBeginningEndPassword(String userName, String passWord) {
//		loginPage = new LoginPage2();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		Assert.assertEquals(loginPage.getToolbarTitle(), "Le Thi Ha");
//		loginPage.clearAllText();
//	}
	
	//TC13 : Can not test, dialog is not in app
	
	@Test(priority = 2,dataProvider = "loginDataProviderNotExistedUserName")
	public void testLoginNotExistedUserNam(String userName, String passWord) {
		loginPage = new LoginPage2();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		By verificationTextUiAuto2 = By.xpath("//android.widget.Toast[1]");
		ExpectedCondition<WebElement> verificationReady = ExpectedConditions
						.presenceOfElementLocated(verificationTextUiAuto2);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(verificationReady);
		WebElement toastView = getDriver().findElement(By.xpath("//android.widget.Toast[1]"));
		Assert.assertEquals(toastView.getAttribute("name").trim(), "Sai mật khẩu hoặc email");
	}
	
	//TC14 : Can not test, dialog is not in app
//	@Test(priority = 3,dataProvider = "loginDataProviderNotExistedPassword")
//	public void testLoginNotExistedPassword(String userName, String passWord) {
//		loginPage = new LoginPage2();
//		loginPage.enterUserName(userName);
//		loginPage.enterPassword(passWord);
//		loginPage.login();
//		String emptyPassword = loginPage.getEmptyPasswordText();
//		Assert.assertEquals(emptyPassword, "Empty password");
//		loginPage.clearAllText();
//	}
	
	//TC15
	
	@Test(priority = 4,dataProvider = "loginDataProviderSpecialCharactersUsername")
	public void testLoginSpecialCharactersUsername(String userName, String passWord) {
		loginPage = new LoginPage2();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String emptyEmail = loginPage.getEmptyEmailText();
		Assert.assertEquals(emptyEmail, "Invalid email");
		loginPage.clearAllText();
	}
	
	//TC16
	
	@Test(priority = 5,dataProvider = "loginDataProviderHtmlCharactersUsername")
	public void testLoginHtmlCharactersUsername(String userName, String passWord) {
		loginPage = new LoginPage2();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String emptyEmail = loginPage.getEmptyEmailText();
		Assert.assertEquals(emptyEmail, "Invalid email");
		loginPage.clearAllText();
	}
	
	//TC17
	
	@Test(priority = 6,dataProvider = "loginDataProviderSqlCharactersUsername")
	public void testLoginSqlCharactersUsername(String userName, String passWord) {
		loginPage = new LoginPage2();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String emptyEmail = loginPage.getEmptyEmailText();
		Assert.assertEquals(emptyEmail, "Invalid email");
	}
}