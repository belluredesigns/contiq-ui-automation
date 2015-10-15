package com.contiq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewProjectPage extends DefaultPage {

	public NewProjectPage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(css = ".modal-title")
	public WebElement modalTitle;
	
	@FindBy(id = "select_projet")
	public WebElement projectType;
	
	@FindBy(id= "project-name")
	public WebElement projectName;
	
	@FindBy(id="project-description")
	public WebElement projectDescription;
	
	@FindBy(css="button.close")
	public WebElement XButton;
	
	@FindBy(css="[class='btn btn-default']")
	public WebElement closeButton;
	
	@FindBy(css="input[class='btn btn-primary']")
	public WebElement createProject;
	
	
	public void selectProject(EProjectType type){
		Select s = new Select(projectType);
		s.selectByVisibleText(type.toString());		
	}
	
	public void createProject(EProjectType types, String projectName, String projectDescription){
		
		selectProject(types);
		this.projectName.sendKeys(projectName);
		this.projectDescription.sendKeys(projectDescription);
		createProject.click();
	}
	
}
