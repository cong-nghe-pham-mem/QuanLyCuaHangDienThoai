package DAO;

import DTO.CategoryDTO;
import java.sql.*;
import java.util.ArrayList;

import DTO.ProductDTO;

public class Product_DAO {
	private ArrayList <ProductDTO> product;
	private MySQLConnect connect = new MySQLConnect();
	public Product_DAO() {
		
	}
        
        public ProductDTO getSanPham(String masp){
            String sql = "select * from `sản phẩm` where `Mã sản phẩm`="+masp;
            ProductDTO sp = null;
            try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				sp = new ProductDTO();
                                sp.setIdProd(rs.getInt("Mã sản phẩm"));
                                sp.setNameProd(rs.getString("Tên điện thoại"));
                                sp.setDescription(rs.getString("Mô tả"));
                                sp.setPrice(rs.getInt("Giá cả"));
                                sp.setSL(rs.getInt("Số lượng"));
			}
                        connect.Close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return sp;
        }
        
	public ArrayList<CategoryDTO> getTL(){
        ArrayList<CategoryDTO> tl = new ArrayList();
        String sql = "select * from `danh mục`";
        ResultSet rs = connect.executeQuery(sql);
        try {
            while(rs.next()){
                CategoryDTO tldto = new CategoryDTO();
                tldto.setName(rs.getString("Tên Danh mục"));
                tldto.setType(rs.getString("Mã danh mục"));
                tl.add(tldto);
            }
            connect.Close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tl;
    }
	public ArrayList <ProductDTO> listPD(String sql){
		product = new ArrayList <ProductDTO>();
		try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				ProductDTO sp = new ProductDTO();
                                sp.setIdProd(rs.getInt("Mã sản phẩm"));
                                sp.setNameProd(rs.getString("Tên điện thoại"));
                                sp.setDescription(rs.getString("Mô tả"));
                                sp.setPrice(rs.getInt("Giá cả"));
                                sp.setSL(rs.getInt("Số lượng"));
				product.add(sp);
			}
                        connect.Close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public boolean Insert(ProductDTO sp) {
		String sql = "INSERT INTO `sản phẩm` VALUES (";
		sql += "'" + sp.getIdProd() + "', ";
		sql += "'" + sp.getNameProd().replaceAll("'", "''") + "', ";
		sql += "'" + sp.getDescription().replaceAll("'", "''") + "', ";
		sql += "'" + sp.getPrice() + "', ";
		sql += "'" + sp.getSL() + "'";
		sql += ")";
		System.out.println(sql);
		return connect.executeUpdate(sql);
	}
	
	public void Update_PD(ProductDTO sp) {
		String sql = "UPDATE `sản phẩm` SET";
		sql += " `Tên điện thoại` = '" + sp.getNameProd().replaceAll("'", "''") + "', ";
		sql += " `Giá cả` = '" + sp.getPrice() + "', ";
		sql += " `Mô tả` = '" + sp.getDescription().replaceAll("'", "''") + "', ";
		sql += " `Số lượng` = '" + sp.getSL() + "' ";
		sql += " WHERE `Mã sản phẩm` = '" + sp.getIdProd() + "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
	}
	
	public void Delete(String maPD) {
		String sql = "DELETE FROM `sản phẩm` WHERE `Mã sản phẩm` = '" + maPD + "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
	}
        public int getMaxId(){
        int max = 0;
        try {
            String sql = "select max(`Mã sản phẩm`) as max from `sản phẩm`";
            ResultSet rs = connect.executeQuery(sql);
            while(rs.next())
            max = rs.getInt("max");
            connect.Close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return max;
    }
        public boolean updateSoLuong(String masp, int sl){
            String sql = "update `sản phẩm` set `Số lượng`="+sl+" where `Mã sản phẩm`="+masp;
            System.out.print(sql);
            return connect.executeUpdate(sql);
        }
}
