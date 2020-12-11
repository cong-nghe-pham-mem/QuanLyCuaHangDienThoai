package DAO;

import java.util.ArrayList;
import java.sql.*;

import DTO.NhanVien;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVien_DAO {
	private MySQLConnect connect = new MySQLConnect();
	private ArrayList <NhanVien> employee;
	
	public NhanVien_DAO() {
		
	}
	
        public NhanVien getNhanVien(String manv){
            String sql = "select * from nhanvien where maNV='"+manv+"'";
            NhanVien nv = null;
            ResultSet rs = connect.executeQuery(sql);
            try {
                while(rs.next()){
                  String maNV		= rs.getString("maNV");
				String tenNV	= rs.getString("tenNV");
				String gender	= rs.getString("gender");
				String sdt		= rs.getString("sdt");
				String CMND		= rs.getString("CMND");
				String chucvu 	= rs.getString("chucvu");
				String birthDate = rs.getString("birthDate");
				String ngayvaolam = rs.getString("ngayvaolam");
				int roleID = rs.getInt("roleID");
				nv = new NhanVien(maNV, tenNV, gender, birthDate, sdt, CMND, chucvu, ngayvaolam, roleID);
                }
                connect.Close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return nv;
        }
        
        public String getMaNV(){
            String sql = "select max(maNV) max from nhanvien";
            ResultSet rs = connect.executeQuery(sql);
            String manv = "";
            try {
                while(rs.next()){
                  manv = rs.getString("max");
                }
                connect.Close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            manv = manv.replaceAll("([a-z]|[A-Z])+|_","");
            manv = "NV_" + (Integer.parseInt(manv)+1);
            return manv;
        }
        
	public ArrayList<NhanVien> listNV(String sql){
		employee = new ArrayList <NhanVien>();
		try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				String maNV		= rs.getString("maNV");
				String tenNV	= rs.getString("tenNV");
				String gender	= rs.getString("gender");
				String sdt		= rs.getString("sdt");
				String CMND		= rs.getString("CMND");
				String chucvu 	= rs.getString("chucvu");
				String birthDate = rs.getString("birthDate");
				String ngayvaolam = rs.getString("ngayvaolam");
				int roleID = rs.getInt("roleID");
				NhanVien nv = new NhanVien(maNV, tenNV, gender, birthDate, sdt, CMND, chucvu, ngayvaolam, roleID);
				employee.add(nv);
			}
                        connect.Close();
		}catch(SQLException e) {
			System.out.println("Lỗi SQL: " + e.getClass().getName());
			System.out.println("Thông Báo Lỗi: " + e.getMessage());
			System.out.println("Số Hiệu Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
		}
		return employee;
	}
	
	public boolean Insert(NhanVien nv) {
		String sql = "INSERT INTO nhanvien VALUES(";
		sql += "'" + nv.getMaNV() + "', ";
		sql += "'" + nv.getTenNV() + "', ";
		sql += "'" + nv.getGender() + "', ";
		sql += "'" + nv.getBirthDate() + "', ";
		sql += "'" + nv.getSdt() + "', ";
		sql += "'" + nv.getCMND() + "', ";
		sql += "'" + nv.getChucvu() + "', ";
		sql += "'" + nv.getNgayvaolam() + "', ";
		sql += "'" + nv.getRoleID() + "', ";
		sql += "0)";
		System.out.println(sql);
		return connect.executeUpdate(sql);
	}
	
	public void Update(NhanVien nv) {
		String sql = "UPDATE nhanvien SET";
		sql += " tenNV = '" + nv.getTenNV() + "', ";
		sql += " gender = '" + nv.getGender() + "', ";
		sql += " birthDate = '" + nv.getBirthDate() + "', ";
		sql += " sdt = '" + nv.getSdt() + "', ";
		sql += " CMND = '" + nv.getCMND() + "', ";
		sql += " chucvu = '" + nv.getChucvu() + "', ";
		sql += " roleID = " + nv.getRoleID() + "";
		sql += " WHERE maNV = '" + nv.getMaNV() + "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
	}
	
	public void Delete(String maNV) {
		String sql = "DELETE FROM nhanvien WHERE maNV = '" + maNV + "'";
		connect.executeUpdate(sql);
	}
}
