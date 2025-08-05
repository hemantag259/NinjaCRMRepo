package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ToReadDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		FileReader fr=new FileReader(".\\src\\test\\resources\\CommonJsonData.json");
		JSONParser parser=new JSONParser();
		Object jobj = parser.parse(fr);
		JSONObject obj=(JSONObject)jobj;
		String Browser = obj.get("Browser").toString();
		System.out.println(Browser);
		

	}

}
