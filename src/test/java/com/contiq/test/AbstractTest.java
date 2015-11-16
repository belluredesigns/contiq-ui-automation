package com.contiq.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.comtiq.util.TestProperties;
import com.comtiq.util.WebDriverUtil;
import com.contiq.pages.HomePage;
import com.contiq.pages.LoginPage;

import ch.qos.logback.classic.Logger;

public abstract class AbstractTest {

	public Logger log = (Logger)LoggerFactory.getLogger(AbstractTest.class);

	protected WebDriver driver;
	TestProperties prop = TestProperties.getInstance();
	
	@BeforeMethod
	public void setUp(){
		driver = WebDriverUtil.getDriver(prop.getBrowser());
		driver.get(prop.getUrl());		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		
		
	}
	
	protected HomePage logIn(String email, String password){
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		HomePage homePage = lp.logIn(email, password);
		return homePage;
		
	}
	
	
	
}
