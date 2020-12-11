package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Calendar;

import DTO.NhanVien;
import BUS.NhanVien_BUS;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Employee_Frame extends JPanel {
	private ArrayList <NhanVien> employee;
	private NhanVien_BUS nv_bus = new NhanVien_BUS();
	private int WIDTH;
	private JPanel header, function, data;
	private Font title = new Font("Calibri", Font.PLAIN, 30);
	private Font lb = new Font("Tahoma", Font.PLAIN, 14);
	private Calendar cal = Calendar.getInstance();
	
	private static DefaultTableModel model;
	private JTable employee_table;
	private JComboBox<String> ngaysinh_day, ngaysinh_month, ngaysinh_year;
	private JComboBox<String> ngayvl_day, ngayvl_month, ngayvl_year;
	
	public Employee_Frame() {
		
	}
	
	public Employee_Frame(int WIDTH) {
		this.WIDTH = WIDTH;
		init();
	}
	public void init() {
		setLayout(null);
		setBackground(null);
		setBounds(new Rectangle(0, 0, WIDTH, 960));
		//HEADER PANEL
			header = new JPanel();
			header.setBounds(0, 0, WIDTH, 80);
			header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 28));
			JLabel header_title = new JLabel("Quản Lý Nhân Viên");
			header_title.setFont(title);
			header.add(header_title);
		//KẾT THÚC KHAI BÁO
		
		//FUNCTION PANEL
			function = new JPanel();
			function.setBounds(0, 80, WIDTH, 220);
			function.setLayout(null);
			
			//CHỨC NĂNG THAO TÁC TRÊN TABLE
				JPanel left = new JPanel();
				left.setLayout(null);
				left.setBounds(5, 5, WIDTH -1250, 175);
				left.setBorder(new TitledBorder(null, "Các Chức năng Thao Tác", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				JButton btn_them, btn_xoa, btn_sua;
				btn_them = new JButton("Thêm Nhân Viên");
				btn_xoa = new JButton("Xóa Nhân Viên");
				btn_sua = new JButton("Cập Nhật NV");
				btn_them.setBounds(15, 30, 170, 35);
				btn_xoa.setBounds(15, 75, 170, 35);
				btn_sua.setBounds(15, 120, 170, 35);
				left.add(btn_them);
				left.add(btn_xoa);
				left.add(btn_sua);
			//KẾT THÚC KHAI BÁO
			
			//CHỨC NĂNG TÌM KIẾM
				//TÌM KIẾM CƠ BẢN
					JPanel search_coban = new JPanel();
					search_coban.setLayout(null);
					search_coban.setBounds(300, 5, WIDTH -1250, 175);
					search_coban.setBorder(new TitledBorder(null, "Tìm Kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					
					JTextField search_box = new JTextField();
					search_box.setHorizontalAlignment(JTextField.CENTER);
					search_box.setBounds(15, 26, 190, 27);
					search_coban.add(search_box);
					
					JButton search_maNV = new JButton("TK Theo Mã NV");
					search_maNV.setFont(lb);
					search_maNV.setBounds(13, 65, 195, 28);
					search_coban.add(search_maNV);
					
					JButton search_tenNV = new JButton("TK Theo Tên NV");
					search_tenNV.setFont(lb);
					search_tenNV.setBounds(13, 100, 195, 28);
					search_coban.add(search_tenNV);
					
					JButton search_sdt = new JButton("TK Theo SĐT");
					search_sdt.setFont(lb);
					search_sdt.setBounds(13, 135, 195, 28);
					search_coban.add(search_sdt);
				//KẾT THÚC KHAI BÁO
				
				//TÌM KIẾM NÂNG CAO
					JPanel search_nangcao = new JPanel();
					search_nangcao.setLayout(null);
					search_nangcao.setBounds(600, 0, WIDTH -1250, 175);
					search_nangcao.setBorder(new TitledBorder(null, "Tìm Kiếm Nâng Cao", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					
					//TÌM KIẾM THEO NGÀY SINH
						JLabel ngaysinh_lb = new JLabel("Ngày Sinh:");
						ngaysinh_lb.setFont(lb);
						ngaysinh_lb.setBounds(15, 25, 70, 20);
						
						ngaysinh_day = new JComboBox();
						ngaysinh_month = new JComboBox();
						ngaysinh_year = new JComboBox();
						
						ngaysinh_day = getDay(ngaysinh_day);
						ngaysinh_day.setBounds(85, 25, 40, 25);
						
						ngaysinh_month = getMonth(ngaysinh_month);
						ngaysinh_month.setBounds(130, 25, 40, 25);
						
						ngaysinh_year= getYear(ngaysinh_year);
						ngaysinh_year.setBounds(175, 25, 55, 25);
					//KẾT THÚC KHAI BÁO
					
					//TÌM KIẾM THEO GIỚI TÍNH
						ButtonGroup gender = new ButtonGroup();
						JRadioButton male = new JRadioButton("Nam");
						male.setBounds(115, 54, 60, 20);
						JRadioButton female = new JRadioButton("Nữ");
						female.setBounds(180, 54, 50, 20);
						JLabel gender_lb = new JLabel("Theo giới tính:");
						gender_lb.setFont(lb);
						gender_lb.setBounds(15, 53, 100, 20);
						gender.add(male);
						gender.add(female);
					//KẾT THÚC KHAI BÁO
					
					//TÌM KIẾM THEO NGÀY VÀO LÀM
						JLabel ngayvl_lb = new JLabel("Ngày Vào Làm:");
						ngayvl_lb.setBounds(15, 75, 100, 25);
						ngayvl_lb.setFont(lb);
						
						ngayvl_day = new JComboBox();
						ngayvl_month = new JComboBox();
						ngayvl_year = new JComboBox();
						
						ngayvl_day = getDay(ngayvl_day);
						ngayvl_month = getMonth(ngayvl_month);
						ngayvl_year = getYear(ngayvl_year);
						
						ngayvl_day.setBounds(60, 100, 40, 25);
						ngayvl_month.setBounds(115, 100, 40, 25);
						ngayvl_year.setBounds(165, 100, 55, 25);
					//KẾT THÚC KHAI BÁO
				//KẾT THÚC KHAI BÁO
						
				JButton filter = new JButton("Lọc");
				filter.setBounds(155, 135, 75, 25);
				search_nangcao.add(ngaysinh_lb);
				search_nangcao.add(ngaysinh_day);
				search_nangcao.add(ngaysinh_month);
				search_nangcao.add(ngaysinh_year);
				
				search_nangcao.add(gender_lb);
				search_nangcao.add(male);
				search_nangcao.add(female);
				
				search_nangcao.add(ngayvl_lb);
				search_nangcao.add(ngayvl_day);
				search_nangcao.add(ngayvl_month);
				search_nangcao.add(ngayvl_year);
				search_nangcao.add(filter);
			//KẾT THÚC KHAI BÁO
			function.add(left);
			function.add(search_coban);
			function.add(search_nangcao);
		//KẾT THÚC KHAI BÁO
		
		//DATA PANEL
			data = new JPanel();
			data.setLayout(new CardLayout());
			data.setBorder(new TitledBorder(null, "Dữ liệu của nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			data.setBounds(0, 300, WIDTH, 660);
			model = getModel(model);
			model = getRowData(model);
                        employee_table = new JTable(model);
                                employee_table.setAutoCreateRowSorter(true);
                                employee_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				employee_table.setDefaultEditor(Object.class, null);
                                employee_table.setFillsViewportHeight(true);
        employee_table.setFont(new Font("Segoe UI", 0, 16));
        employee_table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        employee_table.setRowHeight(40);

        // color
        int bgColor = 235;
        int color = 0;
        employee_table.getTableHeader().setBackground(new Color(bgColor, bgColor, bgColor));
       employee_table.getTableHeader().setForeground(new Color(color, color, color));
        employee_table.setBackground(new Color(bgColor, bgColor, bgColor));
        employee_table.setForeground(new Color(color, color, color));
                                double total = 0;
                               DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        employee_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                                double[] percentages = new double[]{1,1.5,1,1,1,1.5,1.5,1};
        for (int i = 0; i < employee_table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < employee_table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = employee_table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (getPreferredSize().width * (percentages[i] / total)));
        }
			employee_table.setDefaultEditor(Object.class, null);
			JScrollPane scroll = new JScrollPane(employee_table);
			data.add(scroll);
		//KẾT THÚC KHAI BÁO
				
		//EVENTS
			//CÁC THAO TÁC TRÊN TABLE
				btn_xoa.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = -1;
							row = employee_table.getSelectedRow();
						if(row != -1) {
							int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn xóa nhân viên " + employee_table.getValueAt(row, 0) + " với tên nhân viên là: " + employee_table.getValueAt(row, 1) + " ?", "Xóa Dữ Liệu", JOptionPane.YES_NO_OPTION);
							if(confirm == JOptionPane.YES_OPTION) {
								String id = employee_table.getValueAt(row, 0).toString();
								int modelRow = employee_table.convertRowIndexToModel(row);
								model.removeRow(modelRow);
								nv_bus.Delete(id);
								JOptionPane.showMessageDialog(null, "Đã xóa thành công nhân viên " + id, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				});
				btn_them.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new EmployeeInsert_Frame();
					}
				});
				btn_sua.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = -1;
						row = employee_table.getSelectedRow();
					if(row != -1) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn cập nhật thông tin của nhân viên " + employee_table.getValueAt(row, 0) + " với tên nhân viên là: " + employee_table.getValueAt(row, 1) + " ?", "Xóa Dữ Liệu", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							String id = employee_table.getValueAt(row, 0).toString();
							new EmployeeUpdate_Frame(id);
							
							//JOptionPane.showMessageDialog(null, "Đã xóa thành công nhân viên " + id, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					}
				});
			//KẾT THÚC SỰ KIỆN THAO TÁC
			
			//SỰ KIỆN TÌM KIẾM CƠ BẢN
				search_maNV.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						String sql = "SELECT * FROM nhanvien WHERE maNV LIKE '%" + search_box.getText() + "%'";
						employee = nv_bus.listNV(sql);
						for(int i = 0; i < employee.size(); i++) {
							String maNV		   = employee.get(i).getMaNV();
							String tenNV	   = employee.get(i).getTenNV();
							String gender	   = employee.get(i).getGender();
							String birthDate   = employee.get(i).getBirthDate();
							String sdt		   = employee.get(i).getSdt();
							String CMND		   = employee.get(i).getCMND();
							String chucvu	   = employee.get(i).getChucvu();
							String ngayvaolam  = employee.get(i).getNgayvaolam();
							Object []data = {
								maNV, tenNV, birthDate, gender, sdt, CMND, chucvu, ngayvaolam	
							};
							model.addRow(data);
						}
					}
				});
				search_tenNV.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						String sql = "SELECT * FROM nhanvien WHERE tenNV LIKE '%" + search_box.getText() + "%'";
						employee = nv_bus.listNV(sql);
						for(int i = 0; i < employee.size(); i++) {
							String maNV		   = employee.get(i).getMaNV();
							String tenNV	   = employee.get(i).getTenNV();
							String gender	   = employee.get(i).getGender();
							String birthDate   = employee.get(i).getBirthDate();
							String sdt		   = employee.get(i).getSdt();
							String CMND		   = employee.get(i).getCMND();
							String chucvu	   = employee.get(i).getChucvu();
							String ngayvaolam  = employee.get(i).getNgayvaolam();
							Object []data = {
								maNV, tenNV, birthDate, gender, sdt, CMND, chucvu, ngayvaolam	
							};
							model.addRow(data);
						}
					}
				});
				search_sdt.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						
						employee = nv_bus.getArrayList_condition("sdt", search_box.getText());
						for(int i = 0; i < employee.size(); i++) {
							String maNV		   = employee.get(i).getMaNV();
							String tenNV	   = employee.get(i).getTenNV();
							String gender	   = employee.get(i).getGender();
							String birthDate   = employee.get(i).getBirthDate();
							String sdt		   = employee.get(i).getSdt();
							String CMND		   = employee.get(i).getCMND();
							String chucvu	   = employee.get(i).getChucvu();
							String ngayvaolam  = employee.get(i).getNgayvaolam();
							Object []data = {
								maNV, tenNV, birthDate, gender, sdt, CMND, chucvu, ngayvaolam	
							};
							model.addRow(data);
						}
					}
				});
			//KẾT THÚC TÌM KIẾM CƠ BẢN
			
			//TÌM KIẾM NÂNG CAO
				filter.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						String birthDate = ngaysinh_day.getSelectedItem().toString() + "/" + ngaysinh_month.getSelectedItem().toString() + "/" + ngaysinh_year.getSelectedItem().toString();
						String workDate = ngayvl_day.getSelectedItem().toString() + "/" + ngayvl_month.getSelectedItem().toString() + "/" + ngayvl_year.getSelectedItem().toString();
						String gend = "";
						String dk = "";
						if(male.isSelected())
							gend = "Nam";
						if(female.isSelected())
							gend = "Nữ";
						
						employee = nv_bus.search_nangcao(birthDate, gend, workDate);
						for(int i = 0; i < employee.size(); i++) {
							String maNV		   = employee.get(i).getMaNV();
							String tenNV	   = employee.get(i).getTenNV();
							String gender	   = employee.get(i).getGender();
							String birthDate_1   = employee.get(i).getBirthDate();
							String sdt		   = employee.get(i).getSdt();
							String CMND		   = employee.get(i).getCMND();
							String chucvu	   = employee.get(i).getChucvu();
							String ngayvaolam  = employee.get(i).getNgayvaolam();
							Object []data = {
								maNV, tenNV, birthDate_1, gender, sdt, CMND, chucvu, ngayvaolam	
							};
							model.addRow(data);
						}
						System.out.println(dk);
					}
				});
			//KẾT THÚC SỰ KIỆN TÌM KIẾM NÂNG CAO
		//END OF EVENTS
			
		add(header);
		add(function);
		add(data);
		
	}
	
	private DefaultTableModel getModel(DefaultTableModel model) {
		Vector columnName = new Vector();
		columnName.add("Mã Nhân Viên");
		columnName.add("Tên Nhân Viên");
		columnName.add("Ngày Sinh");
		columnName.add("Giới Tính");
		columnName.add("Số Điện Thoại");
		columnName.add("CMND");
		columnName.add("Chức Vụ");
		columnName.add("Ngày Vào Làm");
		model = new DefaultTableModel(columnName, 0);
		
		return model;
	}
	
	private DefaultTableModel getRowData(DefaultTableModel model) {
		employee = nv_bus.listNV("SELECT * FROM nhanvien");
		for(int i = 0; i < employee.size(); i++) {
			String maNV		   = employee.get(i).getMaNV();
			String tenNV	   = employee.get(i).getTenNV();
			String gender	   = employee.get(i).getGender();
			String birthDate   = employee.get(i).getBirthDate();
			String sdt		   = employee.get(i).getSdt();
			String CMND		   = employee.get(i).getCMND();
			String chucvu	   = employee.get(i).getChucvu();
			String ngayvaolam  = employee.get(i).getNgayvaolam();
			Object []data = {
				maNV, tenNV, birthDate, gender, sdt, CMND, chucvu, ngayvaolam	
			};
			model.addRow(data);
		}
		return model;
	}
	public static DefaultTableModel getTModel(){
            return model;
        }
	//TẠO CÁC CHOICE NGÀY THÁNG NĂM
		private JComboBox<String> getDay(JComboBox<String> day) {
			day.addItem("");
			String a = "";
			for(int i = 1; i <= 31; i++) {
				if(i < 10) 
					a = "0" + i;
				else
					a += i;
				day.addItem(a);
				a = "";
			}			
			return day;
		}
		private JComboBox<String> getMonth(JComboBox<String> month) {
			month.addItem("");
			String a = "";
			for(int i = 1; i <= 12; i++) {
				if(i < 10) 
					a = "0" + i;
				else
					a += i;
				month.addItem(a);
				a = "";
			}			
			return month;
		}
		private JComboBox<String> getYear(JComboBox<String> year) {
			year.addItem("");
			String a = "";
			for(int i = 1990; i <= cal.get(Calendar.YEAR); i++) {
				a += i;
				year.addItem(a);
				a = "";
			}
			return year;
		}
	//KẾT THÚC KHAI BÁO
}
