/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

;

import DTO.NhaCungCap;
import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */


public class QuanLyNhaCungCapDAO {

    MySQLConnect connect = new MySQLConnect();

//    public QuanLyNhaCungCapDAO(){
//        nhaCungCapDB.logIn("root","");
//    }
    public ArrayList<NhaCungCap> readDB() {
        ArrayList<NhaCungCap> dsncc = new ArrayList<>();
        try {
            String qry = "SELECT * FROM nhacungcap";
            ResultSet r = connect.executeQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String ma = r.getString(1);
                    String ten = r.getString(2);
                    String diachi = r.getString(3);
                    String sdt = r.getString(4);
                    String fax = r.getString(5);

                    dsncc.add(new NhaCungCap(ma, ten, diachi, sdt, fax));
                }
                connect.Close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thấy data cần tìm trong ResultSet");
        }
        return dsncc;
    }

    public ArrayList<NhaCungCap> search(String columnName, String value) {
        ArrayList<NhaCungCap> dsncc = new ArrayList<>();

        try {
            String qry = "SELECT * FROM sanpham WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = connect.executeQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mancc = r.getString(1);
                    String tenncc = r.getString(2);
                    String diachi = r.getString(3);
                    String sdt = r.getString(4);
                    String fax = r.getString(5);
                    dsncc.add(new NhaCungCap(mancc, tenncc, diachi, sdt, fax));
                }
                connect.Close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng sản phẩm");
        }

        return dsncc;
    }

    public boolean add(NhaCungCap ncc) {
        boolean ok = connect.executeUpdate("INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`,`SDT`,`Fax`) VALUES ('"
                + ncc.getMaNCC() + "', '" 
                + ncc.getTenNCC() + "', '" 
                + ncc.getDiaChi() + "','" 
                + ncc.getSDT() + "','" 
                + ncc.getFax() + "');");
        return ok;
    }

    public boolean delete(String mancc) {
        boolean ok = connect.executeUpdate("DELETE FROM `nhacungcap` WHERE `nhacungcap`.`MaNCC` = '" + mancc + "'");
        return ok;
    }

    public boolean update(String ma, String ten, String diachi, String sdt, String fax) {
        boolean ok = connect.executeUpdate("Update NhaCungCap Set MaNCC='" + ma + "',TenNCC='" + ten + "',DiaChi='" + diachi + "',SDT='" + sdt + "',Fax='" + fax + "' where MaNCC='" + ma + "'");
        return ok;
    }


}
