package com.contiq.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.contiq.pages.HomePage;

public class LogInPageTest extends AbstractTest {
	
	@Test
	public void logIn(){
	
		HomePage homePage = logIn(prop.getEmailAddress(), prop.getPassword());
		Assert.assertEquals(homePage.getTitle(), "Contiq");
	}
	
}
