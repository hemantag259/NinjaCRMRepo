package testngPractice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExecutePriority {

	@Test(priority=1)
	public void add()
	{
		Reporter.log("add",true);
	}
	@Test(priority=-1)
	public void sub()
	{
		Reporter.log("sub",true);
	}
	@Test(priority=2)
	public void mul()
	{
		Reporter.log("mul",true);
	}
}
