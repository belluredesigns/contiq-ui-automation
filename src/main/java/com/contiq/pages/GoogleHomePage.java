package com.contiq.pages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends DefaultPage {
	@FindBy(xpath="//div[contains(text(),'COMPOSE')][@role='button']")
	private WebElement compose;
	
	@FindBy(xpath= "//textarea[@class='vO'][@name='to']")
	private WebElement toField;
	//final String composeText = "COMPOSE";
	
	@FindBy(xpath="//input[@class='aoT'][@name='subjectbox']")
	private WebElement subject;
	
	@FindBy(xpath="//div[@class='Am Al editable LW-avf'][@role='textbox']")
	private WebElement textBox;
	
	@FindBy(xpath="//div[contains(text(), 'Send')][@role='button']")
	private WebElement sendButton;
	
	@FindBy(xpath="//div[contains(text(), 'Your message has been sent.')]")
	private WebElement sentMessage;
	
	public GoogleHomePage(WebDriver d){
		super(d);
		waitForWebElement(By.xpath("//div[contains(text(),'COMPOSE')][@role='button']"));
	}
	
	/*public boolean verifyTitle(String title)
	{
		waitForWebElement(By.xpath("//textarea[@class='vO'][@name='to']"));
		String s = driver.getTitle();
		if(s.length()>0 && s.contains("google")){
		return true;
		}
		return false;
		
	}
	
	public WebElement verifySentMessage(String message){
		waitForWebElement(By.xpath("//textarea[@class='vO'][@name='to']"));
		WebElement msg = sentMessage.getText();
		return msg;
		
	}*/

	//Clicking on the compose button and sending mail
	public GoogleHomePage compose(String to, String subjectText,String message){
		compose.click();
		waitForWebElement(By.xpath("//textarea[@class='vO'][@name='to']"));
		toField.sendKeys(to);
		subject.sendKeys(subjectText);
		textBox.sendKeys(message);
		sendButton.click();
		return PageFactory.initElements(driver, GoogleHomePage.class);

	}
	
	
}
