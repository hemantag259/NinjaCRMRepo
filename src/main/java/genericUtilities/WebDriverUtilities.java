package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {

   public void pageToFullyLoad(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   
   }
   
   public void elementToBeVisible(WebDriver driver, WebElement Element)
   {
	   WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.visibilityOf(Element));
   }
   
   
   public void switchToFrame(WebDriver driver, int index)
   {
	   driver.switchTo().frame(index);
   }
   public void switchToFrame(WebDriver driver, String idorname)
   {
	   driver.switchTo().frame(idorname);
   }
   public void switchToFrame(WebDriver driver, WebElement frameEle)
   {
	   driver.switchTo().frame(frameEle);
   }
   
   public void selectByIndex(WebElement element, int index)
   {
	   Select sel=new Select(element);
	   sel.selectByIndex(index);
   }
   public void selectByValue(WebElement element, String value)
   {
	   Select sel=new Select(element);
	   sel.selectByValue(value);
   }
   public void selectByText(WebElement element, String text)
   {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
   }
   
   public void switchToAlertAccept(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   public void switchToAlertDismiss(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   public void switchToAlertSendKeys(WebDriver driver,String text)
   {
	   driver.switchTo().alert().sendKeys(text);
   }
   public String switchToAlertGetText(WebDriver driver)
   {
	   String text=driver.switchTo().alert().getText();
	   return text;
   }
   
   public void mouseHover(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();
   }
   public void click(WebDriver driver,WebElement element )
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).click().perform();
   }
   
   public void doubleClick(WebDriver driver,WebElement element )
   {
	   Actions act=new Actions(driver);
	   act.doubleClick(element).perform();
   }
   public void takeInput(WebDriver driver,WebElement element,String text )
   {
	   Actions act=new Actions(driver);
	   act.click(element).sendKeys(text).perform();
   }
   public void rightClick(WebDriver driver,WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.contextClick(element).perform();
   }
   
   public void toScrollBy(WebDriver driver,int X, int Y)
   {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("Window.scrollBy("+X+","+Y+"");
   }
   public void switchToWindow(WebDriver driver)
   {
	   String parentId=driver.getWindowHandle();
	   Set<String> childIds=driver.getWindowHandles();
	   childIds.remove(parentId);
	   for(String childId:childIds)
	   {
		   driver.switchTo().window(childId);
	   }
	   
   }
   
   public void takesScreenshot(WebDriver driver,String fileName) throws IOException
   {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File temp=ts.getScreenshotAs(OutputType.FILE);
	   File perm=new File(".//errorScreenshots"+fileName+".png");
	   FileHandler.copy(temp, perm);
	   
   }
}
