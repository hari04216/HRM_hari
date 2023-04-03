package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDataFromexcel(String SheetName, int rowno, int coloumnno) throws Throwable {
		FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(rowno).getCell(coloumnno).getStringCellValue();
		return value;
	}

	public int getLastRowno(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}

	public void writeDataIntoExcel(String sheetName, int rowno, int coloumnno, String data) throws Throwable {
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowno).createCell(coloumnno).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(Ipathconstants.Excelpath);
		wb.write(fout);
	}

	public HashMap<String, String> readMultipleData(String SheetName) throws Throwable {
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i <= count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	public String getExpectedDataFromExcwl(String SheetName, Object expData) throws Throwable {
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i <= count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map.get(expData);
	}
	
	
	
	public Object[][] readmultiplesetofdata(String sheetname) throws Throwable
	{
		FileInputStream fi=new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow =sh.getLastRowNum()+1;
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][]obj=new Object[ lastrow][lastCell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
				return obj;
	}
}
