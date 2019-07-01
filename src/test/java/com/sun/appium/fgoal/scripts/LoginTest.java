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
	private Object[][] loginDataProvider() {
		return CSVHelper.loadUser();
	}

	@Test(dataProvider = "loginDataProvider")
	public void testLogin(String userName, String passWord) {
		loginPage = new LoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.login();

//		Assert.assertEquals(loginPage.getToolbarTitle(), "Chu Anh Tuan");

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