/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.CategoryDTO;
import java.util.ArrayList;
/**
 *
 * @author Administrator
 */
public class loaiSP_BUS {

    private DAO.loaiSP_DAO tl_dao = new DAO.loaiSP_DAO();
    private ArrayList<CategoryDTO> tl_list;
    
    public loaiSP_BUS() {
    }
    
    public ArrayList<CategoryDTO> getTL(){
            return tl_dao.getTL();
        }
    
    public CategoryDTO getLoaiSanPham(String matl){
        return tl_dao.getLoaiSanPham(matl);
    }
    
    public boolean insert(CategoryDTO tl){
        return tl_dao.insert(tl);
    }
    
    public boolean update(CategoryDTO tl){
        return tl_dao.update(tl);
    }
    
    public boolean delete(CategoryDTO tl){
        return tl_dao.delete(tl);
    }
}
