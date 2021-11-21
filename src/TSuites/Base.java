package TSuites;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

	public static WebDriver driver;
	final Logger log = LogManager.getLogger(Base.class.getSimpleName());

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		PropertyConfigurator.configure("config/log4j.properties");
		log.info("Setup for testing initated.");
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/medicare/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		log.info("Medicare WebSite Lanuched");
	}

	@AfterTest
	public void TearDown() {
		log.info("In Tear Down... All tests executions completed");
		driver.quit();
	}

}
