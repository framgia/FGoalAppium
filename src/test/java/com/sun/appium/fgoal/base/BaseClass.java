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
		cap.setCapability("deviceName", "Moto G");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.framgia.fgoal.stg");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.framgia.fgoal.screen.login.LoginActivity");
//		if (runOn.equals("192.168.56.101:5555")) {
//			cap.setCapability("udid", "192.168.56.101:5555");
//			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4729/wd/hub"), cap);
//		} else if (runOn.equals("087fc6cc")) {
			cap.setCapability("deviceName", "087fc6cc");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
//		} else if (platformRunAs.equals("mobile")) {
//			driver = new AndroidDriver<MobileElement>(service.getUrl(), cap);
//		}
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

	public WebDriver getDriver() {
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
