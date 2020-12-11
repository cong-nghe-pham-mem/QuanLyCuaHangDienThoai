package GUI;


import DTO.KhachHang;
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

public class HienThiKhachHang extends FormHienThi {

    BUS.KhachHang_BUS qlkh = new BUS.KhachHang_BUS();

    JTextField txTim = new JTextField(15);
    JComboBox<String> cbTypeSearch;
    JButton btnRefresh = new JButton("Làm mới");

    // index
    final int MAKH_I = 1, TEN_I = 2, DIACHI_I = 3, SDT_I = 4;

    public HienThiKhachHang() {
        setLayout(new BorderLayout());

        mtb = new MyTable();
        mtb.setPreferredSize(new Dimension(1200 - 250, 600));
        mtb.setHeaders(new String[]{"STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "CMND", "Số điện thoại", "Ngày sinh"});
        mtb.setColumnsWidth(new double[]{0.5, 1.5, 3, 1.2, 2.5, 2.5, 2});
        mtb.setAlignment(0, JLabel.CENTER);
        mtb.setAlignment(5, JLabel.CENTER);
        mtb.setupSort();
        setDataToTable(qlkh.getArrayList_normal(), mtb);

        // ======== search panel ===========
        cbTypeSearch = new JComboBox<>(new String[]{"Mã khách hàng", "Tên khách hàng", "CMND", "Số điện thoại"});

        JPanel plHeader = new JPanel();
        JPanel plTim = new JPanel();
        plTim.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txTim.setBorder(BorderFactory.createTitledBorder("Tất cả")); // tạo border rỗng
        plTim.add(cbTypeSearch);
        plTim.add(txTim);
        plHeader.add(plTim);

        btnRefresh.setIcon(new ImageIcon(this.getClass().getResource("/icons/icons8_data_backup_30px.png")));
        plHeader.add(btnRefresh);

        cbTypeSearch.addActionListener((ActionEvent e) -> {
            txTim.setBorder(BorderFactory.createTitledBorder(cbTypeSearch.getSelectedItem().toString()));
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
        setDataToTable(qlkh.getArrayList_normal(), mtb);
    }

    private void txSearchOnChange() {
        setDataToTable(qlkh.search(txTim.getText(), cbTypeSearch.getSelectedItem().toString()), mtb);
    }

    private void setDataToTable(ArrayList<KhachHang> data, MyTable table) {
        table.clear();
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (KhachHang customer : data) {
            String maKH		= customer.getMaKh();
			String tenKH	= customer.getTenKH();
			String gender	= customer.getGender();
			String CMND		= customer.getCMND();
			String sdt		= customer.getSdt();
			String birthDate = customer.getBirthDate();
                table.addRow(new String[]{
                    String.valueOf(stt),
                    maKH, tenKH, gender, CMND, sdt, birthDate
                });
                stt++;
            }
    }
}
