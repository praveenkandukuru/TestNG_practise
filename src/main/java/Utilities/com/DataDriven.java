package Utilities.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class is used to drive the data from the different files
 * @author prave
 */



public class DataDriven {
	/**
	 * 
	 * This method is used to get the data from the properties file
	 * 
	 * @param value
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromPropertiesFile(String value) throws IOException
	{
		FileInputStream fis=new FileInputStream(".//PropertiesFile//Browser.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String bname=prop.getProperty(value);
		return bname;
	}

	/**
	 * This method is used to get the data from the excel sheet
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */
	public String getdatafromExcelSheet(String sheetname, int rownum, int cellnum) throws IOException
	{
		FileInputStream fis = new FileInputStream("");
		Workbook wbk=WorkbookFactory.create(fis);
		Sheet sheet=wbk.getSheet(sheetname);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(cell);
		return value;
	}
	
	/**
	 * This method is used to set the data in Excel sheet
	 * 
	 * @param sheetname
	 * @param data
	 * @param rownum
	 * @param cellnum
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setValueInExcelsheet(String sheetname,String data,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("");
		
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(data);
		Row row=sheet.createRow(rownum);
		Cell cell=row.createCell(cellnum);
		cell.setCellValue(data);
	}

	
}
