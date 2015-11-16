package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.contiq.pages.GoogleHomePage;
import com.contiq.pages.GoogleLogInPage;
import com.contiq.pages.LoginPage;

//div[conatins(text(), Your message has been sent.']

public class GoogleLoginTest {
	
	WebDriver driver ;
	@BeforeMethod
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		
		
		
	}
	
	@Test
	public void login(){
		
		GoogleLogInPage lp = PageFactory.initElements(driver, GoogleLogInPage.class);
		GoogleHomePage hp = lp.logIn("kapoorrichan@gmail.com", "goGoogle123");
	/*	Assert.assertTrue(hp.verifyTitle("Google"));
		
		// Asserting the title of the google home 
		
		
		String expected = "Your message has been sent";
		Assert.assertEquals(pageTitle,testTitle);*/
		// Clicking on compose button and sending mail to the user
		GoogleHomePage hpCompose = hp.compose("richa_k@hotmail.com","test", "good job");
	//	Assert.assertEquals(hp.verifySentMessage(msg), expected);
	}
	
	@AfterMethod
    public void terDown(){
		driver.close();
		
	}
}
