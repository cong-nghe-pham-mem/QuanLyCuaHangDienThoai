package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import BUS.HoaDon_BUS;
import DTO.OrderDTO;
import DTO.DetailOrDTO;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
public class Bill_Frame extends JPanel {

	/**
	 * Create the panel.
	 */
	private ArrayList <OrderDTO> bill;
	private HoaDon_BUS hd_bus = new HoaDon_BUS();
	private static DefaultTableModel model;
	private Calendar cal = Calendar.getInstance();
	
	private JPanel contentPane;
	private JPanel header;
	private Font title = new Font("Calibri", Font.PLAIN, 30);
	private JPanel function;
	private JPanel left;
	private JComboBox<String> ngaylap_day;
	private JComboBox<String> ngaylap_month;
	private JComboBox<String> ngaylap_year;
	private JTextField priceTo;
	private JTextField priceEnd;
	private Panel data;
	private JTable bill_data;
	private int WIDTH;
	
	public Bill_Frame(int WIDTH) {
		this.WIDTH = WIDTH;
		Init();
	}
	public void Init() {
		setLayout(null);
		setBounds(0, 0, WIDTH, 960);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, WIDTH, 960));
		contentPane.setLayout(null);
		
		JButton btn_detail = new JButton("Xem chi tiết");
		btn_detail.setBounds(25, 300, 193, 39);
		contentPane.add(btn_detail);
		
		header = new JPanel();
		header.setBounds(0, 0, WIDTH, 95);
		contentPane.add(header);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		
		JLabel header_title = new JLabel("QUẢN LÝ HÓA ĐƠN");
		header_title.setFont(title);
		header.add(header_title);
		
		function = new JPanel();
		function.setBounds(0, 96, 744, 238);
		contentPane.add(function);
		function.setLayout(null);
		
		left = new JPanel();
		left.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		left.setBounds(24, 13, 217, 178);
		function.add(left);
		left.setLayout(null);
		
		JButton btn_xetDuyet = new JButton("Xét Duyệt");
		btn_xetDuyet.setFont(new Font("Calibri", Font.PLAIN, 16));
		btn_xetDuyet.setBounds(12, 25, 193, 39);
		left.add(btn_xetDuyet);
		
		JButton btn_update = new JButton("Sửa HĐ");
		btn_update.setFont(new Font("Calibri", Font.PLAIN, 16));
		btn_update.setBounds(12, 75, 193, 39);
		left.add(btn_update);
		
		JButton btn_xoa = new JButton("Xóa HĐ");
		btn_xoa.setFont(new Font("Calibri", Font.PLAIN, 16));
		btn_xoa.setBounds(12, 125, 193, 38);
		left.add(btn_xoa);
		
		JPanel middle = new JPanel();
		middle.setBorder(new TitledBorder(null, "T\u00ECm Ki\u1EBFm C\u01A1 B\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		middle.setBounds(270, 13, 217, 178);
		function.add(middle);
		middle.setLayout(null);
		
		JTextField search_box = new JTextField();
		search_box.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search_box.setHorizontalAlignment(SwingConstants.CENTER);
		search_box.setBounds(12, 25, 190, 30);
		middle.add(search_box);
		search_box.setColumns(10);
		
		JButton search_maHD = new JButton("TK Theo Mã HĐ");
		search_maHD.setFont(new Font("Calibri", Font.PLAIN, 14));
		search_maHD.setBounds(36, 68, 145, 39);
		middle.add(search_maHD);
		
		JButton search_maKH = new JButton("TK Theo Mã KH");
		search_maKH.setFont(new Font("Calibri", Font.PLAIN, 14));
		search_maKH.setBounds(36, 118, 145, 39);
		middle.add(search_maKH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm Ki\u1EBFm N\u00E2ng Cao", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(510, 13, 222, 220);
		function.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ngày Lập: ");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 25, 79, 23);
		panel.add(lblNewLabel);
		
		ngaylap_day = new JComboBox();
		ngaylap_day = getDay(ngaylap_day);
		ngaylap_day.setBounds(22, 54, 45, 22);
		panel.add(ngaylap_day);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(73, 49, 12, 32);
		panel.add(lblNewLabel_1);
		
		ngaylap_month = new JComboBox<String>();
		ngaylap_month = getMonth(ngaylap_month);
		ngaylap_month.setBounds(89, 54, 45, 22);
		panel.add(ngaylap_month);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(140, 49, 12, 32);
		panel.add(label);
		
		ngaylap_year = new JComboBox<String>();
		ngaylap_year = getYear(ngaylap_year);
		ngaylap_year.setBounds(154, 54, 58, 22);
		panel.add(ngaylap_year);
		
		JLabel lblNewLabel_2 = new JLabel("Chọn Giá:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(12, 90, 79, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Từ:");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(12, 111, 30, 27);
		panel.add(lblNewLabel_3);
		
		priceTo = new JTextField();
		priceTo.setBounds(62, 116, 150, 22);
		panel.add(priceTo);
		priceTo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Đến:");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(11, 149, 45, 16);
		panel.add(lblNewLabel_4);
		
		priceEnd = new JTextField();
		priceEnd.setBounds(62, 146, 150, 22);
		panel.add(priceEnd);
		priceEnd.setColumns(10);
		
		JButton filter = new JButton("Lọc");
		filter.setBounds(115, 183, 100, 25);
		panel.add(filter);
		
		data = new Panel();
		data.setBounds(0, 346, WIDTH, 620);
		contentPane.add(data);
		data.setLayout(null);
		
		JPanel bill_table = new JPanel();
		bill_table.setBorder(new TitledBorder(null, "Dữ Liệu Của Hóa Đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bill_table.setBounds(12, 13, WIDTH - 20, 600);
		bill = hd_bus.getArrayList_normal();
		model = getModel(model);
		for(int i = 0; i < bill.size(); i++) {
			int maHD = bill.get(i).getIdOrder();
			int maKH = bill.get(i).getId();
			String ngayLap = bill.get(i).getOrderdate();
			int tongTien = bill.get(i).getTotalmoney();
			Object []data_table = {
					maHD, maKH, ngayLap, tongTien
			};
			System.out.println(data_table);
			model.addRow(data_table);
		}
		
		bill_table.setLayout(new CardLayout(0, 0));
		bill_data = new JTable(model);
		bill_data.setFillsViewportHeight(true);
		bill_data.setDefaultEditor(Object.class, null);
                
                bill_data = new JTable(model);
                                bill_data.setAutoCreateRowSorter(true);
                                bill_data.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				bill_data.setDefaultEditor(Object.class, null);
                                bill_data.setFillsViewportHeight(true);
        bill_data.setFont(new Font("Segoe UI", 0, 16));
        bill_data.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        bill_data.setRowHeight(40);

        // color
        int bgColor = 235;
        int color = 0;
        bill_data.getTableHeader().setBackground(new Color(bgColor, bgColor, bgColor));
        bill_data.getTableHeader().setForeground(new Color(color, color, color));
        bill_data.setBackground(new Color(bgColor, bgColor, bgColor));
        bill_data.setForeground(new Color(color, color, color));
                                double total = 0;
                               DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        bill_data.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                                double[] percentages = new double[]{2,2,2,2};
        for (int i = 0; i < bill_data.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < bill_data.getColumnModel().getColumnCount(); i++) {
            TableColumn column = bill_data.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (getPreferredSize().width * (percentages[i] / total)));
        }
		JScrollPane scroll = new JScrollPane(bill_data);
		
		bill_table.add(scroll);
		data.add(bill_table);
		
		//EVENTS
			btn_xoa.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int []row;
						row = bill_data.getSelectedRows();
					if(row.length != 0) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn xóa hóa đơn ? ", "Cảnh Báo", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							for(int i = 0; i < row.length; i++) {
								hd_bus.Delete(bill_data.getValueAt(row[i]-i, 0).toString());
								model.removeRow(row[i]-i);
							}
							JOptionPane.showMessageDialog(null, "Đã xóa thành công", "Xóa thành công", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
				}
			});
			btn_update.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = -1;
					row = bill_data.getSelectedRow();
					if(row != -1) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật thông tin của hóa đơn có mã " + bill_data.getValueAt(row, 0) + " được sở hữu bởi khách hàng " + bill_data.getValueAt(row, 1),"Cảnh Báo", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							String id = bill_data.getValueAt(row, 0).toString();
							new BillUpdate_Frame(id);
						}
					}
				}
			});
			btn_xetDuyet.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int []row;
					row = bill_data.getSelectedRows();
					if(row.length >= 2) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn xét duyệt các hóa đơn này ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							int dem = 0;
							for(int i = 0; i < row.length; i++) {
								hd_bus.xetDuyet((int) bill_data.getValueAt(row[i]-i, 0));
								model.removeRow(row[i]-i);
								dem++;
							}
							JOptionPane.showMessageDialog(null, "Đã xét duyệt " + dem + " hóa đơn", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
					else if(row.length == 1) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn xét duyệt các hóa đơn này ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							
							hd_bus.xetDuyet((int) bill_data.getValueAt(row[0], 0));
							JOptionPane.showMessageDialog(null, "Đã xét duyệt 1 hóa đơn", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							model.removeRow(row[0]);
							return;
						}
					}	
				}
			});
			//SEARCH CƠ BẢN
				search_maHD.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						bill = hd_bus.search_coban("dh.`Mã đơn hàng`", search_box.getText());
						if(bill.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả cần tìm", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						for(int i = 0; i < bill.size(); i++) {
							int maHD = bill.get(i).getIdOrder();
			int maKH = bill.get(i).getId();
			String ngayLap = bill.get(i).getOrderdate();
			int tongTien = bill.get(i).getTotalmoney();
			Object []data_table = {
					maHD, maKH, ngayLap, tongTien
			};
							System.out.println(data_table);
							model.addRow(data_table);
						}
					}
				});
				search_maKH.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						bill = hd_bus.search_coban("dh.`Mã người dùng`", search_box.getText());
						if(bill.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả cần tìm", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						for(int i = 0; i < bill.size(); i++) {
							int maHD = bill.get(i).getIdOrder();
			int maKH = bill.get(i).getId();
			String ngayLap = bill.get(i).getOrderdate();
			int tongTien = bill.get(i).getTotalmoney();
			Object []data_table = {
					maHD, maKH, ngayLap, tongTien
			};
							model.addRow(data_table);
						}
					}
				});
			//KẾT THÚC SỰ KIỆN SEARCH CƠ BẢN
			
			//SEARCH NÂNG CAO
				filter.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						String to = "";
						String end = "";
						String ngayLap = ngaylap_day.getSelectedItem().toString() + "/" + ngaylap_month.getSelectedItem().toString() + "/" +ngaylap_year.getSelectedItem().toString();
						if(ngayLap.split("/").length == 0) {
							ngayLap = "";
						}
						if(!isNumeric(priceTo.getText()) && !priceTo.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Giá từ không hợp dữ liệu", "Sai dữ liệu giá từ", JOptionPane.ERROR_MESSAGE);
							priceTo.requestFocus();
							return;
						}
						if(!isNumeric(priceEnd.getText()) && !priceEnd.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Giá đến không hợp dữ liệu", "Sai dữ liệu giá đến", JOptionPane.ERROR_MESSAGE);
							priceEnd.requestFocus();
							return;
						}
						bill = hd_bus.search_nangcao(ngayLap, priceTo.getText(), priceEnd.getText());
						for(int i = 0; i < bill.size(); i++) {
							int maHD = bill.get(i).getIdOrder();
			int maKH = bill.get(i).getId();
			String ngayLapHD = bill.get(i).getOrderdate();
			int tongTien = bill.get(i).getTotalmoney();
			Object []data_table = {
					maHD, maKH, ngayLapHD, tongTien
			};
							model.addRow(data_table);
						}
					}
				});
			//KẾT THÚC SỰ KIỆN SEARCH NÂNG CAO
				
			btn_detail.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int []row = bill_data.getSelectedRows();
					if(row.length > 1) {
						JOptionPane.showMessageDialog(null, "Bạn chỉ có thể xem chi tiết của một hóa đơn thôi", "Thông Báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else if(row.length == 1) {
						String id = bill_data.getValueAt(row[0], 0).toString();
                                                ArrayList<DetailOrDTO> cthd = hd_bus.getCTHD(id);
        javax.swing.JPanel ctspPane = new javax.swing.JPanel();
        DefaultTableModel model = new DefaultTableModel();
        javax.swing.JTable ctspTable = new javax.swing.JTable(model){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
             @Override
            public java.awt.Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row, int column) {
            java.awt.Component component = super.prepareRenderer(renderer, row, column);
            int rendererWidth = component.getPreferredSize().width;
            javax.swing.table.TableColumn tableColumn = getColumnModel().getColumn(column);
            tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
            return component;
            }
        };
        ctspTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        String[] columns = {"Mã sản phẩm","Tổng tiền","Số lượng","Tình trạng đơn hàng"};
        model.setColumnIdentifiers(columns);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
        for(int i =0;i<cthd.size();i++){
            if(cthd.get(i).getIdOrder()==(int)bill_data.getValueAt(bill_data.getSelectedRow(), 0)){
                String ttdh = "";
                if(cthd.get(i).getOrderstatus().equals("0")) ttdh = "Đang chờ xử lý";
            model.addRow(new Object[]{
                cthd.get(i).getIdProd(),nf.format(cthd.get(i).getMoney()),cthd.get(i).getSl(),ttdh
            });
            }
        }
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(ctspTable,javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);       
        scrollPane.setPreferredSize(new java.awt.Dimension(ctspTable.getPreferredSize().width,100));        
        ctspPane.setLayout(new java.awt.GridBagLayout());       
        ctspPane.add(scrollPane,new java.awt.GridBagConstraints(0, 0, 1, 1, 1, 1, java.awt.GridBagConstraints.NORTHWEST, java.awt.GridBagConstraints.BOTH, new java.awt.Insets(5, 5, 5, 0), 0, 0));
        ctspPane.addHierarchyListener(new java.awt.event.HierarchyListener() {
            @Override
		public void hierarchyChanged(HierarchyEvent e) {
			java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(ctspPane);
			if (window instanceof java.awt.Dialog) {
				java.awt.Dialog dialog = (java.awt.Dialog) window;
				if (!dialog.isResizable()) {
					dialog.setResizable(true);
				}
			}
		}
	});
        JOptionPane.showMessageDialog(null, ctspPane, "CHI TIẾT HÓA ĐƠN", JOptionPane.INFORMATION_MESSAGE);                     
					}
				}
			});
		//END OF EVENT
		add(contentPane);
	}
	
        public static DefaultTableModel getTModel(){
            return model;
        }
        
	private DefaultTableModel getModel(DefaultTableModel model) {
		Vector columnName = new Vector();
		columnName.add("Mã Hóa Đơn");
		columnName.add("Mã Khách Hàng");
		columnName.add("Ngày Lập");
		columnName.add("Tổng Tiền");
		model = new DefaultTableModel(columnName, 0);
		return model;
	}
	private boolean isNumeric(String a) {
		return a.matches("^[-+]?\\d+(\\.\\d+)?$");
	}
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
}
