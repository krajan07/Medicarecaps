package TSuites;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.AddProducttoCart;
import pageobjects.CartPage;
import pageobjects.LogInPage;
import pageobjects.LogOutLogInPage;
import pageobjects.LogOutPage;
import pageobjects.OrderConfirmationPage;
import pageobjects.ShippingPage;
import pageobjects.ViewProductsPage;

public class Shopping extends Base {

	@Test(priority = 0 , enabled=true)
	@Parameters({ "ivusername", "password" })
	public void InValidUserLoginCheck(String ivusername,String password) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(1000);
		LP.InValidUserLog(URL, ivusername, password);
	}
	
	@Test(priority = 1, enabled=true)
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
	public void ViewProductList() throws InterruptedException {
		ViewProductsPage VPP = new ViewProductsPage();
		Thread.sleep(1000);
		VPP.ProductList();
	}
	
	@Test(priority = 3, enabled = true)
	@Parameters({"med1", "med2"})
	public void MedAddCart(String med1, String med2) throws InterruptedException {
		AddProducttoCart AC = new AddProducttoCart();
		Thread.sleep(1000);
		AC.AddMedicine(med1, med2);
	}
	
	@Test(priority = 4, enabled = true)
	@Parameters({"med1", "med2"})
	public void checkCart(String med1, String med2) throws InterruptedException {
		CartPage CP = new CartPage();
		Thread.sleep(2000);
		CP.checkCart(med1, med2);
	}
	
	@Test(priority = 5, enabled = true)
	public void selectShipping() throws InterruptedException {
		ShippingPage SP = new ShippingPage();
		Thread.sleep(2000);
		SP.shippingPage();
	}
	
	
	@Test(priority = 6, enabled = true)
	public void orderConfirm() throws InterruptedException {
		OrderConfirmationPage OCP = new OrderConfirmationPage();
		Thread.sleep(2000);
		OCP.orderComplete();
	}
	
	@Test(priority = 7, enabled = true)
	public void userLogOutClick() throws InterruptedException {
		LogOutPage LO = new LogOutPage();
		Thread.sleep(2000);
		LO.logOut();
	}
	
	@Test(priority = 7, enabled = true)
	public void userLogOutConfirm() throws InterruptedException {
		LogOutLogInPage LOLI = new LogOutLogInPage();
		Thread.sleep(2000);
		LOLI.confirmlogOut();
	}
	
}
