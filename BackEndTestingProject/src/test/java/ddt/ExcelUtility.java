package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Tushar Gavare
 *
 */
public class ExcelUtility {
	
	/**
	 * read data from Excel based row and column index
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName , int rowNum , int celNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Tushar Gavare\\eclipse-workspace\\BackEndTestingProject\\testdata\\CrmtestScriptdata.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
	    String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
	    wb.close();
		return data;
	}
	/**
	 * get the used row count based on sheet name
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowcount(String sheetName ) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Tushar Gavare\\eclipse-workspace\\BackEndTestingProject\\testdata\\CrmtestScriptdata.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		 wb.close();
		return rowCount;
	}
	/**
	 * write data back to excel based on cell index
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataIntoExcel(String sheetName , int rowNum , int celNum , String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Tushar Gavare\\eclipse-workspace\\BackEndTestingProject\\testdata\\CrmtestScriptdata.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos = new FileOutputStream("./testdata/CrmtestScriptdata.xlsx");
		wb.write(fos);
		wb.close();
	} 
	

	}








