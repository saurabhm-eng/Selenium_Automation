package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signuppageobject {
	WebDriver driver;

	public Signuppageobject(WebDriver driver) {

		this.driver = driver;

	}
	
	By register_link	= By.xpath("//span[contains(text(),'Register')]");
	By Validation_msg = By.xpath("//div[@class='alert alert-danger alert-registration-page']");
	By email_field = By.id("user_email");
	By pass_field = By.id("user_password");
	By submit = By.xpath("//input[@value='Sign Up']");
	
	
	
	public WebElement register_link() {

		return driver.findElement(register_link);

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
