package testngPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvokeCountExecute {
	
	@Test(invocationCount=3)
	public void launch() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}

}
