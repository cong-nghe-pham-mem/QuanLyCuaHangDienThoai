package BUS;

import java.util.ArrayList;

import DTO.chitietsanphamDTO;
import DAO.DetailProduct_DAO;

public class DetailProduct_BUS {
	private ArrayList <chitietsanphamDTO> dtProduct;
	private DetailProduct_DAO dtpd_dao = new DetailProduct_DAO();
	public DetailProduct_BUS() {
		
	}
	public ArrayList <chitietsanphamDTO> getList () {
		dtProduct = dtpd_dao.listDD("SELECT * FROM `chi tiết sản phẩm`");
		return dtProduct;
	}
	public ArrayList <chitietsanphamDTO> getArrayList(String key, String id){
		String sql = "SELECT * FROM `chi tiết sản phẩm` WHERE `" + key + "` LIKE '%" + id + "%'";
		dtProduct = dtpd_dao.listDD(sql);
		return dtProduct;
	}
        public boolean insert(chitietsanphamDTO ctsp){
            return dtpd_dao.insert(ctsp);
        }
        public void update(chitietsanphamDTO ctsp){
            dtpd_dao.update(ctsp);
        }
        public void upload(String url, int masp){
            dtpd_dao.upload(url, masp);
        }
}
