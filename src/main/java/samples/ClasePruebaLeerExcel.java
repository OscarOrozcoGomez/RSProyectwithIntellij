package samples;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClasePruebaLeerExcel {
    static XSSFWorkbook book;
    static XSSFSheet sheet;
    static XSSFRow row;
    static XSSFCell cell;
    String[][] data;
    public static String getCellDataByIndex(String sheetName, int rownumber, int columnNumber){
        try {
            FileInputStream fis = new FileInputStream("C:/Users/Toshiba/Documents/Eclipse/com.rousesrvices/src/main/java/libro.xlsx");
            book = new XSSFWorkbook(fis);
            sheet = book.getSheet(sheetName);
            row = sheet.getRow(rownumber);
            cell = row.getCell(columnNumber);
        }catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return cell.getStringCellValue();
    }
    public Object[][] gettingMatrixValues(String sheetName){
        try {
            FileInputStream fis = new FileInputStream("C:/Users/Toshiba/Documents/Eclipse/com.rousesrvices/src/main/java/libro.xlsx");
            book = new XSSFWorkbook(fis);
            sheet = book.getSheet(sheetName);
            row = null;
            cell = null;

            // Making the object of excel row
            row = sheet.getRow(0);

            int colCount = row.getLastCellNum();
            System.out.println("Column Count :- " + colCount);

            int rowCount = sheet.getLastRowNum() + 1;
            System.out.println("Row Count :- " + rowCount);
            data = new String[rowCount][colCount];
            for (int i = 0; i <= sheet.getLastRowNum() ; i++){
                for (int j = 0; j <= row.getLastCellNum() - 1; j++){
                    System.out.print(getCellDataByIndex("matriz", i,j) + "//");
                    data[i][j] = getCellDataByIndex("matriz", i,j);
                }
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return data;
    }
}


