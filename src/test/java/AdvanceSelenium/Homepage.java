package AdvanceSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.base;
import pageObjects.Homepageobject;

public class Homepage extends base {

	public WebDriver driver;

	@BeforeTest

	public void startBrowser() throws IOException {

		driver = initializerDriver();

		driver.get("http://qaclickacademy.com/");

		driver.manage().window().maximize();

	}

	@Test(enabled = false)

	public void validateHeaderLinks() throws InterruptedException {

		Homepageobject hp = new Homepageobject(driver);

		for (int i = 0; i < hp.headerDriver().findElements(By.tagName("a")).size(); i++) {

			String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			hp.headerDriver().findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
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

	@Test(enabled = true)

	public void brokenLinks() throws MalformedURLException, IOException {

		//List<WebElement> footerLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		List<WebElement> footerLinks = driver.findElements(By.tagName("a"));
		
		int count = footerLinks.size();
		System.out.println(count);

		SoftAssert a = new SoftAssert();

		for (WebElement link : footerLinks) 
		
		{
			String url = link.getAttribute("href");
			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			System.out.println(resCode);

			a.assertTrue(resCode < 400, "The link with text " + link.getText() + "is broken with code" + resCode);

		}

		a.assertAll();

	}

	@AfterTest

	public void closeBrowser() {

		driver.close();
	}

}
