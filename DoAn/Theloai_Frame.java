package GUI;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import DTO.ProductDTO;
import BUS.Product_BUS;
import BUS.DetailProduct_BUS;
import BUS.loaiSP_BUS;
import DTO.CategoryDTO;
import DTO.chitietsanphamDTO;
import Excel.ExportExcel;
import Excel.ImportExcel;
import PDF.ExportPDF;
import java.text.NumberFormat;
import java.util.Locale;
import stolenBtn.SuaButton;
import stolenBtn.ThemButton;
import stolenBtn.XoaButton;

public class Theloai_Frame extends JPanel {
	private int WIDTH;
        private loaiSP_BUS l_bus = new loaiSP_BUS();
	private JPanel header, data, bottom;
	private Calendar cal = Calendar.getInstance();
        private ArrayList <DTO.CategoryDTO> tl;
	private ArrayList <ProductDTO> listSP, sr;
	private ExportExcel wfe = new ExportExcel();
	private Product_BUS pd_bus = new Product_BUS();
	private JComboBox<String> gia;
	private JComboBox<CategoryDTO> thuonghieu;
	private DetailProduct_BUS dtpd_bus = new DetailProduct_BUS();
        
	public Theloai_Frame() {
		
	}
	
	public Theloai_Frame(int WIDTH) {
		this.WIDTH = WIDTH;
		init();
	}      
        
