package utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.List;
 
import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {
	public static String filePath = "testData/CASProject.xlsx";
	public static XSSFWorkbook getWorkbook() throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		return workbook;
	}
	public static void writeURL(String Url,int rownum,int colnum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(colnum).setCellValue(Url);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void writeTitle(String title,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(1).setCellValue(title);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void writeAuthor(String Author,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(2).setCellValue(Author);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void writeArticle(String article,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(3).setCellValue(article);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void validateHyperLink(String result,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(4).setCellValue(result);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void validateShareOptions(String result,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(5).setCellValue(result);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void writeLikes(String likes,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(6).setCellValue(likes);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void writeViews(String views,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		row.createCell(7).setCellValue(views);
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
	public static void writeData(List<String> data,int rownum) throws IOException
	{
		XSSFWorkbook workbook = getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(rownum);
		int len = data.size();
		for(int i = 0;i<len;i++)
		{
			row.createCell(i).setCellValue(data.get(i));
		}
		FileOutputStream fo = new FileOutputStream(filePath);
		workbook.write(fo);
		workbook.close();
	}
}
