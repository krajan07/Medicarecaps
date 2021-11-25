package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import TSuites.Base;

public class LogOutLogInPage extends HomePage {
	
	@FindBy(xpath = "//*[@id='loginForm']/div[3]/div/input[2]")
	WebElement ClickLogin;
	SoftAssert softAssert = new SoftAssert();

	public LogOutLogInPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);

	}
	
	public void confirmlogOut() throws InterruptedException {
	try {
		Thread.sleep(2000);
		Assert.assertTrue(ClickLogin.isEnabled());
		log.info("User Logout validation passed");
		}catch(Exception e) {
			log.error(e);
		}
	}
}
