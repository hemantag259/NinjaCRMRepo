package testngPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	
	@Test
	public void checkAssertion()
	{
		String expTitle="Facebook – log in or sign";
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actTitle=driver.getTitle();
		//Assert.assertEquals(expTitle, actTitle);
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(expTitle, actTitle);
		System.out.println("hi");
		soft.assertAll();
		
	}

}
