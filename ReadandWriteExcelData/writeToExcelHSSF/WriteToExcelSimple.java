package writeToExcelHSSF;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteToExcelSimple {
	
	File f;
	FileOutputStream fos;
	HSSFWorkbook wb;
	HSSFSheet sh;
	HSSFRow rw;
	HSSFCell cl;
	
	public void CreateWorkBook() throws IOException{
		
		f = new File("C:\\Users\\IBM_ADMIN\\Desktop\\MyFile.xls");
		wb = new HSSFWorkbook();
		sh = wb.createSheet("My Sheet");
		rw = sh.createRow(1);
		cl = rw.createCell(0);
		cl.setCellValue("My Cell");
		fos = new FileOutputStream(f);
		wb.write(fos);
	}
	
	public static void main(String[] args) throws IOException {
		WriteToExcelSimple WES = new WriteToExcelSimple();
		WES.CreateWorkBook();
		Desktop.getDesktop().open(WES.f);
	}
}
