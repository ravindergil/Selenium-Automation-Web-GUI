package readExcelHSSF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelSimple {

	File f;
	FileInputStream fis;
	HSSFWorkbook wb;
	HSSFSheet sh;
	HSSFRow rw;
	HSSFCell cl;
	
	@SuppressWarnings("rawtypes")
	public void ReadExcel() throws IOException{
		f = new File("C:\\Users\\IBM_ADMIN\\Desktop\\TestData.xls");
		fis = new FileInputStream(f);
		wb = new HSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		
		Iterator rows = sh.rowIterator();
		while(rows.hasNext()) {
			rw = (HSSFRow)rows.next();
			
			Iterator cell = rw.cellIterator();
			while(cell.hasNext()) {
				cl = (HSSFCell)cell.next();
				
				if(cl.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					System.out.print(cl.getStringCellValue() + " ");
				} else if (cl.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cl.getNumericCellValue() + " ");
				} else {
					System.out.println("Data is not Required");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		ReadExcelSimple RES = new ReadExcelSimple();
		RES.ReadExcel();
	}
}
