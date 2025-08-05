package testngPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWorking {
	
	@DataProvider
	public Object[][] loginDetails()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="hemant";
		obj[0][1]="agrawal";
		obj[1][0]="pooja";
		obj[1][1]="agrawal";
		obj[2][0]="pari";
		obj[2][1]="agrawal";
		return obj;
		
	}
	
	@Test(dataProvider="loginDetails")
	public void login(String firstName, String lastName)
	{
		System.out.println(firstName+" "+lastName);
	}
	
	
	
	

}
