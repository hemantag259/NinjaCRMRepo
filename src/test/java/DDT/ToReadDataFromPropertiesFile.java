package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
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
        
	}

}
