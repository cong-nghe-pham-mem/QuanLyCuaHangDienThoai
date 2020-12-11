package GUI;

import BUS.DetailProduct_BUS;
import BUS.loaiSP_BUS;
import BUS.Product_BUS;
import DTO.ProductDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class HienThiSanPham extends FormHienThi {
NumberFormat PriceFormatter = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
    loaiSP_BUS qllspBUS = new loaiSP_BUS();
    Product_BUS qlspBUS = new Product_BUS();
    DetailProduct_BUS qlctspBUS = new DetailProduct_BUS();
    JTextField txTim = new JTextField(15);
    JComboBox<String> cbTypeSearch;
    JButton btnRefresh = new JButton("Làm mới");

    JLabel lbImage = new JLabel();
    JTextField txMaSP = new JTextField(12);
    JTextField txLoaiSP = new JTextField(12);
    JTextField txTenSP = new JTextField(12);
    JTextField txDonGia = new JTextField(12);
    JTextField txSoLuong = new JTextField(7);

    JTextField txSoLuong1 = new JTextField(5);
    JTextField txSoLuong2 = new JTextField(5);
    JTextField txGia1 = new JTextField(6);
    JTextField txGia2 = new JTextField(6);

    // index
    final int MASP_I = 1, MALSP_I = 2, TEN_I = 3, GIA_I = 4, SOLUONG_I = 5;

    public HienThiSanPham() {
        setLayout(new BorderLayout());

        mtb = new MyTable();
        mtb.setPreferredSize(new Dimension(1200 - 250, 600));
        mtb.setHeaders(new String[]{"STT", "Mã sản phẩm", "Mã loại", "Tên", "Đơn giá", "Số lượng", "Hình ảnh"});
        mtb.setColumnsWidth(new double[]{0.5, 1, 1, 2, 1.5, 1, 2});
        mtb.setAlignment(0, JLabel.CENTER);
        mtb.setAlignment(4, JLabel.RIGHT);
        mtb.setAlignment(5, JLabel.CENTER);
        mtb.setAlignment(7, JLabel.CENTER);
        mtb.setupSort();
        setDataToTable(qlspBUS.getArrayList(), mtb);

        // ======== search panel ===========
        JPanel plHeader = new JPanel();

        cbTypeSearch = new JComboBox<>(new String[]{"Mã sản phẩm", "Mã loại", "Tên"});
        JPanel plTim = new JPanel();
        plTim.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txTim.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        plTim.add(cbTypeSearch);
        plTim.add(txTim);
        plHeader.add(plTim);

        // so sánh số lượng
        JPanel plSoSanhSoLuong = new JPanel();
        plSoSanhSoLuong.setBorder(BorderFactory.createTitledBorder("Số lượng"));
        txSoLuong1.setBorder(BorderFactory.createTitledBorder("Từ:"));
        txSoLuong2.setBorder(BorderFactory.createTitledBorder("Tới:"));
        plSoSanhSoLuong.add(txSoLuong1);
        plSoSanhSoLuong.add(txSoLuong2);
        plHeader.add(plSoSanhSoLuong);

        // so sánh giá
        JPanel plSoSanhGia = new JPanel();
        plSoSanhGia.setBorder(BorderFactory.createTitledBorder("Đơn giá"));
        txGia1.setBorder(BorderFactory.createTitledBorder("Từ:"));
        txGia2.setBorder(BorderFactory.createTitledBorder("Tới:"));
        plSoSanhGia.add(txGia1);
        plSoSanhGia.add(txGia2);
        plHeader.add(plSoSanhGia);

        // btn refresh
        btnRefresh.setIcon(new ImageIcon(this.getClass().getResource("/icons/icons8_data_backup_30px.png")));
        plHeader.add(btnRefresh);

        // add action listener
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

        addDocumentListener(txTim);
        addDocumentListener(txSoLuong1);
        addDocumentListener(txSoLuong2);
        addDocumentListener(txGia1);
        addDocumentListener(txGia2);

        mtb.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                String masp = getSelectedRow(1);
                showInfo(masp);
            }
        });

        // panel image ----------- Copy From BanHangForm
        JPanel plImage = new JPanel();
        lbImage.setPreferredSize(new Dimension(250, 250));
        lbImage.setBorder(BorderFactory.createLineBorder(Color.black));
        plImage.add(lbImage);

        JPanel plTextField = new JPanel();
        plTextField.setPreferredSize(new Dimension(400, 250));
        plTextField.setLayout(new FlowLayout());
        plTextField.setBackground(new Color(240, 240, 240));
        // border
        txMaSP.setBorder(BorderFactory.createTitledBorder("Mã sản phẩm"));
        txLoaiSP.setBorder(BorderFactory.createTitledBorder("Loại sản phẩm"));
        txTenSP.setBorder(BorderFactory.createTitledBorder("Tên sản phẩm"));
        txDonGia.setBorder(BorderFactory.createTitledBorder("Đơn giá"));
        txSoLuong.setBorder(BorderFactory.createTitledBorder("Số lượng"));
        // font
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        txMaSP.setFont(f);
        txLoaiSP.setFont(f);
        txTenSP.setFont(f);
        txDonGia.setFont(f);
        txSoLuong.setFont(f);
        // add to panel
        plTextField.add(txMaSP);
        plTextField.add(txLoaiSP);
        plTextField.add(txTenSP);
        plTextField.add(txDonGia);
        plTextField.add(txSoLuong);

        plImage.add(plTextField);

        //=========== add all to this jpanel ===========
        this.add(plHeader, BorderLayout.NORTH);
        this.add(mtb, BorderLayout.CENTER);
        this.add(plImage, BorderLayout.SOUTH);
    }

    public void showInfo(String masp) { // copy from BanHangForm
        // https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel
        if (masp != null) {
            // show hình
            for (DTO.ProductDTO sp : qlspBUS.getArrayList()) {
                if (Integer.toString(sp.getIdProd()).equals(masp)) {
                    for(DTO.chitietsanphamDTO ctsp : qlctspBUS.getList()){
                        if(ctsp.getmasanpham()==sp.getIdProd()){
                    int w = lbImage.getWidth();
                    int h = lbImage.getHeight();
                     try{
         if(ctsp.getFilenamehinhanh().contains(":/")) lbImage.setIcon(new ImageIcon(new ImageIcon(ctsp.getFilenamehinhanh()).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH)));
        else lbImage.setIcon(new ImageIcon(new ImageIcon(Product_Frame.class.getResource("/"+ctsp.getFilenamehinhanh())).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH)));
            } catch(NullPointerException ne){
                
            }

                    // show info
                    String loai = qllspBUS.getLoaiSanPham(ctsp.getmadanhmuc()).getName();
                    txMaSP.setText(Integer.toString(sp.getIdProd()));
                    txTenSP.setText(sp.getNameProd());
                    txLoaiSP.setText(loai + " - " + ctsp.getmadanhmuc());
                    txDonGia.setText(PriceFormatter.format(sp.getPrice()));
                    txSoLuong.setText(String.valueOf(sp.getSL()));
                    return;
                        }
                    }
                }
            }
        }
    }

    private void addDocumentListener(JTextField tx) {
        // https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
        tx.getDocument().addDocumentListener(new DocumentListener() {
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
    }

    public void refresh() {
        setDataToTable(qlspBUS.getArrayList(), mtb);
        txTim.setText("");
        txSoLuong1.setText("");
        txSoLuong2.setText("");
        txGia1.setText("");
        txGia2.setText("");
        lbImage.setIcon(null);
    }

    private void txSearchOnChange() {
        int soluong1 = -1, soluong2 = -1;
        float gia1 = -1, gia2 = -1;

        try {
            soluong1 = Integer.parseInt(txSoLuong1.getText());
            txSoLuong1.setForeground(Color.black);
        } catch (NumberFormatException e) {
            txSoLuong1.setForeground(Color.red);
        }
        try {
            soluong2 = Integer.parseInt(txSoLuong2.getText());
            txSoLuong2.setForeground(Color.black);
        } catch (NumberFormatException e) {
            txSoLuong2.setForeground(Color.red);
        }
        try {
            gia1 = Float.parseFloat(txGia1.getText());
            txGia1.setForeground(Color.black);
        } catch (NumberFormatException e) {
            txGia1.setForeground(Color.red);
        }
        try {
            gia2 = Float.parseFloat(txGia2.getText());
            txGia2.setForeground(Color.black);
        } catch (NumberFormatException e) {
            txGia2.setForeground(Color.red);
        }

        setDataToTable(qlspBUS.search(txTim.getText(),
                cbTypeSearch.getSelectedItem().toString(), soluong1, soluong2, gia1, gia2), mtb);
    }

    private void setDataToTable(ArrayList<ProductDTO> data, MyTable table) {
        table.clear();
        int stt = 1; // lưu số thứ tự dòng hiện tại
       
         for (DTO.ProductDTO sp : data) {
            for(DTO.chitietsanphamDTO ctsp : qlctspBUS.getList()){
                if(ctsp.getmasanpham()==sp.getIdProd()){
                table.addRow(new String[]{
                    Integer.toString(sp.getIdProd()),
                    ctsp.getmadanhmuc(),
                    sp.getNameProd(),
                    PriceFormatter.format(sp.getPrice()),
                    String.valueOf(sp.getSL()),});
                }
            }
        }
    }
}
