package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import TSuites.Base;

public class LogOutPage extends HomePage {
	
	@FindBy(xpath = "//*[@id='logout']/a")
	WebElement LogOut;

	SoftAssert softAssert = new SoftAssert();

	public LogOutPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);

	}
	
	
	public void logOut() throws InterruptedException {
		Thread.sleep(2000);
		try {
		Assert.assertTrue(LogOut.isEnabled());
		log.info("Logout button validation passed");
		LogOut.click();
		Thread.sleep(2000);
		}catch(Exception e) {
			log.error(e);
		}	
	}
}