	public void init() {
		MyTable tl_data;
		Font title = new Font("Calibri", Font.PLAIN, 28);
		Font lb = new Font("Tahoma", Font.PLAIN, 20);
		ThemButton btn_them;
                XoaButton btn_xoa;
                SuaButton btn_sua;
		setLayout(null);
		setBackground(null);
		setBounds(new Rectangle(0, 0, WIDTH, 960));
		
		//HEADER
			header = new JPanel();
			header.setBounds(0, 0, WIDTH, 100);
			header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
			JLabel title_header = new JLabel("QUẢN LÝ THỂ LOẠI");
			title_header.setFont(title);
			header.add(title_header);
		//END OF HEADER
		
		//DATA
			data = new JPanel();
			data.setBounds(0, 400, WIDTH, 560);
			data.setLayout(new CardLayout());			
			tl_data = new MyTable(){
                            /*        @Override
                            public boolean isCellEditable(int row, int column){
                            return false;
                            }
                            @Override
                            public java.awt.Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row, int column) {
                            java.awt.Component component = super.prepareRenderer(renderer, row, column);
                            int rendererWidth = component.getPreferredSize().width;
                            javax.swing.table.TableColumn tableColumn = getColumnModel().getColumn(column);
                            tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                            return component;
                            }*/
                            };
                        String[] headers = {"STT","Mã thể loại","Tên thể loại"};
                        tl_data.setHeaders(headers);
                        tl_data.setColumnsWidth(new double[]{0.5,2,2});
                        tl_data.setAlignment(0, JLabel.CENTER);
                        tl_data.setupSort();
                        setDataToTable(l_bus.getTL(), tl_data);
                        /*product_data.setDefaultEditor(Object.class, null);
                        product_data.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
                            JScrollPane scroll_data = new JScrollPane(tl_data);
                            data.add(scroll_data);
		//END OF DATA
		
		//BOTTOM
			bottom = new JPanel();
			bottom.setBounds(0, 100, WIDTH, 300);
			bottom.setLayout(null);
			
				
			//RESULT				
				JButton find;
				JPanel result = new JPanel();
				result.setBounds(20, 0, WIDTH - 210, 450);
				result.setLayout(null);
				JPanel  result_data,search;
                                //CHỨC NĂNG                                        
                                        JPanel function = new JPanel();
                                        function.setLayout(null);
                                        function.setBounds(20, 220, WIDTH -550, 80);                                      
                                        function.setBorder(new TitledBorder(null, "Chức Năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
                                        btn_them = new ThemButton();
                                        btn_them.setFont(lb);
                                        btn_them.setBounds(80, 25, 195, 45);
                                        btn_xoa = new XoaButton();
                                        btn_xoa.setFont(lb);
                                        btn_xoa.setBounds(380, 25, 195, 45);
                                        btn_sua = new SuaButton();
                                        btn_sua.setFont(lb);
                                        btn_sua.setBounds(670, 25, 195, 45);
                                        function.add(btn_them);
                                        function.add(btn_xoa);
                                        function.add(btn_sua);
                                        //KẾT THÚC CHỨC NĂNG
					//TÌM KIẾM
                                        search = new JPanel();
					search.setLayout(null);
					search.setBounds(0, 5, WIDTH -750, 150);
					search.setBorder(new TitledBorder(null, "Tìm Kiếm ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                                        JTextField search_box = new JTextField();
                                        search_box.setBounds(15, 25, WIDTH -780, 50);
                                        search_box.setHorizontalAlignment(JTextField.CENTER);
                                        JButton search_maPD = new JButton("TK Theo Mã Thể Loại");
                                        search_maPD.setBounds(100, 100, 240, 40);
                                        search_maPD.setFont(lb);
                                        JButton search_tenPD = new JButton("TK Theo Tên Thể Loại");
                                        search_tenPD.setBounds(400, 100, 240, 40);
                                        search_tenPD.setFont(lb);
                                        search.add(search_box);
                                        search.add(search_maPD);
                                        search.add(search_tenPD);
                                        //  KẾT THÚC TÌM KIẾM
					//KẾT THÚC KHAI BÁO
					//TÌM KIẾM NÂNG CAO
					
					//Giá cả
						JLabel gia_lb = new JLabel("Giá cả:");
						gia_lb.setBounds(20, 10, 100, 50);
						gia_lb.setFont(lb);
						gia_lb.setHorizontalAlignment(JLabel.RIGHT);
					//KẾT THÚC KHAI BÁO
					
					//Thương hiệu
						JLabel thuonghieu_lb = new JLabel("Thương hiệu:");
						thuonghieu_lb.setBounds(350, 10, 150, 50);
						thuonghieu_lb.setFont(lb);
						thuonghieu_lb.setHorizontalAlignment(JLabel.RIGHT);
					//KẾT THÚC KHAI BÁO	
					//NÚT TÌM KIẾM NÂNG CAO
						find = new JButton("Tìm");
						find.setBounds(20, 100, 120, 30);
                                                find.setFont(lb);
					//KẾT THÚC KHAI BÁO
					
					//CREATE CHOICE
						gia = getPrice(new JComboBox());						
						gia.setBounds(120, 20, 120, 30);
                                                gia.setFont(lb);
                                                
                                                thuonghieu = getTL(new JComboBox());
                                                thuonghieu.setBounds(500, 20, 120, 30);
                                                thuonghieu.setFont(lb);
					//END CREATING CHOICE
					
					//ADDING COMPONENTS
						
					//END ADDING COMPONENTS
					
					
				//KẾT THÚC TÌM KIẾM NÂNG CAO				
				
                                result.add(search);
				
				                           
				
			//END OF RESULT
		
			bottom.add(function);
			bottom.add(result);
		//END OF BOTTOM
		

			//NÚT THÊM
				btn_them.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new TheloaiInsert_Frame(tl_data).setVisible(true);
                                                
					}
				});
			//KẾT THÚC SỰ KIỆN NÚT THÊM
                        btn_xoa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thể loại "+tl_data.getTable().getValueAt(tl_data.getTable().getSelectedRow(), 1), "", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                            l_bus.delete(new CategoryDTO(tl_data.getTable().getValueAt(tl_data.getTable().getSelectedRow(), 2).toString(), tl_data.getTable().getValueAt(tl_data.getTable().getSelectedRow(), 1).toString()));
                            tl_data.clear();
                            setDataToTable(l_bus.getTL(), tl_data);
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });
                        btn_sua.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if(JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa Thể loại "+tl_data.getTable().getValueAt(tl_data.getTable().getSelectedRow(), 2).toString()+" không?","WARNING",JOptionPane.YES_NO_OPTION)==0){
                                    new TheloaiUpdate_Frame(tl_data.getTable().getValueAt(tl_data.getTable().getSelectedRow(), 1).toString(), tl_data).setVisible(true);
                                }
                            }
                        });
			
		//END OF EVENTS

		add(header);
		add(data);
		add(bottom);
	}
        
        private void setDataToTable(ArrayList<DTO.CategoryDTO> data, MyTable table) {
        table.clear();
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (DTO.CategoryDTO q : data) {
            table.addRow(new String[]{
                String.valueOf(stt),
                q.getType(),
                q.getName()});
            stt++;
            }
        }
        
	private DefaultTableModel getModel(DefaultTableModel model) {
		Vector columnName = new Vector();
		columnName.add("Mã sản phẩm");
		columnName.add("Tên điện thoại");
		columnName.add("Mô tả");
		columnName.add("Giá cả");
		columnName.add("Số lượng");
		model = new DefaultTableModel(columnName, 0);
		return model;
	}
	private DefaultTableModel getDataRow(DefaultTableModel model) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
		listSP = pd_bus.getArrayList();
		for(int i = 0; i < listSP.size(); i++) {
			model.addRow(new Object[]{
                            listSP.get(i).getIdProd(),listSP.get(i).getNameProd(),listSP.get(i).getDescription(),nf.format(listSP.get(i).getPrice()),listSP.get(i).getSL()
                        });
		}
		return model;
	}
        
	private JComboBox<CategoryDTO> getTL(JComboBox<CategoryDTO> tl) {
		tl.addItem(new CategoryDTO("", ""));
		ArrayList<CategoryDTO> th = pd_bus.getTL();
		for(int i=0;i<th.size();i++){
                    tl.addItem(th.get(i));
                }
		return tl;
	}
        
        private JComboBox<String> getPrice(JComboBox<String> price) {
                price.addItem("Chọn Giá");
                price.addItem("0-10tr ");
                price.addItem("10-20tr");
                price.addItem("20-30tr");
                price.addItem("Trên 30tr");
                return price;
        }
	
}
