package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils 
{
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet ws1;
	public static Row row;
	public static  Cell cell;
	public static FileOutputStream fo;
	public static CellStyle style;

	public static int getRowcount(String Xlfile,String Xlsheet) throws Throwable
	{
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		int rowcount=ws1.getLastRowNum();
		return rowcount;
	}

	public static short getcellcount(String Xlfile,String Xlsheet, int rownum ) throws Throwable
	{ 
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		row= ws1.getRow(rownum);
		short cellcount= row.getLastCellNum();
		return cellcount;
	}
	public static String getStringCellData(String Xlfile,String Xlsheet, int rownum,int colnum) throws Throwable
	{
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		row= ws1.getRow(rownum);
		cell= row.getCell(colnum);
		String data=  cell.getStringCellValue();
		return data;
	}

	public static double getNumaricCellData(String Xlfile,String Xlsheet, int rownum,int colnum) throws Throwable
	{
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		row= ws1.getRow(rownum);
		cell= row.getCell(colnum);
		double data=  cell.getNumericCellValue();
		return data;

	}

	public static boolean getBooleanCellData(String Xlfile,String Xlsheet, int rownum,int colnum) throws Throwable
	{
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		row= ws1.getRow(rownum);
		cell= row.getCell(colnum);
		boolean data=  cell.getBooleanCellValue();
		return data;

	}

	public static void SetStringCellData(String Xlfile,String Xlsheet, int rownum,int colnum,String data) throws Throwable
	{
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		row= ws1.getRow(rownum);
		cell= row.createCell(colnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(Xlfile);
		wb.write(fo);
		wb.close();
	}

	public static void fillGreenColor(String Xlfile,String Xlsheet, int rownum,int colnum) throws Throwable
	{
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		row= ws1.getRow(rownum);
		cell= row.getCell(colnum);

		style =wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo= new FileOutputStream(Xlfile);
		wb.write(fo);
		wb.close();
	}

	public static void fillRedColor(String Xlfile,String Xlsheet, int rownum,int colnum) throws Throwable
	{
		fi = new FileInputStream(Xlfile);
		wb= new XSSFWorkbook(fi);
		ws1= wb.getSheet(Xlsheet);
		row= ws1.getRow(rownum);
		cell= row.getCell(colnum);

		style =wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo= new FileOutputStream(Xlfile);
		wb.write(fo);
		wb.close();
	}




}