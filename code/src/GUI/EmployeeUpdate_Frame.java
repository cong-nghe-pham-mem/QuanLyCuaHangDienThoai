package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DTO.NhanVien;
import DTO.Role;
import BUS.NhanVien_BUS;
import BUS.Role_BUS;

public class EmployeeUpdate_Frame extends JFrame {
	private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	
	private ArrayList <NhanVien> employee;
	private NhanVien_BUS nv_bus = new NhanVien_BUS();
	private Role_BUS r_bus = new Role_BUS();
	private ArrayList <Role> r = r_bus.getList();
	private Calendar cal = Calendar.getInstance();
	private JPanel contentPane;
	private JTextField maNV;
	private JTextField tenNV;
	private JTextField sdt;
	private JTextField CMND;
	private JTextField chucvu;
	private Choice ngaysinh_day;
	private Choice ngaysinh_month;
	private Choice ngaysinh_year;
	private Choice nvl_day;
	private Choice nvl_month;
	private String id;
	private Choice nvl_year;
	private JComboBox<Role> roleID;
	
	
	public EmployeeUpdate_Frame(String id) {
		this.id = id;
		employee = nv_bus.listNV("SELECT * FROM nhanvien WHERE maNV = '" + id + "'");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã NV:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(129, 10, 106, 25);
		contentPane.add(lblNewLabel);
		
		maNV = new JTextField();
		maNV.setEditable(false);
		maNV.setBounds(266, 13, 86, 20);
		contentPane.add(maNV);
		maNV.setColumns(10);
		
		JLabel lblTnNv = new JLabel("Tên NV:");
		lblTnNv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNv.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTnNv.setBounds(129, 55, 106, 25);
		contentPane.add(lblTnNv);
		
		tenNV = new JTextField();
		tenNV.setColumns(10);
		tenNV.setBounds(266, 55, 145, 20);
		contentPane.add(tenNV);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiiTnh.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblGiiTnh.setBounds(129, 100, 106, 25);
		contentPane.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNgySinh.setBounds(129, 145, 106, 25);
		contentPane.add(lblNgySinh);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSinThoi.setBounds(129, 190, 106, 25);
		contentPane.add(lblSinThoi);
		
		sdt = new JTextField();
		sdt.setColumns(10);
		sdt.setBounds(266, 190, 86, 20);
		contentPane.add(sdt);
		
		JLabel lblCmnd = new JLabel("CMND:");
		lblCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCmnd.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCmnd.setBounds(129, 235, 106, 25);
		contentPane.add(lblCmnd);
		
		CMND = new JTextField();
		CMND.setColumns(10);
		CMND.setBounds(266, 235, 86, 20);
		contentPane.add(CMND);
		
		JLabel lblChcV = new JLabel("Chức Vụ:");
		lblChcV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChcV.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblChcV.setBounds(129, 280, 106, 25);
		contentPane.add(lblChcV);
		
		chucvu = new JTextField();
		chucvu.setColumns(10);
		chucvu.setBounds(266, 280, 145, 20);
		contentPane.add(chucvu);
		
		JLabel lblNgyVoLm = new JLabel("Ngày Vào Làm:");
		lblNgyVoLm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyVoLm.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNgyVoLm.setBounds(129, 325, 106, 25);
		contentPane.add(lblNgyVoLm);
		
		ButtonGroup gender = new ButtonGroup();
		JRadioButton male = new JRadioButton("Nam");
		male.setBounds(266, 100, 55, 23);
		contentPane.add(male);
		gender.add(male);
		
		JRadioButton female = new JRadioButton("Nữ");
		female.setBounds(327, 100, 50, 23);
		contentPane.add(female);
		gender.add(female);
		
		ngaysinh_day = new Choice();
		ngaysinh_day = getDay(ngaysinh_day);
		ngaysinh_day.setBounds(266, 146, 40, 20);
		contentPane.add(ngaysinh_day);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(309, 137, 7, 36);
		contentPane.add(label);
		
		ngaysinh_month = new Choice();
		ngaysinh_month = getMonth(ngaysinh_month);
		ngaysinh_month.setBounds(321, 146, 40, 20);
		contentPane.add(ngaysinh_month);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(366, 137, 7, 36);
		contentPane.add(label_1);
		
		ngaysinh_year = new Choice();
		ngaysinh_year = getYear(ngaysinh_year);
		ngaysinh_year.setBounds(378, 146, 55, 20);
		contentPane.add(ngaysinh_year);
		
		nvl_day = new Choice();
		nvl_day = getDay(nvl_day);
		nvl_day.setBounds(266, 326, 40, 20);
		contentPane.add(nvl_day);
		
		JLabel label_2 = new JLabel("/");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(309, 317, 7, 36);
		contentPane.add(label_2);
		
		nvl_month = new Choice();
		nvl_month = getMonth(nvl_month);
		nvl_month.setBounds(321, 326, 40, 20);
		contentPane.add(nvl_month);
		
		JLabel label_3 = new JLabel("/");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(366, 317, 7, 36);
		contentPane.add(label_3);
		
		nvl_year = new Choice();
		nvl_year = getYear(nvl_year);
		nvl_year.setBounds(378, 326, 55, 20);
		contentPane.add(nvl_year);
		
		JLabel role = new JLabel("Quyền quản trị: ");
		role.setHorizontalAlignment(SwingConstants.RIGHT);
		role.setFont(new Font("Calibri", Font.PLAIN, 16));
		role.setBounds(129, 370, 106, 25);
		roleID = new JComboBox();
		roleID.addItem(new Role(-1, "", ""));
		for(int i = 0; i < r.size(); i++) {
			roleID.addItem(r.get(i));
                        if(r.get(i).getRoleID()==employee.get(0).getRoleID()) roleID.setSelectedIndex(i+1);
		}
		roleID.setBounds(265, 370, 100, 25);
		contentPane.add(role);
		contentPane.add(roleID);
		
		JButton btn_update = new JButton("Cập Nhật");
		btn_update.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_update.setBounds(169, 420, 99, 31);
		contentPane.add(btn_update);
		
		JButton btn_reset = new JButton("Nhập Lại");
		btn_reset.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_reset.setBounds(278, 420, 99, 31);
		contentPane.add(btn_reset);
		
		JButton btn_cancle = new JButton("Hủy Bỏ");
		btn_cancle.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_cancle.setBounds(385, 420, 99, 31);
		contentPane.add(btn_cancle);
		
		for(int i = 0; i < employee.size(); i++) {
			maNV.setText(employee.get(i).getMaNV());
			tenNV.setText(employee.get(i).getTenNV());
			String gend = employee.get(i).getGender();
			if(gend.equals("Nam"))
				male.setSelected(true);
			else if(gend.equals("Nữ"))
				female.setSelected(true);
			ngaysinh_day.select(employee.get(i).getBirthDate().split("/")[0]);
			ngaysinh_month.select(employee.get(i).getBirthDate().split("/")[1]);
			ngaysinh_year.select(employee.get(i).getBirthDate().split("/")[2]);
			sdt.setText(employee.get(i).getSdt());
			CMND.setText(employee.get(i).getCMND());
			chucvu.setText(employee.get(i).getChucvu());
			nvl_day.select(employee.get(i).getNgayvaolam().split("/")[0]);
			nvl_month.select(employee.get(i).getNgayvaolam().split("/")[1]);
			nvl_year.select(employee.get(i).getNgayvaolam().split("/")[2]);
		}
		
		String regex = "^[0-9]*$";
		//EVENTS
			//BUTTON'S EVENTS
				btn_cancle.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btn_reset.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tenNV.setText("");
						gender.clearSelection();
						ngaysinh_day.select("");
						ngaysinh_month.select("");
						ngaysinh_year.select("");
						sdt.setText("");
						CMND.setText("");
						chucvu.setText("");
						nvl_day.select("");
						nvl_month.select("");
						nvl_year.select("");
					}
				});
				btn_update.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String birthDate = ngaysinh_day.getSelectedItem().toString() + "/" + ngaysinh_month.getSelectedItem().toString() + "/" + ngaysinh_year.getSelectedItem().toString();
						String workDate = nvl_day.getSelectedItem().toString() + "/" + nvl_month.getSelectedItem().toString() + "/" + nvl_year.getSelectedItem().toString();
						if(tenNV.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Tên nhân viên không được bỏ trống", "Tên nhân viên bị trống", JOptionPane.ERROR_MESSAGE);
							tenNV.requestFocus();
							return;
						}
						String gend = "";
						if(male.isSelected()) {
							gend = "Nam";
						}
						if(female.isSelected()) {
							gend = "Nữ";
						}
						if(gend.equals("")) {
							JOptionPane.showMessageDialog(null, "Giới tính chưa chọn", "Giới tính bị trống", JOptionPane.ERROR_MESSAGE);
							male.requestFocus();
							return;
						}
						if(!isValidDate(birthDate)) {
							JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ", "Ngày sinh không hợp lệ", JOptionPane.ERROR_MESSAGE);
							ngaysinh_day.requestFocus();
							return;
						}
						if(sdt.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống", "Số điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
							sdt.requestFocus();
							return;
						}
						if(!sdt.getText().matches(regex)) {
							JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Số điện thoại không hợp lệ", JOptionPane.ERROR_MESSAGE);
							sdt.requestFocus();
							return;
						}
						if(CMND.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "CMND không được để trống", "CMND bị trống", JOptionPane.ERROR_MESSAGE);
							CMND.requestFocus();
							return;
						}
						if(CMND.getText().length() < 9 || CMND.getText().length() > 12) {
							JOptionPane.showMessageDialog(null, "CMND không hợp lệ", "CMND không hợp lệ", JOptionPane.ERROR_MESSAGE);
							CMND.requestFocus();
							return;
						}
					
						if(!isValidDate(workDate)) {
							JOptionPane.showMessageDialog(null, "Ngày vào làm không hợp lệ", "Ngày vào làm không hợp lệ", JOptionPane.ERROR_MESSAGE);
							nvl_day.requestFocus();
							return;
						}
						int role = -1;
                                                if(!roleID.getSelectedItem().toString().equals("")) {
                                                    Role ro = (Role) roleID.getSelectedItem();
                                                    role = ro.getRoleID();
                                                }
						if(role == -1) {
							JOptionPane.showMessageDialog(null, "Chưa phân quyền", "Phân quyền chưa có", JOptionPane.ERROR_MESSAGE);
							roleID.requestFocus();
							return;
						}
						NhanVien nv = new NhanVien(maNV.getText(), tenNV.getText(), gend, birthDate, sdt.getText(), CMND.getText(), chucvu.getText(), workDate, role);
						nv_bus.Update(nv);
                                                Employee_Frame.getTModel().setRowCount(0);
                                                            employee = nv_bus.listNV("SELECT * FROM nhanvien");
		for(int i = 0; i < employee.size(); i++) {
			String maNV		   = employee.get(i).getMaNV();
			String tenNV	   = employee.get(i).getTenNV();
			String gender	   = employee.get(i).getGender();
			String birthdate   = employee.get(i).getBirthDate();
			String sdt		   = employee.get(i).getSdt();
			String CMND		   = employee.get(i).getCMND();
			String chucvu	   = employee.get(i).getChucvu();
			String ngayvaolam  = employee.get(i).getNgayvaolam();
			Object []data = {
				maNV, tenNV, birthdate, gender, sdt, CMND, chucvu, ngayvaolam	
			};
			Employee_Frame.getTModel().addRow(data);
		}
						JOptionPane.showMessageDialog(null, "Đã sửa thành công thông tin của nhân viên có mã " + maNV.getText(), "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
			//END OF BUTTON'S EVENTS
		//END OF EVENT
		setVisible(true);
	}
	
	private Choice getDay(Choice day) {
		day.add("");
		String a;
		for(int i = 1; i <= 31; i++) {
			if(i < 10)
				a = "0" + i;
			else
				a = "" + i;
			day.add(a);
		}
		day.select("");
		return day;
	}
	
	private Choice getMonth(Choice month) {
		month.add("");
		String a;
		for(int i = 1; i <= 12; i++) {
			if(i < 10)
				a = "0" + i;
			else
				a = "" + i;
			month.add(a);
		}
		month.select("");
		return month;
	}
	
	private Choice getYear(Choice year) {
		year.add("");
		String a;
		for(int i = cal.get(Calendar.YEAR) - 70; i <= cal.get(Calendar.YEAR); i++) {
			if(i < 10)
				a = "0" + i;
			else
				a = "" + i;
			year.add(a);
		}
		year.select("");
		return year;
	}
	
	public static boolean isValidDate(String dateString) {
        Matcher dateMatcher = dateRegexPattern.matcher(dateString);
 
        if (dateMatcher.matches()) {
 
           dateMatcher.reset();
 
           if (dateMatcher.find()) {
               String day = dateMatcher.group(1);
               String month = dateMatcher.group(2);
               int year = Integer.parseInt(dateMatcher.group(3));
 
               if ("31".equals(day) && 
                  ("4".equals(month) || "6".equals(month) || "9".equals(month) ||
                   "11".equals(month) || "04".equals(month) || "06".equals(month) || 
                   "09".equals(month))) {
                   return false; // 1, 3, 5, 7, 8, 10, 12 has 31 days
               } else if ("2".equals(month) || "02".equals(month)) {
                    //leap year
                    if (year % 4 == 0) {
                        return !"30".equals(day) && !"31".equals(day);
                    } else {
                        return !"29".equals(day) && !"30".equals(day) && !"31".equals(day);
                    }
               } else {
                   return true;
               }
           } else {
               return false;
           }
        } else {
            return false;
        }
    }
}
