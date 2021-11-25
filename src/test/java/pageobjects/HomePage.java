package pageobjects;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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

	public void DBConnection() throws ClassNotFoundException, SQLException, IOException 
	{
		//Class.forName("com.sql.jdbcDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		FileReader reader=new FileReader("config/db.properties");  
		Properties p=new Properties();  
	    p.load(reader);  
	    Connection con=DriverManager.getConnection(p.getProperty("dbURL"), p.getProperty("user"), p.getProperty("pwd"));  
	    Statement stmt=con.createStatement();  
	}
	
	public void isHomePage() {
		PropertyConfigurator.configure("config/log4j.properties");
		try {
		Assert.assertEquals("About", About.getText());
		Assert.assertEquals("Contact", Contact.getText());
		log.info("Home Page Passed");
		}catch(Exception e) {
			log.error(e);
		}
	}
	
	

}
