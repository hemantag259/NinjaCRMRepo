package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String toReadDataFromExcel(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestScriptData.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	   String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	   return data;
	

	
	}
	
	public int toGetRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestScriptData.xlsx");
		   Workbook wb = WorkbookFactory.create(fis);
		   int rowCount=wb.getSheet(sheetName).getLastRowNum();
		   return rowCount;
	}

}
