package AdvanceSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.base;
import Resources.excelUtilities;
import pageObjects.Homepageobject;

public class Homepage extends base {
	private static Logger log = LogManager.getLogger(Homepage.class.getName());

	public WebDriver driver;
	Homepageobject hp;

	@BeforeTest

	public void startBrowser() throws IOException, InterruptedException {

		driver = initializerDriver();

		driver.get("http://qaclickacademy.com/");

		driver.manage().window().maximize();

		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void validatePopUP() {

		hp = new Homepageobject(driver);

		hp.newsletterEmail().sendKeys("abc");

		hp.subscribeNowButton().click();

		hp.noThanks().click();
	}

	@Test(enabled = false)

	public void validateHeaderLinks() throws InterruptedException {

		hp = new Homepageobject(driver);

		int count = hp.headerElements().findElements(By.tagName("a")).size();

		for (int i = 0; i < count; i++) {

			String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			hp.headerElements().findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			Thread.sleep(5000L);
		}

		Set<String> abc = driver.getWindowHandles();

		Iterator<String> it = abc.iterator();

		while (it.hasNext())

		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

	@Test(enabled = false)

	public void brokenLinks() throws MalformedURLException, IOException {

		List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));

		int count = homePageLinks.size();
		System.out.println(count);

		SoftAssert a = new SoftAssert();

		for (WebElement link : homePageLinks)

		{
			String url = link.getAttribute("href");

			if(url.contains("tel:") ||  url.contains("mailto:") || url.contains("javascript"))
			{continue;}


			if (url.contains("tel") || url.contains("mailto") || url.contains("void")) {

				continue;

			}

			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			System.out.println(resCode);

			a.assertTrue(resCode < 400, "The link with text " + link.getText() + " is broken with code " + resCode);

		}

		a.assertAll();

	}

	@AfterTest

	public void closeBrowser() {

		driver.close();
	}

	@Test(enabled = false)
	public void getFromExcel() throws IOException {

		excelUtilities d = new excelUtilities();

		ArrayList data = d.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		// driver.findElement(By.id("abc")).sendKeys(data.get(1));

	}

	@Test(enabled = false)
	public void loggingOutput() {

		log.debug("I have clicked on button");
		log.info("Button is displayed");
		log.error("Button is not displayed");
		log.fatal("Button is missing");

	}

	@Test

	public void testNew() {

		driver.get("https://sso.teachable.com/secure/9521/users/sign_up?reset_purchase_session=1");

		driver.findElement(By.id("user_name")).sendKeys("saurabh");
		driver.findElement(By.id("user_email")).sendKeys("saurabh");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		JavascriptExecutor js =  (JavascriptExecutor) driver;
				
		String Script = "return window.javascript_errors";
		
		String text = (String) js.executeScript(Script);
		System.out.println(text);

	}

}
