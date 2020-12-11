package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ProductDTO;
import DAO.Product_DAO;
import DTO.CategoryDTO;

public class Product_BUS {
	private ArrayList <ProductDTO> product;
	private Product_DAO sp_dao = new Product_DAO();
	
	public Product_BUS() {
		
	}
        
        public ArrayList<ProductDTO>search(String toSearch, String type, int sl1, int sl2, float gia1, float gia2){
            String sql = "select * from `sản phẩm` sp join `chi tiết sản phẩm` ctsp where ";
            switch(type){
                case "Mã sản phẩm":
                    sql += "sp.`Mã sản phẩm` like '%"+toSearch+"%'";
                    break;
                case "Mã loại":
                    sql += "ctsp.`Mã danh mục` like '%"+toSearch+"%'";
                    break;
                case "Tên":
                    sql += "sp.`Tên điện thoại` like '%"+toSearch+"%'";
                    break;
            }
            if(sl1!=-1&&sl2!=-1) sql += " and (sp.`Số lượng` between "+sl1+" and "+sl2+")";
            if(gia1!=-1&&gia2!=-1) sql += " and(sp.`Giá cả` between "+gia1+" and "+gia2+")";
            return listPD(sql);
        }
	
        public ArrayList<ProductDTO> search(String toSearch){
            String sql = "select * from `sản phẩm` where `Mã sản phẩm` like '%"+toSearch+"%' or `Tên điện thoại` like '%"+toSearch+"%' or `Giá cả` like '%"+toSearch+"%' or `Số lượng` like '%"+toSearch+"%'";
            return listPD(sql);
        }
        
        public ProductDTO getSanPham(String masp){
            return sp_dao.getSanPham(masp);
        }
        
        public boolean updateSoLuong(String masp, int sl){
            return sp_dao.updateSoLuong(masp, sl);
        }
        
	public ArrayList <ProductDTO> listPD(String sql){
		product = sp_dao.listPD(sql);
		return product;
	}
	
	public boolean Insert(ProductDTO cb) {
		return sp_dao.Insert(cb);
	}
	
	public void Update(ProductDTO cb) {
		sp_dao.Update_PD(cb);
	}
	
	public void Delete(String maCB) {
		sp_dao.Delete(maCB);
	}
	
	public ArrayList <ProductDTO> getArrayList(){
		product = listPD("SELECT * FROM `sản phẩm`");
		return product;
	}
	public ArrayList<CategoryDTO> getTL(){
            return sp_dao.getTL();
        }
	public ArrayList <ProductDTO> search_coban(String key, String id){
                id = id.trim().replaceAll(" {2,}", " ");
		String sql = "SELECT * FROM `sản phẩm` WHERE `" + key + "` LIKE '%" + id + "%'";
		System.out.println(sql);
		product = sp_dao.listPD(sql);
		return product;
	}
	
	public ArrayList <ProductDTO> search_nangcao(String type,String toSearch, String tenTL, int startPrice, int endPrice){
		ArrayList getSearch = new ArrayList();
                toSearch = toSearch.trim().replaceAll(" {2,}", " ");
                String sql = "select * from `sản phẩm` sp ";
                if(!tenTL.equals("")){
                    sql += "join `chi tiết sản phẩm` ctsp on sp.`Mã sản phẩm`=ctsp.`Mã sản phẩm` where ctsp.`Mã danh mục`='"+tenTL+"' and ";
                }  else sql += "where ";
                if(type==null) sql += "(`Tên điện thoại` LIKE '%"+toSearch+"%' or sp.`Mã sản phẩm` LIKE '%"+toSearch+"%') and (sp.`Giá cả` BETWEEN "+startPrice+" and "+endPrice+")";
                else {
                    sql += "("+type+" LIKE '%"+toSearch+"%') and (sp.`Giá cả` BETWEEN "+startPrice+" and "+endPrice+")";
                }
		product = sp_dao.listPD(sql);
		return product;
	}
        public int getMaxId(){
            return sp_dao.getMaxId();
        }
}
