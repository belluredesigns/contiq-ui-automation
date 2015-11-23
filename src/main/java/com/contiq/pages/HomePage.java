package com.contiq.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DefaultPage{
	final static int PRESENTATION_PLUS_SIGN_INDEX = 0;
	final static int BLOGPOST_PLUS_SIGN_INDEX = 1;
	final String PLUS_SIGN = "div[class='ho_main'] [class='fa fa-plus-square']";

	
	//TODO
	final String XPATH_PROJECT_TO_PROJECT_NAME = "";
	final String XPATH_PROJECT_TO_PROJECT_CLOSE_BTN = "";
	
	public HomePage(WebDriver driver) {
		super(driver);
		waitForWebElement(By.cssSelector(PLUS_SIGN));

		
	}

	@FindBy(css = PLUS_SIGN)
	List <WebElement> plusSigns;

	@FindBy(css = "a[class ='single_project pro_switch']")
	private List<WebElement> projectList;
	
	@FindBy(css="div[class ='project']")
	private List <WebElement> allProjects;
	
	
	public WebElement getProject(String name, String des){
		waitUtil.checkPageIsReady();
		PageFactory.initElements(driver, this);
		String elementText = name + "\n" + des;
		for (WebElement e : projectList){
			if(e.getText().equals(elementText))
				return e;
		}
		
		return null;
	}
	public void closeProject(String projectName, String projectDesc) throws Exception
	{
		WebElement closeBtn = getCloseButton(projectName, projectDesc);
		if(closeBtn == null)
			throw new Exception("Unable to locate close btn for the given project");
		
		closeBtn.click();
	}
	private WebElement getCloseButton(String projectName, String projectDesc){
		
		waitUtil.checkPageIsReady();
		PageFactory.initElements(driver, this);
		String elementText = projectName + "\n" + projectDesc;
		for (WebElement e : allProjects){

			By projectN = By.xpath(XPATH_PROJECT_TO_PROJECT_NAME);
			By close = By.xpath(XPATH_PROJECT_TO_PROJECT_CLOSE_BTN);
			WebElement n = e.findElement(projectN);
			if(n.getText().equals(elementText))
			{
				return e.findElement(close);
			}
		}
		
		return null;
	}
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
