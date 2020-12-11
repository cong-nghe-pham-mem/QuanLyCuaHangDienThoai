package GUI;

import BUS.Role_BUS;
import DTO.Role;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HienThiQuyen extends FormHienThi {

    Role_BUS qlqBUS = new Role_BUS();

    JTextField txTim = new JTextField(15);
    JComboBox<String> cbTypeSearch;
    RefreshButton btnRefresh = new RefreshButton();

    // index
    final int MAQUYEN_I = 1, CHITIET_I = 2;

    public HienThiQuyen() {
        setLayout(new BorderLayout());

        mtb = new MyTable();
        mtb.setPreferredSize(new Dimension(1200 - 250, 600));
        mtb.setHeaders(new String[]{"STT", "Mã quyền", "Tên quyền", "Chi tiết quyền"});
        mtb.setColumnsWidth(new double[]{.5, 2, 2, 2});
        mtb.setAlignment(0, JLabel.CENTER);
        mtb.setupSort();
        setDataToTable(qlqBUS.getList(), mtb);

        // ======== search panel ===========
        cbTypeSearch = new JComboBox<>(new String[]{"Tất cả", "Mã quyền", "Tên quyền", "Chi tiết quyền"});

        JPanel plHeader = new JPanel();
        JPanel plTim = new JPanel();
        plTim.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txTim.setBorder(BorderFactory.createTitledBorder(" ")); // tạo border rỗng
        plTim.add(cbTypeSearch);
        plTim.add(txTim);
        plHeader.add(plTim);

        plHeader.add(btnRefresh);

        cbTypeSearch.addActionListener((ActionEvent e) -> {
            txTim.requestFocus();
            if (!txTim.getText().equals("")) {
                txSearchOnChange();
            }
        });

        btnRefresh.addActionListener((ae) -> {
            refresh();
        });

        // https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
        txTim.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                txSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                txSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                txSearchOnChange();
            }
        });

        //=========== add all to this jpanel ===========
        this.add(plHeader, BorderLayout.NORTH);
        this.add(mtb, BorderLayout.CENTER);
    }

    public void refresh() {
        setDataToTable(qlqBUS.getList(), mtb);
    }

    private void txSearchOnChange() {
        setDataToTable(qlqBUS.search(txTim.getText(), cbTypeSearch.getSelectedItem().toString()), mtb);
    }

    private void setDataToTable(ArrayList<Role> data, MyTable table) {
        table.clear();
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (Role q : data) {
            table.addRow(new String[]{
                String.valueOf(stt),
                Integer.toString(q.getRoleID()),
                q.getRoleName(),
                q.getChitiet()});
            stt++;
        }
    }
}
