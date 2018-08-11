package week8.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;

//import wdMethods.SeMethods;



public class ReadExcel extends SeMethods{
    
	@Test
	public Object[][] readExcelData(String fileName) throws IOException {
	
		//Open Excel from the File Path
		XSSFWorkbook workBook=new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		//Go to Sheet
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		//Find the Row Counts
		int rowCount = sheet.getLastRowNum();
		
		//Find the Cell Count
		short columnCount = sheet.getRow(0).getLastCellNum();
		
		//Read the Data from Excel
		//CRate Object for write the data from create lead using TWo dimensional Array
		
		Object [][] data=new Object[rowCount][columnCount];
		
		
		for (int i=1;i<=rowCount;i++)
		{
			
			XSSFRow row = sheet.getRow(i);
			
			
			for(int j=0;j<columnCount;j++) 
			{
				
			String stringCellValue = row.getCell(j).getStringCellValue();
				
			    data[i-1][j] = stringCellValue;
			    
			
				
			}
			

						
		}
		workBook.close();
		return data;
	}

	
	}

