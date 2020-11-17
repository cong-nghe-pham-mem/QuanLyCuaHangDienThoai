/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.ArrayList;
import DTO.CategoryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class loaiSP_DAO {
    private MySQLConnect connect = new MySQLConnect();
    private CategoryDTO tl;
    private ArrayList<CategoryDTO> tl_list;

    public loaiSP_DAO() {
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
    
    public CategoryDTO getLoaiSanPham(String matl){
        String sql = "select * from `danh mục` where `Mã danh mục`='"+matl+"'";
        CategoryDTO tl = null;
        ResultSet rs = connect.executeQuery(sql);
        try {
            while(rs.next()){
                tl = new CategoryDTO();
                tl.setName(rs.getString("Tên Danh mục"));
                tl.setType(rs.getString("Mã danh mục"));
            }
            connect.Close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tl;
    }
    
    public boolean insert(CategoryDTO tl){
        String sql = "insert into `danh mục` values('"+tl.getType()+"','"+tl.getName()+"')";
        return connect.executeUpdate(sql);
    }
    
    public boolean update(CategoryDTO tl){
        String sql = "update `danh mục` set `Tên Danh mục`='"+tl.getName()+"' where `Mã danh mục`='"+tl.getType()+"'";
        return connect.executeUpdate(sql);
    }
    
    public boolean delete(CategoryDTO tl){
        String sql = "delete from `danh mục` where `Mã danh mục`='"+tl.getType()+"'";
        return connect.executeUpdate(sql);
    }
}
