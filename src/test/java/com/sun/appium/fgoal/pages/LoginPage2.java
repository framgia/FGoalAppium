
package com.sun.appium.fgoal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.sun.appium.fgoal.base.BaseClass;
import com.sun.appium.fgoal.objects.LoginPageObject2;
import com.sun.appium.fgoal.ultilities.GeneralKeywors;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author CHIRAG
 *
 */
public class LoginPage2 {

	private BaseClass obj = new BaseClass();
	private LoginPageObject2 loginPageObject = new LoginPageObject2(obj.getDriver());
	

	public LoginPage2() {
		
		PageFactory.initElements(new AppiumFieldDecorator(obj.getDriver()), loginPageObject);
	}

	public void enterUserName(String username) {
		GeneralKeywors.sendkeys(loginPageObject.usernameTextField, username);
	}
	
	public String getUserName()
	{
		return loginPageObject.usernameTextField.getText();
	}

	public void enterPassword(String password) {
		GeneralKeywors.sendkeys(loginPageObject.passwordTextField, password);
	}
	
	public String getPassword()
	{
		return loginPageObject.passwordTextField.getText();
	}
	
	public void login() {
		loginPageObject.loginButton.click();
	}
	
	public String getToolbarTitle() {
		return loginPageObject.getToolbar().getText();
	}
	
	public String getEmptyEmailText() {
		return loginPageObject.getEmptyEmail() != null ? loginPageObject.getEmptyEmail().getText()  : "";
	}
	
	public String getEmptyPasswordText() {
		return loginPageObject.getEmptyPassword() != null ? loginPageObject.getEmptyPassword().getText() : "";
	}

	public void clearAllText() {
		loginPageObject.usernameTextField.clear();
		loginPageObject.passwordTextField.clear();
	}
}
