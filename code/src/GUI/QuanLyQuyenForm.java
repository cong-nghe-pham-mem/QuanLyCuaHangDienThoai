package GUI;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import BUS.Role_BUS;

public class QuanLyQuyenForm extends JPanel {
    private Role_BUS r_bus = new Role_BUS();
    HienThiQuyen formHienThi = new HienThiQuyen();

    ThemButton btnThem = new ThemButton();
    SuaButton btnSua = new SuaButton();
    XoaButton btnXoa = new XoaButton();
    

    public QuanLyQuyenForm(String manv) {
        setLayout(new BorderLayout());

        // buttons
        if (!r_bus.checkRole(manv, "phanQuyen")) {
            btnThem.setEnabled(false);
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
        }

        JPanel plBtn = new JPanel();
        plBtn.add(btnThem);
        plBtn.add(btnXoa);
        plBtn.add(btnSua);

        this.add(formHienThi, BorderLayout.CENTER);
        this.add(plBtn, BorderLayout.NORTH);

        // actionlistener
        btnThem.addActionListener((ActionEvent ae) -> {
            btnThemMouseClicked();
        });
        btnXoa.addActionListener((ActionEvent ae) -> {
            btnXoaMouseClicked();
        });
        btnSua.addActionListener((ActionEvent ae) -> {
            btnSuaMouseClicked();
            formHienThi.refresh();
        });
    }

    private void btnSuaMouseClicked() {
        String maquyen = formHienThi.getSelectedRow(1);
        if (maquyen != null) {
            ThemSuaQuyenForm suaq = new ThemSuaQuyenForm("Sửa", maquyen);

            // https://stackoverflow.com/questions/4154780/jframe-catch-dispose-event
            suaq.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    formHienThi.refresh();
                }
            });

        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn quyền nào để sửa");
        }
    }

    private void btnXoaMouseClicked() {
        String maquyen = formHienThi.getSelectedRow(1);
        if (maquyen != null) {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa quyền " + maquyen + " ?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                r_bus.delete(maquyen);
                formHienThi.refresh();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn quyền nào để xóa");
        }
    }

    private void btnThemMouseClicked() {
        ThemSuaQuyenForm themq = new ThemSuaQuyenForm("Thêm", "");
        themq.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                formHienThi.refresh();
            }
        });
    }
}
