package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class CartPage extends HomePage {

	WebDriver driver;

	@FindBy(xpath = "//table[@id='cart']/tbody")
	WebElement CartTbody;
	@FindBy(xpath = "//*[@id='cart']/tfoot/tr[2]/td[4]")
	WebElement CheckOut;

	public CartPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	public void checkCart(String med1,String med2) throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> row = CartTbody.findElements(By.tagName("tr"));
		log.info(row.size());
		int ch = 1 ,i=0;
		try {
		do {
		for(WebElement mlist : row) {
			String med = driver.findElement(By.xpath("//*[@id='cart']/tbody/tr["+ch+"]/td[1]/div/div[2]/h4")).getText();
			Assert.assertTrue(med.matches(med1) || (med.matches(med2)));
			ch++;
			i++;
		}
		}while(i> row.size());
		log.info("Medicines " +med1+ " and " +med2+ "successfully added in the cart");
		log.info("Products in the cart validation passed.");
		Thread.sleep(2000);
		Assert.assertTrue(CheckOut.isEnabled());
		log.info("Checkout is enabled to proceed.");
		Thread.sleep(2000);
		CheckOut.click();		
		}catch(Exception e) {
		log.error(e);
		} 
	}
	
}
