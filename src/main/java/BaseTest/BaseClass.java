package BaseTest;

import org.testng.annotations.Test;

import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;
import genericUtilities.PropertyUtility;
import genericUtilities.WebDriverUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver=null;
	public PropertyUtility pu = new PropertyUtility();
	
	public WebDriverUtilities wu = new WebDriverUtilities();
	

	@BeforeMethod(groups={"smoke","regression"})
	public void beforeMethod() throws IOException {
		LoginPage lp = new LoginPage(driver);

		String URL = pu.toGetDataFromProperty("URL");
		String USERNAME = pu.toGetDataFromProperty("Username");
		String PASSWORD = pu.toGetDataFromProperty("Password");

		lp.login(URL, USERNAME, PASSWORD);
		System.out.println("Login to the application");
	}

	@AfterMethod(groups={"smoke","regression"})
	public void afterMethod() {
		HomePage hp = new HomePage(driver);
		WebElement icon = hp.getUserIcon();
		wu.mouseHover(driver, icon);
		WebElement logout = hp.getLogout();
		wu.click(driver, logout);
		System.out.println("Logout to the application");
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups={"smoke","regression"})
	public void beforeClass() throws IOException {
		String BROWSER = pu.toGetDataFromProperty("Browser");
		//String BROWSER=browser;
		if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		sdriver=driver;
		driver.manage().window().maximize();
		wu.pageToFullyLoad(driver);
		
		
	}

	@AfterClass(groups={"smoke","regression"})
	public void afterClass() {
		driver.quit();
		System.out.println("Closing the browser");
	}

	@BeforeSuite(groups={"smoke","regression"})
	public void beforeSuite() {
		System.out.println("DB Open");
	}

	@AfterSuite(groups={"smoke","regression"})
	public void afterSuite() {
		System.out.println("DB Close");
	}

}
