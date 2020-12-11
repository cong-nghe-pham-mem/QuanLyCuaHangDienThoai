package GUI;

import DTO.DetailOrDTO;
import DTO.OrderDTO;
import DTO.KhachHang;
import Excel.ExportExcel;
import BUS.KhachHang_BUS;
import BUS.HoaDon_BUS;
import PDF.ExportPDF;
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import stolenBtn.ExportExcelButton;
import stolenBtn.ExportPdfButton;

public class Statistic_Frame extends JPanel {
	private ArrayList <KhachHang> customer;
        private ArrayList <OrderDTO> bill;
        private ArrayList <DetailOrDTO> dtbill;
        private HoaDon_BUS hd_bus = new HoaDon_BUS();
	private KhachHang_BUS kh_bus = new KhachHang_BUS();
	private int WIDTH;
	private JPanel header, function, data, bottom;
	private Font title = new Font("Calibri", Font.PLAIN, 28);
	private Font lb = new Font("Tahoma", Font.PLAIN, 16);
	private JTable customer_table;
	private DefaultTableModel model;
	private Calendar cal = Calendar.getInstance();
        private JComboBox<String> ngaydau_day,ngaydau_month,ngaydau_year;
        private JComboBox<String> ngaycuoi_day,ngaycuoi_month,ngaycuoi_year;
	Statistic_Frame(int WIDTH){
		this.WIDTH = WIDTH;
		init();
	}
	public void init() {
		setLayout(null);
		setBackground(null);
		setBounds(0, 0, WIDTH, 960);
		//HEADER
			header = new JPanel();
			header.setBounds(0, 0, WIDTH, 80);
			header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
			JLabel title_header = new JLabel("Thống Kê");
			title_header.setFont(title);
			header.add(title_header);
		//END OF HEADER
		
		//FUNCTION 
			function = new JPanel();
			function.setLayout(null);
			function.setBounds(0, 83, WIDTH, 180);
			//LEFT PANEL
				JPanel left = new JPanel();
				left.setLayout(null);
				left.setBorder(new TitledBorder(null, "Chọn loại Thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				left.setBounds(3, 10, WIDTH - 1050, 170);
				JButton btn_spbc, btn_dt,btn_tk;
                                btn_tk  = new JButton("TK Hóa Đơn");
				btn_spbc = new JButton("TK Sản Phẩm Bán Chạy");
				btn_dt = new JButton("TK Doanh Thu");
                                btn_tk.setBounds(10, 30, 190, 35);
				btn_spbc.setBounds(10, 80, 190, 35);
				btn_dt.setBounds(10, 130, 190, 35);
                                left.add(btn_tk);
				left.add(btn_dt);
				left.add(btn_spbc);
			//END OF LEFT PANEL
				
			//SEARCH PANEL
				JPanel search = new JPanel();
				search.setLayout(null);
				search.setBounds(500, 10, WIDTH - 1050, 170);
				search.setBorder(new TitledBorder(null, "Tìm Kiếm Cơ Bản", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				JTextField search_box = new JTextField();
				search_box.setBounds(20, 28, 175, 30);
				search_box.setHorizontalAlignment(JTextField.CENTER);
				JButton search_maHD, search_LSP;
				search_maHD = new JButton("Tìm Theo Mã Hóa Đơn");
				search_maHD.setBounds(10, 70, 190, 40);
				search_LSP = new JButton("Tìm Theo Loại SP");
				search_LSP.setBounds(10, 120, 190, 40);
				search.add(search_box);
				search.add(search_maHD);
				search.add(search_LSP);
			//END OF SEARCH PANEL
				
			//ADVANCED SEARCH PANEL
				JPanel advanced_search = new JPanel();
				advanced_search.setLayout(null);
				advanced_search.setBounds(1000, 10, WIDTH - 1050, 170);
				advanced_search.setBorder(new TitledBorder(null, "Sắp Xếp Theo Ngày Mua", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
				//ngày đầu
                                JLabel ngaydau_lb = new JLabel("Từ:");
						ngaydau_lb.setFont(lb);
						ngaydau_lb.setBounds(15, 25, 70, 20);
						
						ngaydau_day = new JComboBox<String>();
						ngaydau_month = new JComboBox<String>();
						ngaydau_year = new JComboBox<String>();
						
                                                ngaydau_day = getDay(ngaydau_day);
                                                ngaydau_day.setBounds(25, 55, 50, 25);
						
						ngaydau_month = getMonth(ngaydau_month);
						ngaydau_month.setBounds(80, 55, 50, 25);
						
						ngaydau_year= getYear(ngaydau_year);
						ngaydau_year.setBounds(135, 55, 65, 25);
                                //
                                //ngày cuối
                                JLabel ngaycuoi_lb = new JLabel("Đến:");
						ngaycuoi_lb.setFont(lb);
						ngaycuoi_lb.setBounds(15, 95, 70, 20);
						
						ngaycuoi_day = new JComboBox<String>();
						ngaycuoi_month = new JComboBox<String>();
						ngaycuoi_year = new JComboBox<String>();
						
						ngaycuoi_day = getDay(ngaycuoi_day);
						ngaycuoi_day.setBounds(25, 125, 50, 25);
						
						ngaycuoi_month = getMonth(ngaycuoi_month);
						ngaycuoi_month.setBounds(80, 125, 50, 25);
						
						ngaycuoi_year= getYear(ngaycuoi_year);
						ngaycuoi_year.setBounds(135, 125, 65, 25);
                                //
				advanced_search.add(ngaydau_lb);
                                advanced_search.add(ngaydau_day);
                                advanced_search.add(ngaydau_month);
                                advanced_search.add(ngaydau_year);
                                
                                advanced_search.add(ngaycuoi_lb);
                                advanced_search.add(ngaycuoi_day);
                                advanced_search.add(ngaycuoi_month);
                                advanced_search.add(ngaycuoi_year);
			//END OF ADVANCED SEARCH PANEL
			function.add(left);
			function.add(search);
			function.add(advanced_search);
		//END OF FUNCTION PANEL
		
		//DATA PANEL
			data = new JPanel();
			data.setLayout(null);
			data.setBounds(0, 250, WIDTH, 900);
			//TABLE KHÁCH HÀNG
				JPanel customer_data = new JPanel();
				customer_data.setLayout(new CardLayout());
				customer_data.setBounds(0, 80, WIDTH - 10, 625);
				customer_data.setBorder(new TitledBorder(null, "Dữ Liệu Thống Kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				model = getModel(model);
				model = getRowData(model);
				customer_table = new JTable(model);
                                customer_table.setAutoCreateRowSorter(true);
                                customer_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				customer_table.setDefaultEditor(Object.class, null);
                                customer_table.setFillsViewportHeight(true);
        customer_table.setFont(new Font("Segoe UI", 0, 16));
        customer_table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        customer_table.setRowHeight(40);

        // color
        int bgColor = 235;
        int color = 0;
        customer_table.getTableHeader().setBackground(new Color(bgColor, bgColor, bgColor));
        customer_table.getTableHeader().setForeground(new Color(color, color, color));
        customer_table.setBackground(new Color(bgColor, bgColor, bgColor));
        customer_table.setForeground(new Color(color, color, color));
                                double total = 0;
                               DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        customer_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                                double[] percentages = new double[]{1,2,2,1,2.5,1.2,1.5,1.5,2,0.5};
        for (int i = 0; i < customer_table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < customer_table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = customer_table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (getPreferredSize().width * (percentages[i] / total)));
        }
				JScrollPane scroll = new JScrollPane(customer_table);
				customer_data.add(scroll);
			//KẾT THÚC KHAI BÁO
				
			//CHỨC NĂNG ĐỌC GHI
				JPanel file = new JPanel();
				file.setLayout(null);
				file.setBounds(580, 15, WIDTH - 590, 480);				
				ExportExcelButton writeExcel = new ExportExcelButton();
				ExportPdfButton writePDF = new ExportPdfButton();				
				writeExcel.setBounds(0, 10, 170, 35);
				writePDF.setBounds(300, 10, 170, 35);
				file.add(writeExcel);
				file.add(writePDF);
			//KẾT THÚC KHAI BÁO
			data.add(customer_data);
			data.add(file);
		//END OF DATA PANEL
			
		//EVENTS
                customer_table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(e.getClickCount()==2){
                            int []row = customer_table.getSelectedRows();
                            String id = customer_table.getValueAt(row[0], 0).toString();
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
            if(cthd.get(i).getIdOrder()==(int)customer_table.getValueAt(customer_table.getSelectedRow(), 0)){
                String ttdh = "";
                if(cthd.get(i).getOrderstatus().equals("1")) ttdh = "Đã xử lý";
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
                        } else
                        if(e.getClickCount()==1){                        
                         bill = hd_bus.orderBy("dh.`"+model.getColumnName(customer_table.getSelectedColumn())+"`");
                         if(!bill.isEmpty()) model.setRowCount(0);
						customer = kh_bus.getArrayList_normal();
						NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                for(int j = 0 ; j < bill.size(); j++) {
		for(int i = 0; i < customer.size(); i++) {
                    if(customer.get(i).getMaKh().equals(Integer.toString(bill.get(j).getId()))) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					bill.get(j).getIdOrder(),nf.format(bill.get(j).getTotalmoney()),bill.get(j).getOrderdate(), maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
                    }
		}
                }
                        }
                    }
});
                
			//BUTTON
                                btn_tk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
                                            model.setRowCount(0);
						bill = hd_bus.getArrayList();
		customer = kh_bus.getArrayList_normal();
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                for(int j = 0 ; j < bill.size(); j++) {
		for(int i = 0; i < customer.size(); i++) {
                    if(customer.get(i).getMaKh().equals(Integer.toString(bill.get(j).getId()))) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					bill.get(j).getIdOrder(),nf.format(bill.get(j).getTotalmoney()),bill.get(j).getOrderdate(), maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
                    }
		}
                }
					}
				});
				btn_spbc.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						bill = hd_bus.getListSPBC(10);
		customer = kh_bus.getArrayList_normal();
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                for(int j = 0 ; j < bill.size(); j++) {
		for(int i = 0; i < customer.size(); i++) {
                    if(customer.get(i).getMaKh().equals(Integer.toString(bill.get(j).getId()))) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					bill.get(j).getIdOrder(),nf.format(bill.get(j).getTotalmoney()),bill.get(j).getOrderdate(), maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
                    }
		}
                }
					}
				});
				btn_dt.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						bill = hd_bus.getListDT(50000000);
		customer = kh_bus.getArrayList_normal();
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                for(int j = 0 ; j < bill.size(); j++) {
		for(int i = 0; i < customer.size(); i++) {
                    if(customer.get(i).getMaKh().equals(Integer.toString(bill.get(j).getId()))) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					bill.get(j).getIdOrder(),nf.format(bill.get(j).getTotalmoney()),bill.get(j).getOrderdate(), maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
                    }
		}
                }
					}
				});
			//END OF BUTTONS EVENTS
				
			//NORMAL SEARCH
				search_maHD.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
                                                String startDate = ngaydau_year.getSelectedItem()+"-"+ngaydau_month.getSelectedItem()+"-"+ngaydau_day.getSelectedItem();
                                                String endDate = ngaycuoi_year.getSelectedItem()+"-"+ngaycuoi_month.getSelectedItem()+"-"+ngaycuoi_day.getSelectedItem();
                                                if(startDate.equals("--")) startDate = "";
                                                if(endDate.equals("--")) endDate = "";
                                                bill = hd_bus.searchTK("dh.`Mã đơn hàng`", search_box.getText(), startDate, endDate);
						customer = kh_bus.getArrayList_normal();
						NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                for(int j = 0 ; j < bill.size(); j++) {
		for(int i = 0; i < customer.size(); i++) {
                    if(customer.get(i).getMaKh().equals(Integer.toString(bill.get(j).getId()))) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					bill.get(j).getIdOrder(),nf.format(bill.get(j).getTotalmoney()),bill.get(j).getOrderdate(), maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
                    }
		}
                }
					}
				});
				search_LSP.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
                                                String startDate = ngaydau_year.getSelectedItem()+"-"+ngaydau_month.getSelectedItem()+"-"+ngaydau_day.getSelectedItem();
                                                String endDate = ngaycuoi_year.getSelectedItem()+"-"+ngaycuoi_month.getSelectedItem()+"-"+ngaycuoi_day.getSelectedItem();
                                                if(startDate.equals("--")) startDate = "";
                                                if(endDate.equals("--")) endDate = "";
                                                bill = hd_bus.searchTK("dm.`Tên Danh Mục`", search_box.getText(), startDate, endDate);
						customer = kh_bus.getArrayList_normal();
						NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                for(int j = 0 ; j < bill.size(); j++) {
		for(int i = 0; i < customer.size(); i++) {
                    if(customer.get(i).getMaKh().equals(Integer.toString(bill.get(j).getId()))) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					bill.get(j).getIdOrder(),nf.format(bill.get(j).getTotalmoney()),bill.get(j).getOrderdate(), maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
                    }
                }
                }
					}
				});
			//END OF NORMAL SEARCH
			
			//ADVANCED SEARCH
				
			//END OF ADVANCED SEARCH
				
			//ĐỌC FILE, GHI FILE EXCEL
				writeExcel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						ExportExcel wfe = new ExportExcel();
						try {
							wfe.writeStatistic(customer,bill, "Excel/Thongkedonhang.xlsx");
                                                        JOptionPane.showMessageDialog(null, "Đã xuất file Excel thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e) {
							// TODO Auto-generated catch block
                                                        JOptionPane.showMessageDialog(null, "Xuất file Excel thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
			//KẾT THÚC ĐỌC FILE, GHI FILE EXCEL
				
			//ĐỌC FILE, GHI FILE PDF
				  writePDF.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							ExportPDF wpdf = new ExportPDF();
							try {
								wpdf.writePDFStatics(bill,customer,"PDF/danhsachsanphamtrongkho.pdf");
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (DocumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Đã in ra file PDF thành công ở PDF/danhsachthongke.pdf" , "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						}
					});
			//KẾT THÚC ĐỌC FILE, GHI FILE PDF
		//END OF EVENTS
		add(header);
		add(function);
		add(data);
	}
	private DefaultTableModel getModel(DefaultTableModel model) {
		Vector columnName = new Vector();
                columnName.add("Mã Đơn Hàng");
                columnName.add("Tổng Tiền");
                columnName.add("Ngày Lập");
		columnName.add("Mã Khách Hàng");
		columnName.add("Tên Khách Hàng");
		columnName.add("Giới Tính");
		columnName.add("CMND");
		columnName.add("Số Điện Thoại");
		columnName.add("Ngày Sinh");
		columnName.add("Mã Giảm Giá");
		model = new DefaultTableModel(columnName, 0);
		return model;
	}
	private DefaultTableModel getRowData(DefaultTableModel model) {
                bill = hd_bus.getArrayList();
		customer = kh_bus.getArrayList_normal();
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
                for(int j = 0 ; j < bill.size(); j++) {
		for(int i = 0; i < customer.size(); i++) {
                    if(customer.get(i).getMaKh().equals(Integer.toString(bill.get(j).getId()))) {
			String maKH		= customer.get(i).getMaKh();
			String tenKH	= customer.get(i).getTenKH();
			String gender	= customer.get(i).getGender();
			String CMND		= customer.get(i).getCMND();
			String sdt		= customer.get(i).getSdt();
			String birthDate = customer.get(i).getBirthDate();
			String maGiamGia = customer.get(i).getMaGiamGia();
			Object []data = {
					bill.get(j).getIdOrder(),nf.format(bill.get(j).getTotalmoney()),bill.get(j).getOrderdate(), maKH, tenKH, gender, CMND, sdt, birthDate, maGiamGia
			};
			model.addRow(data);
                    }
		}
                }
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
