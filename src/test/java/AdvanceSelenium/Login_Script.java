package AdvanceSelenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

import Resources.base;
import pageObjects.Homepageobject;
import pageObjects.Loginpageobject;

public class Login_Script extends base {
	
	Loginpageobject lp = new Loginpageobject(null);	
	
	@BeforeTest

	public void startBrowser() throws IOException {

		driver = initializerDriver();

		driver.get("http://qaclickacademy.com/");

		driver.manage().window().maximize();
		lp = new Loginpageobject(driver);
	}
	
	// open Login page 
	@Test(priority=1, description = "Open Login Page")
	public void open_login_page(){

		lp.Login_link().click();
		
	}
	
	// check validation When email id and password is blank.
	@Test(priority=2, description = "All field with blank data")
	public void Blank_data() throws Exception {
		
		String expectedmessage = "Invalid email or password.";
		
		lp.submit().click();
		
		Assert.assertEquals(lp.error_msg().getText(), expectedmessage);
		
	}
	
	// check validation When valid email id and password is blank.
		@Test(priority=3, description = "valid username and blank password")
		public void Blank_password() throws Exception {
			
			String expectedmessage = "Invalid email or password.";
			
			lp.email().sendKeys(Keys.chord(Keys.CONTROL, "a"),"testing@mailinator.com");
			
			Thread.sleep(2000);
			
			lp.submit().click();
			
			Assert.assertEquals(lp.error_msg().getText(), expectedmessage);
			
	}
	
	// check validation When valid email id and password is blank.
			@Test(priority=4, description = "valid username and blank password")
			public void invalid_email() throws Exception {
				
				String expectedmessage = "Invalid email or password.";
				
				lp.email().sendKeys(Keys.chord(Keys.CONTROL, "a"),"testing");
				
				Thread.sleep(2000);
				
				lp.submit().click();
				
				Assert.assertEquals(lp.error_msg().getText(), expectedmessage);
				
		}
	

	@AfterTest

	public void closeBrowser() {

		driver.close();
	}

}