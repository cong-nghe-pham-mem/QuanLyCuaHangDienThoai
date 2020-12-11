package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DTO.ProductDTO;
import BUS.Product_BUS;
import DTO.KhachHang;
import BUS.KhachHang_BUS;


public class ImportExcel {
	private ArrayList <ProductDTO> sp;
	private Product_BUS sp_bus = new Product_BUS();
	public ImportExcel() {
		
	}
	
	public ImportExcel(String filePath) throws IOException {
		sp = readSanpham(filePath);
		System.out.println("Đọc file thành công");
	}
	
	//LẤY DỮ LIỆU BẢNG ĐƯA VÀO ARRAY LIST
		private Object getCellValue(Cell cell) {
			switch(cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					return cell.getStringCellValue();
                                case Cell.CELL_TYPE_NUMERIC:
                                        return cell.getNumericCellValue();
			}
			return null;
		}
	//KẾT THÚC LẤY DỮ LIỆU
	
	//ĐỌC FILE EXCEL CHUYẾN BAY
		public ArrayList <ProductDTO> readSanpham(String filePath) throws IOException{
			sp = new ArrayList<ProductDTO>();
			FileInputStream iS = new FileInputStream(new File(filePath));
			Workbook workbook = getWorkbook(iS, filePath);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator <Row> iterator = firstSheet.iterator();
			int i=0;
			while(iterator.hasNext()){
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				ProductDTO cb = new ProductDTO();
                                Cell nextCell;
                                
				while(cellIterator.hasNext()){
                                    
                                        nextCell = cellIterator.next();
					if(i>4){
                                        int columnIndex = nextCell.getColumnIndex();
					switch(columnIndex) {
						case 1:
							cb.setIdProd( Integer.parseInt(getCellValue(nextCell).toString().replaceAll("\\.[0-9]*", "")));
							break;
						case 2: 
							cb.setNameProd((String) getCellValue(nextCell));
							break;
						case 3: 
							cb.setDescription((String) getCellValue(nextCell));
							break;
						case 4: 
							cb.setPrice(Integer.parseInt(getCellValue(nextCell).toString().replaceAll("\\.[0-9]*", "")));
							break;
						case 5: 
							cb.setSL(Integer.parseInt(getCellValue(nextCell).toString().replaceAll("\\.[0-9]*", "")));
							break;
					}
                                        
                                    }
                                        
                                        i++;
				}
				
				if(i>5) sp.add(cb);
			}
			//((FileInputStream) workbook).close();
			iS.close();
			return sp;
		}
	//KẾT THÚC ĐỌC FILE
	
	//KIỂM TRA SỰ HỢP LỆ CỦA FILE
		private Workbook getWorkbook(FileInputStream iS, String filePath) throws IOException {
			Workbook workbook = null;
			if(filePath.endsWith("xlsx")) 
				workbook = new XSSFWorkbook(iS);
			else if(filePath.endsWith("xls")) 
				workbook = new HSSFWorkbook(iS);
			else
				throw new IllegalArgumentException("File đã chọn không phải là file EXCEL");
			return workbook;
		}
	//KẾT THÚC KIỂM TRA
}
