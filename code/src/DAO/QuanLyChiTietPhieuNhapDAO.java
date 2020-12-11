/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class QuanLyChiTietPhieuNhapDAO {

    MySQLConnect connect = new MySQLConnect();

    public ArrayList<ChiTietPhieuNhap> readDB() {
        ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<>();
        try {

            String query = "SELECT * FROM chitietphieunhap";
            ResultSet r = connect.executeQuery(query);
            if (r != null) {
                while (r.next()) {
                    String ma = r.getString(1);
                    String maSP = r.getString(2);
                    Integer soLuong = r.getInt(3);
                    Float donGia = r.getFloat(4);

                    ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(ma, maSP, soLuong, donGia);
                    dsctpn.add(ctpn);
                }
                connect.Close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thấy data cần tìm trong ResultSet");

        }
        return dsctpn;

    }

    public ArrayList<ChiTietPhieuNhap> search(String columName, String value) {
        ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<>();
        try {

            String query = "SELECT * FROM chitietphieunhap WHERE" + columName + " = '" + value + "'";
            ResultSet r = connect.executeQuery(query);
            if (r != null) {
                while (r.next()) {
                    String ma = r.getString(1);
                    String maSP = r.getString(2);
                    Integer soLuong = r.getInt(3);
                    Float donGia = r.getFloat(4);

                    ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(ma, maSP, soLuong, donGia);
                    dsctpn.add(ctpn);
                }
                connect.Close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thấy data cần tìm trong ResultSet");

        }
        return dsctpn;

    }

    public boolean add(ChiTietPhieuNhap ctpn) {
        boolean ok = connect.executeUpdate("INSERT INTO `chitietphieunhap`(`MaPN`,`MaSP`,`SoLuong`,`DonGia`) VALUE('"
                + ctpn.getMa() + "', '" + ctpn.getMaSP() + "','" + ctpn.getSoLuong() + "','" + ctpn.getDonGia() + "')");
        return ok;

    }

    public boolean deleteAll(String _mapn) {
        boolean success = connect.executeUpdate("DELETE FROM chitietphieunhap WHERE MaPN='" + _mapn + "';");
        return success;
    }

    public boolean delete(String _mapn, String _masp) {
        boolean success = connect.executeUpdate("DELETE FROM chitietphieunhap WHERE MaPN='" + _mapn + "' AND MaSP='" + _masp + "';");
        return success;
    }

    public boolean update(String mapn, String masp, int soluong, float dongia) {
        boolean ok = connect.executeUpdate("UPDATE `chitietphieunhap` SET "
                + "SoLuong='" + soluong
                + "',DonGia='" + dongia
                + "' WHERE MaPN='" + mapn + "' AND MaSP='" + masp + "';");
        return ok;
    }
}
