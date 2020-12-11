package GUI;

import DTO.KhachHang;
import Excel.ExportExcel;
import BUS.KhachHang_BUS;


import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Calendar;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import stolenBtn.ExportExcelButton;
import stolenBtn.ExportPdfButton;

public class Customer_Frame extends JPanel {
	private ArrayList <KhachHang> customer;
	private KhachHang_BUS kh_bus = new KhachHang_BUS();
	private int WIDTH;
	private JPanel header, function, data, bottom;
	private Font title = new Font("Calibri", Font.PLAIN, 28);
	private Font lb = new Font("Tahoma", Font.PLAIN, 16);
	private JTable customer_table;
	private static DefaultTableModel model;
	private Calendar cal = Calendar.getInstance();
	Customer_Frame(int WIDTH){
		this.WIDTH = WIDTH;
		init();
	}
	public void init() {
		setLayout(null);
		setBackground(null);
		setBounds(0, 0, WIDTH, 960);
		//HEADER
			header = new JPanel();
			header.setBounds(3, 3, WIDTH, 80);
			header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
			JLabel title_header = new JLabel("Quản Lý Khách Hàng");
			title_header.setFont(title);
			header.add(title_header);
		//END OF HEADER
		
		//FUNCTION 
			function = new JPanel();
			function.setBounds(0, 80, WIDTH, 225);
                        function.setLayout(null);
			//LEFT PANEL
				JPanel left = new JPanel();
				left.setLayout(null);
				left.setBorder(new TitledBorder(null, "Thao tác trên Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				left.setBounds(5, 5, WIDTH - 1250, 175);
				JButton btn_them, btn_xoa, btn_sua;
                                btn_them = new JButton("Thêm Khách Hàng");
				btn_xoa = new JButton("Xóa Khách Hàng");
				btn_sua = new JButton("Sửa Thông Tin");
                                btn_them.setBounds(15, 30, 170, 35);
				btn_xoa.setBounds(15, 75, 170, 35);
				btn_sua.setBounds(15, 120, 170, 35);
				left.add(btn_them);
				left.add(btn_xoa);
				left.add(btn_sua);
                                
                                
			//END OF LEFT PANEL
				
			//SEARCH PANEL
				JPanel search = new JPanel();
				search.setLayout(null);
				search.setBounds(400, 10, WIDTH - 1285, 170);
				search.setBorder(new TitledBorder(null, "Tìm Kiếm Cơ Bản", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				JTextField search_box = new JTextField();
				search_box.setBounds(20, 28, 175, 30);
				search_box.setHorizontalAlignment(JTextField.CENTER);
				JButton search_maKH, search_tenKH;
				search_maKH = new JButton("Tìm Theo Mã KH");
				search_maKH.setBounds(10, 70, 190, 40);
				search_tenKH = new JButton("Tìm Theo Tên KH");
				search_tenKH.setBounds(10, 120, 190, 40);
				search.add(search_box);
				search.add(search_maKH);
				search.add(search_tenKH);
			//END OF SEARCH PANEL
				
			//ADVANCED SEARCH PANEL
				JPanel advanced_search = new JPanel();
				advanced_search.setLayout(null);
				advanced_search.setBounds(800, 10, WIDTH - 1280, 200);
				advanced_search.setBorder(new TitledBorder(null, "Tìm Kiếm Nâng Cao", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
				//TÌM KIẾM THEO CHỨNG MINH NHÂN DÂN
					JTextField search_CMND = new JTextField();
					search_CMND.setText("Tìm Kiếm Theo CMND...");
					search_CMND.setForeground(SystemColor.controlShadow);
					search_CMND.setBounds(13, 65, 185, 35);
				//KẾT THÚC KHAI BÁO
				
				//TÌM KIẾM THEO GIỚI TÍNH
					JLabel lb_gender = new JLabel("Tìm kiếm theo giới tính");
					lb_gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lb_gender.setBounds(13, 105, 160, 35);
					ButtonGroup gender = new ButtonGroup();
					JRadioButton male = new JRadioButton("Nam");
					male.setBounds(45, 140, 80, 20);
					JRadioButton female = new JRadioButton("Nữ");
					female.setBounds(130, 140, 65, 20);
					gender.add(male);
					gender.add(female);
				//KẾT THÚC KHAI BÁO
					
				//TÌM KIẾM THEO TUỔI
					JComboBox<String> search_age = new JComboBox<String>();
					search_age.setBounds(13, 30, 185, 29);
					search_age.addItem("Age");
					for(int i = 1; i <= 90; i++) {
						String a = "" + i;
						search_age.addItem(a);
						a = "";
					}
					//search_age.select("Tìm Kiếm Theo Tuổi");
				//KẾT THÚC KHAI BÁO
					
				//CÁC BUTTON TRONG TÌM KIẾM NÂNG CAO
					JButton filter = new JButton("Lọc");
					JButton reset  = new JButton("Nhập Lại");
					reset.setBounds(109, 165, 100, 25);
					reset.setFont(lb);
					filter.setBounds(3, 165, 100, 25);
					filter.setFont(lb);
				//KẾT THÚC KHAI BÁO
				advanced_search.add(search_age);
				advanced_search.add(search_CMND);
				advanced_search.add(lb_gender);
				advanced_search.add(male);
				advanced_search.add(female);
				advanced_search.add(reset);
				advanced_search.add(filter);
			//END OF ADVANCED SEARCH PANEL
                        //CHỨC NĂNG ĐỌC GHI
				JPanel file = new JPanel();
				file.setLayout(null);
				file.setBounds(1200, 10, WIDTH - 590, 453);
				//JButton readExcel = new JButton("Đọc File Excel");
				ExportExcelButton writeExcel = new ExportExcelButton();
				ExportPdfButton writePDF = new ExportPdfButton();
				//readExcel.setBounds(0, 10, 170, 30);
				writeExcel.setBounds(0, 10, 170, 30);//50->10
				writePDF.setBounds(0, 50, 170, 30);//90->10
				//file.add(readExcel);
				file.add(writeExcel);
				file.add(writePDF);
			//KẾT THÚC KHAI BÁO
			function.add(left);
			function.add(search);
			function.add(advanced_search);
                        function.add(file);
		//END OF FUNCTION PANEL
		
		//DATA PANEL
			data = new JPanel();
			data.setLayout(null);
			data.setBounds(0, 300, WIDTH, 680);
			//TABLE KHÁCH HÀNG
				JPanel customer_data = new JPanel();
				customer_data.setLayout(new CardLayout());
				customer_data.setBounds(5, 15, WIDTH -10, 640);
				customer_data.setBorder(new TitledBorder(null, "Dữ Liệu Của Khách Hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				model = getModel(model);
				model = getRowData(model);
				customer_table = new JTable(model);
                                customer_table = new JTable(model);
                                customer_table.setAutoCreateRowSorter(true);
                                customer_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				customer_table.setDefaultEditor(Object.class, null);
                                customer_table.setFillsViewportHeight(true);
        customer_table.setFont(new Font("Segoe UI", 0, 16));
        customer_table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        customer_table.setRowHeight(40);

        // color
        int bgColor = 235;
        int color = 0;
        customer_table.getTableHeader().setBackground(new Color(bgColor, bgColor, bgColor));
        customer_table.getTableHeader().setForeground(new Color(color, color, color));
        customer_table.setBackground(new Color(bgColor, bgColor, bgColor));
        customer_table.setForeground(new Color(color, color, color));
                                double total = 0;
                               DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        customer_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                                double[] percentages = new double[]{1,2.5,1.5,2,1,1.5,0.5};
        for (int i = 0; i < customer_table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < customer_table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = customer_table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (getPreferredSize().width * (percentages[i] / total)));
        }
				customer_table.setDefaultEditor(Object.class, null);
				JScrollPane scroll = new JScrollPane(customer_table);
				customer_data.add(scroll);
			//KẾT THÚC KHAI BÁO
				
			
			data.add(customer_data);
			//data.add(file);
		//END OF DATA PANEL
			
		//EVENTS
			//BUTTON
				btn_xoa.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = -1;
							row = customer_table.getSelectedRow();
						if(row != -1) {
							int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này ?", "Cảnh Báo", JOptionPane.YES_NO_OPTION);
							if(confirm == JOptionPane.YES_OPTION) {
								String id = customer_table.getValueAt(row, 0).toString();
								int modelRow = customer_table.convertRowIndexToModel(row);
								model.removeRow(modelRow);
								kh_bus.Delete(id);
								JOptionPane.showMessageDialog(null, "Đã xóa thành công khách hàng: " + id, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				});
                                btn_them.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CustomerInsert_Frame();
					}
				});
				btn_sua.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = -1;
							row = customer_table.getSelectedRow();
						if(row != -1) {
							String id = customer_table.getValueAt(row, 0).toString();
							String name = customer_table.getValueAt(row, 1).toString();
							int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu của khách hàng " + id + " mang tên " + name + " không ?", "Thông Báo", JOptionPane.YES_OPTION);
							if(confirm == JOptionPane.YES_OPTION) {
								CustomerUpdate_Frame update = new CustomerUpdate_Frame(id);
							}
						}
					}
				});
			//END OF BUTTONS EVENTS
				
			//NORMAL SEARCH
				search_maKH.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						customer = kh_bus.search_coban("maKH", search_box.getText());
						for(int i = 0; i < customer.size(); i++) {
							String maKH		= customer.get(i).getMaKh();
							String tenKH	= customer.get(i).getTenKH();
							String gender	= customer.get(i).getGender();
							String CMND		= customer.get(i).getCMND();
							String sdt		= customer.get(i).getSdt();
							String birthDate = customer.get(i).getBirthDate();
							String maGiamGia = customer.get(i).getMaGiamGia();
							Object []data = {
									maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
							};
							model.addRow(data);
						}
					}
				});
				search_tenKH.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						customer = kh_bus.search_coban("tenKH", search_box.getText());
						for(int i = 0; i < customer.size(); i++) {
							String maKH		= customer.get(i).getMaKh();
							String tenKH	= customer.get(i).getTenKH();
							String gender	= customer.get(i).getGender();
							String CMND		= customer.get(i).getCMND();
							String sdt		= customer.get(i).getSdt();
							String birthDate = customer.get(i).getBirthDate();
							String maGiamGia = customer.get(i).getMaGiamGia();
							Object []data = {
									maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
							};
							model.addRow(data);
						}
					}
				});
			//END OF NORMAL SEARCH
			
			//ADVANCED SEARCH
				search_CMND.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if(search_CMND.getText().equals("Tìm Kiếm Theo CMND...")) {
							search_CMND.setText("");
							search_CMND.setForeground(Color.BLACK);
						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						if(search_CMND.getText().equals("")) {
							search_CMND.setText("Tìm Kiếm Theo CMND...");
							search_CMND.setForeground(SystemColor.controlShadow);
						}
					}
				});
				filter.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						
						String decoy = search_age.getSelectedItem().toString();
						System.out.println(decoy);
						String gend = "";
						int age = 0;
						
						if(decoy.equals("Age"))
							decoy = "";
						else if(!decoy.equals("")) 
							age = cal.get(Calendar.YEAR) - Integer.parseInt(decoy);
						if(male.isSelected()) {
							gend = "Nam";
						}
						if(female.isSelected()) {
							gend = "Nữ";
						}
						System.out.println(gend);
						
						//String sql = "SELECT * FROM khachhang WHERE status = 0" + dk;
						//System.out.println(sql);
						customer = kh_bus.search_nangcao(age, gend, search_CMND.getText());
						for(int i = 0; i < customer.size(); i++) {
							String maKH		= customer.get(i).getMaKh();
							String tenKH	= customer.get(i).getTenKH();
							String gender	= customer.get(i).getGender();
							String CMND		= customer.get(i).getCMND();
							String sdt		= customer.get(i).getSdt();
							String birthDate = customer.get(i).getBirthDate();
							String maGiamGia = customer.get(i).getMaGiamGia();
							Object []data = {
									maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
							};
							model.addRow(data);
						}
					}
				});
				
				reset.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//search_age.select("Age");
						search_CMND.setText("Tìm Kiếm Theo CMND...");
						search_CMND.setForeground(SystemColor.controlShadow);
						gender.clearSelection();
						model = getModel(model);
						customer_table.setModel(getRowData(model));
					}
				});
				
			//END OF ADVANCED SEARCH
				
			//ĐỌC FILE, GHI FILE EXCEL
				writeExcel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						ExportExcel wfe = new ExportExcel();
						try {
							wfe.writeCustomer(customer, "Excel/customer.xlsx");
                                                        JOptionPane.showMessageDialog(null, "Đã in ra file Excel thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e) {
							// TODO Auto-generated catch block
                                                        JOptionPane.showMessageDialog(null, "Xuất file Excel thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
			//KẾT THÚC ĐỌC FILE, GHI FILE EXCEL
				
			//ĐỌC FILE, GHI FILE PDF
				writePDF.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Chức năng đang bảo trì", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
			//KẾT THÚC ĐỌC FILE, GHI FILE PDF
		//END OF EVENTS
		add(header);
		add(function);
		add(data);
	}
	private DefaultTableModel getModel(DefaultTableModel model) {
		Vector columnName = new Vector();
		columnName.add("Mã Khách Hàng");
		columnName.add("Tên Khách Hàng");
		columnName.add("Giới Tính");
		columnName.add("CMND");
		columnName.add("Số Điện Thoại");
		columnName.add("Ngày Sinh");
		columnName.add("Mã Giảm Giá");
		model = new DefaultTableModel(columnName, 0);
		return model;
	}
	private DefaultTableModel getRowData(DefaultTableModel model) {
		customer = kh_bus.getArrayList_normal();
		for(int i = 0; i < customer.size(); i++) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
		}
		return model;
	}
        public static DefaultTableModel getTModel(){
            return model;
        }
}
