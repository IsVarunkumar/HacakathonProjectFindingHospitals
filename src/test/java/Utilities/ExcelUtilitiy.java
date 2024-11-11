package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilitiy {
	
	public String[] getExcelData() throws IOException {
		XSSFRow row;
		String destination = System.getProperty("user.dir")+"\\src\\test\\resources\\HackatonData.xlsx";
		FileInputStream file = new FileInputStream(destination);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Input");
		int totalRowCount = sheet.getPhysicalNumberOfRows();
		int totalColCount = sheet.getRow(0).getPhysicalNumberOfCells();
		String[] data = new String[totalRowCount-1];
		for(int i=0;i<totalRowCount-1;i++) {
			row = sheet.getRow(i+1);
			for(int j=0;j<totalColCount;j++) {
				XSSFCell cell= row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					data[i] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i] = String.valueOf(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i] = String.valueOf(cell.getBooleanCellValue());
					break;
				default: data[i]="";
					break;
				}
			}
		}
		return data;
	}
	
	
//	public static void main(String[] args) throws IOException {
//		ExcelUtilitiy e= new ExcelUtilitiy();
//		String data[] = e.getExcelData();
//		for(int i=0;i<data.length;i++) {
//			System.out.println(data[i]);
//		}
//	}
}
