package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NinjaProductCreate {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Read data from Properties file
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
        Properties prop= new Properties();
        prop.load(fis);
       String BROWSER = prop.getProperty("Browser");
      String URL = prop.getProperty("URL");
     String USERNAME = prop.getProperty("Username");
    String PASSWORD = prop.getProperty("Password");
    WebDriver driver=null;
    if(BROWSER.equals("Edge"))
    {
    	driver=new EdgeDriver();
    }
    else if(BROWSER.equals("Chrome"))
    {
    	driver=new ChromeDriver();
    }
    else if(BROWSER.equals("Firefox"))
    {
    	driver=new FirefoxDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(URL);
    driver.findElement(By.id("username")).sendKeys(USERNAME);
    driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
     driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	    // driver.findElement(By.linkText("Campaigns")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Products")).click();
	     driver.findElement(By.xpath("//span[text()='Add Product']")).click();
	     
	     Random ran=new Random();
	     int count=ran.nextInt(1000);
	     //Read from excel
	     
	     FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TestScriptData.xlsx");
	     Workbook wb= WorkbookFactory.create(fis1);
	     Sheet sh= wb.getSheet("Product");
	    Row r = sh.getRow(1);
	    String productName= r.getCell(0).getStringCellValue();
	    String 	quantitydata=r.getCell(1).getStringCellValue();
	    String unitPerPrice=r.getCell(2).getStringCellValue();
	    
	     WebElement quantity = driver.findElement(By.name("quantity"));
	     quantity.clear();
	     quantity.sendKeys(quantitydata);
	     driver.findElement(By.name("productName")).sendKeys(productName+count);
	    WebElement price = driver.findElement(By.name("price"));
	    price.clear();
	    price.sendKeys(unitPerPrice);
	    WebElement cat = driver.findElement(By.name("productCategory"));
	   
	    Select sel=new Select(cat);
	    sel.selectByVisibleText("Electronics");
	    WebElement vendor = driver.findElement(By.name("vendorId"));
	    Select selven=new Select(vendor);
	 selven.selectByValue("VID_002");
	    driver.findElement(By.xpath("//button[text()='Add']")).click();
	    WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(alert));
	    String text = alert.getText();
	    if(text.contains(productName))
	    {
	    	System.out.println("product successfully created");
	    }
	    else
	    {
	    	System.out.println("product not created");
	    }
	    
	    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	    WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
	    Actions act= new Actions(driver);
	    act.moveToElement(icon).perform();
	    driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
	    driver.quit();
	    
	}

}
