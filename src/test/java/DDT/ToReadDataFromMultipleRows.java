package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromMultipleRows {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("Mobile");
		
		int rowCount=sh.getLastRowNum();
		for(int i=1;i<=rowCount;i++)
		{
			Row r= sh.getRow(i);
			String prodCat=r.getCell(0).getStringCellValue();
			String prodName=r.getCell(1).getStringCellValue();
			System.out.println(prodCat+"==="+prodName);
		}
		

	}

}
