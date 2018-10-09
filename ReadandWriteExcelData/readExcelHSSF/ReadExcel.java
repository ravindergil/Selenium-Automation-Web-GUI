package readExcelHSSF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	
	
	@SuppressWarnings({ "rawtypes", "deprecation", "static-access" })
	public static void ReadXLSFile() throws IOException {
		File f = new File("C:\\Users\\IBM_ADMIN\\Desktop\\TestData.xls");
		FileInputStream fis = new FileInputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheetAt(0);
		HSSFRow rw;
		HSSFCell cl;
		
		Iterator row = sh.rowIterator();
		while(row.hasNext()){
			rw = (HSSFRow)row.next();
			
			Iterator cell = rw.cellIterator();
			while(cell.hasNext()){
				cl = (HSSFCell)cell.next();
				
				if(cl.getCellType() == HSSFCell.CELL_TYPE_STRING){
					System.out.print(cl.getStringCellValue() + '\t');
				} else if (cl.CELL_TYPE_NUMERIC == HSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cl.getNumericCellValue());
				} else {
					System.out.println("Value not matched");
				}
			}
			System.out.println();
		}
		wb.close();
	}

	public static void main(String[] args) throws IOException {
			ReadXLSFile();
	}
}
