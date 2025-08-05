package ImplementationOfUtility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtilities;
import genericUtilities.PropertyUtility;
import genericUtilities.WebDriverUtilities;

public class CreateCampaignwithExpectedDate extends BaseClass{

	@Test
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
		if (text.contains(campname)) {
			System.out.println("compaign successfully created");
		} else {
			System.out.println("Compaign not created");
		}
		cp.getCloseBtn().click();

	}

}
