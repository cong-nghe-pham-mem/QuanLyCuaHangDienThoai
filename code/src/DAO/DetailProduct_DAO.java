package DAO;

import java.util.ArrayList;
import java.sql.*;

import DTO.chitietsanphamDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetailProduct_DAO {
	private ArrayList <chitietsanphamDTO> dtProduct;
	private MySQLConnect connect = new MySQLConnect();
	public DetailProduct_DAO() {
		
	}
	
	public ArrayList <chitietsanphamDTO> listDD(String sql){
		dtProduct = new ArrayList <chitietsanphamDTO>();
		try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				chitietsanphamDTO ctsp = new chitietsanphamDTO(rs.getInt("Mã chi tiết"),rs.getInt("Mã sản phẩm"),rs.getString("Mã danh mục"),rs.getString("Kích thước"),rs.getString("Trọng lượng"),rs.getString("Màu sắc"),rs.getString("Bộ nhớ trong"),rs.getString("Bộ nhớ đệm/Ram"),rs.getString("Hệ điều hành"),rs.getString("Camera trước"),rs.getString("Camera sau"),rs.getString("Pin"),rs.getString("Bảo hành"),rs.getString("Tình trạng"),rs.getString("Hình ảnh"));
                                dtProduct.add(ctsp);
			}
                        connect.Close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dtProduct;
	}
        public boolean insert(chitietsanphamDTO ctsp){
            String sql = "INSERT INTO `chi tiết sản phẩm`(`Mã chi tiết`,`Mã sản phẩm`,`Mã danh mục`,`Kích thước`,`Trọng lượng`,`Màu sắc`,`Bộ nhớ trong`,`Bộ nhớ đệm/Ram`,"
                    + "`Hệ điều hành`,`Camera trước`,`Camera sau`,`Pin`,`Bảo hành`,`Tình trạng`) VALUES (";
            sql += "'" + ctsp.getmachitiet() + "', ";
            sql += "'" + ctsp.getmasanpham() + "', ";
            sql += "'" + ctsp.getmadanhmuc() + "', ";
            sql += "'" + ctsp.getkichthuoc().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.gettrongluong().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.getmausac().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.getbonhotrong().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.getbonhodem().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.gethedieuhanh().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.getcameratruoc().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.getcamerasau().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.getpin().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.getbaohanh().replaceAll("'", "''") + "', ";
            sql += "'" + ctsp.gettinhtrang().replaceAll("'", "''") + "'";
            sql += ")";
            System.out.print(sql);
            return connect.executeUpdate(sql);
        }
         public void update(chitietsanphamDTO ctsp){
            if(!checkExists(ctsp)) insert(ctsp);
            else {
            int masp  = ctsp.getmasanpham();
            String madm = ctsp.getmadanhmuc().replaceAll("'", "''");
            String kich_thuoc =ctsp.getkichthuoc().replaceAll("'", "''");
            String trong_luong =ctsp.gettrongluong().replaceAll("'", "''");
            String mau_sac =ctsp.getmausac().replaceAll("'", "''");
            String bonho_trong =ctsp.getbonhotrong().replaceAll("'", "''");
            String ram =ctsp.getbonhodem().replaceAll("'", "''");
            String he_dieu_hanh =ctsp.gethedieuhanh().replaceAll("'", "''");
            String camera_truoc =ctsp.getcameratruoc().replaceAll("'", "''");
            String camera_sau =ctsp.getcamerasau().replaceAll("'", "''");
            String pin =ctsp.getpin().replaceAll("'", "''");
            String bao_hanh =ctsp.getbaohanh().replaceAll("'", "''");
            String tinh_trang =ctsp.gettinhtrang().replaceAll("'", "''");
            
            String sql = "UPDATE `chi tiết sản phẩm` SET";
		sql += " `Mã danh mục` = '" + madm + "', ";
		sql += " `Kích thước` = '" + kich_thuoc+ "', ";
		sql += " `Trọng lượng` = '" + trong_luong + "', ";
                sql += " `Màu sắc` = '" + mau_sac + "', ";
                sql += " `Bộ nhớ trong` = '" + bonho_trong + "', ";
                sql += " `Bộ nhớ đệm/Ram` = '" + ram + "', ";
                sql += " `Hệ điều hành` = '" + he_dieu_hanh+ "', ";
                sql += " `Camera trước` = '" + camera_truoc + "', ";
                sql += " `Camera sau` = '" + camera_sau + "', ";
                sql += " `Pin` = '" + pin + "', ";
                sql += " `Bảo hành` = '" + bao_hanh + "', ";
                sql += " `Tình trạng` = '" + tinh_trang + "' ";
		sql += "where `Mã sản phẩm` = " + masp;
		System.out.println(sql);
		connect.executeUpdate(sql);
            }
        }
         public boolean checkExists(chitietsanphamDTO ctsp){
             String sql = "SELECT `Mã sản phẩm` from `chi tiết sản phẩm` where `Mã sản phẩm`='"+ctsp.getmasanpham()+"'";
             ResultSet rs = connect.executeQuery(sql);
            try {
                while(rs.next()){
                    connect.Close();
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
         }
         public void upload(String url, int masp){
             String sql = "update `chi tiết sản phẩm` SET `Hình ảnh` = '"+url.replaceAll("'", "''")+"' where `Mã sản phẩm` ='"+masp+"'";
             System.out.print(sql);
             connect.executeUpdate(sql);
         }
}
