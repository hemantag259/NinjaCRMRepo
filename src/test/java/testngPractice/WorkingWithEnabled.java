package testngPractice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkingWithEnabled {
	
	public class Demo {

		@Test
		public void a11()
		{
			Reporter.log("a11 executed",true);
		}
		
		@Test(enabled=false)
		public void a23()
		{
			Reporter.log("a23 executed",true);
		}
		
		@Test(enabled=true)
		public void b25()
		{
			Reporter.log("b25 executed", true);
		}
	}


}
