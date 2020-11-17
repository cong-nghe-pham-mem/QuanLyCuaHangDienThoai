package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

import DTO.ProductDTO;
import BUS.Product_BUS;
import BUS.DetailProduct_BUS;
import DTO.CategoryDTO;
import DTO.chitietsanphamDTO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JComboBox;
import stolenBtn.ThemButton;

public class TheloaiUpdate_Frame extends JFrame {

	//private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	private JPanel contentPane;
	private JTextField matl;
        private JTextField tentl;
        private MyTable mt;
        private BUS.loaiSP_BUS l_bus = new BUS.loaiSP_BUS();
	Font text = new Font("Tahoma", Font.PLAIN, 25);	
	public TheloaiUpdate_Frame(String ma, MyTable mt) {
            this.mt=mt;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(850, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//top
		JLabel lblNewLabel = new JLabel("Mã Thể Loại:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(90, 20, 150, 30);
		contentPane.add(lblNewLabel);
		
		matl = new JTextField();
		matl.setBounds(250, 20, 120, 35);
                matl.setFont(text);
		matl.setEditable(false);
		contentPane.add(matl);                
		matl.setColumns(10);
                matl.setText(ma);
                
                JLabel lbltheloai = new JLabel("Tên Thể Loại:");
		lbltheloai.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltheloai.setFont(new Font("Calibri", Font.BOLD, 25));
		lbltheloai.setBounds(400, 20, 150, 30);
		contentPane.add(lbltheloai);
		
		tentl= new JTextField();
		tentl.setBounds(560, 20, 120, 35);
                tentl.setFont(text);
		tentl.setEditable(true);
		contentPane.add(tentl);		
		tentl.setColumns(10);
		//
                JButton btn_cancle = new JButton("Hủy Bỏ");
		btn_cancle.setBounds(600, 120, 150, 40);
                btn_cancle.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(btn_cancle);
		
		JButton btn_reset = new JButton("Nhập Lại");
		btn_reset.setBounds(350, 120, 150, 40);
                btn_reset.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(btn_reset);
		
		SuaButton btn_save = new SuaButton();
		btn_save.setBounds(100, 120, 150, 40);
                btn_save.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(btn_save);
                
                btn_cancle.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
                btn_reset.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    tentl.setText("");
                }
            });
                
              btn_save.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(tentl.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Tên không được để trống!","WARNING",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    l_bus.update(new CategoryDTO(tentl.getText(), ma));
                    ArrayList<CategoryDTO> data = l_bus.getTL();
                    mt.clear();
                    int stt = 1; // lưu số thứ tự dòng hiện tại
        for (DTO.CategoryDTO q : data) {
            mt.addRow(new String[]{
                String.valueOf(stt),
                q.getType(),
                q.getName()});
            stt++;
            }
                    JOptionPane.showMessageDialog(null, "Sửa thành công","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            });
        }
       
        
}