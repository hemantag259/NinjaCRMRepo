package Campaign;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtilities;
import genericUtilities.WebDriverUtilities;


@Listeners(ListenerUtility.ListenerImplementation.class)
public class CampaignTest  extends BaseClass {
	
	@Test(groups="smoke")
	public void createCampaignTest() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtilities jutil = new JavaUtilities();
		WebDriverUtilities wutil = new WebDriverUtilities();
		
		HomePage hp = new HomePage(driver);
		hp.getCreateCampBtn().click();

		Thread.sleep(2000);

		// Read data from Excel
		String campname = eutil.toReadDataFromExcel("Campaign", 1, 2);
		System.out.println(campname);
		String target = eutil.toReadDataFromExcel("Campaign", 1, 3);
		String status = eutil.toReadDataFromExcel("Campaign", 1, 4);

		CampaignPage cp = new CampaignPage(driver);
		cp.getCampName().sendKeys(campname);
		Thread.sleep(2000);
		cp.getTargetSize().sendKeys(target);
		Thread.sleep(2000);
		cp.getCampStatus().sendKeys(status);
		cp.getCreateCampBtn().click();

		Thread.sleep(2000);
		
		
        //Validation
		WebElement alert = cp.getToastMsg();
		wutil.elementToBeVisible(driver, alert);
		String text = alert.getText();
		Assert.assertTrue(text.contains(campname));
		cp.getCloseBtn().click();

	}
	@Test(groups="regression")
	public void createCampaignWithExpectedDate() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtilities jutil = new JavaUtilities();
		WebDriverUtilities wutil = new WebDriverUtilities();
		
	
		HomePage hp=new HomePage(driver);
		hp.getCreateCampBtn().click();
		
		Thread.sleep(2000);

		// Read data from Excel
		String campname = eutil.toReadDataFromExcel("Campaign", 1, 2);
		System.out.println(campname);
		String target = eutil.toReadDataFromExcel("Campaign", 1, 3);
		String status = eutil.toReadDataFromExcel("Campaign", 1, 4);
		CampaignPage cp=new CampaignPage(driver);
		
		cp.getCampName().sendKeys(campname);
		Thread.sleep(2000);
		cp.getTargetSize().sendKeys(target);
		String ExpDate = jutil.toGetRequiredDate(30);

		WebElement expDateDD = cp.getExpCloseDate();
		wutil.takeInput(driver, expDateDD, ExpDate);
		Thread.sleep(2000);
		cp.getCampStatus().sendKeys(status);
		cp.getCreateCampBtn().click();
		Thread.sleep(2000);

		WebElement alert = cp.getToastMsg();
		wutil.elementToBeVisible(driver, alert);
		String text = alert.getText();
		Assert.assertTrue(text.contains(campname));
		cp.getCloseBtn().click();

	}


}
