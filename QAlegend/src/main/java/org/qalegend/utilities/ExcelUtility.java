package org.qalegend.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qalegend.constants.Constants;


public class ExcelUtility {
	
	 static FileInputStream f;
	  static XSSFWorkbook w;
	  static XSSFSheet s;
		

	public static String readStringData(int row, int column, String sheetname) 
	{
		try{
		String path=Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
		f= new FileInputStream(path);
		w= new XSSFWorkbook(f);
		s= w.getSheet(sheetname);
		Row r= s.getRow(row);
		Cell c= r.getCell(column);
		return c.getStringCellValue();
		}
		catch(Exception e) {
			throw new RuntimeException("TestData excel not fount");
			
		}
	}

	public static String readIntegerData(int row, int column, String sheetname) 
	{
		try{
		String path=Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
		f= new FileInputStream(path);
		w= new XSSFWorkbook(f);
		s= w.getSheet(sheetname);
		Row r= s.getRow(row);
	    Cell c= r.getCell(column);
	    int d=(int) c.getNumericCellValue();
		return String.valueOf(d);
		}
		catch(Exception e)
		{
			throw new RuntimeException("TestData excel not fount");
		}
		
	}

}
