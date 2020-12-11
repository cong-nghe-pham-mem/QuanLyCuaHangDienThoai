/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ChiTietPhieuNhap;
import BUS.QuanLyChiTietPhieuNhapBUS;
import BUS.Product_BUS;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class HienThiChiTietPN extends FormHienThi {
NumberFormat PriceFormatter = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
    QuanLyChiTietPhieuNhapBUS qlctpn = new QuanLyChiTietPhieuNhapBUS();
    Product_BUS qlspBUS = new Product_BUS();

    JTextField txTim = new JTextField(15);
    JComboBox cbTypeSearch = new JComboBox(new String[]{"Tất cả", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá"});
    JButton btnRefresh = new JButton("Làm mới");
    String mapn;

    public HienThiChiTietPN(String _mapn) {
        setLayout(new BorderLayout());
        this.mapn = _mapn;

        mtb = new MyTable();
        mtb.setHeaders(new String[]{"STT", "Mã phiếu nhập", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"});
        mtb.setAlignment(0, JLabel.CENTER);
        mtb.setAlignment(4, JLabel.CENTER);
        mtb.setAlignment(5, JLabel.RIGHT);
        mtb.setAlignment(6, JLabel.RIGHT);
        mtb.setupSort();
        setDataToTable(qlctpn.getAllChiTiet(mapn), mtb);

        JPanel plHeader = new JPanel();
        JPanel plTim = new JPanel();
        plTim.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txTim.setBorder(BorderFactory.createTitledBorder(" ")); // tạo border rỗng
        plTim.add(cbTypeSearch);
        plTim.add(txTim);
        plHeader.add(plTim);

        btnRefresh.setIcon(new ImageIcon(this.getClass().getResource("/icons/icons8_data_backup_30px.png")));
        plHeader.add(btnRefresh);

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
        btnRefresh.addActionListener((ActionEvent ae) -> {
            refresh();
        });
        this.add(plHeader, BorderLayout.NORTH);
        this.add(mtb, BorderLayout.CENTER);
    }

    public void refresh() {
        qlctpn.readDB();
        setDataToTable(qlctpn.getAllChiTiet(mapn), mtb);
    }

    private void txSearchOnChange() {
        setDataToTable(qlctpn.search(cbTypeSearch.getSelectedItem().toString(), txTim.getText()), mtb);
    }

    private void setDataToTable(ArrayList<ChiTietPhieuNhap> data, MyTable mtb) {
        mtb.clear();
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (ChiTietPhieuNhap pn : data) {
            mtb.addRow(new String[]{
                String.valueOf(stt), 
                pn.getMa(), 
                pn.getMaSP(),
                qlspBUS.getSanPham(pn.getMaSP()).getNameProd(),
                String.valueOf(pn.getSoLuong()), 
                PriceFormatter.format(pn.getDonGia()),
                PriceFormatter.format(pn.getSoLuong() * pn.getDonGia())
            });
            stt++;
        }
    }
}
