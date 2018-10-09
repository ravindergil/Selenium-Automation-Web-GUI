package WorkingWithExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel {
	
	File f;
	FileInputStream fis;
	HSSFWorkbook WB;
	HSSFSheet Sh;
	HSSFRow rw;
	HSSFCell cl;
	String UN, PW;
	
	public void ReadFile() throws IOException {
		f = new File("C:\\Users\\IBM_ADMIN\\Desktop\\TestData.xls");
		fis = new FileInputStream(f);
		WB = new HSSFWorkbook(fis);
		Sh = WB.getSheetAt(0);
		Iterator<Row> row = Sh.rowIterator();
		while(row.hasNext()) {
			rw = (HSSFRow)row.next();
			Iterator<Cell> cell = rw.cellIterator();
			while(cell.hasNext()) {
				cl = (HSSFCell)cell.next();
				UN = rw.getCell(0).getStringCellValue();
				PW = rw.getCell(1).getStringCellValue();
			}
			System.out.println(UN + '\t' + PW);
		}
	}
	
	public static void main(String[] args) throws IOException {
		ReadExcel RE = new ReadExcel();
		RE.ReadFile();
	}
}
