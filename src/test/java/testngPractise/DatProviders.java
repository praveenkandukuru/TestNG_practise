package testngPractise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DatProviders {
	
	
	
	@Test(dataProvider="getData")
	public void execute(String un,String pwd)
	{
		System.out.println(un+"---------"+pwd);
	}

	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		
		
		
		FileInputStream fiStream = new FileInputStream("D:\\javapractice\\Book1.xlsx");
		Workbook wbk = WorkbookFactory.create(fiStream);
		Sheet sheet = wbk.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(1);
		System.out.println(cell.getStringCellValue());
		
		int rownum = sheet.getPhysicalNumberOfRows();
		System.out.println(rownum);
		
		int cellnum=sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(cellnum);
		String dataStrings=sheet.getRow(0).getCell(1).getStringCellValue();
	
		Object data[][]=new Object[rownum-1][cellnum];
		for (int rows = 1; rows < rownum; rows++) {
		
//			Row row=
//			System.out.println(rows);
			
			
			for (int col =0;col<cellnum; col++) {
				
				data[rows-1][col]=sheet.getRow(rows).getCell(col).getStringCellValue();
			}
		}

		return data;
	}

}
