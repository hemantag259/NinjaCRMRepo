package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class irctclogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
	    WebDriver driver= new ChromeDriver(options);
	     driver.manage().window().maximize();
	     driver.get("https://www.irctc.co.in/nget/train-search");
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     Thread.sleep(10000);
	     WebElement fromdd = driver.findElement(By.xpath("(//input[@role='searchbox'])[1]"));
	    Actions act= new Actions(driver);
	   //  act.moveToElement(fromdd).click().perform();
	   //  JavascriptExecutor js=(JavascriptExecutor) driver;
	   //  js.executeScript("arguments[0].click()", fromdd);
	    // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    //WebElement textbox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='searchbox']")));
	     fromdd.sendKeys("mumbai");
	    // Thread.sleep(3000);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     WebElement fromstation = driver.findElement(By.xpath("//span[contains(text(),'MUMBAI CENTRAL')]"));
	     WebDriverWait fromwait=new WebDriverWait(driver, Duration.ofSeconds(10));
		  fromwait.until(ExpectedConditions.elementToBeClickable(fromstation));
	     
	     
	     act.moveToElement(fromstation).click().perform();
	     WebElement todd= driver.findElement(By.xpath("(//input[@role='searchbox'])[2]"));
	     todd.sendKeys("indore");
		    // Thread.sleep(3000);
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		     WebElement tostation = driver.findElement(By.xpath("//span[contains(text(),'INDORE')]"));
		     WebDriverWait towait=new WebDriverWait(driver, Duration.ofSeconds(10));
			  towait.until(ExpectedConditions.elementToBeClickable(tostation));
			  act.moveToElement(tostation).click().perform();
			  WebElement search = driver.findElement(By.xpath("//button[text()='Search']"));
			  JavascriptExecutor js=(JavascriptExecutor) driver;
			   js.executeScript("arguments[0].scrollIntoView", search);
			   search.click();
			 WebElement train = driver.findElement(By.xpath("//strong[contains(text(),'DURONTO')]"));
	           String trainName=train.getText();
	           int size=trainName.length();
	           int beginindex=size-5;
	           String trainnumber=trainName.substring(beginindex-1,size-1);
	           System.out.println(trainnumber);
	
	}

}
