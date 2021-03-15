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
	By name_field = By.id("user_name");
	By pass_field = By.id("user_password");
	By cnf_pass_field = By.id("user_password_confirmation");
	By submit = By.xpath("//input[@value='Sign Up']");
	By t_c = By.id("user_agreed_to_terms");
	
	
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
	
	public WebElement cnf_password() {

		return driver.findElement(cnf_pass_field);

	}
	
	public WebElement email() {

		return driver.findElement(email_field);

	}
	
	public WebElement name() {

		return driver.findElement(name_field);

	}
	
	public WebElement t_c() {

		return driver.findElement(t_c);

	}
	
	/*	public WebElement contact() {

		return driver.findElement(contact);

	}*/
}
