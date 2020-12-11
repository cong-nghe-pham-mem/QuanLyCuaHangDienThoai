package GUI;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DTO.ProductDTO;
import DTO.chitietsanphamDTO;
import DTO.CategoryDTO;
import BUS.Product_BUS;
import BUS.DetailProduct_BUS;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
public class ProductUpdate_Frame extends JFrame {

	private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");

	
	private JPanel contentPane;
	private JComboBox<CategoryDTO> tl;
        private JTextField ten;
        private JTextField mact;
	private JTextField tendt;
	private JTextField masp;
	private JTextField kich_thuoc;
	private JTextField trong_luong;
        private JTextField mau_sac;
	private JTextField bonho_trong;
	private JTextField ram;
	private JTextField he_dieu_hanh;
	private JTextField camera_truoc;
        private JTextField camera_sau;
        private JTextField pin;
        private JTextField bao_hanh;
        private JTextField tinh_trang;
	private JTextField gia;
        private JTextField soluong;
        private JTextField mota;
	
	private Product_BUS pd_bus = new Product_BUS();
	private DetailProduct_BUS dtpd_bus = new DetailProduct_BUS();
	private ArrayList <ProductDTO> product = pd_bus.getArrayList();
	private ArrayList <chitietsanphamDTO> dtProduct = dtpd_bus.getList();
	
	public ProductUpdate_Frame(String masp) {
		init(masp);
	}
	
