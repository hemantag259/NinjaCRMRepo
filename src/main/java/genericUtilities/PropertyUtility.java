package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	
	public String toGetDataFromProperty(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
	    String value=prop.getProperty(key);
	    return value;
	}

}
