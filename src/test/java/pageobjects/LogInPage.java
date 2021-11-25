package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import TSuites.Base;

public class LogInPage extends HomePage {
	@FindBy(xpath = "//*[@id='username']")
	WebElement UserName;
	@FindBy(xpath = "//*[@id='password']")
	WebElement Password;
	@FindBy(xpath = "//*[@id='loginForm']/div[3]/div/input[2]")
	WebElement ClickLogin;
	@FindBy(xpath = "//a[@id='dropdownMenu1']")
	WebElement CurrentUser;
	@FindBy(xpath = "//*[@id='logout']/a")
	WebElement LogOut;
	@FindBy(xpath = "//*[@id='username-error']")
	WebElement UError;
	@FindBy(xpath = "//*[@id='password-error']")
	WebElement PError;

	String u1 = "Test User";
	SoftAssert softAssert = new SoftAssert();

	public LogInPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);

	}

	public void isLoginPage() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		try {
		Assert.assertEquals("Login", LoginDescription.getText());
		log.info("Login page validation passed");
		}catch(Exception e) {
			log.error(e);
		}
	}

	public void ValidUserLog(String URL, String uname, String pass) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		ClickLogin.click();
		Thread.sleep(1000);
		try {
		Assert.assertEquals(u1, CurrentUser.getText());
		log.info("Login Successful validation passed");
		}catch(Exception e) {
			log.error(e);
		}
	}

	public void InValidUserLog(String URL, String uname, String pass) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		Thread.sleep(1000);
		try {
		log.warn("Error Message on the Login Page ---> " + UError.getText());
		softAssert.assertEquals("Please enter a valid email address!", UError.getText());
		log.info("Invalid user message validation passed");
		softAssert.assertAll();
		}catch(Exception e) {
			log.error(e);
		}
	}
	
	public void InValidPassLog(String URL, String uname, String pass) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		ClickLogin.click();
		Thread.sleep(1000);
		try {
		log.warn("Error Message on the Login Page ---> " + PError.getText());
		softAssert.assertEquals("Please enter your password!", PError.getText());
		log.info("Login with proper username and password validation passed");
		softAssert.assertAll();
		}catch(Exception e) {
			log.error(e);
		}
	}
}
