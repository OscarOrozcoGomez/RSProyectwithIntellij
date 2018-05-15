package help;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.PathsObtainer;

public class ExcelReader extends PathsObtainer{

	private XSSFWorkbook excelBook;
	private String excelMatrixSheetName = "Traceability Matrix";
	private XSSFCell cell;
	private String errorinFile;
	/***
	 * @param excelBook, This parameter stores Excel book value
	 */
	public void getBookName() {
		try {
			excelBook = new XSSFWorkbook(getExcelPath());
			String data = getSheetByName(excelMatrixSheetName).getRow(0).getCell(0).getStringCellValue(); 
			excelBook.getNumberOfSheets();
			//setExcelBook(new XSSFWorkbook(getPropertiesFile()));
		} catch (IOException e) {
			errorinFile = e.getMessage();
		}
	}
	private XSSFSheet getSheetByName(String sheetName) {
		return excelBook.getSheet(sheetName);
	}
	
//	public static String getCellData(int RowNum, int ColNum) throws Exception{
//		cell = excelWSheet.getRow(RowNum).getCell(ColNum);
//		String CellData = cell.getStringCellValue();
//		return CellData;
//	}
//	public static void main(String[] args) {
//		//Need to read the matriz or first sheet
//		for(int i = 0; i < excelWSheet.getLastRowNum(); i++ ) {
//			getCellData(i, "Traceability Matrix");
//		}
//	}
	public static void main(String[] args) {
		ExcelReader no = new ExcelReader();
		no.getBookName();
	}
}
