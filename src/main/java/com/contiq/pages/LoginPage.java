package com.contiq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DefaultPage{
	
	public LoginPage(WebDriver driver){
		super(driver);
		if(!driver.getTitle().equalsIgnoreCase("Login")){
			throw new IllegalArgumentException("This is not a login page");
			
		}
	}
	
	@FindBy(id = "username")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(css = "button.btn-primary")
	public WebElement loginButton;
	
	public HomePage logIn(String email, String password){
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		return hp;
	}
	
	
	
	
	
}
