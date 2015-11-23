package com.contiq.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.contiq.pages.EProjectType;
import com.contiq.pages.HomePage;
import com.contiq.pages.NewProjectPage;

public class NewProjectPageTest extends AbstractTest {

//	@Test
	public void createNewPresentationProject() {
		String projectName = "PresentationTest1";
		String projectDescription = "PresentationTeasDesc1";
		HomePage homePage = logIn(prop.getEmailAddress(), prop.getPassword());
		NewProjectPage nPP = homePage.clickPresentationPlusSign();
		nPP.createProject(EProjectType.PRESENTATIONS, projectName, projectDescription);
		WebElement pName = homePage.getProject(projectName, projectDescription);
		Assert.assertNotNull(pName);
	}

	//@Test
	public void createNewBlogProject() {
		String blogProjectName = "BlogTest1";
		String blogProjectDes = "BlogTest1des";
		HomePage homePage = logIn(prop.getEmailAddress(), prop.getPassword());
		NewProjectPage nBP = homePage.clickBlogPostPlusSign();
		nBP.createProject(EProjectType.BLOG_POST, blogProjectName, blogProjectDes);
		WebElement pName = homePage.getProject(blogProjectName, blogProjectDes);
		Assert.assertNotNull(pName);

	}

}
