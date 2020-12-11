package BUS;

import DAO.KhachHang_DAO;
import DTO.KhachHang;

import java.util.ArrayList;

public class KhachHang_BUS {
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private ArrayList <KhachHang> customer;
	public KhachHang_BUS() {
		
	}
        
        public KhachHang getKhachHang(String makh){
            return kh_dao.getKhachHang(makh);
        }
        public String getMaKH(){
            return kh_dao.getMaKH();
        }
        
        public ArrayList <KhachHang> search(String toSearch, String key){
            String sql = "select * from khachhang";
            switch(key){
                case "Mã khách hàng":
                    sql += " where maKh like '%"+toSearch+"%'";
                    break;
                case "Tên khách hàng":
                    sql += " where tenKH like '%"+toSearch+"%'";
                    break;
                case "CMND":
                    sql += " where CMND like '%"+toSearch+"%'";
                    break;
                case "Số điện thoại":
                    sql += " where sdt like '%"+toSearch+"%'";
                    break;
            }
            System.out.print(sql);
            customer = kh_dao.listKH(sql);
            return customer;
        }
	
	public ArrayList <KhachHang> listKH(String sql){
		customer = kh_dao.listKH(sql);
		return customer;
	}
	
	public boolean Insert(KhachHang kh) {
		return kh_dao.Insert(kh);
	}
	
	public void Update(KhachHang kh) {
		kh_dao.Update(kh);
	}
	
	public void Delete(String maKH) {
		kh_dao.Delete(maKH);
	}
	
	public ArrayList <KhachHang> getArrayList_normal(){
		customer = listKH("SELECT * FROM khachhang WHERE status = 0");
		return customer;
	}
	
	public ArrayList <KhachHang> getArrayList_condition(String key, String id){
		String sql = "SELECT * FROM khachhang WHERE status = 0 AND	 " + key + " = '" + id + "'";
		customer = listKH(sql);
		return customer;
	}
	
	public ArrayList <KhachHang> search_coban(String key, String id){
		String sql = "SELECT * FROM khachhang WHERE status = 0 AND " + key + " LIKE '%" + id + "%'";
		customer = kh_dao.listKH(sql);
		return customer;
	}
	public ArrayList <KhachHang> search_nangcao(int age, String gender, String CMND){
		customer = new ArrayList <KhachHang>();
		String dk = "";
		if(age != 0) {
			dk += " AND (";
			dk += " birthDate LIKE '%" + age + "%'";
			dk += " )";
		}
		if(!gender.equals("")) {
			dk += " AND (";
			dk += " gender LIKE '%" + gender + "%'";
			dk += " )";
		}
		if(!CMND.equals("Tìm Kiếm Theo CMND...")) {
			dk += " AND (";
			dk += " CMND LIKE '%" + CMND + "%'";
			dk += " )";
		}
		String sql = "SELECT * FROM khachhang WHERE 1" + dk;
		System.out.println(sql);
		customer = listKH(sql);
		return customer;
	}
}
