package com.sun.appium.fgoal.ultilities;

import org.openqa.selenium.WebElement;

/**
 * @author CHIRAG
 *
 */
public class GeneralKeywors {

	public static void click(WebElement ele) {
		ele.click();
	}

	public static void sendkeys(WebElement ele, String text) {
		ele.sendKeys(text);
	}
}