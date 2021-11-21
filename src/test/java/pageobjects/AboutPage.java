package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class AboutPage extends HomePage {

	WebDriver driver;

	public AboutPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isAboutPage() throws InterruptedException {
		About.click();
		Thread.sleep(1000);
		Assert.assertEquals("About Us", AboutDescription.getText());
		log.info("About page validation passed");
	}

}
