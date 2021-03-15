package AdvanceSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Resources.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Signuppageobject;

public class testcase_check_Script extends base {

	public static void main(String args[]) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://courses.rahulshettyacademy.com/sign_up");
		driver.manage().window().maximize();
		/*SoftAssert softAssertion = new SoftAssert();*/
		Signuppageobject sp = new Signuppageobject(driver);
		/*String[] expectedmessage = { "Name is required", "Email is required", "Password is required.",
				"You must agree to the Terms of Use and Privacy Policy" };*/
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(By.tagName("Body"),By.tagName("Div") ));*/
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grecaptcha-badge']")));
		Thread.sleep(2000);
		sp.email().sendKeys("test");
		sp.submit().click();
		/*Actions actions = new Actions(driver);
		WebElement element = sp.email();
		actions.moveToElement(element).perform();
		WebElement toolTip = driver.findElement(By.xpath("//*[@title='Please enter an email address.']"));
		
		String toolTipText = toolTip.getText();
		System.out.println("toolTipText-->"+toolTipText);*/
		
		
		//((JavascriptExecutor) driver).executeScript("argument[0].get", arg1)
		
		
		/*List<WebElement> Validation_list = sp.error_msg().findElements(By.tagName("li"));
		System.out.println(Validation_list.size());
		int i = 0;
		for (WebElement Validation_message : Validation_list) {
			softAssertion.assertTrue(Validation_message.getText().equals(expectedmessage[i]),
					expectedmessage[i] + " Validation Failed");
			i++;
		}
*/
		driver.quit();
		//softAssertion.assertAll();
	}

}
