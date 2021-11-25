package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class AddProducttoCart extends HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//table[@id='productListTable']/tbody")
	WebElement ProductTbody;
	@FindBy(xpath = "//table[@id='cart']/tbody")
	WebElement CartTbody;

	public AddProducttoCart() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	public void AddMedicine(String med1,String med2) throws InterruptedException {
		ViewProducts.click();
		Thread.sleep(3000);
		List<WebElement> row = ProductTbody.findElements(By.tagName("tr"));
		int ch = 1 ,i=0;
		do {
		for(WebElement mlist : row) {
			if(driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[2]")).getText().contains(med1)) {
				log.info("Product Added : " + driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[2]")).getText());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[6]/a[2]")).click();
				driver.navigate().back();
			}else if(driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[2]")).getText().contains(med2))
			 {
				log.info("Product Added : " + driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[2]")).getText());
				driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[6]/a[2]")).click();
				Thread.sleep(3000);
			}else {
				log.info("Product not matched");
			}
			ch++;
			i++;
		}
		}while(i> row.size());
		String CURL = driver.getCurrentUrl();
		log.info("Current URL" + CURL);
		try {
		Assert.assertEquals("http://localhost:8990/medicare/cart/show?result=added", CURL);
		log.info("Add product to cart validation passed");
		}
		catch(Exception e) {
			log.error(e);
		}
	}

}
