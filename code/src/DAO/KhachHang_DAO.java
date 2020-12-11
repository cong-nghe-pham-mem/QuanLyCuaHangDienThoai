package DAO;

import java.util.ArrayList;
import java.sql.*;

import DTO.KhachHang;

public class KhachHang_DAO {
	private MySQLConnect connect = new MySQLConnect();
	private ArrayList<KhachHang> customer;
	public KhachHang_DAO() {
		
	}
        
        public KhachHang getKhachHang(String makh){
            String sql = "select * from khachhang where maKh='"+makh+"'";
            KhachHang kh = null;
            try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				String maKh		= rs.getString("maKh");
				String tenKH	= rs.getString("tenKH");
				String gender 	= rs.getString("gender");
				String CMND 	= rs.getString("CMND");
				String sdt		= rs.getString("sdt");
				String birthDate = rs.getString("birthDate");
				String maGiamGia = rs.getString("maGiamGia");
				kh = new KhachHang(maKh, tenKH, gender, CMND, sdt, birthDate, maGiamGia);
			}
                        connect.Close();
		}catch(SQLException e) {
			System.out.println("Lỗi SQL: " + e.getClass().getName());
			System.out.println("Thông Báo Lỗi: " + e.getMessage());
			System.out.println("Số Hiệu Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
		}
            return kh;
        }
        public String getMaKH(){
            String sql = "select max(maKH) max from khachhang";
            ResultSet rs = connect.executeQuery(sql);
            String makh = "";
            try {
                while(rs.next()){
                  makh = rs.getString("max");
                }
                connect.Close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            makh = makh.replaceAll("([a-z]|[A-Z])+|_","");
            makh = "KH_" + (Integer.parseInt(makh)+1);
            return makh;
        }
        
	public ArrayList <KhachHang> listKH(String sql){
		customer = new ArrayList <KhachHang>();
		try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				String maKh		= rs.getString("maKh");
				String tenKH	= rs.getString("tenKH");
				String gender 	= rs.getString("gender");
				String CMND 	= rs.getString("CMND");
				String sdt		= rs.getString("sdt");
				String birthDate = rs.getString("birthDate");
				String maGiamGia = rs.getString("maGiamGia");
				KhachHang kh = new KhachHang(maKh, tenKH, gender, CMND, sdt, birthDate, maGiamGia);
				customer.add(kh);
			}
                        connect.Close();
		}catch(SQLException e) {
			System.out.println("Lỗi SQL: " + e.getClass().getName());
			System.out.println("Thông Báo Lỗi: " + e.getMessage());
			System.out.println("Số Hiệu Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
		}
		return customer;
	}
	
	public boolean Insert(KhachHang kh) {
		String sql = "INSERT INTO khachhang VALUES(";
		sql += "'" + kh.getMaKh() + "', ";
		sql += "'" + kh.getTenKH() + "', ";
		sql += "'" + kh.getGender() + "', ";
		sql += "'" + kh.getCMND() + "', ";
		sql += "'" + kh.getSdt() + "', ";
		sql += "'" + kh.getBirthDate() + "', ";
		sql += "'" + kh.getMaGiamGia() + "', ";
		sql += "0)";
		System.out.println(sql);
		return connect.executeUpdate(sql);
	}
	
	public void Update(KhachHang kh) {
		String sql = "UPDATE khachhang SET";
		sql += " maKh = '" + kh.getMaKh() + "', ";
		sql += " tenKH = '" + kh.getTenKH() + "', ";
		sql += " gender = '" + kh.getGender() + "', ";
		sql += " CMND = '" + kh.getCMND() + "', ";
		sql += " sdt = '" + kh.getSdt() + "', ";
		sql += " birthDate = '" + kh.getBirthDate() + "', ";
		sql += " maGiamGia = '" + kh.getMaGiamGia() + "'";
		sql += " WHERE maKh = '" + kh.getMaKh() + "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
	}
	
	public void Delete(String maKH) {
		String sql = "DELETE FROM khachhang WHERE maKh = '" + maKH + "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
	}

 
}
