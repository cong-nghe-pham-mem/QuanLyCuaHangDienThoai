package PDF;

import java.awt.Font;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DTO.ProductDTO;

public class writePDF {
	public writePDF() {
		
	}
	
	public void writePDFProduct(ArrayList <ProductDTO> sp, String filePath) throws DocumentException, IOException{

		Document document = new Document(PageSize.A3);
		Paragraph title = new Paragraph("Danh sách sản phẩm còn lại trong kho", new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 30));
		title.add(new Paragraph("\n"));
		title.setAlignment(Paragraph.ALIGN_CENTER);
		PdfPTable table = new PdfPTable(new float[] {
			4, 10, 4, 4, 4
		});
		
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("Mã sản phẩm");
		table.addCell("Tên sản phẩm");
		table.addCell("Chi tiết sản phẩm");
		table.addCell("Giá ");
		table.addCell("Số lượng");
		table.setHeaderRows(1);
		PdfPCell [] cells = table.getRow(0).getCells();
		
		for(int i = 0; i < cells.length; i++) {
			cells[i].setBackgroundColor(BaseColor.GRAY);
		}
		for(int i = 0; i < sp.size(); i++) {
			table.addCell(Integer.toString(sp.get(i).getIdProd()));
                        table.addCell(sp.get(i).getNameProd());
                        table.addCell(sp.get(i).getDescription());
                        table.addCell(Integer.toString(sp.get(i).getPrice()));
                        table.addCell(Integer.toString(sp.get(i).getSL()));
		}
		
		PdfWriter.getInstance(document, new FileOutputStream("PDF/danhsachsanphamtrongkho.pdf"));
		document.open();
		document.add(title);
		document.add(table);
		document.close();
		System.out.println("Xuất PDF thành công");
		
	}
	
	private String Encoding(String a) {
		byte[] utf8;
		String value = null;
		try {
			utf8 = a.getBytes("UTF-8");
			value = new String(utf8, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	private Paragraph addEmptyLine(Paragraph p , int number) {
		for(int i = 0; i < number;i ++) {
			p.add(new Paragraph(""));
		}
		return p;
	}
}
