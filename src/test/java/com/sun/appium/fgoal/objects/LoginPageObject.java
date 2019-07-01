package com.sun.appium.fgoal.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author CHIRAG
 *
 */
public class LoginPageObject {

	private AndroidDriver driver;

	public LoginPageObject(AndroidDriver driver) {
		this.driver = driver;
	}

	@AndroidFindBy(id = "com.framgia.fgoal.stg:id/edit_username")
	public MobileElement usernameTextField;

	@AndroidFindBy(id = "com.framgia.fgoal.stg:id/edit_password")
	public MobileElement passwordTextField;

	// @AndroidFindBy(xpath = "//*[@text='Sign
	// in']/../following::android.widget.TextView[1]")
	@AndroidFindBy(id = "com.framgia.fgoal.stg:id/text_login")
	public MobileElement loginButton;
	
	@AndroidFindBy(xpath = "android.widget.Toast")
	public MobileElement toastMessage;
	
	//android.widget.Toast
			//

	public MobileElement getToolbar() {
		return (MobileElement) driver.findElement(By.id("com.framgia.fgoal.stg:id/toolbar_title"));
	}
	
	public MobileElement getToastMessage() {
		MobileElement mobileElement =  (MobileElement) driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Toast\")");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		MobileElement element = (MobileElement)wait.until(ExpectedConditions.visibilityOf(mobileElement));
		return element;
	}
}
