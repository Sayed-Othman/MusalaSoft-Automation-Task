package utilities;
import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static final String       testDataExcelFileName =PropertyManager.getInstance().getTestDataFilePath(); //Global test data excel file
	public static final String       currentDir            = System.getProperty("user.dir"); 
	private static      XSSFWorkbook excelWBook;   //Excel WorkBook
	private static      XSSFSheet    mySheet;      //Excel Sheet
	public static       int          rowNumber;    //Row Number
	public static       int          columnNumber; //Column Number

	public String[][] ReadSheet() throws InvalidFormatException, IOException{
		File myfile = new File(currentDir+testDataExcelFileName);
		excelWBook = new XSSFWorkbook(myfile);
		mySheet = excelWBook.getSheet("sheet1");
		rowNumber= (mySheet.getLastRowNum()+1);
		columnNumber = 1;
		String[][] myArray= new String[rowNumber-1][columnNumber];

		for(int i =1 ;i<rowNumber;i++)
		{
			for(int y=0 ;y<columnNumber;y++) {
				XSSFRow row = mySheet.getRow(i);
				myArray[i-1][y]=row.getCell(y).toString();
			}

		}
		return myArray;
	}
}

