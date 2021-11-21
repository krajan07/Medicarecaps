package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class AddCart extends HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//table[@id='productListTable']/tbody")
	WebElement Tbody;

	public AddCart() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	public void ProductList(String med1) throws InterruptedException {
		ViewProducts.click();
		Thread.sleep(3000);
		List<WebElement> row = Tbody.findElements(By.tagName("tr"));
		log.info("Total Number of Rows = " + row.size());
		int ch = 0;
		for(WebElement mlist : row) {
				ch++;
				if(mlist.getText().contains(med1)) {
					log.info(mlist.getText());
					driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[6]/a[2]")).click();
				}
				break;
		}
		String curUrl = driver.getCurrentUrl();
		log.info("We are in page -->  " +curUrl);
		
		
		
		
		
		
		}
	
		

}
