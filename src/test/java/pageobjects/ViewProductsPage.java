package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class ViewProductsPage extends HomePage {

	WebDriver driver;
	@FindBy(xpath = "//*[@class='breadcrumb']/li[2]")
	WebElement AllProducts;
	@FindBy(xpath = "//table[@id='productListTable']/tbody")
	WebElement Tbody;

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
	
	
	public void ProductList(String med1) throws InterruptedException {
		ViewProducts.click();
		Thread.sleep(3000);
		List<WebElement> row = Tbody.findElements(By.tagName("tr"));
		log.info("Total number of products in the page = " + row.size());
		int ch = 0;
		log.info("Products listed in the current page are : ");
		for(WebElement mlist : row) {
			ch++;
			log.info(driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[2]")).getText());
		}
		Assert.assertEquals("All Products", AllProducts.getText());
		log.info("All Products list page validation Passed");
		}
	
		

}
