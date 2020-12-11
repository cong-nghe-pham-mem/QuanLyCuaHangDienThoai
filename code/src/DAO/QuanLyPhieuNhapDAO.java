/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class QuanLyPhieuNhapDAO {

    MySQLConnect connect = new MySQLConnect();

    public QuanLyPhieuNhapDAO() {
    }

    public ArrayList readDB() {
        ArrayList<PhieuNhap> dspn = new ArrayList<>();
        try {
            String qry = "SELECT * FROM phieunhap";
            ResultSet rs = connect.executeQuery(qry);
            if (rs != null) {

                while (rs.next()) {
                    PhieuNhap pn = new PhieuNhap();

                    pn.setMaPN(rs.getString(1));
                    pn.setMaNCC(rs.getString(2));
                    pn.setMaNV(rs.getString(3));
                    pn.setNgayNhap(rs.getDate(4).toLocalDate());
                    pn.setGioNhap(rs.getTime(5).toLocalTime());
                    pn.setTongTien(rs.getFloat(6));
                    dspn.add(pn);
                }
                connect.Close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        }
        return dspn;
    }

    public boolean add(PhieuNhap pn) {
        boolean ok = connect.executeUpdate("INSERT INTO phieunhap(MaPN,MaNCC,MaNV,NgayNhap,GioNhap,TongTien) VALUES ('"
                + pn.getMaPN() + "','"
                + pn.getMaNCC() + "','"
                + pn.getMaNV() + "','"
                + pn.getNgayNhap() + "','"
                + pn.getGioNhap() + "','"
                + pn.getTongTien() + "');");
        return ok;
    }

    public boolean delete(String mapn) {
        if (!connect.executeUpdate("DELETE FROM phieunhap WHERE MaPN='" + mapn + "';")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua phiếu nhập truoc !!!");
            return false;
        }
        return true;
    }

    public boolean update(PhieuNhap pn) {
        boolean ok = connect.executeUpdate("UPDATE phieunhap SET "
                + "MaNCC='" + pn.getMaNCC()
                + "', MaNV='" + pn.getMaNV()
                + "', NgayNhap='" + pn.getNgayNhap()
                + "', GioNhap='" + pn.getGioNhap()
                + "', TongTien='" + pn.getTongTien()
                + "' WHERE MaPN='" + pn.getMaPN() + "';");
        return ok;
    }

    public boolean updateTongTien(String _mapn, float _tongTien) {
        boolean ok = connect.executeUpdate("UPDATE phieunhap SET TongTien='" + _tongTien + "' WHERE MaPN='" + _mapn + "';");
        return ok;
    }

    public boolean update(String maPN, String maNCC, String maNV, LocalDate ngayNhap, LocalTime gioNhap, float tongTien) {
        PhieuNhap pn = new PhieuNhap();
        pn.setMaPN(maPN);
        pn.setMaNCC(maNCC);
        pn.setMaNV(maNV);
        pn.setNgayNhap(ngayNhap);
        pn.setGioNhap(gioNhap);
        pn.setTongTien(tongTien);
        return update(pn);
    }
}
