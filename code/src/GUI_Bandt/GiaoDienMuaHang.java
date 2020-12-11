package GUI_Bandt;

import javax.swing.*;
import javax.swing.border.*;

import GUI.Bill_Frame;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class GiaoDienMuaHang extends JFrame {

	private JPanel contentPane;
	private JPanel body;
	private String name;
	private String maKH;
	
	public GiaoDienMuaHang(String name, String maKH) {
		this.name = name;
		this.maKH = maKH;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1050, 820);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 153));
		panel.setBounds(0, 0, 241, 820);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel welcome_user = new JLabel("Xin chào " + name);
		welcome_user.setForeground(new Color(102, 0, 51));
		welcome_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		welcome_user.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_user.setBounds(0, 11, 241, 40);
		panel.add(welcome_user);
		
		JPanel purchase = new JPanel();
		purchase.setBackground(new Color(0, 255, 153));
		purchase.setBounds(0, 62, 241, 53);
		panel.add(purchase);
		purchase.setLayout(null);
		
		JLabel purchase_active = new JLabel("");
		purchase_active.setEnabled(false);
		purchase_active.setHorizontalAlignment(SwingConstants.CENTER);
		purchase_active.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/marker.png")));
		purchase_active.setBounds(0, 11, 28, 31);
		purchase.add(purchase_active);
		
		JLabel purchase_left = new JLabel("");
		purchase_left.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/purchase.png")));
		purchase_left.setBounds(38, 11, 39, 31);
		purchase.add(purchase_left);
		
		JLabel purchase_right = new JLabel("Mua Hàng");
		purchase_right.setForeground(new Color(102, 0, 51));
		purchase_right.setHorizontalAlignment(SwingConstants.CENTER);
		purchase_right.setFont(new Font("Calibri", Font.PLAIN, 18));
		purchase_right.setBounds(87, 11, 129, 31);
		purchase.add(purchase_right);
		
		JPanel tickets = new JPanel();
		tickets.setBackground(new Color(0, 255, 153));
		tickets.setLayout(null);
		tickets.setBounds(0, 135, 241, 53);
		panel.add(tickets);
		
		JLabel tickets_active = new JLabel("");
		tickets_active.setEnabled(false);
		tickets_active.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/marker.png")));
		tickets_active.setHorizontalAlignment(SwingConstants.CENTER);
		tickets_active.setBounds(0, 11, 28, 31);
		tickets.add(tickets_active);
		
		JLabel tickets_left = new JLabel("");
		tickets_left.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/tickets.png")));
		tickets_left.setBounds(38, 11, 39, 31);
		tickets.add(tickets_left);
		
		JLabel tickets_right = new JLabel("Lịch sử giao dịch");
		tickets_right.setForeground(new Color(102, 0, 51));
		tickets_right.setHorizontalAlignment(SwingConstants.CENTER);
		tickets_right.setFont(new Font("Calibri", Font.PLAIN, 18));
		tickets_right.setBounds(87, 11, 129, 31);
		tickets.add(tickets_right);
		
		JPanel profile = new JPanel();
		profile.setBackground(new Color(0, 255, 153));
		profile.setLayout(null);
		profile.setBounds(0, 287, 241, 53);
		panel.add(profile);
		
		JLabel profile_active = new JLabel("");
		profile_active.setEnabled(false);
		profile_active.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/marker.png")));
		profile_active.setHorizontalAlignment(SwingConstants.CENTER);
		profile_active.setBounds(0, 11, 28, 31);
		profile.add(profile_active);
		
		JLabel profile_left = new JLabel("");
		profile_left.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/user.png")));
		profile_left.setBounds(38, 11, 39, 31);
		profile.add(profile_left);
		
		JLabel profile_right = new JLabel("Thông Tin");
		profile_right.setForeground(new Color(102, 0, 51));
		profile_right.setHorizontalAlignment(SwingConstants.CENTER);
		profile_right.setFont(new Font("Calibri", Font.PLAIN, 18));
		profile_right.setBounds(87, 11, 129, 31);
		profile.add(profile_right);
		
		JPanel logout = new JPanel();
		logout.setBackground(new Color(0, 255, 153));
		logout.setLayout(null);
		logout.setBounds(0, 361, 241, 53);
		panel.add(logout);
		
		
		JLabel logout_left = new JLabel("");
		logout_left.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/logout.png")));
		logout_left.setBounds(38, 11, 39, 31);
		logout.add(logout_left);
		
		JLabel logout_right = new JLabel("Đăng Xuất");
		logout_right.setForeground(new Color(102, 0, 51));
		logout_right.setHorizontalAlignment(SwingConstants.CENTER);
		logout_right.setFont(new Font("Calibri", Font.PLAIN, 18));
		logout_right.setBounds(87, 11, 129, 31);
		logout.add(logout_right);
		
		JPanel bill = new JPanel();
		bill.setBackground(new Color(0, 255, 153));
		bill.setLayout(null);
		bill.setBounds(0, 210, 241, 53);
		panel.add(bill);
		
		JLabel bill_active = new JLabel("");
		bill_active.setEnabled(false);
		bill_active.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/marker.png")));
		bill_active.setHorizontalAlignment(SwingConstants.CENTER);
		bill_active.setBounds(0, 11, 28, 31);
		bill.add(bill_active);
		
		JLabel bill_left = new JLabel("");
		bill_left.setIcon(new ImageIcon(GiaoDienMuaHang.class.getResource("/icons/bill.png")));
		bill_left.setBounds(38, 11, 39, 31);
		bill.add(bill_left);
		
		JLabel bill_right = new JLabel("Thanh Toán");
		bill_right.setForeground(new Color(102, 0, 51));
		bill_right.setHorizontalAlignment(SwingConstants.CENTER);
		bill_right.setFont(new Font("Calibri", Font.PLAIN, 18));
		bill_right.setBounds(87, 11, 144, 31);
		bill.add(bill_right);
		
		body = new JPanel();                
		body.setBounds(243, 0, 785, 765);
		contentPane.add(body);
		body.setLayout(null);
		
		//EVENTS
			purchase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					body.removeAll();
					body.revalidate();
					body.add(new Purchase_Frame(762, maKH));
					body.repaint();
					
					purchase_active.setEnabled(true);
					tickets_active.setEnabled(false);
					profile_active.setEnabled(false);
                                        bill_active.setEnabled(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					purchase.setBackground(new Color(102, 255, 102));
                                        purchase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					tickets.setBackground(new Color(0, 255, 153));
                                        tickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					bill.setBackground(new Color(0, 255, 153));
                                        bill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					profile.setBackground(new Color(0, 255, 153));
                                        profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					logout.setBackground(new Color(0, 255, 153));
                                        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					purchase.setBackground(new Color(0, 255, 153));
				}
			});
			tickets.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					body.removeAll();
					body.revalidate();
					body.add(new Deals_Frame(762, maKH));
					body.repaint();
					
					purchase_active.setEnabled(false);
					tickets_active.setEnabled(true);
					profile_active.setEnabled(false);
                                        bill_active.setEnabled(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					purchase.setBackground(new Color(0, 255, 153));
					tickets.setBackground(new Color(102, 255, 102));
					bill.setBackground(new Color(0, 255, 153));
					profile.setBackground(new Color(0, 255, 153));
					logout.setBackground(new Color(0, 255, 153));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					tickets.setBackground(new Color(0, 255, 153));
				}
			});
			profile.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					body.removeAll();
					body.revalidate();
					body.add(new Profile_Frame(762, maKH));
					body.repaint();
					
					purchase_active.setEnabled(false);
					tickets_active.setEnabled(false);
					profile_active.setEnabled(true);
                                        bill_active.setEnabled(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					purchase.setBackground(new Color(0, 255, 153));
					tickets.setBackground(new Color(0, 255, 153));
					bill.setBackground(new Color(0, 255, 153));
					profile.setBackground(new Color(102, 255, 102));
					logout.setBackground(new Color(0, 255, 153));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					profile.setBackground(new Color(0, 255, 153));
				}
			});
                        bill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					body.removeAll();
					body.revalidate();
					body.add(new Bills_Frame(762,maKH));
					body.repaint();
					
					purchase_active.setEnabled(false);
					tickets_active.setEnabled(false);
					profile_active.setEnabled(false);
                                        bill_active.setEnabled(true);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					purchase.setBackground(new Color(0, 255, 153));
					tickets.setBackground(new Color(0, 255, 153));
					bill.setBackground(new Color(102, 255, 102));
					profile.setBackground(new Color(0, 255, 153));
					logout.setBackground(new Color(0, 255, 153));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					bill.setBackground(new Color(0, 255, 153));
				}
			});
			logout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new DangNhap();
				}
                                @Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					purchase.setBackground(new Color(0, 255, 153));
					tickets.setBackground(new Color(0, 255, 153));
					logout.setBackground(new Color(102, 255, 102));
					profile.setBackground(new Color(0, 255, 153));
					bill.setBackground(new Color(0, 255, 153));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					logout.setBackground(new Color(0, 255, 153));
				}
			});
		//END OF EVENTS
			
		setVisible(true);
	}
}
