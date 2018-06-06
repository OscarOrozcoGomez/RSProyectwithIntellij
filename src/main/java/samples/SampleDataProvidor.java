package samples;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SampleDataProvidor extends ExtendtReports{



    @Test(dataProvider = "Alimentador")
    public void run(String username, String password, String val, String val1, String val2){
        logger = reports.startTest(val);
        System.out.print(username);
        System.out.print(password);
        System.out.print(val);
        System.out.print(val1);
        System.out.print(val2);
        logger.log(LogStatus.PASS, "A wevo");
        reports.endTest(logger);
        reports.flush();
    }
    /*@Test(dataProvider = "Alimentador")
    public void runa(String username, String password, String val, String val1, String val2){
        System.out.println("Oscar");
        System.out.println(username);
        System.out.println(password);
        System.out.println(val);
        System.out.println(val1);
        System.out.println(val2);

    }*/
    /*@Test
    public void print() throws IOException, InvalidFormatException {
        SampleDataProvidor no = new SampleDataProvidor();
        no.returnCellValuess("TC001");
    }*/
    /*public static void main(String [] args) throws IOException, InvalidFormatException {
        SampleDataProvidor no = new SampleDataProvidor();
        no.returnCellValues("matriz");
        for (String yo :no.returnCellValues("matriz")) {
            System.out.println(yo);
        }
    }*/

    @DataProvider(name = "Alimentador")
    public Object[][] dataFeeder() {
        ClasePruebaLeerExcel no = new ClasePruebaLeerExcel();
        return no.gettingMatrixValues("matriz");
    }

    public List<String> returnCellValues(String sheetName) throws IOException, InvalidFormatException {        // Getting the Sheet at index zero
       List<String> excelMatrixValues = new ArrayList<String>();
        Workbook workbook = WorkbookFactory.create(new File("C:/Users/Toshiba/Documents/Eclipse/com.rousesrvices/src/main/java/libro.xlsx"));
        Sheet sheet = workbook.getSheet(sheetName);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
                excelMatrixValues.add(cellValue);
            }
            System.out.println();
        }
    return excelMatrixValues;
    }
    public void returnCellValuess(String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream("C:/Users/Toshiba/Documents/Eclipse/com.rousesrvices/src/main/java/libro.xlsx");
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheet(sheetName);
        XSSFRow row = null;
        XSSFCell cell;

        // Making the object of excel row
        row = mySheet.getRow(0);

        int colCount = row.getLastCellNum();
        System.out.println("Column Count :- " + colCount);

        int rowCount = mySheet.getLastRowNum() + 1;
        System.out.println("Row Count :- " + rowCount);
        for (int i = 0; i <= row.getLastCellNum(); i++){
            for (int j = 0; j <= mySheet.getLastRowNum() + 1; j++){
                //cell.getStringCellValue();
            }
        }
    }

}
