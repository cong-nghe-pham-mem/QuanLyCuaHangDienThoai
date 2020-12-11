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

import DTO.KhachHang;
import BUS.KhachHang_BUS;

public class CustomerUpdate_Frame extends JFrame {

	private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	
	private JPanel contentPane;
	private String id;
	private JTextField maKh;
	private JTextField tenKH;
	private JTextField gender;
	private JTextField CMND;
	private JLabel lblSinThoi;
	private JTextField sdt;
	private JLabel lblMGimGi;
	private JLabel lblMGimGi_1;
	private JTextField maGiamGia;
	private JButton btn_update;
	private JButton btn_reset;
	private JButton btn_cancle;
	private Choice ngaysinh_day, ngaysinh_month, ngaysinh_year;
	private ArrayList <KhachHang> customer;
	private KhachHang_BUS kh_bus = new KhachHang_BUS();
	private Calendar cal = Calendar.getInstance();
	
	
	CustomerUpdate_Frame(){
		
	}
	
	CustomerUpdate_Frame(String id){
		this.id = id;
		Init();
	}
	
	public void Init() {
		customer = listKH("SELECT * FROM khachhang WHERE maKh = '" + id + "'");
		
		setSize(500, 450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
                gender = new JTextField();
                
		JLabel lblNewLabel = new JLabel("Mã KH:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel.setBounds(118, 25, 118, 23);
		contentPane.add(lblNewLabel);
		
                maKh = new JTextField();
		maKh.setEditable(false);
		maKh.setBounds(258, 25, 86, 20);
		contentPane.add(maKh);
		maKh.setColumns(10);
		
		JLabel lblTnKh = new JLabel("Tên KH:");
		lblTnKh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnKh.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblTnKh.setBounds(118, 70, 118, 23);
		contentPane.add(lblTnKh);
		
		tenKH = new JTextField();
		tenKH.setColumns(10);
		tenKH.setBounds(258, 70, 167, 20);
		contentPane.add(tenKH);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiiTnh.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblGiiTnh.setBounds(118, 115, 118, 23);
		contentPane.add(lblGiiTnh);
		
		ButtonGroup btn_gender = new ButtonGroup();
		JRadioButton male = new JRadioButton("Nam");
		male.setBounds(245, 113, 55, 25);
		JRadioButton female = new JRadioButton("Nữ");
		female.setBounds(300, 113, 50, 25);
		btn_gender.add(male);
		btn_gender.add(female);
		contentPane.add(male);
		contentPane.add(female);
		
		JLabel lblCmnd = new JLabel("CMND:");
		lblCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCmnd.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblCmnd.setBounds(118, 160, 118, 23);
		contentPane.add(lblCmnd);
		
		CMND = new JTextField();
		CMND.setColumns(10);
		CMND.setBounds(258, 160, 86, 20);
		contentPane.add(CMND);
		
		lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblSinThoi.setBounds(118, 205, 118, 23);
		contentPane.add(lblSinThoi);
		
		sdt = new JTextField();
		sdt.setColumns(10);
		sdt.setBounds(258, 205, 86, 20);
		contentPane.add(sdt);
		
		lblMGimGi = new JLabel("Ngày Sinh:");
		lblMGimGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMGimGi.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblMGimGi.setBounds(118, 250, 118, 23);
		contentPane.add(lblMGimGi);
		
		lblMGimGi_1 = new JLabel("Mã Giảm Giá:");
		lblMGimGi_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMGimGi_1.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblMGimGi_1.setBounds(118, 295, 118, 23);
		contentPane.add(lblMGimGi_1);
		
		maGiamGia = new JTextField();
		maGiamGia.setColumns(10);
		maGiamGia.setBounds(258, 295, 86, 20);
		contentPane.add(maGiamGia);
		
		btn_update = new JButton("Câp Nhật");
		btn_update.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_update.setBounds(118, 364, 100, 34);
		contentPane.add(btn_update);
		
		btn_reset = new JButton("Nhập Lại");
		btn_reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_reset.setBounds(240, 364, 100, 34);
		contentPane.add(btn_reset);
		
		btn_cancle = new JButton("Hủy Bỏ");
		btn_cancle.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_cancle.setBounds(361, 364, 100, 34);
		contentPane.add(btn_cancle);
		
		ngaysinh_day = new Choice();
		ngaysinh_day = getDay(ngaysinh_day);
		ngaysinh_day.setBounds(258, 250, 40, 20);
		contentPane.add(ngaysinh_day);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(302, 240, 7, 36);
		contentPane.add(label);
		
		ngaysinh_month = new Choice();
		ngaysinh_month = getMonth(ngaysinh_month);
		ngaysinh_month.setBounds(313, 250, 40, 20);
		contentPane.add(ngaysinh_month);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(358, 240, 7, 36);
		contentPane.add(label_1);
		
		ngaysinh_year = new Choice();
		ngaysinh_year = getYear(ngaysinh_year);
		ngaysinh_year.setBounds(370, 250, 55, 20);
		contentPane.add(ngaysinh_year);
		
		for(int i = 0; i < customer.size(); i++) {
			maKh.setText(id);
			tenKH.setText(customer.get(i).getTenKH());
			if(customer.get(i).getGender().equals("Nam")) {
				male.setSelected(true);
			}
			else if(customer.get(i).getGender().equals("Nữ")) {
				female.setSelected(true);
			}
			CMND.setText(customer.get(i).getCMND());
			sdt.setText(customer.get(i).getSdt());
			String birthDate = customer.get(i).getBirthDate();
			System.out.println(birthDate);
			if(!birthDate.equals("")) {
				ngaysinh_day.select(birthDate.split("/")[0]);
				ngaysinh_month.select(birthDate.split("/")[1]);
				ngaysinh_year.select(birthDate.split("/")[2]);
			}
			
			maGiamGia.setText(customer.get(i).getMaGiamGia());
			
		}
		
		//EVENTS
			//SỰ KIỆN NHẬP
			//KẾT THÚC SỰ KIỆN NHẬP
			
			//SỰ KIỆN BUTTON
				btn_update.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String gend = "";
						if(tenKH.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống", "Tên khách hàng bị trống", JOptionPane.ERROR_MESSAGE);
							tenKH.requestFocus();
							return;
						}
						if(male.isSelected()) {
							gend = "Nam";
						}
						else if(female.isSelected()) {
							gend = "Nữ";
						}
						if(gend.equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa chọn giới tính", "Giới tính chưa có", JOptionPane.ERROR_MESSAGE);
							male.requestFocus();
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
						String birthDate = ngaysinh_day.getSelectedItem().toString() + "/" + ngaysinh_month.getSelectedItem().toString() + "/" + ngaysinh_year.getSelectedItem().toString() ; 
						//System.out.println(birthDate.split("/").length);
						if(!isValidDate(birthDate)) {
							JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ", "Ngày sinh không hợp lệ", JOptionPane.ERROR_MESSAGE);
							ngaysinh_day.requestFocus();
							return;
						}
                                                KhachHang kh = new KhachHang(maKh.getText(), tenKH.getText(), gend, CMND.getText(), sdt.getText(), birthDate, maGiamGia.getText());
						kh_bus.Update(kh);
                                                Customer_Frame.getTModel().setRowCount(0);
                                                            customer = kh_bus.listKH("SELECT * FROM khachhang");
                                                        for(int i = 0; i < customer.size(); i++) {
							String maKH		= customer.get(i).getMaKh();
							String tenKH	= customer.get(i).getTenKH();
							String gender	= customer.get(i).getGender();
							String CMND		= customer.get(i).getCMND();
							String sdt		= customer.get(i).getSdt();
							String birthdate = customer.get(i).getBirthDate();
							String maGiamGia = customer.get(i).getMaGiamGia();
							Object []data = {
									maKH, tenKH, gender, CMND, sdt, birthdate, maGiamGia
							};
							Customer_Frame.getTModel().addRow(data);
		}
						
						JOptionPane.showMessageDialog(null, "Đã cập nhật dữ liệu của khách hàng " + id, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					}
				});
                                btn_reset.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        tenKH.setText("");
                                        gender.setText("");
                                        CMND.setText("");
                                        sdt.setText("");
                                        maGiamGia.setText("");
                                    }
                                });
                                btn_cancle.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        dispose();
                                    }
                                });
			//KẾT THÚC SỰ KIỆN BUTTON
		//END OF EVENTS
		
		setVisible(true);
	}
	
	private ArrayList <KhachHang> listKH(String sql){
		customer = kh_bus.listKH(sql);
		return customer;
	}
	
	//TẠO DỮ LIỆU CHO CÁC CHOICE
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
	//KẾT THÚC TẠO DỮ LIỆU
			
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
