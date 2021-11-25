package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class ShippingPage extends HomePage {

	WebDriver driver;
   
	
	@FindBy(linkText = "Select")
	WebElement DefaultShipping;
	
	@FindBy(linkText = "Pay")
	WebElement Pay;

	
	public ShippingPage() {
		driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	public void shippingPage() throws InterruptedException {
		Thread.sleep(1000);
		log.info(DefaultShipping);
		try {
		Assert.assertTrue(DefaultShipping.isEnabled());
		log.info("Shipping adress selection validation passed");
		DefaultShipping.click();
		Thread.sleep(2000);
		Assert.assertTrue(Pay.isEnabled());
		log.info("Payment validation passed");
		Thread.sleep(2000);
		Pay.click();
		Thread.sleep(2000);
		}catch(Exception e) {
			log.error(e);
		}
	}

}
