package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderClass {

	
	
	public static ArrayList<String> main(String testCaseName) throws IOException
	{
		ArrayList<String> data = new ArrayList<>();
		
		XSSFSheet sheet = null;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\AutomationSwagLabs\\src\\main\\java\\testData\\LoginTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int TotalSheetCount= workbook.getNumberOfSheets();
		for(int i=0; i<TotalSheetCount; i++)
		{	
			if(workbook.getSheetName(i).equalsIgnoreCase("Login"))
			{	
				 sheet = workbook.getSheetAt(i);
				 
				 Iterator<Row> row = sheet.iterator();
				Row firstRow = row.next();
				
				Iterator<Cell> cell = firstRow.cellIterator();
						
				int k=0;
				int column = 0;
				CellAddress coulumnAddress;
				 while(cell.hasNext())
				 {
					 Cell cellValue = cell.next();
					 if(cellValue.getStringCellValue().equalsIgnoreCase(testCaseName))
					 {
						    column = k;
						  //coulumnAddress= cellValue.getAddress();
					 } 
					 k++; 
				 } 
				 
				 while(row.hasNext())
				 {
					 Row newRow = row.next();
					 data.add( newRow.getCell(column).getStringCellValue());
				 }
			}
		}
		
		return data;
		
	}
	
	
}
