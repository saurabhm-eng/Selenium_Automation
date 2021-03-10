package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepageobject {

	WebDriver driver;

	public Homepageobject(WebDriver driver) {

		this.driver = driver;

	}

	By footerSection = By.id("gf-BIG");

	public WebElement headerDriver() {

		return driver.findElement(footerSection);

	}

}