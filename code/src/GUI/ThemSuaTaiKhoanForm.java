package GUI;

import BUS.User_BUS;
import DTO.User;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThemSuaTaiKhoanForm extends JFrame {
private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
private Date date = new Date();
    String manv;
    String type;
    User_BUS qltkBUS = new User_BUS();
    User tkSua;

    JTextField txUsername = new JTextField(15);
    JTextField txPassword = new JTextField(15);
    JTextField txMaNV = new JTextField(15);

    MoreButton btnChonNhanVien = new MoreButton();

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");

    public ThemSuaTaiKhoanForm(String _type, String _username, String manv) {
        this.setLayout(new BorderLayout());
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.type = _type;
        this.manv = manv;

        // inputs
        txUsername.setBorder(BorderFactory.createTitledBorder("Tên tài khoản"));
        txPassword.setBorder(BorderFactory.createTitledBorder("Mật khẩu"));
        txMaNV.setBorder(BorderFactory.createTitledBorder(" "));
        txMaNV.setEditable(false);
        JPanel plChonNhanVien = new JPanel();
        plChonNhanVien.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        plChonNhanVien.add(txMaNV);
        plChonNhanVien.add(btnChonNhanVien);


        JPanel plInput = new JPanel();
        plInput.add(txUsername);
        plInput.add(txPassword);
        plInput.add(plChonNhanVien);

        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm tài khoản");

            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/icons/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa tài khoản");
            for (User tk : qltkBUS.getArrayList()) {
                if (tk.getUserName().equals(_username)) {
                    this.tkSua = tk;
                }
            }
            if (this.tkSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy tài khoản");
                this.dispose();
            }

            txUsername.setText(this.tkSua.getUserName());
            txUsername.setEditable(false);
            txPassword.setText(this.tkSua.getPassword());
            txMaNV.setText(this.tkSua.getMaNV());

            btnSua.setIcon(new ImageIcon(this.getClass().getResource("/icons/icons8_support_30px.png")));
            plButton.add(btnSua);
        }
        
        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/icons/icons8_cancel_30px_1.png")));
        plButton.add(btnHuy);

        this.add(plInput, BorderLayout.CENTER);
        this.add(plButton, BorderLayout.SOUTH);

        // mouse listener
        btnThem.addActionListener((ae) -> {
            btnThemMouseClicked();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaMouseClicked();
        });
        btnHuy.addActionListener((ae) -> {
            this.dispose();
        });
        btnChonNhanVien.addActionListener((ae) -> {
            ChonNhanVienForm cnv = new ChonNhanVienForm(txMaNV);
        });

        this.setVisible(true);
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String username = txUsername.getText();
            String pass = txPassword.getText();
            String manv = txMaNV.getText();
            
            User user = new User(username, pass, null, null, null, null, df.format(date), manv);
            
            if (qltkBUS.Insert(user)) {
                JOptionPane.showMessageDialog(this, "Thêm " + username + " thành công!");
                this.dispose();
            }
        }
    }

    private void btnSuaMouseClicked() {
        if (checkEmpty()) {
            if(manv.equals("")){
                JOptionPane.showMessageDialog(null, "Không thể thêm nhân viên vào tài khoản khách hàng", "ERROR", JOptionPane.ERROR_MESSAGE);
                this.dispose();
                return;
            }
            String username = txUsername.getText();
            String pass = txPassword.getText();
            String manv = txMaNV.getText();
            

            if (qltkBUS.update(username, pass, manv)) {
                JOptionPane.showMessageDialog(this, "Sửa " + username + " thành công!");
                this.dispose();
            }
        }
    }

    private Boolean checkEmpty() {
        String username = txUsername.getText();
        String pass = txPassword.getText();
        String manv = txMaNV.getText();

        if (username.trim().equals("")) {
            return showErrorTx(txUsername, "Tên đăng nhập không được để trống");

        } else if (pass.equals("")) {
            return showErrorTx(txPassword, "Mật khẩu không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(txMaNV, "Mã nhân viên không được để trống");

        }

        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
