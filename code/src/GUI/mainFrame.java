package GUI;

import BUS.Role_BUS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import titleCustom.BorderPanel;

public class mainFrame extends JFrame {
        private static String manv;
	private JPanel contentPane;
        private JPanel management_top;
	public  JPanel body;
        private JPanel thongke;
	private JPanel sanpham;
	private JPanel employee;
        private JPanel customer;
        private JPanel bill;
        private JPanel quyen;
        private JPanel theloai;
        private JPanel tk;
        private JPanel bh;
        private JPanel nh;
        private JPanel pn;
        private JPanel ncc;
        private JLabel thongke_active,sanpham_active, customer_active,employee_active,bill_active,theloai_active,qlq_active,qltk_active, bh_active, nh_active, pn_active, ncc_active;
        private Role_BUS r_bus = new Role_BUS();
	/**
	 * Launch the application.
	 */
        public static String getManv(){
            return manv;
        }

	/**
	 * Create the frame.
	 */
	public mainFrame(String manv) {
            this.manv=manv;
                boolean[] check = new boolean[15];
                boolean[] checkH = new boolean[15];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setUndecorated(true);
		setSize(1800, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
                BorderPanel custom = new BorderPanel(this);
                JPanel title_decorated = custom.getCustomPanel();
                title_decorated.setBackground(Color.white);
                JLabel lbl_title = new JLabel("QUẢN LÝ ADMIN");
                lbl_title.setFont(new Font("Arial", Font.PLAIN, 25));
                title_decorated.add(lbl_title,BorderLayout.WEST);
                add(title_decorated,BorderLayout.NORTH);
                contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane,BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		JPanel management = new JPanel();
                management.setPreferredSize(new Dimension(300,1020));
                JScrollPane scroll = new JScrollPane(management,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                //scroll.setPreferredSize(new Dimension(300,1000));
		management.setBackground(new Color(82, 83, 81));
                scroll.setBounds(0, 0, 300, 960);
                scroll.getVerticalScrollBar().setUnitIncrement(16);
                contentPane.add(scroll);
                management.setLayout(null); 
                
                management_top = new JPanel();
                management_top.setBackground(null);
                management_top.setBounds(0, 0, 300, 70);
                management_top.setPreferredSize(new Dimension(300,70));
                /*JLabel managementTitle = new JLabel("Quản Lý Admin");
                managementTitle.setForeground(new Color(255, 255, 255));
                managementTitle.setFont(new Font("Arial", Font.BOLD, 30));
                managementTitle.setBounds(0, 0, 300, 30);*/
                JButton logout = new JButton("Đăng xuất",new ImageIcon(this.getClass().getResource("/icons/logout.png")));
                logout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                       if(JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?", "LOGOUT", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                           new GUI_Bandt.DangNhap().setVisible(true);
                           dispose();
                           JOptionPane.showMessageDialog(null, "Đăng xuất thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                       }
                    }
                });
                logout.setBounds(10, 5, 260, 60);
                logout.setFont(new Font("Arial", Font.PLAIN, 25));
                //logout.setBackground(Color.white);
                //management_top.add(managementTitle);
                management_top.add(logout);
                management_top.setLayout(null);
		management.add(management_top);
                
		//Thống kê
		thongke = new JPanel();
		thongke.setBackground(new Color(76, 175, 80));
		thongke.setBounds(10, 88, 260, 66);
		management.add(thongke);
		thongke.setLayout(null);
		
		JLabel chart_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/chart.png")));
		chart_left.setBounds(37, 11, 46, 50);
		thongke.add(chart_left);
		
		JLabel chart_right = new JLabel("Thống Kê");
		chart_right.setForeground(new Color(255, 255, 255));
		chart_right.setFont(new Font("Arial", Font.PLAIN, 25));
		chart_right.setBounds(97, 11, 200, 50);
		thongke.add(chart_right);
                
                thongke_active = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		thongke_active.setEnabled(false);
		thongke_active.setBounds(3, 23, 32, 26);
		thongke.add(thongke_active);
		//
                
                //Sản phẩm
		sanpham = new JPanel();
		sanpham.setBackground(new Color(76, 175, 80));
		sanpham.setLayout(null);
		sanpham.setBounds(10, 165, 260, 66);
		management.add(sanpham);
                
                
		
		JLabel fight_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/48x48.png")));
		fight_left.setBounds(37, 11, 46, 50);
		sanpham.add(fight_left);
		
		JLabel flight_right = new JLabel("Sản Phẩm");
		flight_right.setForeground(new Color(255, 255, 255));
		flight_right.setFont(new Font("Arial", Font.PLAIN, 25));
		flight_right.setBounds(97, 11, 200, 50);
		sanpham.add(flight_right);
		
		sanpham_active = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		sanpham_active.setEnabled(false);
		sanpham_active.setBounds(0, 23, 32, 26);
		sanpham.add(sanpham_active);
                
                if(!r_bus.checkRole(manv, "sanPham")) {
                    for(int i=0;i<sanpham.getComponentCount();i++) sanpham.getComponent(i).setEnabled(false);
                }
		//
		
		//Khánh hàng
		customer = new JPanel();
		customer.setBackground(new Color(76, 175, 80));
		customer.setLayout(null);
		customer.setBounds(10, 242, 260, 66);
		management.add(customer);
		
		customer_active = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		customer_active.setBounds(3, 23, 32, 26);
		customer_active.setEnabled(false);
		customer.add(customer_active);
		
		JLabel customer_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/customer.png")));
		customer_left.setBounds(37, 11, 46, 50);
		customer.add(customer_left);
		
		JLabel customer_right = new JLabel("Khách Hàng");
		customer_right.setForeground(new Color(255, 255, 255));
		customer_right.setFont(new Font("Arial", Font.PLAIN, 25));
		customer_right.setBounds(97, 11, 200, 50);
		customer.add(customer_right);
                
                if(!r_bus.checkRole(manv, "khachHang")){
                    for(int i=0;i<customer.getComponentCount();i++) customer.getComponent(i).setEnabled(false);
                }
		//
                
                //Nhân viên
		employee = new JPanel();
		employee.setBackground(new Color(76, 175, 80));
		employee.setLayout(null);
		employee.setBounds(10, 319, 260, 66);
		management.add(employee);
		
		JLabel employee_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/employee.png")));
		employee_left.setBounds(37, 11, 46, 50);
		employee.add(employee_left);
		
		JLabel employee_right = new JLabel("Nhân Viên");
		employee_right.setForeground(new Color(255, 255, 255));
		employee_right.setFont(new Font("Arial", Font.PLAIN, 25));
		employee_right.setBounds(96, 11, 200, 50);
		employee.add(employee_right);
		
		employee_active = new JLabel("");
		employee_active.setEnabled(false);
		employee_active.setHorizontalAlignment(SwingConstants.CENTER);
		employee_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		employee_active.setBounds(3, 23, 32, 26);
		employee.add(employee_active);
                
                if(!r_bus.checkRole(manv, "nhanVien")) for(int i=0;i<employee.getComponentCount();i++) employee.getComponent(i).setEnabled(false);
		//
                
                //Hóa đơn
		bill = new JPanel();
		bill.setBackground(new Color(76, 175, 80));
		bill.setLayout(null);
		bill.setBounds(10, 396, 260, 66);
		management.add(bill);
		
		JLabel bill_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/bill.png")));
		bill_left.setBounds(37, 11, 46, 50);
		bill.add(bill_left);
		
		JLabel bill_right = new JLabel("Hóa Đơn");
		bill_right.setForeground(new Color(255, 255, 255));
		bill_right.setFont(new Font("Arial", Font.PLAIN, 25));
		bill_right.setBounds(97, 11, 200, 50);
		bill.add(bill_right);
		
		bill_active = new JLabel("");
		bill_active.setEnabled(false);
		bill_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		bill_active.setHorizontalAlignment(SwingConstants.CENTER);
		bill_active.setBounds(3, 23, 32, 26);
		bill.add(bill_active);
                
                if(!r_bus.checkRole(manv, "hoaDon")) for(int i=0;i<bill.getComponentCount();i++) bill.getComponent(i).setEnabled(false);
		//
		//Thể loại
                theloai = new JPanel();
		theloai.setBackground(new Color(76, 175, 80));
		theloai.setLayout(null);
		theloai.setBounds(10, 473, 260, 66);
		management.add(theloai);
		
		JLabel theloai_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/theloai.png")));
		theloai_left.setBounds(37, 11, 46, 50);
		theloai.add(theloai_left);
		
		JLabel theloai_right = new JLabel("Thể Loại");
		theloai_right.setForeground(new Color(255, 255, 255));
		theloai_right.setFont(new Font("Arial", Font.PLAIN, 25));
		theloai_right.setBounds(97, 11, 200, 50);
		theloai.add(theloai_right);
		
		theloai_active = new JLabel("");
		theloai_active.setEnabled(false);
		theloai_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		theloai_active.setHorizontalAlignment(SwingConstants.CENTER);
		theloai_active.setBounds(3, 23, 32, 26);
		theloai.add(theloai_active);
                
                if(!r_bus.checkRole(manv, "theLoai")) for(int i=0;i<theloai.getComponentCount();i++) theloai.getComponent(i).setEnabled(false);
                //
                //Phân quyền
                quyen = new JPanel();
		quyen.setBackground(new Color(102, 51, 153));
		quyen.setLayout(null);
		quyen.setBounds(10, 550, 260, 66);
		management.add(quyen);
		
		JLabel qlq_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/quyen.png")));
		qlq_left.setBounds(37, 11, 46, 50);
		quyen.add(qlq_left);
                
                JLabel qlq_right = new JLabel("Phân quyền");
		qlq_right.setForeground(new Color(255, 255, 255));
		qlq_right.setFont(new Font("Tahoma", Font.PLAIN, 25));
		qlq_right.setBounds(97, 11, 200, 50);
		quyen.add(qlq_right);
		
                qlq_active = new JLabel("");
		qlq_active.setEnabled(false);
		qlq_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		qlq_active.setHorizontalAlignment(SwingConstants.CENTER);
		qlq_active.setBounds(3, 23, 32, 26);
		quyen.add(qlq_active);
                //
                //Tài khoản
                tk = new JPanel();
		tk.setBackground(new Color(102, 51, 153));
		tk.setLayout(null);
		tk.setBounds(10, 627, 260, 66);
		management.add(tk);
		
		JLabel qltk_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/taikhoan.png")));
		qltk_left.setBounds(37, 11, 46, 50);
		tk.add(qltk_left);
                
                JLabel qltk_right = new JLabel("Tài khoản");
		qltk_right.setForeground(new Color(255, 255, 255));
		qltk_right.setFont(new Font("Tahoma", Font.PLAIN, 25));
		qltk_right.setBounds(97, 11, 200, 50);
		tk.add(qltk_right);
		
                qltk_active = new JLabel("");
		qltk_active.setEnabled(false);
		qltk_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		qltk_active.setHorizontalAlignment(SwingConstants.CENTER);
		qltk_active.setBounds(3, 23, 32, 26);
		tk.add(qltk_active);
                
                if(!r_bus.checkRole(manv, "taiKhoan")) for(int i=0;i<tk.getComponentCount();i++) tk.getComponent(i).setEnabled(false);
                //
                //Bán hàng
                bh = new JPanel();
		bh.setBackground(new Color(102, 51, 153));
		bh.setLayout(null);
		bh.setBounds(10, 704, 260, 66);
		management.add(bh);
		
		JLabel bh_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/banhang.png")));
		bh_left.setBounds(37, 11, 46, 50);
		bh.add(bh_left);
                
                JLabel bh_right = new JLabel("Bán hàng");
		bh_right.setForeground(new Color(255, 255, 255));
		bh_right.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bh_right.setBounds(97, 11, 200, 50);
		bh.add(bh_right);
		
                bh_active = new JLabel("");
		bh_active.setEnabled(false);
		bh_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		bh_active.setHorizontalAlignment(SwingConstants.CENTER);
		bh_active.setBounds(3, 23, 32, 26);
		bh.add(bh_active);
                
                if(!r_bus.checkRole(manv, "banHang")) for(int i=0;i<bh.getComponentCount();i++) bh.getComponent(i).setEnabled(false);
                
                //
                //Nhập hàng
                nh = new JPanel();
		nh.setBackground(new Color(102, 51, 153));
		nh.setLayout(null);
		nh.setBounds(10, 781, 260, 66);
		management.add(nh);
		
		JLabel nh_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/nhaphang.png")));
		nh_left.setBounds(37, 11, 46, 50);
		nh.add(nh_left);
                
                JLabel nh_right = new JLabel("Nhập hàng");
		nh_right.setForeground(new Color(255, 255, 255));
		nh_right.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nh_right.setBounds(97, 11, 200, 50);
		nh.add(nh_right);
		
                nh_active = new JLabel("");
		nh_active.setEnabled(false);
		nh_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		nh_active.setHorizontalAlignment(SwingConstants.CENTER);
		nh_active.setBounds(3, 23, 32, 26);
		nh.add(nh_active);
                if(!r_bus.checkRole(manv, "nhapHang")) for(int i=0;i<nh.getComponentCount();i++) nh.getComponent(i).setEnabled(false);
                
                //
                //Phiếu nhập
                pn = new JPanel();
		pn.setBackground(new Color(102, 51, 153));
		pn.setLayout(null);
		pn.setBounds(10, 858, 260, 66);
		management.add(pn);
		
		JLabel pn_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/phieunhap.png")));
		pn_left.setBounds(37, 11, 46, 50);
		pn.add(pn_left);
                
                JLabel pn_right = new JLabel("Phiếu nhập");
		pn_right.setForeground(new Color(255, 255, 255));
		pn_right.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pn_right.setBounds(97, 11, 200, 50);
		pn.add(pn_right);
		
                pn_active = new JLabel("");
		pn_active.setEnabled(false);
		pn_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		pn_active.setHorizontalAlignment(SwingConstants.CENTER);
		pn_active.setBounds(3, 23, 32, 26);
		pn.add(pn_active);
                
                if(!r_bus.checkRole(manv, "phieuNhap")) for(int i=0;i<pn.getComponentCount();i++) pn.getComponent(i).setEnabled(false);
                //
                //Nhà cung cấp
                ncc = new JPanel();
		ncc.setBackground(new Color(102, 51, 153));
		ncc.setLayout(null);
		ncc.setBounds(10, 935, 260, 66);
		management.add(ncc);
		
		JLabel ncc_left = new JLabel(new ImageIcon(mainFrame.class.getResource("/icons/nhacungcap.png")));
		ncc_left.setBounds(37, 11, 46, 50);
		ncc.add(ncc_left);
                
                JLabel ncc_right = new JLabel("Nhà cung cấp");
		ncc_right.setForeground(new Color(255, 255, 255));
		ncc_right.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ncc_right.setBounds(97, 11, 200, 50);
		ncc.add(ncc_right);
		
                ncc_active = new JLabel("");
		ncc_active.setEnabled(false);
		ncc_active.setIcon(new ImageIcon(mainFrame.class.getResource("/icons/arrow.png")));
		ncc_active.setHorizontalAlignment(SwingConstants.CENTER);
                ncc_active.setBounds(3, 23, 32, 26);
		ncc.add(ncc_active);
                //
                
                
                
		
		
		
		body = new JPanel();
                body.setBackground(new Color(2, 5, 9));                
		body.setBounds(300, 0, 1495, 960);
		contentPane.add(body);
		body.setLayout(null);
		
                java.util.Timer timer = new java.util.Timer();
                timer.scheduleAtFixedRate(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        if(!check[0]&&!checkH[0]) thongke.setBackground(new Color(76, 175, 80));
                        if(!check[1]&&!checkH[1]) sanpham.setBackground(new Color(76, 175, 80));
                        if(!check[2]&&!checkH[2]) customer.setBackground(new Color(76, 175, 80));
                        if(!check[3]&&!checkH[3]) employee.setBackground(new Color(76, 175, 80));
                        if(!check[4]&&!checkH[4]) bill.setBackground(new Color(76, 175, 80));
                        if(!check[5]&&!checkH[5]) theloai.setBackground(new Color(76, 175, 80));
                        if(!check[6]&&!checkH[6]) quyen.setBackground(new Color(76, 175, 80));
                        if(!check[7]&&!checkH[7]) tk.setBackground(new Color(76, 175, 80));
                        if(!check[8]&&!checkH[8]) bh.setBackground(new Color(76, 175, 80));
                        if(!check[9]&&!checkH[9]) nh.setBackground(new Color(76, 175, 80));
                        if(!check[10]&&!checkH[10]) pn.setBackground(new Color(76, 175, 80));
                        if(!check[11]&&!checkH[11]) ncc.setBackground(new Color(76, 175, 80));
                    }
                }, 0, 200);
                
