package com.comtiq.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {


	/*
	 * 
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setBrowserName("safari");
	CommandExecutor executor = new SeleneseCommandExecutor(new URL("http://localhost:4444/"), new URL("http://www.google.com/"), capabilities);
	WebDriver driver = new RemoteWebDriver(executor, capabilities);


	 */
	public static WebDriver getDriver(EBrowser browser) 
	{
		WebDriver driver = null;
//		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (browser)
		{
		case FIREFOX:
//			try {
//				driver = new RemoteWebDriver(
//						new URL("http://localhost:4444/wd/hub"), 
//						DesiredCapabilities.firefox());
//			} catch (MalformedURLException e) {
//				return null;
//			}
//			capabilities.setBrowserName("firefox");
			driver = new FirefoxDriver();
			break;
		case IE:
			throw new IllegalArgumentException("IE currently not supported");
		case SAFARI:
			//			driver = new SafariDriver();
			break;
		default:
			//			driver = new ChromeDriver();


		}
		return driver;
	}
}
