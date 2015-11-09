package com.contiq.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefaultPage {
	
	protected final WebDriver driver;
	protected WebDriverWait wait ;

	public DefaultPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		
	}
	public void waitForWebElement(final By by)
	{
		wait.until(new ExpectedCondition() {
			@Override
			public Object apply(Object arg0) {
				return driver.findElement(by);
			}
		});

	}
	public void waitForcss(final String e)
	{
		wait.until(new ExpectedCondition() {
			@Override
			public Object apply(Object arg0) {
				return driver.findElement(By.cssSelector(e));
			}
		});

	}
	public void waitForxPath(final String e)
	{
		wait.until(new ExpectedCondition() {
			@Override
			public Object apply(Object arg0) {
				return driver.findElement(By.xpath(e));
			}
		});

	}
	
	
	
	public WebElement findWebElement(String str){
		List<WebElement> elements = driver.findElements(By.tagName("div"));
		for(WebElement e : elements){
			if (e.getText().equals(str)){
				return e;
			}
		}
		return null;
	}
	
}
