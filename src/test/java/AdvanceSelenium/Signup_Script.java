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
	@Test(priority = 2, description = "All field with blank data", enabled=false)
	public void Blank_data() throws Exception {

		String[] expectedmessage = { "Name is required", "Email is required", "Password is required",
		"You must agree to the Terms of Use and Privacy Policy" };
		Thread.sleep(1000);
		sp.submit().click();
		List <WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
		assert_message(Validation_list, expectedmessage);
		softAssertion.assertAll();

	}

	// check validation When Invalid email id
	@Test(priority = 3, description = "Invalid email_ID")
	public void invalid_email() throws Exception {

		
	/*	String[] expectedmessage = { "Name is required", "Email is required", "Password is required",
		"You must agree to the Terms of Use and Privacy Policy" };*/
		Thread.sleep(1000);
		sp.email().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sp.email().sendKeys("Amit");
		sp.submit().click();
		
		String data1 = (String)((JavascriptExecutor) driver).executeScript(sp.email().getAttribute("requiredattribute "));
		
		
		
		//String data =sp.email().getAttribute("title");
		System.out.println(data1);
		
//		List <WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
	//	assert_message(Validation_list, expectedmessage);
		//softAssertion.assertAll();
		
		/*String[] expectedmessage = { "This field is required.", "This field is required.", "This field is required.",
				"Please enter valid email id here.", "This field is required.", "This field is required.",
				"This field is required.", "This field is required.", "This field is required.",
				"This field is required." };
		element.findElement(log.email_field).sendKeys(Keys.chord(Keys.CONTROL, "a"), "vikram");
		element.findElement(log.signup_button).click();
		assertmultivalidate(element, log.validation_err_field, expectedmessage);*/

	}

	// check validation When valid email id and password is blank.
/*	@Test(priority = 4, description = "valid username and blank password")
	public void invalid_email() throws Exception {

		String expectedmessage = "Invalid email or password.";

		sp.email().sendKeys(Keys.chord(Keys.CONTROL, "a"), "testing");

		Thread.sleep(2000);

		sp.submit().click();

		Assert.assertEquals(sp.error_msg().getText(), expectedmessage);

	}
*/
	@AfterTest

	public void closeBrowser() {

		driver.close();
	}

}
