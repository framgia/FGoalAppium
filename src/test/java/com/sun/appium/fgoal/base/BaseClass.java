package com.sun.appium.fgoal.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sun.appium.fgoal.ultilities.GlobalParameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * @author CHIRAG
 *
 */
public class BaseClass {

	private static AndroidDriver driver;
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder server;

	String platformRunAs;
	/*
	 * myPlatform should be web or mobile
	 * 
	 */
	final String myPlatform = "mobile";

	@Parameters({ "platform", "runOn" })
	@BeforeClass
	public void setup(@Optional(myPlatform) String platform, String runOn)
			throws MalformedURLException {
		System.out.println(platform);
		GlobalParameters.runType = platform;
		String path = System.getProperty("user.dir");

		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("app", path + "//app//fgoal.apk");
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", runOn);
		cap.setCapability("automationName","UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.framgia.fgoal.stg");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.framgia.fgoal.screen.login.LoginActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		System.out.println("mobile will launch");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
		/*
		 * if(mobileRunAs.equals("normal")) { //driver.quit(); }
		 */

	}

	public AndroidDriver getDriver() {
		return this.driver;
	}

	@Parameters({ "runAs" })
	@BeforeTest
	public void startAppiumserver(@Optional(myPlatform) String platform) {
		System.out.println(platform);
		if (platform.equalsIgnoreCase("mobile")) {
			platformRunAs = "mobile";
			server = new AppiumServiceBuilder();
			server.usingAnyFreePort();
			server.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			server.withArgument(GeneralServerFlag.LOG_LEVEL, "error:error");
			service = AppiumDriverLocalService.buildService(server);
			service.start();
			System.out.println("Appium Server is Started...");
		}

	}

	@Parameters({ "runAs" })
	@AfterTest
	public void stopAppiumServer(@Optional(myPlatform) String platform) {
		if (platform.equalsIgnoreCase("mobile")) {
			service.stop();
			System.out.println("Appium Server is Stoped...");
		}
	}
}
