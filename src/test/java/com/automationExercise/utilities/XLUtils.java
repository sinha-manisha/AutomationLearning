package com.automationExercise.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;


public class XLUtils {
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum, int column) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		String data;
		DataFormatter formatter=new DataFormatter();
		data=formatter.formatCellValue(cell);
		
		wb.close();
		fi.close();
		return data;
	}

}
