package WorkingWithExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {
	
	XSSFWorkbook WB;
	XSSFSheet SH;
	XSSFRow Rw;
	XSSFCell Cl;
	
	public void ReadExcelSheet0() throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\IBM_ADMIN\\Desktop\\TestData.xlsx"));
		WB = new XSSFWorkbook(fis);
		SH = WB.getSheetAt(0);
		int startRow = 1;
		int startCol = 1;
		int totalRow = SH.getLastRowNum();
		int totalCol = Rw.getLastCellNum();
		//int ci,cj = 0;
		String CellData;
		
		for(int i=startRow; i<=totalRow; i++) {
			Rw = SH.getRow(i);
			for(int j = startCol; j<=totalCol; j++) {
				Cl = Rw.getCell(j);
				CellData =  Cl.getStringCellValue();
				System.out.println(CellData);
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		ExcelDataRead EDR = new ExcelDataRead();
		EDR.ReadExcelSheet0();
	}
}