	public void init(String id) {	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(750, 750);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
                
                JLabel lblten = new JLabel("SỬA SẢN PHẨM");
		lblten.setHorizontalAlignment(SwingConstants.RIGHT);
		lblten.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblNewLabel.setBounds(138, 10, 93, 28);
		contentPane.add(lblten,new GridBagConstraints(0,0,2,1,0.1,0.1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
                
		
		JLabel lblMachit = new JLabel("Mã chi tiết:");
		lblMachit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMachit.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblNewLabel.setBounds(138, 10, 93, 28);
		contentPane.add(lblMachit,new GridBagConstraints(0,1,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		mact = new JTextField();
		mact.setEditable(false);
		//masp.setBounds(255, 15, 86, 20);
                contentPane.add(mact,new GridBagConstraints(1,1,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		mact.setColumns(10);
                
                JLabel lblNewLabel = new JLabel("Mã SP:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblNewLabel.setBounds(138, 10, 93, 28);
		contentPane.add(lblNewLabel,new GridBagConstraints(0,2,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		masp = new JTextField();
		masp.setEditable(false);
		//masp.setBounds(255, 15, 86, 20);
                contentPane.add(masp,new GridBagConstraints(1,2,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		masp.setColumns(10);
		
		JLabel lblTnCb = new JLabel("Tên ĐT:");
		lblTnCb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnCb.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblTnCb.setBounds(138, 55, 93, 28);
                contentPane.add(lblTnCb,new GridBagConstraints(0,3,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		tendt = new JTextField();
		tendt.setColumns(10);
		tendt.setBounds(255, 60, 150, 20);
		contentPane.add(tendt,new GridBagConstraints(1,3,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
		JLabel lblMMb = new JLabel("Kích thước:");
		lblMMb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMMb.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblMMb.setBounds(138, 100, 93, 28);
                contentPane.add(lblMMb,new GridBagConstraints(0,4,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		kich_thuoc = new JTextField();
		kich_thuoc.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(kich_thuoc);
                contentPane.add(kich_thuoc,new GridBagConstraints(1,4,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
		JLabel lblimi = new JLabel("Trọng lượng:");
		lblimi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblimi.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblimi.setBounds(138, 145, 93, 28);
		contentPane.add(lblimi,new GridBagConstraints(0,5,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
                
                trong_luong = new JTextField();
		trong_luong.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(trong_luong);
                contentPane.add(trong_luong,new GridBagConstraints(1,5,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
                JLabel lblMausac = new JLabel("Màu sắc:");
		lblMausac.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblMausac.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
                contentPane.add(lblMausac,new GridBagConstraints(0,6,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		mau_sac = new JTextField();
		mau_sac.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
                contentPane.add(mau_sac,new GridBagConstraints(1,6,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
		JLabel lblimn = new JLabel("Bộ nhớ trong:");
		lblimn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblimn.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblimn.setBounds(138, 190, 93, 28);
		contentPane.add(lblimn);
                contentPane.add(lblimn,new GridBagConstraints(0,7,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		bonho_trong = new JTextField();
		bonho_trong.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(bonho_trong);
                contentPane.add(bonho_trong,new GridBagConstraints(1,7,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
		JLabel lblNgyi = new JLabel("RAM:");
		lblNgyi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyi.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblNgyi.setBounds(138, 235, 93, 28);
		contentPane.add(lblNgyi,new GridBagConstraints(0,8,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
                ram = new JTextField();
		ram.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(ram);
                contentPane.add(ram,new GridBagConstraints(1,8,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
		JLabel lblNgyn = new JLabel("Hệ điều hành:");
		lblNgyn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyn.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblNgyn.setBounds(138, 280, 93, 28);
		contentPane.add(lblNgyn,new GridBagConstraints(0,9,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
                
                he_dieu_hanh = new JTextField();
		he_dieu_hanh.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(he_dieu_hanh);
                contentPane.add(he_dieu_hanh,new GridBagConstraints(1,9,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
		JLabel lblSbayi = new JLabel("Camera trước:");
		lblSbayi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSbayi.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayi.setBounds(138, 325, 93, 28);
		contentPane.add(lblSbayi);
                contentPane.add(lblSbayi,new GridBagConstraints(0,10,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		camera_truoc = new JTextField();
		camera_truoc.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(camera_truoc);
                contentPane.add(camera_truoc,new GridBagConstraints(1,10,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
		JLabel lblSbayn = new JLabel("Camera sau:");
		lblSbayn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSbayn.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
		contentPane.add(lblSbayn);
                contentPane.add(lblSbayn,new GridBagConstraints(0,11,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		camera_sau = new JTextField();
		camera_sau.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(camera_sau);
                contentPane.add(camera_sau,new GridBagConstraints(1,11,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
		JLabel lblPin = new JLabel("Pin:");
		lblPin.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblPin.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
		contentPane.add(lblPin);
                contentPane.add(lblPin,new GridBagConstraints(0,12,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		pin = new JTextField();
		pin.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(pin);
                contentPane.add(pin,new GridBagConstraints(1,12,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
		
                JLabel lblBaoh = new JLabel("Bảo hành:");
		lblBaoh.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblBaoh.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
		contentPane.add(lblBaoh);
                contentPane.add(lblBaoh,new GridBagConstraints(0,13,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		bao_hanh= new JTextField();
		bao_hanh.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(bao_hanh);
                contentPane.add(bao_hanh,new GridBagConstraints(1,13,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
                JLabel lblttrang = new JLabel("Tình Trạng:");
		lblttrang.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblttrang.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
                contentPane.add(lblttrang,new GridBagConstraints(0,14,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		tinh_trang = new JTextField();
		tinh_trang.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(tinh_trang);
                contentPane.add(tinh_trang,new GridBagConstraints(1,14,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
                JLabel lblGia = new JLabel("Giá:");
		lblGia.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblGia.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
		contentPane.add(lblGia);
                contentPane.add(lblGia,new GridBagConstraints(0,15,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		gia = new JTextField();
		gia.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
                contentPane.add(gia,new GridBagConstraints(1,15,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
                JLabel lblSol = new JLabel("Số lượng:");
		lblSol.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblSol.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
		contentPane.add(lblSol);
                contentPane.add(lblSol,new GridBagConstraints(0,16,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		soluong = new JTextField();
		soluong.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
		contentPane.add(soluong);
                contentPane.add(soluong,new GridBagConstraints(1,16,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
                JLabel lblMota = new JLabel("Mô tả:");
		lblMota.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblMota.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
                contentPane.add(lblMota,new GridBagConstraints(0,17,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		mota = new JTextField();
		mota.setColumns(10);
		//kich_thuoc.setBounds(255, 105, 86, 20);
                contentPane.add(mota,new GridBagConstraints(1,17,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
                JLabel lbltl = new JLabel("Thương hiệu:");
		lbltl.setHorizontalAlignment(SwingConstants.RIGHT);
	        lbltl.setFont(new Font("Calibri", Font.PLAIN, 18));
		//lblSbayn.setBounds(138, 370, 93, 28);
                contentPane.add(lbltl,new GridBagConstraints(0,18,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
                
                tl = getTL(new JComboBox());
                contentPane.add(tl,new GridBagConstraints(1,18,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,0),0,0));
                
		JButton btn_update = new JButton("Cập Nhật");
		//btn_update.setBounds(265, 412, 89, 28);
                contentPane.add(btn_update,new GridBagConstraints(1,19,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0));
                
                JButton btn_cancle = new JButton("Hủy bỏ");
		//btn_update.setBounds(265, 412, 89, 28);
		contentPane.add(btn_cancle,new GridBagConstraints(2,19,1,1,0.1,0.1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0));               
		for(int i = 0; i < product.size(); i++) {                    
			if(id.equals(Integer.toString(product.get(i).getIdProd()))) {                                
				masp.setText(Integer.toString(product.get(i).getIdProd()));
				tendt.setText(product.get(i).getNameProd());
                                mota.setText(product.get(i).getDescription());
                                gia.setText(Integer.toString(product.get(i).getPrice()));
                                soluong.setText(Integer.toString(product.get(i).getSL()));
                                for(int j=0;j< dtProduct.size();j++){
                                    if(id.equals(Integer.toString(dtProduct.get(j).getmasanpham()))){
                                        mact.setText(Integer.toString(dtProduct.get(j).getmachitiet()));                                        				
                                kich_thuoc.setText(dtProduct.get(j).getkichthuoc());
                                trong_luong.setText(dtProduct.get(j).gettrongluong());
                                mau_sac.setText(dtProduct.get(j).getmausac());
                                bonho_trong.setText(dtProduct.get(j).getbonhotrong());
                                ram.setText(dtProduct.get(j).getbonhodem());
                                he_dieu_hanh.setText(dtProduct.get(j).gethedieuhanh());
                                camera_truoc.setText(dtProduct.get(j).getcameratruoc());
                                camera_sau.setText(dtProduct.get(j).getcamerasau());
                                pin.setText(dtProduct.get(j).getpin());
                                bao_hanh.setText(dtProduct.get(j).getbaohanh());
                                tinh_trang.setText(dtProduct.get(j).gettinhtrang());
                                for(int l=0;l<tl.getItemCount();l++){
                                    String type = tl.getItemAt(l).getType();
                                    if(type.equals(dtProduct.get(j).getmadanhmuc())){
                                        tl.setSelectedIndex(l);
                                        System.out.print(j);
                                        break;
                                    }
                                }                                
                                break;
                                    }
                                }
				break;
			}
		}
                 if(mact.getText().equals("")) mact.setText(masp.getText());
		
		//EVENTS
			btn_cancle.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btn_update.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(tendt.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Tên điện thoại không được để trống", "Tên điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						tendt.requestFocus();
						return;
					}
					if(kich_thuoc.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Kích thước của điện thoại không được để trống", "Kích thước của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						kich_thuoc.requestFocus();
						return;
					}
					if(trong_luong.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Trọng lượng của điện thoại không được để trống", "Trọng lượng của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						trong_luong.requestFocus();
						return;
					}
                                        if(mau_sac.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Màu sắc của điện thoại không được để trống", "Màu sắc của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						mau_sac.requestFocus();
						return;
					}
					if(bonho_trong.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Bộ nhớ trong của điện thoại không được để trống", "Bộ nhớ trong của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						bonho_trong.requestFocus();
						return;
					}
                                        if(ram.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Bộ nhớ đệm của điện thoại không được để trống", "Bộ nhớ đệm của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						ram.requestFocus();
						return;
					}
                                        if(he_dieu_hanh.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Hệ điều hành của điện thoại không được để trống", "Hệ điều hành của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						he_dieu_hanh.requestFocus();
						return;
					}
                                        if(camera_truoc.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Camera trước của điện thoại không được để trống", "Camera trước của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						camera_truoc.requestFocus();
						return;
					}
                                        if(camera_sau.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Camera sau của điện thoại không được để trống", "Camera sau của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						camera_sau.requestFocus();
						return;
					}
                                        if(pin.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Pin của điện thoại không được để trống", "Pin của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						pin.requestFocus();
						return;
					}
                                        if(bao_hanh.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Bảo hành của điện thoại không được để trống", "Bảo hành của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						bao_hanh.requestFocus();
						return;
					}
                                        if(tinh_trang.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Tình trạng của điện thoại không được để trống", "Tình trạng của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						tinh_trang.requestFocus();
						return;
					}
                                        if(gia.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Giá của điện thoại không được để trống", "Giá của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						gia.requestFocus();
						return;
					}
                                        if(soluong.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Số lượng của điện thoại không được để trống", "Số lượng của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						soluong.requestFocus();
						return;
					}
                                        if(mota.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Mô tả của điện thoại không được để trống", "Mô tả của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						mota.requestFocus();
						return;
					}
                                        if(tl.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Thương hiệu của điện thoại không được để trống", "Thương hiệu của của điện thoại bị trống", JOptionPane.ERROR_MESSAGE);
						mota.requestFocus();
						return;
					}
                                        try{
                                        CategoryDTO x = (CategoryDTO) tl.getSelectedItem();
                                        chitietsanphamDTO ctsp = new chitietsanphamDTO(Integer.parseInt(mact.getText()), Integer.parseInt(masp.getText()), x.getType(), kich_thuoc.getText(), trong_luong.getText(),mau_sac.getText(), bonho_trong.getText(), ram.getText(), he_dieu_hanh.getText(),camera_truoc.getText() ,camera_sau.getText(), pin.getText(), bao_hanh.getText(), tinh_trang.getText());
                                        ProductDTO sp = new ProductDTO(Integer.parseInt(masp.getText()), tendt.getText(),mota.getText(),Integer.parseInt(gia.getText()),Integer.parseInt(soluong.getText()));
                                        pd_bus.Update(sp);
                                        dtpd_bus.update(ctsp);
                                        Product_Frame.getTModel().setRowCount(0);
                                        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                                        ArrayList<ProductDTO> listSP = pd_bus.getArrayList();
                                        for(int i = 0; i < listSP.size(); i++) {
                                            Product_Frame.getTModel().addRow(new Object[]{
                                                listSP.get(i).getIdProd(),listSP.get(i).getNameProd(),listSP.get(i).getDescription(),nf.format(listSP.get(i).getPrice()),listSP.get(i).getSL()
                                            });
                                        }
					JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
					dispose();
                                        } catch(NumberFormatException ne){
                                            JOptionPane.showMessageDialog(null, "Giá cả, Số lượng phải là Số Nguyên", "FAIL", JOptionPane.ERROR_MESSAGE);
                                        }
				}
			});
		//END OF EVENTS
		
		setVisible(true);
	}
        
        
        public JComboBox<CategoryDTO> getTL(JComboBox<CategoryDTO> dm){
            dm.addItem(new CategoryDTO("", ""));
            ArrayList<CategoryDTO> th = pd_bus.getTL();
		for(int i=0;i<th.size();i++){
                    dm.addItem(th.get(i));
                }
            return dm;
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
