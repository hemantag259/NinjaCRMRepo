package Practice;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new EdgeDriver();
	     driver.manage().window().maximize();
	     driver.get("http://49.249.28.218:8098/");
	     driver.findElement(By.id("username")).sendKeys("rmgyantra");
	     driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.linkText("Contacts")).click();
	     Random r= new Random();
	     int count=r.nextInt(1000);
	     driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.name("contactName")).sendKeys("hemant"+count);
	     driver.findElement(By.name("organizationName")).sendKeys("QSpider");
	     driver.findElement(By.name("mobile")).sendKeys("12345");
	     driver.findElement(By.name("title")).sendKeys("Mr.");
	    String parent = driver.getWindowHandle();
	     driver.findElement(By.xpath("//*[name()='svg' and @role='img']/parent::button")).click();
	     Thread.sleep(3000);
	    Set<String> childs = driver.getWindowHandles();
	    childs.remove(parent);
	    for(String child: childs)
	    {
	    driver.switchTo().window(child);
	    }
	   
	    
	     driver.findElement(By.xpath("//td[text()='CAM00001']/following-sibling::td[6]/button")).click();
	     driver.switchTo().window(parent);
	     driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
	     
	}

}
