package Campaign;
import org.testng.annotations.Test;

public class ReadDataFromCMDTest {

	
	@Test
	public void CMDDataRead() {
		// TODO Auto-generated method stub
		
		String URL = System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		System.out.println("URL is "+URL+" with username as "+username+" with password as "+password);
				

	}

}
