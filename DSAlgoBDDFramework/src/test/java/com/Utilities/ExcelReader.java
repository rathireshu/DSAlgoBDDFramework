package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String xlsxFilePath= "C:/Users/bhanu/git/DSAlgoBDDFramework/DSAlgoBDDFramework/src/test/resources/TestData/DSAlgoTestData.xlsx";
    int totalRow;
    
    
	public List<Map<String,String>> getTestDataFromSheet(String sheetName) throws IOException
	{
		File file = new File(xlsxFilePath);
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try{
		FileInputStream inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);		   
	    sheet = workbook.getSheet(sheetName);		  
			
		} catch(Exception e) {
			LoggerLoad.error("Error while reading test data from excel file");
		} finally {
			if(workbook != null)
				workbook.close();
		}
		return  readSheet(sheet);
	}
	
	private List<Map<String,String>> readSheet(XSSFSheet sheet) {
	    
		
	  int totalRow=sheet.getPhysicalNumberOfRows();
			
	  List<Map<String,String>> excelRows = new ArrayList<Map<String,String>>();
			
	  for(int currentRow=1; currentRow <= totalRow; currentRow++)
			{
				XSSFRow row=sheet.getRow(currentRow);
				if(null != row) {
					int totalCol = row.getLastCellNum();
					
					Map<String,String> colMapData = new HashMap<String,String>();
					
					for(int currentCol=0; currentCol < totalCol; currentCol++)
					{
						XSSFCell cell=row.getCell(currentCol);
						
						String colHeaderName= sheet.getRow(sheet.getFirstRowNum()).getCell(currentCol).getStringCellValue();
						colMapData.put(colHeaderName, cell.getStringCellValue());
				    }
				    
					excelRows.add(colMapData);
				}
				
			}
			return excelRows;
			
	}
	
	
	
}
		
		
		
	

