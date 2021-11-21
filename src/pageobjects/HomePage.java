package pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TSuites.Base;

public class HomePage {

	WebDriver driver;
	final Logger log = LogManager.getLogger(Base.class.getSimpleName());

	// WEB ELEMENTS
	@FindBy(xpath = "//li[@id='about']")
	WebElement About;
	@FindBy(xpath = "//div[@class='row']//h1")
	WebElement AboutDescription;
	@FindBy(xpath = "//li[@id='contact']")
	WebElement Contact;
	@FindBy(xpath = "//*[@id=\"listProducts\"]")
	WebElement ViewProducts;
	@FindBy(xpath = "//*[@id=\"signup\"]")
	WebElement SignUp;
	@FindBy(xpath = "//div[@class='row']//h4")
	WebElement SignUpDescription;
	@FindBy(xpath = "//*[@id=\"login\"]")
	WebElement Login;
	@FindBy(xpath = "//div[@class='row']//h4")
	WebElement LoginDescription;
	@FindBy(xpath = "//p[@class='lead']")
	WebElement Categories;
	@FindBy(xpath = "//*[@id=\"a_Antipyretics\"]")
	WebElement Antipyretics;
	@FindBy(xpath = "//*[@id=\"a_Analgesics\"]")
	WebElement Analgesics;
	@FindBy(xpath = "//*[@id=\"a_Antibiotics\"]")
	WebElement Antibiotics;
	@FindBy(xpath = "//*[@class='breadcrumb']/li[3]")
	WebElement CurrentSelection;

	public HomePage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isHomePage() {
		PropertyConfigurator.configure("config/log4j.properties");
		Assert.assertEquals("About", About.getText());
		Assert.assertEquals("Contact", Contact.getText());
		log.info("Home Page Passed");
	}

	/*
	 * public void login(String uname,String pass) { test =
	 * report.startTest("Login Test Case"); test.log(LogStatus.PASS,
	 * "Login page loaded successfully"); UserName.sendKeys(uname);
	 * test.log(LogStatus.PASS, "Successfully provided user name");
	 * Password.sendKeys(pass); test.log(LogStatus.PASS,
	 * "Successfully provided password"); ClickLogin.click();
	 * test.log(LogStatus.PASS, "Successfully clicked on Login Button");
	 * driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS); }
	 */

}
