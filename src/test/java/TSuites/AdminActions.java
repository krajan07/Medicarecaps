package TSuites;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.*;

public class AdminActions extends Base {
	
	@Test(priority = 0, enabled = true)
	@Parameters({ "ausername", "apassword" })
	public void ValidAdminUserLoginCheck(String ausername, String apassword) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(1000);
		LP.ValidAdminUserLog(ausername, apassword);
	}
	
	
	@Test(priority = 1, enabled = true)
	public void ManageProductsPageConfirm() throws InterruptedException {
		ManageProductsPage MPP = new ManageProductsPage();
		Thread.sleep(1000);
		MPP.ManagelProductClick();
	}
	
	@Test(priority = 2, enabled = true)
	@Parameters({ "name", "brand", "unitPrice", "category" })
	public void AddMedicine(String name, String brand, String unitprice, String category) throws InterruptedException {
		ManageMedicines ANP = new ManageMedicines();
		Thread.sleep(1000);
		ANP.AddProduct(name, brand, unitprice, category);		
	}
	
	@Test(priority = 3, enabled = true)
	@Parameters({ "medname", "qty" })
	public void EditMedQty(String medname, String qty) throws InterruptedException {
		ManageMedicines ANP = new ManageMedicines();
		Thread.sleep(1000);
		ANP.EditQty(medname, qty);		
	}
	
	@Test(priority = 4, enabled = true)
	@Parameters({ "medname" })
	public void EditedMedQty(String medname) throws Exception {
		ManageMedicines ANP = new ManageMedicines();
		Thread.sleep(1000);
		ANP.EditQtyConfirm(medname);		
	}
	
	@Test(priority = 5, enabled = true)
	public void userLogOutClick() throws InterruptedException {
		LogOutPage LO = new LogOutPage();
		Thread.sleep(2000);
		LO.logOut();
	}
}
