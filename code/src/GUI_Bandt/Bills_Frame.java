package GUI_Bandt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DTO.DetailOrDTO;
import DTO.OrderDTO;
import BUS.DetailProduct_BUS;
import BUS.HoaDon_BUS;

public class Bills_Frame extends JPanel {
	private int WIDTH;
	private String maKH;
	private JTextField search_box;
	private DefaultTableModel model;
	private ArrayList <DetailOrDTO> detail;
	private ArrayList <OrderDTO> bill;
	private DetailProduct_BUS cthd_bus = new DetailProduct_BUS();
	private HoaDon_BUS hd_bus = new HoaDon_BUS();
	private TableRowSorter rowSorter;
	/**
	 * Create the panel.
	 */
	public Bills_Frame(int WIDTH, String maKH) {
		this.WIDTH = WIDTH;
		this.maKH = maKH;
		//THANH TOÁN
		setBounds(new Rectangle(0, 0, WIDTH + 23, 800));
		setLayout(null);
		setBackground(null);
		
		JPanel search = new JPanel();
		search.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chức Năng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 51, 102)));
		search.setBounds(21, 29, WIDTH -23, 87);
		search.setBackground(null);
		add(search);
		search.setLayout(null);
		
                JButton pay = new JButton("THANH TOÁN");
                pay.setBounds(150, 30, 150, 50);
                search.add(pay);
                JButton del = new JButton("XÓA ĐƠN HÀNG");
                del.setBounds(450, 30, 150, 50);
                search.add(del);
		//KẾT THÚC THANH TOÁN
		JPanel table = new JPanel();
		table.setBounds(10, 141, WIDTH , 600);
		//model = getData(model);
                bill = hd_bus.getCart(maKH);
		model = getModel(model);
		for(int i = 0; i < bill.size(); i++) {
			int maHD = bill.get(i).getIdOrder();
			int makh = bill.get(i).getId();
			String ngayLap = bill.get(i).getOrderdate();
			int tongTien = bill.get(i).getTotalmoney();
			Object []data_table = {
					maHD, makh, ngayLap, tongTien
			};
			System.out.println(data_table);
			model.addRow(data_table);
		}
		JTable own = new JTable(model);
		rowSorter = new TableRowSorter<>(own.getModel());
		own.setRowSorter(rowSorter);
                
                own.setDefaultEditor(Object.class, null);
                
		JScrollPane scroll = new JScrollPane(own);
		table.add(scroll);
		add(table);
		table.setLayout(new CardLayout(0, 0));
		
                pay.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int []row;
					row = own.getSelectedRows();
					if(row.length >= 2) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là thanh toán các hóa đơn này ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							int dem = 0;
							for(int i = 0; i < row.length; i++) {
								hd_bus.thanhToan((int) own.getValueAt(row[i]-i, 0));
								model.removeRow(row[i]-i);
								dem++;
							}
							JOptionPane.showMessageDialog(null, "Đã thanh toán " + dem + " hóa đơn", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
					else if(row.length == 1) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn thanh toán các hóa đơn này ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							
							hd_bus.thanhToan((int) own.getValueAt(row[0], 0));
							JOptionPane.showMessageDialog(null, "Đã thanh toán 1 hóa đơn", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
							model.removeRow(row[0]);
							return;
						}
					}	
				}
                });
                del.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int []row;
						row = own.getSelectedRows();
					if(row.length != 0) {
						int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn xóa hóa đơn ? ", "Cảnh Báo", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							for(int i = 0; i < row.length; i++) {
								hd_bus.Delete(own.getValueAt(row[i]-i, 0).toString());
								model.removeRow(row[i]-i);
							}
							JOptionPane.showMessageDialog(null, "Đã xóa thành công", "Xóa thành công", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
                    }
                });
		//EVENTS
                /*search_box.getDocument().addDocumentListener(new DocumentListener() {
                
                @Override
                public void removeUpdate(DocumentEvent e) {
                String text = search_box.getText();
                
                if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
                } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                }
                
                @Override
                public void insertUpdate(DocumentEvent e) {
                String text = search_box.getText();
                
                if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
                } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                }
                
                @Override
                public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                
                }
                });*/
		//END OF EVENTS
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
}
