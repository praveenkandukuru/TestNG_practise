package testngPractise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders2 {
	
	@Test(dataProvider="getData")
	
	public void getDatafromDP(Hashtable<String,String> data1)
	
	{
		System.out.println(data1.get("username"));
		System.out.println(data1.get("username")+"   "+data1.get("password")+"  "+data1.get("dod")+"   "+data1.get("salary"));
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	
	{
	
		FileInputStream fis=new FileInputStream("D:\\javapractice\\Book2.xlsx");
		Workbook wbk=WorkbookFactory.create(fis);
		Sheet sheet=wbk.getSheet("Sheet1");
		Row row=sheet.getRow(0);
		
		int rows=sheet.getPhysicalNumberOfRows();
		
		int cells=row.getPhysicalNumberOfCells();
		Hashtable<String,String> htable=null;
		
		Object data[][]=new Object[rows-1][cells];
		
		
		
		DataFormatter format=new DataFormatter();
		
		for(int i=1;i<rows;i++)
		{
			htable=new Hashtable<String, String>();
			for(int j=0;j<cells;j++)
			{
				//data[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
				htable.put(format.formatCellValue(sheet.getRow(0).getCell(j)),format.formatCellValue(sheet.getRow(i).getCell(j)));
				data[i-1][0]=htable;
			}
		}
		return data;
	}

}
