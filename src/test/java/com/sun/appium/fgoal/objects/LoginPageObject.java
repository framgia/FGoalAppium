package com.sun.appium.fgoal.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author CHIRAG
 *
 */
public class LoginPageObject {

	@AndroidFindBy(id = "com.framgia.fgoal.stg:id/edit_username")
	public WebElement usernameTextField;

	@AndroidFindBy(id = "com.framgia.fgoal.stg:id/edit_password")
	public WebElement passwordTextField;

//	@AndroidFindBy(xpath = "//*[@text='Sign in']/../following::android.widget.TextView[1]")
	@AndroidFindBy(id = "com.framgia.fgoal.stg:id/text_login")
	public WebElement loginButton;
}
