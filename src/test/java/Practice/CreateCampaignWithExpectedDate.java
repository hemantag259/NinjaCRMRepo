package Practice;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaignWithExpectedDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     WebDriver driver= new EdgeDriver();
     driver.manage().window().maximize();
     driver.get("http://49.249.28.218:8098/");
     driver.findElement(By.id("username")).sendKeys("rmgyantra");
     driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
     Thread.sleep(3000);
     driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    // driver.findElement(By.linkText("Campaigns")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
     Thread.sleep(2000);
     Random ran=new Random();
     int count=ran.nextInt(1000);
     driver.findElement(By.name("campaignName")).sendKeys("hemant"+count);
     Thread.sleep(2000);
    WebElement target = driver.findElement(By.name("targetSize"));
    target.clear();
    target.sendKeys("15");
     Thread.sleep(2000);
     driver.findElement(By.name("campaignStatus")).sendKeys("Designed");
     
     Date date=new Date();
     SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
     sim.format(date);
     Calendar cal=sim.getCalendar();
     cal.add(Calendar.DAY_OF_MONTH, 30);
     String ExpDate=sim.format(cal.getTime());
     
    WebElement expDateDD = driver.findElement(By.name("expectedCloseDate"));
    Actions act=new Actions(driver);
    act.click(expDateDD).sendKeys(ExpDate).perform();
     
     
     driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
     Thread.sleep(2000);
    WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(alert));
    String text = alert.getText();
    if(text.contains("hemant"))
    {
    	System.out.println("compaign successfully created");
    }
    else
    {
    	System.out.println("Compaign not created");
    }
    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
    WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
   
    act.moveToElement(icon).perform();
    driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
    driver.quit();
	}

}
