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

public class Deals_Frame extends JPanel {
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
	public Deals_Frame(int WIDTH, String maKH) {
		this.WIDTH = WIDTH;
		this.maKH = maKH;
		
		setBounds(new Rectangle(0, 0, WIDTH + 23, 800));
		setLayout(null);
		setBackground(null);
		
		JPanel search = new JPanel();
		search.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tìm Kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 51, 102)));
		search.setBounds(21, 29, WIDTH -23, 87);
		search.setBackground(null);
		add(search);
		search.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Deals_Frame.class.getResource("/icons/search_48px.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 23, 77, 53);
		search.add(lblNewLabel);
		
		search_box = new JTextField();
		search_box.setFont(new Font("Tahoma", Font.PLAIN, 30));
		search_box.setBounds(111, 23, WIDTH -150, 48);
		search_box.setBackground(null);
		search.add(search_box);
		search_box.setColumns(10);
		
		JPanel table = new JPanel();
		table.setBounds(10, 141, WIDTH , 600);
		//model = getData(model);
		JTable own = new JTable(model);
		rowSorter = new TableRowSorter<>(own.getModel());
		own.setRowSorter(rowSorter);
                
		JScrollPane scroll = new JScrollPane(own);
		table.add(scroll);
		add(table);
		table.setLayout(new CardLayout(0, 0));
		
		//EVENTS
			search_box.getDocument().addDocumentListener(new DocumentListener() {
				
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
			});
		//END OF EVENTS
	}
	
	private DefaultTableModel getModel(DefaultTableModel model) {
		Vector name = new Vector();
		name.add("Mã Vé");
		name.add("Họ Khách Hàng");
		name.add("Tên Khách Hàng");
		name.add("Ngày Mua");
		name.add("Thành Tiền");
		model = new DefaultTableModel(name, 0);
		return model;
	}
}
