package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class ViewProductsPage extends HomePage {

	WebDriver driver;

	public ViewProductsPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isViewAllProductPage() throws InterruptedException {
		ViewProducts.click();
		Thread.sleep(3000);
		Assert.assertEquals("Categories", Categories.getText());
		log.info("View Product Page validation Passed");
	}

	public void isAntipyretics() throws InterruptedException {
		// ViewProducts.click();
		Thread.sleep(3000);
		Antipyretics.click();
		Thread.sleep(3000);
		Assert.assertEquals("Antipyretics", CurrentSelection.getText());
		log.info("Antipyretics validation Passed");
	}

	public void isAnalgesics() throws InterruptedException {
		// ViewProducts.click();
		Thread.sleep(3000);
		Analgesics.click();
		Thread.sleep(3000);
		Assert.assertEquals("Analgesics", CurrentSelection.getText());
		log.info("Analgesics validation Passed");
	}

	public void isAntibiotics() throws InterruptedException {
		// ViewProducts.click();
		Thread.sleep(3000);
		Antibiotics.click();
		Thread.sleep(3000);
		Assert.assertEquals("Antibiotics", CurrentSelection.getText());
		log.info("Antibiotics Page validation Passed");
	}

}
