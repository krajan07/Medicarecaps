package TSuites;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.LogInPage;
import pageobjects.ViewProductsPage;

public class Shopping extends Base {

	@Test(priority = 0 , enabled=false)
	@Parameters({ "ivusername", "password" })
	public void InValidUserLoginCheck(String ivusername,String password) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(1000);
		LP.InValidUserLog(URL, ivusername, password);
	}
	
	@Test(priority = 1, enabled=false)
	@Parameters({ "username", "epassword" })
	public void InValidPasswordLoginCheck(String username, String epassword) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(1000);
		LP.InValidPassLog(URL, username, epassword);
	}
	
	@Test(priority = 2, enabled = true)
	@Parameters({ "username", "password" })
	public void ValidUserLoginCheck(String username, String password) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(1000);
		LP.ValidUserLog(URL, username, password);
	}
	
	@Test(priority = 2, enabled = true)
	@Parameters("med1")
	public void ViewProductList(String med1) throws InterruptedException {
		ViewProductsPage VPP = new ViewProductsPage();
		Thread.sleep(1000);
		VPP.ProductList(med1);
	}
	
	

}
