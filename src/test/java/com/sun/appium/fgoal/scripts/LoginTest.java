package com.sun.appium.fgoal.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.appium.fgoal.base.BaseClass;
import com.sun.appium.fgoal.pages.LoginPage;
import com.sun.appium.fgoal.ultilities.CSVHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author CHIRAG
 *
 */
public class LoginTest extends BaseClass {

	LoginPage loginPage;

	
	@DataProvider
	private Object[][] loginDataProviderNoUserName() {
		return CSVHelper.loadUser(0,1);
	}
	
	@DataProvider
	private Object[][] loginDataProviderNoPassword() {
		return CSVHelper.loadUser(1,0);
	}
	
	@DataProvider
	private Object[][] loginDataProviderNoUserNameAndPassword() {
		return CSVHelper.loadUser(0,0);
	}
	
	@DataProvider
	private Object[][] loginDataProvider() {
		return CSVHelper.loadUser(1,1);
	}
	
	//TC04
	@Test(priority = 0,dataProvider = "loginDataProviderNoUserName")
	public void testLoginNoUserName(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String emptyEmail = loginPage.getEmptyEmailText();
		Assert.assertEquals(emptyEmail, "Empty email");
		loginPage.clearAllText();
	}
	
	//TC05
	
	@Test(priority = 1,dataProvider = "loginDataProviderNoPassword")
	public void testLoginNoPassword(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String emptyPassword = loginPage.getEmptyPasswordText();
		Assert.assertEquals(emptyPassword, "Empty password");
		loginPage.clearAllText();
	}
	
	//TC06
	
	@Test(priority = 2,dataProvider = "loginDataProviderNoUserNameAndPassword")
	public void testLoginNoUserNameAndPassword(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		String emptyEmail = loginPage.getEmptyEmailText();
		Assert.assertEquals(emptyEmail, "Empty email");
		String emptyPassword = loginPage.getEmptyPasswordText();
		Assert.assertEquals(emptyPassword, "Empty password");
		loginPage.clearAllText();
	}
	
	//TC25
	@Test(priority = 3,dataProvider = "loginDataProvider")
	public void testLoginPassEncoding(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		try {
			Thread.sleep(5000);
			Assert.assertEquals(loginPage.getPassword(), "••••••");
			loginPage.clearAllText();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TC07
	
	@Test(priority = 4,dataProvider = "loginDataProvider")
	public void testLogin(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();
		// android.widget.Toast
		// android.widget.Toast[@text='toast text']
		// try {
		// Thread.sleep(200);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		
		By verificationTextUiAuto2 = By.xpath("//android.widget.Toast[1]");
		ExpectedCondition<WebElement> verificationReady = ExpectedConditions
				.presenceOfElementLocated(verificationTextUiAuto2);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(verificationReady);
		WebElement toastView = getDriver().findElement(By.xpath("//android.widget.Toast[1]"));
		Assert.assertEquals(toastView.getAttribute("name").trim(), "Sai mật khẩu hoặc email");
//		Assert.assertEquals(loginPage.getToastMessage(), "Sai mật khẩu hoặc email");
		// Assert.assertEquals(loginPage.getToolbarTitle(), "Chu Anh Tuan");
//		Assert.assertEquals(loginPage.getToolbarTitle(), "Le Thi Ha");
	}
}