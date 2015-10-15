package com.contiq.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DefaultPage{
final static int PRESENTATION_PLUS_SIGN_INDEX = 0;
final static int BLOGPOST_PLUS_SIGN_INDEX = 1;
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css = "div[class='ho_main'] [class='fa fa-plus-square']")
	List <WebElement> plusSigns;

	
	public String getTitle() {
		return driver.getTitle();			
	}
	
	private WebElement getPlusSign(int index){
		return plusSigns.get(PRESENTATION_PLUS_SIGN_INDEX) ;
			
	}
	
	public NewProjectPage clickPresentationPlusSign(){
		
		getPlusSign(PRESENTATION_PLUS_SIGN_INDEX).click();
		return (PageFactory.initElements(driver, NewProjectPage.class));
	}
	
	public NewProjectPage clickBlogPostPlusSign(){
		
		getPlusSign(BLOGPOST_PLUS_SIGN_INDEX).click();
		return (PageFactory.initElements(driver, NewProjectPage.class));

	}
	


}
