package WorkingWithExcel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WriteToExcel {
	
	
	WebDriver driver;
	File f;
	HSSFWorkbook WB;
	HSSFSheet Sh;
	HSSFRow rw;
	HSSFCell cl;
	FileOutputStream fos;
	
	
	public void CreateFile() throws IOException {
		f = new File("C:\\Users\\IBM_ADMIN\\Desktop\\WebDriver_Demo.xls");
		WB = new HSSFWorkbook();
		Sh = WB.createSheet("Sheet One");
		for(int i=0; i<=5; i++) {
			rw = Sh.createRow(i);
			for(int j=0; j<=5; j++) {
			cl = rw.createCell(j);
			cl.setCellValue("MyCell" + i +'\t'+ j);
			}
		}
		fos = new FileOutputStream(f);
		WB.write(fos);
		fos.flush();
		WB.close();
	}

	public static void main(String[] args) throws IOException {
		WriteToExcel WTE = new WriteToExcel();
		WTE.CreateFile();
		Desktop.getDesktop().open(WTE.f);
	}
}
