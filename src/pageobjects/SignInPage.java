package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class SignInPage extends HomePage {

	WebDriver driver;

	public SignInPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isContactPage() throws InterruptedException {
		SignUp.click();
		Thread.sleep(1000);
		Assert.assertEquals("Sign Up - Personal", SignUpDescription.getText());
		log.info("Sign Up - Personal page validation passed");
	}

}
