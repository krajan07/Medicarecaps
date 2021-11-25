package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TSuites.Base;

public class ManageProductsPage extends HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='manageProduct']")
	WebElement ManageProducts;
	@FindBy(xpath = "//*[@id='productsTable']")
	WebElement ProductTable;
	

	public ManageProductsPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	public void ManagelProductClick() throws InterruptedException {
		ManageProducts.click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ProductTable));
		try {
		Assert.assertTrue(ProductTable.isDisplayed());
		log.info("Manage Product Page validation Passed");
		}catch(Exception e) {
			log.error(e);
		}
	}

	
}