		//EVENTS
			//CHART'S EVENTS
				thongke.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[0]=true;
						thongke.setBackground(new Color(96, 100, 191));
						thongke.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[0]=false;
                                                if(!check[0]) thongke.setBackground(new Color(76, 175, 80));
					}
                                        @Override
					public void mouseClicked(MouseEvent e) {    
                                                for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[0] = true;
						// TODO Auto-generated method stub
						body.removeAll();
						body.add(new Statistic_Frame(1495));
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(true);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
                                                
				});
			//END OF CHART'S EVENTS
				
			//FLIGHT'S EVENTS
                        if(r_bus.checkRole(manv, "sanPham")){
				sanpham.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[1]=true;
						sanpham.setBackground(new Color(96, 100, 191));
						sanpham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[1]=false;
						if(!check[1]) sanpham.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[1] = true;
                                                
						// TODO Auto-generated method stub
						body.removeAll();
						body.add(new Product_Frame(1495));
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(true);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                        }
                        if(r_bus.checkRole(manv, "khachHang")){
                                customer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[2]=true;
						customer.setBackground(new Color(96, 100, 191));
						customer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[2]=false;
						if(!check[2]) customer.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[2] = true;
						// TODO Auto-generated method stub
						body.removeAll();
						body.add(new Customer_Frame(1495));
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(true);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                        }
                        if(r_bus.checkRole(manv, "nhanVien")) {
                                employee.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[3]=true;
						employee.setBackground(new Color(96, 100, 191));
						employee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[3]=false;
						if(!check[3]) employee.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[3] = true;
						// TODO Auto-generated method stub
						body.removeAll();
						body.add(new Employee_Frame(1495));
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(true);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                        }
                        if(r_bus.checkRole(manv, "hoaDon")) {
                                bill.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[4]=true;
						bill.setBackground(new Color(96, 100, 191));
						bill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[4]=false;
						if(!check[4]) bill.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[4] = true;
						// TODO Auto-generated method stub
						body.removeAll();
						body.add(new Bill_Frame(1495));
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(true);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                        }
                        if(r_bus.checkRole(manv, "theLoai")){
                                theloai.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[5]=true;
						theloai.setBackground(new Color(96, 100, 191));
						theloai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[5]=false;
						if(!check[5]) theloai.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[5] = true;
						// TODO Auto-generated method stub
						body.removeAll();
						body.add(new Theloai_Frame(1495));
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(true);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                        }
                                quyen.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[6]=true;
						quyen.setBackground(new Color(96, 100, 191));
						quyen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[6]=false;
						if(!check[6]) quyen.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[6] = true;
						// TODO Auto-generated method stub
						body.removeAll();
                                                body.setLayout(new BorderLayout());
						body.add(new QuanLyQuyenForm(manv),BorderLayout.CENTER);
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(true);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                                if(r_bus.checkRole(manv, "taiKhoan")) {
                                tk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[7]=true;
						tk.setBackground(new Color(96, 100, 191));
						tk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[7]=false;
						if(!check[7]) tk.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[7] = true;
						// TODO Auto-generated method stub
						body.removeAll();
                                                body.setLayout(new BorderLayout());
						body.add(new QuanLyTaiKhoanForm(manv),BorderLayout.CENTER);
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(true);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                                }
                                if(r_bus.checkRole(manv, "banHang")) {
                                bh.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[8]=true;
						bh.setBackground(new Color(96, 100, 191));
						bh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[8]=false;
						if(!check[8]) bh.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[8] = true;
						// TODO Auto-generated method stub
						body.removeAll();
                                                body.setLayout(new BorderLayout());
						body.add(new BanHangForm(1495,960),BorderLayout.CENTER);
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(true);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                                }
                                if(r_bus.checkRole(manv, "nhapHang")) {
                                nh.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[9]=true;
						nh.setBackground(new Color(96, 100, 191));
						nh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[9]=false;
						if(!check[9]) nh.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[9] = true;
						// TODO Auto-generated method stub
						body.removeAll();
                                                body.setLayout(new BorderLayout());
						body.add(new NhapHangForm(1495,960),BorderLayout.CENTER);
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(true);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(false);
					}
				});
                                }
                                if(r_bus.checkRole(manv, "phieuNhap")) {
                                pn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[10]=true;
						pn.setBackground(new Color(96, 100, 191));
						pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[10]=false;
						if(!check[10]) pn.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[10] = true;
						// TODO Auto-generated method stub
						body.removeAll();
                                                body.setLayout(new BorderLayout());
						body.add(new QuanLyPhieuNhapForm(),BorderLayout.CENTER);
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(true);
                                                ncc_active.setEnabled(false);
					}
				});
                                }
                                
                                ncc.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[11]=true;
						ncc.setBackground(new Color(96, 100, 191));
						ncc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
                                                checkH[11]=false;
						if(!check[11]) ncc.setBackground(new Color(76, 175, 80));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
                                            for(int i=0 ; i<check.length ; i++) check[i]=false;
                                                check[11] = true;
						// TODO Auto-generated method stub
						body.removeAll();
                                                body.setLayout(new BorderLayout());
						body.add(new QuanLyNhaCungCapForm(),BorderLayout.CENTER);
						body.repaint();
						body.revalidate();
						
                                                thongke_active.setEnabled(false);
						sanpham_active.setEnabled(false);
						customer_active.setEnabled(false);
						employee_active.setEnabled(false);
						bill_active.setEnabled(false);
                                                theloai_active.setEnabled(false);
                                                qlq_active.setEnabled(false);
                                                qltk_active.setEnabled(false);
                                                bh_active.setEnabled(false);
                                                nh_active.setEnabled(false);
                                                pn_active.setEnabled(false);
                                                ncc_active.setEnabled(true);
					}
				});
                                
			//END OF FLIGHT EVENTS
				
			
		//END OF EVENTS
	}
	public void close() {
		setVisible(false);
	}
}
                                        

