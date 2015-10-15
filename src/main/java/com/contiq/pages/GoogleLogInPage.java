package com.contiq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLogInPage extends DefaultPage {

	
	public GoogleLogInPage(WebDriver d){
		super(d);
		waitForWebElement(By.cssSelector("#next"));
	}
	
	@FindBy(css = "#Passwd")
	public WebElement passwordField;
	
	@FindBy(css = "#signIn")
	public WebElement signInButton;
	
	@FindBy(css = "#Email")
	private WebElement emailField;
	
	@FindBy(css = "#next")
	private WebElement nextButton;
	
	public GoogleHomePage logIn(String email, String password){
		
		emailField.sendKeys(email);
		nextButton.click();
		waitForWebElement(By.cssSelector("#Passwd"));
		passwordField.sendKeys(password);
		signInButton.click();
		return PageFactory.initElements(driver, GoogleHomePage.class);
		
		
		
	}
	
	
}
