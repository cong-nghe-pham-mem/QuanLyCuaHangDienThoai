package GUI;

import BUS.loaiSP_BUS;
import DTO.CategoryDTO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import stolenBtn.ThemButton;

public class TheloaiInsert_Frame extends JFrame {

	//private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	private JPanel contentPane;
	private JTextField matl;
        private JTextField tentl;
        private loaiSP_BUS l_bus = new loaiSP_BUS();
        
	Font text = new Font("Tahoma", Font.PLAIN, 25);	
	public TheloaiInsert_Frame(MyTable mt) {
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
		matl.setEditable(true);
		contentPane.add(matl);                
		matl.setColumns(10);
                
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
		
		ThemButton btn_save = new ThemButton();
		btn_save.setBounds(100, 120, 150, 40);
                btn_save.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(btn_save);

                btn_cancle.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        dispose();
                    }
                });
                
                btn_reset.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        matl.setText("");
                        tentl.setText("");
                    }
                });
                
                btn_save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        CategoryDTO data = new CategoryDTO(tentl.getText(), matl.getText());
                        l_bus.insert(data);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        mt.clear();
                        int stt = 1; // lưu số thứ tự dòng hiện tại
                        for (DTO.CategoryDTO q : l_bus.getTL()) {
                            mt.addRow(new String[]{
                            String.valueOf(stt),
                            q.getType(),
                            q.getName()});
                            stt++;
                            }
                        dispose();
                    }
                });
        }
}