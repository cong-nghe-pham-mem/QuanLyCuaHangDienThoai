package GUI_Bandt;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DTO.KhachHang;
import BUS.KhachHang_BUS;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Profile_Frame extends JPanel {
	private int WIDTH;
	private String maKH;
	private String birthDate = "";
	private Calendar cal = Calendar.getInstance();
	private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	
	
	private KhachHang_BUS kh_bus = new KhachHang_BUS();
	private ArrayList <KhachHang> customer = kh_bus.getArrayList_normal();
	private JTextField tenKH;
	private JTextField CMND;
	private JTextField email;
	private JTextField sdt;
	private Choice ngaySinh_day;
	private Choice ngaySinh_month;
	private Choice ngaySinh_year;
	/**
	 * Create the panel.
	 */
	public Profile_Frame(int WIDTH, String maKH) {
		this.maKH = maKH;
		this.WIDTH = WIDTH;
		setLayout(null);
		setBackground(null);
                setBounds(new Rectangle(0, 0, WIDTH + 23, 800));
		
		JLabel lblNewLabel = new JLabel("Tên Khách Hàng:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(217, 138, 122, 31);
		add(lblNewLabel);
		
		tenKH = new JTextField();
		tenKH.setBounds(385, 143, 171, 20);
		add(tenKH);
		tenKH.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Giới Tính:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(217, 190, 122, 31);
		add(lblNewLabel_1);
		
		ButtonGroup gender = new ButtonGroup();
		JRadioButton male = new JRadioButton("Nam");
		male.setFont(new Font("Calibri", Font.PLAIN, 13));
		male.setBounds(385, 192, 59, 25);		
		add(male);
		
		JRadioButton female = new JRadioButton("Nữ");
		female.setFont(new Font("Calibri", Font.PLAIN, 13));		
		female.setBounds(440, 192, 59, 25);
		add(female);
	
                JRadioButton other = new JRadioButton("Khác");
		other.setFont(new Font("Calibri", Font.PLAIN, 13));		
		other.setBounds(495, 192, 59, 25);
		add(other);
		
		gender.add(male);
		gender.add(female);
                gender.add(other);
		
		JLabel lblCmnd = new JLabel("CMND:");
		lblCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCmnd.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCmnd.setBounds(217, 241, 122, 31);
		add(lblCmnd);
		
		CMND = new JTextField();
		CMND.setColumns(10);
		CMND.setBounds(385, 246, 271, 20);
		add(CMND);
		
		ngaySinh_day = new Choice();
		ngaySinh_day = getDay(ngaySinh_day);
		ngaySinh_day.setBounds(385, 295, 50, 20);
		add(ngaySinh_day);
		
		
		ngaySinh_month = new Choice();
		ngaySinh_month = getMonth(ngaySinh_month);
		ngaySinh_month.setBounds(440, 295, 50, 20);
		add(ngaySinh_month);
		
		
		ngaySinh_year = new Choice();
		ngaySinh_year = getYear(ngaySinh_year);
		ngaySinh_year.setBounds(495, 295, 66, 20);
		add(ngaySinh_year);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNgySinh.setBounds(217, 291, 122, 31);
		add(lblNgySinh);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmail.setBounds(217, 345, 122, 31);
		add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(385, 350, 171, 20);
		add(email);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSinThoi.setBounds(217, 399, 122, 31);
		add(lblSinThoi);
		
		sdt = new JTextField();
		sdt.setColumns(10);
		sdt.setBounds(385, 404, 171, 20);
		add(sdt);
		
		JButton btn_update = new JButton("Cập Nhật");
		btn_update.setBounds(353, 471, 89, 32);
		add(btn_update);
		
		JButton btn_reset = new JButton("Nhập Lại");
		btn_reset.setBounds(467, 471, 89, 32);
		add(btn_reset);
		
		birthDate = ngaySinh_day.getSelectedItem() + "/" + ngaySinh_month.getSelectedItem() + "/" + ngaySinh_year.getSelectedItem();
		if(birthDate.split("/").length < 3)
			birthDate = "";
		for(int i = 0; i < customer.size(); i++) {
			if(customer.get(i).getMaKh().equals(this.maKH)) {
				tenKH.setText(customer.get(i).getTenKH());
				if(customer.get(i).getGender().equals("Nam"))
					male.setSelected(true);
				if(customer.get(i).getGender().equals("Nữ"))
					female.setSelected(true);
                                if(customer.get(i).getGender().equals("Khác"))
					other.setSelected(true);
				CMND.setText(customer.get(i).getCMND());
				if(!birthDate.equals("")) {
					ngaySinh_day.select(birthDate.split("/")[0]);
					ngaySinh_month.select(birthDate.split("/")[1]);
					ngaySinh_year.select(birthDate.split("/")[2]);
				}
				
				sdt.setText(customer.get(i).getSdt());
			}
		}
		
		String regex = "";
		String regexEmail = "";
		
		//EVENTS
			btn_update.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(tenKH.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống", "Tên khách hàng bị trống", JOptionPane.ERROR_MESSAGE);
						tenKH.requestFocus();
						return;
					}
					String gioitinh = "";
					if(male.isSelected())
						gioitinh = "Nam";
					if(female.isSelected())
						gioitinh = "Nữ";
                                        if(other.isSelected())
						gioitinh = "Khác";
					if(gioitinh.equals("")) {
						JOptionPane.showMessageDialog(null, "Chưa chọn giới tính", "Giới tính chưa được chọn", JOptionPane.ERROR_MESSAGE);
						male.requestFocus();
						return;
					}
					
					
					
					birthDate = ngaySinh_day.getSelectedItem() + ngaySinh_month.getSelectedItem() + ngaySinh_year.getSelectedItem();
					if(isValidDate(birthDate)) {
						JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ", "Ngày sinh không hợp lệ", JOptionPane.ERROR_MESSAGE);
						ngaySinh_day.requestFocus();
						return;
					}
					if(email.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Email không được để trống", "Email bị trống", JOptionPane.ERROR_MESSAGE);
						email.requestFocus();
						return;
					}
					if(email.getText().matches(regexEmail)) {
						JOptionPane.showMessageDialog(null, "Nhập theo mẫu VD: abcxyz@gmail.com", "Email không hợp lệ", JOptionPane.ERROR_MESSAGE);
						email.requestFocus();
						return;
					}
					if(sdt.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống", "Số điện thoại không được để trống", JOptionPane.ERROR_MESSAGE);
						sdt.requestFocus();
						return;
					}
					if(sdt.getText().matches(regex)) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Số điện thoại không hợp lệ", JOptionPane.ERROR_MESSAGE);
						sdt.requestFocus();
						return;
					}
					
					KhachHang kh = new KhachHang(maKH, tenKH.getText(), gioitinh, CMND.getText(), sdt.getText(), birthDate, "");
					kh_bus.Update(kh);
					JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			});
			btn_reset.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tenKH.setText("");
					gender.clearSelection();
					CMND.setText("");
					ngaySinh_day.select("");
					ngaySinh_month.select("");
					ngaySinh_year.select("");
					email.setText("");
					sdt.setText("");
				}
			});
		//END OF EVENTS
	}
	private Choice getDay(Choice day) {
		day.add("");
		String a = "";
		for(int i = 1; i <= 31; i++) {
			if(i < 10) 
				a = "0" + i;
			else
				a += i;
			day.add(a);
			a = "";
		}
		day.select("");
		return day;
	}
	private Choice getMonth(Choice month) {
		month.add("");
		String a = "";
		for(int i = 1; i <= 12; i++) {
			if(i < 10) 
				a = "0" + i;
			else
				a += i;
			month.add(a);
			a = "";
		}
		month.select("");
		return month;
	}
	private Choice getYear(Choice year) {
		year.add("");
		String a = "";
		for(int i = 1990; i <= cal.get(Calendar.YEAR); i++) {
			a += i;
			year.add(a);
			a = "";
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
