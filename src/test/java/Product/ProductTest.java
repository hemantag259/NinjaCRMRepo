package Product;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import ObjectRepositories.HomePage;
import ObjectRepositories.ProductPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtilities;
import genericUtilities.WebDriverUtilities;

public class ProductTest extends BaseClass{
	
	@Test(groups="smoke")
	public void productCreationTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtilities jutil = new JavaUtilities();
		WebDriverUtilities wutil = new WebDriverUtilities();

	
		HomePage hp=new HomePage(driver);
		hp.getProductlink().click();
		ProductPage pp=new ProductPage(driver);
		pp.getAddProductLink().click();
		

		int count = jutil.toGetRandomNumber();

		String productName = eutil.toReadDataFromExcel("Product", 1, 0);
		String quantitydata = eutil.toReadDataFromExcel("Product", 1, 1);
		String unitPerPrice = eutil.toReadDataFromExcel("Product", 1, 2);
		
		pp.getQuantity().sendKeys(quantitydata);
		pp.getProdName().sendKeys(productName + count);
		pp.getPrice().clear();
		pp.getPrice().sendKeys(unitPerPrice);
		
		
		WebElement cat	=pp.getProductCat();
		

		Select sel = new Select(cat);
		sel.selectByVisibleText("Electronics");
		WebElement vendor=pp.getVendorId();
		Select selven = new Select(vendor);
		selven.selectByValue("VID_002");
		pp.getAddProduct().click();
		WebElement alert = pp.getToastMsg();
		wutil.elementToBeVisible(driver, alert);
		String text = alert.getText();
		if (text.contains(productName)) {
			System.out.println("product successfully created");
		} else {
			System.out.println("product not created");
		}

		pp.getCloseBtn().click();
		
	}

}
