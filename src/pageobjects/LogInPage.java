package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class LogInPage extends HomePage {

	WebDriver driver;

	public LogInPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isLoginPage() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		Assert.assertEquals("Login", LoginDescription.getText());
		log.info("Login page validation passed");
	}

}
