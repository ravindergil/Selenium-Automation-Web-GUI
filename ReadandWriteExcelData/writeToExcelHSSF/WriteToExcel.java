package writeToExcelHSSF;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteToExcel {
	
	File f;
	FileOutputStream fos;
	HSSFWorkbook wb;
	HSSFSheet sh;
	HSSFRow rw;
	HSSFCell cl;
	
	public void CreateWorkBook() throws IOException {
		
		f = new File("C:\\Users\\IBM_ADMIN\\Desktop\\MyFile.xls");
		wb = new HSSFWorkbook();
		sh = wb.createSheet("Sheet 1");
		
		for(int i = 0; i<=5; i++) {
			rw = sh.createRow(i);
			cl = rw.createCell(i);
			cl.setCellValue("Cell" + i + " " + "Row" + i);
		}
		fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		System.out.println("Excel file is created");
	}

	public static void main(String[] args) throws IOException {
		WriteToExcel WE = new WriteToExcel();
		WE.CreateWorkBook();
		Desktop.getDesktop().open(WE.f);
	}
}
