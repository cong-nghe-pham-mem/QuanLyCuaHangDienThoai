package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import DTO.KhachHang;
import BUS.KhachHang_BUS;

public class CustomerInsert_Frame extends JFrame {

	private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	private JPanel contentPane;
	private Calendar cal = Calendar.getInstance();
	private JTextField maKH;
	private JTextField tenKH;
	private JTextField sdt;
	private JTextField CMND;
	private Choice ngaysinh_day, ngaysinh_month, ngaysinh_year;
	private Choice khl_day, khl_month, khl_year;
	
	private KhachHang_BUS kh_bus = new KhachHang_BUS();
	private ArrayList <KhachHang> customer = kh_bus.getArrayList_normal(); 

	public CustomerInsert_Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Mã KH:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Calibri", Font.PLAIN, 16));
		label.setBounds(97, 22, 106, 25);
		contentPane.add(label);
		
		maKH = new JTextField();
		maKH.setColumns(10);
		maKH.setBounds(234, 25, 86, 20);
		maKH.setEditable(false);
		maKH.setText(kh_bus.getMaKH());
		contentPane.add(maKH);
		
		tenKH = new JTextField();
		tenKH.setColumns(10);
		tenKH.setBounds(234, 67, 145, 20);
		contentPane.add(tenKH);
		
		JLabel label_1 = new JLabel("Tên KH:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_1.setBounds(97, 67, 106, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Giới Tính:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_2.setBounds(97, 112, 106, 25);
		contentPane.add(label_2);
		
		ButtonGroup gender = new ButtonGroup();
		JRadioButton male = new JRadioButton("Nam");
		male.setBounds(234, 112, 55, 23);
		gender.add(male);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Nữ");
		female.setBounds(295, 112, 50, 23);
		gender.add(female);
		contentPane.add(female);
		
		JLabel label_3 = new JLabel("Ngày Sinh:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_3.setBounds(97, 157, 106, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("/");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(277, 149, 7, 36);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("/");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_5.setBounds(334, 149, 7, 36);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Số Điện Thoại:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_6.setBounds(97, 202, 106, 25);
		contentPane.add(label_6);
		
		sdt = new JTextField();
		sdt.setColumns(10);
		sdt.setBounds(234, 202, 86, 20);
		contentPane.add(sdt);
		
		JLabel label_7 = new JLabel("CMND:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_7.setBounds(97, 247, 106, 25);
		contentPane.add(label_7);
		
		CMND = new JTextField();
		CMND.setColumns(10);
		CMND.setBounds(234, 247, 86, 20);
		contentPane.add(CMND);

		
		
		ngaysinh_day = new Choice();
		ngaysinh_day.setBounds(234, 157, 40, 20);
		ngaysinh_day = getDay(ngaysinh_day);
		contentPane.add(ngaysinh_day);
		
		ngaysinh_month = new Choice();
		ngaysinh_month = getMonth(ngaysinh_month);
		ngaysinh_month.setBounds(289, 157, 40, 20);
		contentPane.add(ngaysinh_month);
		
		ngaysinh_year = new Choice();
		ngaysinh_year = getYear(ngaysinh_year);
		ngaysinh_year.setBounds(346, 157, 55, 20);
		contentPane.add(ngaysinh_year);
                
		
		JButton btn_them, btn_reset, btn_cancle;
		btn_them = new JButton("Thêm KH");
		btn_reset = new JButton("Nhập Lại");
		btn_cancle = new JButton("Hủy Bỏ");
		btn_them.setBounds(200, 420, 85, 25);
		btn_reset.setBounds(300, 420, 85, 25);
		btn_cancle.setBounds(400, 420, 85, 25);
		
		
		String regex = "((09|03|07|08|05)+([0-9]{8})\\b)";
		//EVENTS
			//SỰ KIỆN TYPE
				tenKH.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						tenKH.setText(tenKH.getText().replaceAll("  ", " "));
					}
				});
				
			//KẾT THÚC SỰ KIỆN TYPE
			//SỰ KIỆN BUTTON
				btn_them.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(tenKH.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Tên nhân viên chưa có", "Tên nhân viên bị thiếu dữ liệu", JOptionPane.ERROR_MESSAGE);
							tenKH.requestFocus();	
							return;
						}
						tenKH.setText(tenKH.getText().trim());
						String gend = "";
						if(male.isSelected()) {
							gend = "Nam";
						}
						if(female.isSelected()) {
							gend = "Nữ";
						}
						if(gend.equals("")){
							JOptionPane.showMessageDialog(null, "Bạn chưa lựa chọn giới tính", "Thiếu dữ liệu giới tính",JOptionPane.ERROR_MESSAGE);
							male.requestFocus();
							return;
						}
						String birthDate = ngaysinh_day.getSelectedItem().toString() + "/" + ngaysinh_month.getSelectedItem().toString() + "/" + ngaysinh_year.getSelectedItem().toString();
						if(!isValidDate(birthDate)) {
							JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ", "Ngày sinh không hợp lệ",JOptionPane.ERROR_MESSAGE);
							ngaysinh_day.requestFocus();
							return;
						}
						
						if(sdt.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Dữ liệu số điện thoại không được bỏ trống", "Thiếu dữ liệu số điện thoại",JOptionPane.ERROR_MESSAGE);
							sdt.requestFocus();
							return;
						}
						if(sdt.getText().matches(regex)) {
							JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Số điện thoại không hợp lệ",JOptionPane.ERROR_MESSAGE);
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
						
						
                                               
						else {				
                                                        KhachHang kh = new KhachHang(maKH.getText(), tenKH.getText(), gend, birthDate, sdt.getText(), CMND.getText());
                                                        if(kh_bus.Insert(kh)) {
                                                            Employee_Frame.getTModel().setRowCount(0);
                                                            customer = kh_bus.listKH("SELECT * FROM khachhang");
		for(int i = 0; i < customer.size(); i++) {
			String maKH		   = customer.get(i).getMaKH();
			String tenKH	   = customer.get(i).getTenKH();
			String gender	   = customer.get(i).getGender();
			String birthdate   = customer.get(i).getBirthDate();
			String sdt		   = customer.get(i).getSdt();
			String CMND		   = customer.get(i).getCMND();
	
			Object []data = {
				maKH, tenKH, birthdate, gender, sdt, CMND
			};
			Employee_Frame.getTModel().addRow(data);
		}
                                                            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                        else JOptionPane.showMessageDialog(null, "Nhân viên đã tồn tại", "Mã nhân viên bị trùng", JOptionPane.ERROR_MESSAGE);
							dispose();
						}
					}
				});
				btn_reset.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						maKH.setText("");
						tenKH.setText("");
						gender.clearSelection();
						ngaysinh_day.select("");
						ngaysinh_month.select("");
						ngaysinh_year.select("");
						sdt.setText("");
						CMND.setText("");
						khl_day.select("");
						khl_month.select("");
						khl_year.select("");
					}
				});
				btn_cancle.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			//KẾT THÚC SỰ KIỆN
		//END EVENTS
		
		contentPane.add(btn_them);
		contentPane.add(btn_reset);
		contentPane.add(btn_cancle);
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
