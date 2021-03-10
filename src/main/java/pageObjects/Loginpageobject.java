package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpageobject {
	WebDriver driver;

	public Loginpageobject(WebDriver driver) {

		this.driver = driver;

	}
	By login_link	= By.xpath("//span[contains(text(),'Login')]");
	By Validation_msg = By.xpath("//div[@class='main-hero']//div[@role='alert']");
	By email_field = By.id("user_email");
	By pass_field = By.id("user_password");
	By submit = By.xpath("//input[@value='Log In']");
	
	
	
	public WebElement Login_link() {

		return driver.findElement(login_link);

	}

	public WebElement submit() {

		return driver.findElement(submit);

	}

	public WebElement error_msg() {

		return driver.findElement(Validation_msg);

	}
	
	public WebElement password() {

		return driver.findElement(pass_field);

	}
	
	public WebElement email() {

		return driver.findElement(email_field);

	}

	/*	public WebElement contact() {

		return driver.findElement(contact);

	}*/
}
