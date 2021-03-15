package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepageobject {

	WebDriver driver;

	public Homepageobject(WebDriver driver) {

		this.driver = driver;

	}

	By newsletterEmailField = By.xpath("//input[@spellcheck = 'false']");

	By subscribeNowButton = By.xpath(
			"//div[@class='sumome-react-wysiwyg-component sumome-react-wysiwyg-popup-button sumome-react-wysiwyg-button'][1]");

	By noThanks = By.xpath(
			"//div[@class='sumome-react-wysiwyg-component sumome-react-wysiwyg-popup-button sumome-react-wysiwyg-button'][2]");

	
	By headerElements = By.xpath("//ul[@class = 'nav navbar-nav navbar-right']");
	
	
	public WebElement newsletterEmail() {

		return driver.findElement(newsletterEmailField);

	}

	public WebElement subscribeNowButton() {

		return driver.findElement(subscribeNowButton);

	}

	public WebElement noThanks() {

		return driver.findElement(noThanks);

	}
	
	public WebElement headerElements() {

		return driver.findElement(headerElements);

	}

}