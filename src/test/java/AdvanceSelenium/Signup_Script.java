package AdvanceSelenium;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;

import Resources.base;
import pageObjects.Homepageobject;
import pageObjects.Signuppageobject;

public class Signup_Script extends base {
	Signuppageobject sp;

	@BeforeTest

	public void startBrowser() throws IOException {

		driver = initializerDriver();

		driver.get("http://qaclickacademy.com/");

		driver.manage().window().maximize();
		sp = new Signuppageobject(driver);
	}

	// open Registration page
	@Test(priority = 1, description = "Open Registration Page")
	public void open_login_page() {

		sp.register_link().click();

	}

	// check validation When Form is blank.
	@Test(priority = 2, description = "All field with blank data", enabled = false)
	public void Blank_data() throws Exception {

		String[] expectedmessage = { "Name is required", "Email is required", "Password is required",
				"You must agree to the Terms of Use and Privacy Policy" };
		Thread.sleep(1000);
		sp.submit().click();
		List<WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
		assert_message(Validation_list, expectedmessage);
		softAssertion.assertAll();

	}

	// check validation When Already Used email id
	@Test(priority = 3, description = "Already Used email_ID")
	public void already_used_email() throws Exception {

		String[] expectedmessage = { "Email is already in use. Please sign in to your account.", "Password is required",
				"You must agree to the Terms of Use and Privacy Policy" };
		Thread.sleep(1000);
		sp.name().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sp.name().sendKeys("Amit Agarwal");
		sp.email().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sp.email().sendKeys("test@mailinator.com");
		sp.submit().click();
		List<WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
		assert_message(Validation_list, expectedmessage);
		softAssertion.assertAll();

	}

	// check validation When blank password
	@Test(priority = 4, description = "blank password")
	public void blank_password() throws Exception {

		String[] expectedmessage = { "Password is required", "You must agree to the Terms of Use and Privacy Policy" };
		Thread.sleep(1000);
		sp.email().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sp.email().sendKeys("test321@mailinator.com");
		sp.submit().click();
		List<WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
		assert_message(Validation_list, expectedmessage);
		softAssertion.assertAll();

	}

	// check validation When invalid password
	@Test(priority = 5, description = "invalid password")
	public void invalid_password() throws Exception {

		String[] expectedmessage = { "Password confirmation doesn't match Password",
				"Password is too short (minimum is 6 characters)",
				"You must agree to the Terms of Use and Privacy Policy" };
		Thread.sleep(1000);
		sp.password().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sp.password().sendKeys("123");
		sp.submit().click();
		List<WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
		assert_message(Validation_list, expectedmessage);
		softAssertion.assertAll();

	}

	// check validation When Blank Confirm Password
	@Test(priority = 6, description = "Blank Confirm Password")
	public void blank_cnf_password() throws Exception {

		String[] expectedmessage = { "Password confirmation doesn't match Password",
				"You must agree to the Terms of Use and Privacy Policy" };
		Thread.sleep(1000);
		sp.password().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sp.password().sendKeys("123123");
		sp.submit().click();
		List<WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
		assert_message(Validation_list, expectedmessage);
		softAssertion.assertAll();

	}
	
	// check validation When Valid Data
		@Test(priority = 7, description = "Valid Data")
		public void Valid_data() throws Exception {

			String expectedmessage =  "https://courses.rahulshettyacademy.com/" ;
			Thread.sleep(1000);
			sp.password().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			sp.password().sendKeys("123123");
			sp.cnf_password().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			sp.cnf_password().sendKeys("123123");
			sp.t_c().click();
			sp.submit().click();
			
			String url =driver.getCurrentUrl();
			Assert.assertEquals(url, expectedmessage);
		}
		
	@AfterTest

	public void closeBrowser() {

		driver.close();
	}

}
