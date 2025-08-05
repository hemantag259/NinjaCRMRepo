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
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaignCreation {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
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
     driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
     Thread.sleep(2000);
     Random ran=new Random();
     int count=ran.nextInt(1000);
     //Read data from Excel
     FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TestScriptData.xlsx");
     Workbook wb= WorkbookFactory.create(fis1);
     Sheet sh= wb.getSheet("Campaign");
    Row r = sh.getRow(1);
    String campname= r.getCell(2).getStringCellValue();
    String target=r.getCell(3).getStringCellValue();
    System.out.println(campname);
     driver.findElement(By.name("campaignName")).sendKeys(campname+count);
     Thread.sleep(2000);
    WebElement size = driver.findElement(By.name("targetSize"));
    size.clear();
    size.sendKeys(target);
     Thread.sleep(2000);
     driver.findElement(By.name("campaignStatus")).sendKeys("Designed");
     driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
     Thread.sleep(2000);
    WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(alert));
    String text = alert.getText();
    if(text.contains(campname))
    {
    	System.out.println("compaign successfully created");
    }
    else
    {
    	System.out.println("Compaign not created");
    }
    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
    WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
    Actions act= new Actions(driver);
    act.moveToElement(icon).perform();
    driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
    driver.quit();
	}

}
