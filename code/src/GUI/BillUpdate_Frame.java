package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.util.ArrayList;

import DTO.OrderDTO;
import DTO.DetailOrDTO;
import BUS.HoaDon_BUS;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class BillUpdate_Frame extends JFrame {

	private String id;
	private Calendar cal = Calendar.getInstance();
	private ArrayList <OrderDTO> bill;
	private HoaDon_BUS hd_bus = new HoaDon_BUS();
	
	private JPanel contentPane;
	private JTextField maHD;
	private JLabel lblMKhchHng;
	private JTextField maKH;
	private JLabel lblNgyLp;
	private JLabel lblTngTin;
	private JTextField tongTien;
	private Choice ngaylap_day;
	private JLabel label;
	private Choice ngaylap_month;
	private JLabel label_1;
	private Choice ngaylap_year;
	
	public BillUpdate_Frame(String id) {
		this.id = id;
		Init();
	}
	
	public void Init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Hóa Đơn:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(74, 20, 113, 20);
		contentPane.add(lblNewLabel);
		
		maHD = new JTextField();
		maHD.setEditable(false);
		maHD.setBounds(197, 20, 86, 20);
		contentPane.add(maHD);
		maHD.setColumns(10);
		
		lblMKhchHng = new JLabel("Mã Khách Hàng:");
		lblMKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMKhchHng.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMKhchHng.setBounds(74, 70, 113, 20);
		contentPane.add(lblMKhchHng);
		
		maKH = new JTextField();
		maKH.setEditable(false);
		maKH.setColumns(10);
		maKH.setBounds(197, 70, 86, 20);
		contentPane.add(maKH);
		
		lblNgyLp = new JLabel("Ngày Lập:");
		lblNgyLp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyLp.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNgyLp.setBounds(74, 120, 113, 20);
		contentPane.add(lblNgyLp);
		
		
		lblTngTin = new JLabel("Tổng Tiền:");
		lblTngTin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTngTin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTngTin.setBounds(74, 220, 113, 20);
		contentPane.add(lblTngTin);
		
		tongTien = new JTextField();
		tongTien.setColumns(10);
		tongTien.setBounds(197, 220, 86, 20);
		contentPane.add(tongTien);
		
		JButton btn_update = new JButton("Cập Nhật");
		btn_update.setBounds(74, 264, 89, 33);
		contentPane.add(btn_update);
		
		JButton btn_reset = new JButton("Nhập Lại");
		btn_reset.setBounds(173, 264, 89, 33);
		contentPane.add(btn_reset);
		
		JButton btn_cancle = new JButton("Hủy Bỏ");
		btn_cancle.setBounds(272, 264, 89, 33);
		contentPane.add(btn_cancle);
		
		ngaylap_day = new Choice();
		ngaylap_day = getDay(ngaylap_day);
		ngaylap_day.setBounds(197, 120, 39, 20);
		contentPane.add(ngaylap_day);
		
		label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(240, 113, 12, 32);
		contentPane.add(label);
		
		ngaylap_month = new Choice();
		ngaylap_month = getMonth(ngaylap_month);
		ngaylap_month.setBounds(250, 120, 39, 20);
		contentPane.add(ngaylap_month);
		
		label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_1.setBounds(295, 113, 12, 32);
		contentPane.add(label_1);
		
		ngaylap_year = new Choice();
		ngaylap_year = getYear(ngaylap_year);
		ngaylap_year.setBounds(308, 120, 66, 20);
		contentPane.add(ngaylap_year);
		bill = hd_bus.getArrayList_condition("dh.`Mã đơn hàng`", id);
		maHD.setText(Integer.toString(bill.get(0).getIdOrder()));
		maKH.setText(Integer.toString(bill.get(0).getId()));
		String ngaylap = bill.get(0).getOrderdate();
		ngaylap_day.select(ngaylap.split("/")[0]);
		ngaylap_month.select(ngaylap.split("/")[1]);
		ngaylap_year.select(ngaylap.split("/")[2].split(" ")[0]);
		tongTien.setText(Integer.toString(bill.get(0).getTotalmoney()));
		
		//EVENTS
			//TYPE EVENTS
				
			//END OF TYPE EVENTS
			btn_cancle.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btn_update.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
                                    try{
					String ngaylap = ngaylap_day.getSelectedItem().toString() + "/" + ngaylap_month.getSelectedItem().toString() + "/" + ngaylap_year.getSelectedItem().toString();
					OrderDTO hd = new OrderDTO(Integer.parseInt(maHD.getText()),Integer.parseInt(maKH.getText()),Integer.parseInt(tongTien.getText()), ngaylap, LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
					hd_bus.Update(hd);
                                        Bill_Frame.getTModel().setRowCount(0);
                                        bill = hd_bus.getArrayList_normal();
                                        for(int i = 0; i < bill.size(); i++) {
                                        int maHD = bill.get(i).getIdOrder();
                                        int maKH = bill.get(i).getId();
                                        String ngayLap = bill.get(i).getOrderdate();
                                        int tongTien = bill.get(i).getTotalmoney();
                                        Object []data_table = {
                                                maHD, maKH, ngayLap, tongTien
                                        };
                                        Bill_Frame.getTModel().addRow(data_table);
                                    }
					dispose();
                                    }catch(NumberFormatException ne){
                                        JOptionPane.showMessageDialog(null, "Tổng tiền phải là số nguyên", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    }
				}
			});
		//END OF EVENTS
		setVisible(true);
	}
	
	//TẠO CÁC CHOICE NGÀY THÁNG NĂM
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
		//KẾT THÚC KHAI BÁO
}
