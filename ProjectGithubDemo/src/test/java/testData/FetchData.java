package testData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchData {

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	static String testData = System.getProperty("user.dir");
	private static String dataName;

	public static String dataDriven(int rowNum, int cellNum) {

		try {
			wb = new XSSFWorkbook(testData + "/Data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = wb.getSheet(dataName);
		row = sheet.getRow(rowNum);
		return row.getCell(cellNum).toString();
		
	}

	public static int rowCount(String className) {
		dataName = className;

		try {
			wb = new XSSFWorkbook(testData + "/Data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = wb.getSheet(dataName);
		int count = sheet.getLastRowNum();
		return count;
	}
	
	public static void writeData(int rowNum) throws IOException {
		FileInputStream fis = new FileInputStream(testData + "/Data.xlsx");
		FileOutputStream fos;
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(dataName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(47);
		cell.setCellValue("Pass");
		
		fos = new FileOutputStream(testData + "/Data.xlsx");
		wb.write(fos);
		wb.close();
	}

}
