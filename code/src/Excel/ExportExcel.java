package Excel;

import java.io.*;
import java.util.ArrayList;

import DTO.ProductDTO;
import DTO.KhachHang;
import BUS.Product_BUS;
import DTO.OrderDTO;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {
	private ArrayList <ProductDTO> product;
	private Product_BUS cb_bus = new Product_BUS();
	
	public ExportExcel() {
		
	}
	
	public ExportExcel(String filePath) {
		product = cb_bus.listPD("SELECT * FROM `sản phẩm`");
		try {
			write(product, filePath);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//KIỂM TRA SỰ HỢP LỆ CỦA FILE
		private Workbook getWorkbook(String filePath) throws IOException{
			Workbook workbook = null;
			if(filePath.endsWith("xlsx")) {
				workbook = new XSSFWorkbook();
			}
			else if(filePath.endsWith("xls"))
				workbook = new HSSFWorkbook();
			else
				throw new IllegalArgumentException("File đang chọn không phải là file EXCEL");
			return workbook;
		}
	//KẾT THÚC KIỂM TRA
	
	//GHI DỮ LIỆU VÀO FILE EXCEL
		//DỮ LIỆU SẢN PHẨM
			public void write(ArrayList <ProductDTO> array, String filePath) throws IOException {
				Workbook workbook = getWorkbook(filePath);
				Sheet sheet = workbook.createSheet();
				createHeaderRow(sheet);
				int rowCount = 1;
				for(ProductDTO cb : product) {
					Row row = sheet.createRow(++rowCount);
					writeBook(cb, row);
				}
				try (FileOutputStream opS = new FileOutputStream(filePath)){
					workbook.write(opS);
				}
                                System.out.println("Xuất EXCEL thành công");
			}
			private void writeBook(ProductDTO cb, Row row) {
				Cell cell = row.createCell(1);
				cell.setCellValue(cb.getIdProd());
				
				cell = row.createCell(2);
				cell.setCellValue(cb.getNameProd());
				
				cell = row.createCell(3);
				cell.setCellValue(cb.getDescription());
				
				cell = row.createCell(4);
				cell.setCellValue(cb.getPrice());
				
				cell = row.createCell(5);
				cell.setCellValue(cb.getSL());
				
			}
		//KẾT THÚC GHI DỮ LIỆU SẢN PHẨM
		
		//DỮ LIỆU KHÁCH HÀNG
			public void writeCustomer(ArrayList <KhachHang> customer, String filePath) throws IOException{
				Workbook workbook = getWorkbook(filePath);
				Sheet sheet = workbook.createSheet();
				createHeaderRowCustomer(sheet);
				int rowCount = 0;
				for(KhachHang kh : customer) {
					Row row = sheet.createRow(++rowCount);
					writeBookKhachHang(kh, row);
				}
				try (FileOutputStream opS = new FileOutputStream(filePath)) {
					workbook.write(opS);
				}
			}
			private void writeBookKhachHang(KhachHang kh, Row row) {
				Cell cell = row.createCell(1);
				cell.setCellValue(kh.getMaKh());
				
				cell = row.createCell(2);
				cell.setCellValue(kh.getTenKH());
				
				cell = row.createCell(3);
				cell.setCellValue(kh.getGender());
				
				cell = row.createCell(4);
				cell.setCellValue(kh.getCMND());
				
				cell = row.createCell(5);
				cell.setCellValue(kh.getSdt());
				
				cell = row.createCell(6);
				cell.setCellValue(kh.getBirthDate());
				
				cell = row.createCell(7);
				cell.setCellValue(kh.getMaGiamGia());
			}
		//KẾT THÚC GHI DỮ LIỆU KHÁCH HÀNG
                //DỮ LIỆU THỐNG KÊ
                        public void writeStatistic(ArrayList <KhachHang> customer,ArrayList <OrderDTO> order, String filePath) throws IOException{
				Workbook workbook = getWorkbook(filePath);
				Sheet sheet = workbook.createSheet();
				createHeaderRowStatistic(sheet);
				int rowCount = 0;
				for(KhachHang kh : customer) {
                                    for(OrderDTO or: order){
                                        if(Integer.toString(or.getId()).equals(kh.getMaKh())){
					Row row = sheet.createRow(++rowCount);
					writeBookStatistic(kh,or, row);
                                        }
                                    }
				}                                
				try (FileOutputStream opS = new FileOutputStream(filePath)) {
					workbook.write(opS);
				}
			}
                        private void writeBookStatistic(KhachHang kh,OrderDTO or, Row row) {
                            
                                Cell cell = row.createCell(1);
				cell.setCellValue(or.getIdOrder());
				
				cell = row.createCell(2);
				cell.setCellValue(or.getTotalmoney());
				
				cell = row.createCell(3);
				cell.setCellValue(or.getOrderdate());
				
				cell = row.createCell(4);
				cell.setCellValue(kh.getMaKh());
				
				cell = row.createCell(5);
				cell.setCellValue(kh.getTenKH());
				
				cell = row.createCell(6);
				cell.setCellValue(kh.getGender());
				
				cell = row.createCell(7);
				cell.setCellValue(kh.getCMND());                          
                            
                                cell = row.createCell(8);
				cell.setCellValue(kh.getSdt());
                                
                                cell = row.createCell(9);
				cell.setCellValue(kh.getBirthDate());
                                
                                cell = row.createCell(10);
				cell.setCellValue(kh.getMaGiamGia());                 
			}
                //KẾT THÚC GHI DỮ LIỆU THỐNG KÊ
	//KẾT THÚC GHI DỮ LIỆU
	
	//TẠO TÊN CỘT
		private void createHeaderRow(Sheet sheet) {
			CellStyle cellstyle = sheet.getWorkbook().createCellStyle();
			Font font = sheet.getWorkbook().createFont();
			//font.setBoldweight();
			font.setFontHeightInPoints((short) 16);
			
			Row row = sheet.createRow(0);
			
			row = sheet.createRow(1);
			
			Cell cellMaCB = row.createCell(1);
			cellMaCB.setCellStyle(cellstyle);
			cellMaCB.setCellValue("Mã sản phẩm");
			
			Cell cellTenCB = row.createCell(2);
			cellTenCB.setCellStyle(cellstyle);
			cellTenCB.setCellValue("Tên sản phẩm");
			
			Cell cellMaMB = row.createCell(3);
			cellMaMB.setCellStyle(cellstyle);
			cellMaMB.setCellValue("Chi tiết sản phẩm");
	
			Cell cellDiemDi = row.createCell(4);
			cellDiemDi.setCellStyle(cellstyle);
			cellDiemDi.setCellValue("Giá");
			
			Cell cellDiemDen = row.createCell(5);
			cellDiemDen.setCellStyle(cellstyle);
			cellDiemDen.setCellValue("Số lượng");
			
		}
		
		private void createHeaderRowCustomer(Sheet sheet) {
			CellStyle cellstyle = sheet.getWorkbook().createCellStyle();
			Font font = sheet.getWorkbook().createFont();
			//font.setBoldweight();
			font.setFontHeightInPoints((short) 16);
			
			Row row = sheet.createRow(0);
			
			Cell cellMaCB = row.createCell(1);
			cellMaCB.setCellStyle(cellstyle);
			cellMaCB.setCellValue("Mã Khách Hàng");
			
			Cell cellTenCB = row.createCell(2);
			cellTenCB.setCellStyle(cellstyle);
			cellTenCB.setCellValue("Tên Khách Hàng");
			
			Cell cellMaMB = row.createCell(3);
			cellMaMB.setCellStyle(cellstyle);
			cellMaMB.setCellValue("Giới Tính");
	
			Cell cellDiemDi = row.createCell(4);
			cellDiemDi.setCellStyle(cellstyle);
			cellDiemDi.setCellValue("CMND");
			
			Cell cellDiemDen = row.createCell(5);
			cellDiemDen.setCellStyle(cellstyle);
			cellDiemDen.setCellValue("Số Điện Thoại");
			
			Cell cellThoigianDi = row.createCell(6);
			cellThoigianDi.setCellStyle(cellstyle);
			cellThoigianDi.setCellValue("Ngày Sinh");
			
			Cell cellThoigianDen = row.createCell(7);
			cellThoigianDen.setCellStyle(cellstyle);
			cellThoigianDen.setCellValue("Mã Giảm Giá");
			
		}
                private void createHeaderRowStatistic(Sheet sheet) {
			CellStyle cellstyle = sheet.getWorkbook().createCellStyle();
			Font font = sheet.getWorkbook().createFont();
			//font.setBoldweight();
			font.setFontHeightInPoints((short) 16);
			
			Row row = sheet.createRow(0);
			
			Cell cellMaDH = row.createCell(1);
			cellMaDH.setCellStyle(cellstyle);
			cellMaDH.setCellValue("Mã Đơn Hàng");
			
			Cell cellTotal = row.createCell(2);
			cellTotal.setCellStyle(cellstyle);
			cellTotal.setCellValue("Tổng Tiền");
			
			Cell cellngaylap = row.createCell(3);
			cellngaylap.setCellStyle(cellstyle);
			cellngaylap.setCellValue("Ngày Lập");
	
			Cell cellmakh = row.createCell(4);
			cellmakh.setCellStyle(cellstyle);
			cellmakh.setCellValue("Mã Khách Hàng");
			
			Cell celltenkh = row.createCell(5);
			celltenkh.setCellStyle(cellstyle);
			celltenkh.setCellValue("Tên Khách Hàng");
                        
                        Cell cellgioitinh = row.createCell(6);
			cellgioitinh.setCellStyle(cellstyle);
			cellgioitinh.setCellValue("Giới Tính");
                        
                        Cell cellcmnd = row.createCell(7);
			cellcmnd.setCellStyle(cellstyle);
			cellcmnd.setCellValue("Chứng Minh Nhân Dân");
                        
                        Cell cellsdt = row.createCell(8);
			cellsdt.setCellStyle(cellstyle);
			cellsdt.setCellValue("Số Điện Thoại");
                        
                        Cell cellngaysinh = row.createCell(9);
			cellngaysinh.setCellStyle(cellstyle);
			cellngaysinh.setCellValue("Ngày Sinh");
                        
			Cell cellmgg = row.createCell(10);
			cellmgg.setCellStyle(cellstyle);
			cellmgg.setCellValue("Mã Giảm Giá");                        
                    
		}
	//KẾT THÚC KHAI BÁO
}
