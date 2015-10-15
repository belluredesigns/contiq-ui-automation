package com.contiq.test;

import org.testng.annotations.Test;

import com.contiq.pages.EProjectType;
import com.contiq.pages.HomePage;
import com.contiq.pages.NewProjectPage;

public class NewProjectPageTest extends AbstractTest {

	@Test
	public void createNewPresentationProject(){
		HomePage homePage = logIn(prop.getEmailAddress(), prop.getPassword());
		homePage.clickPresentationPlusSign();

	}

	@Test
	public void createNewBlogProject(){
		HomePage homePage = logIn(prop.getEmailAddress(), prop.getPassword());
		NewProjectPage npg = homePage.clickBlogPostPlusSign();
		npg.createProject(EProjectType.PRESENTATIONS, "Test1", "Test1des"); 

	}
	

}
