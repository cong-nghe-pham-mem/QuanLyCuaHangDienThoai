package BUS;

import DTO.NhanVien;
import DAO.NhanVien_DAO;
import java.util.ArrayList;

public class NhanVien_BUS {
	private ArrayList <NhanVien> employee;
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	
	public NhanVien_BUS() {
		
	}
	
        public NhanVien getNhanVien(String manv){
            return nv_dao.getNhanVien(manv);
        }
        
        public String getMaNV(){
            return nv_dao.getMaNV();
        }
        
	public ArrayList <NhanVien> listNV(String sql){
		employee = nv_dao.listNV(sql);
		return employee;
	}
	
	public ArrayList <NhanVien> getArrayList_normal(){
		employee = listNV("SELECT * FROM nhanvien");
		return employee;
	}
	
	public ArrayList <NhanVien> getArrayList_condition(String key, String id){
		String sql = "SELECT * FROM nhanvien WHERE " + key + " LIKE '%" + id + "%'";
		employee = listNV(sql);
		System.out.println(sql);
		return employee;
	}
	
	public boolean Insert(NhanVien nv) {
		return nv_dao.Insert(nv);
	}
	
	public void Update(NhanVien nv) {
		nv_dao.Update(nv);
	}
	
	public void Delete(String maNV) {
		nv_dao.Delete(maNV);
	}
	
	public ArrayList<NhanVien> search_coban(String key, String id){
		String sql = "SELECT * FROM nhanvien WHERE status = 0 AND " + key + " = '" + id + "'";
		employee = nv_dao.listNV(sql);
		return employee;
	}
	
	public ArrayList <NhanVien> search_nangcao(String birthDate, String gend, String workDate){
		String dk = "";
		int length = birthDate.split("/").length;
		System.out.println(length);
		if(length <= 3 && length >= 2) {
			dk += " AND (";
			dk += " birthDate LIKE '%" + birthDate.replaceAll("//", "/%") + "%'";
			dk += " )";
		}
		else if(length == 1) {
			System.out.println("abc");
			dk += " AND (";
			dk += " birthDate LIKE '%" + birthDate.replaceAll("//", "/%") + "%'";
			dk += " )";
		}
		
		if(!gend.equals("")) {
			dk += " AND (";
			dk += " gender LIKE '%" + gend + "%'";
			dk += " )";
		}
		int length_nvl = workDate.split("/").length;
		if(length_nvl <= 3 && length_nvl >= 2) {
			dk += " AND (";
			dk += " ngayvaolam LIKE '%" + workDate.replaceAll("//", "/%") + "%'";
			dk += " )";
		}
		else if(length_nvl == 1) {
			dk += " AND (";
			dk += " ngayvaolam LIKE '%" + workDate.replaceAll("/", "") + "%'";
			dk += " )";
		}
		String sql = "SELECT * FROM nhanvien WHERE status = 0" + dk;
		employee = listNV(sql);
		System.out.println(sql);
		return employee;
	}
        
        public ArrayList<NhanVien> search(String toSearch, String key, String startDate, String endDate){
            String sql = "select * from nhanvien where";
            switch(key){
                case "Mã nhân viên":
                    sql += " maNV like '%"+toSearch+"%'";
                    break;
                case "Số điện thoại":
                    sql += " sdt like '%"+toSearch+"%'";
                    break;
                case "Tên nhân viên":
                    sql += " tenNV like '%"+toSearch+"%'";
                    break;
                case "CMND":
                    sql += " CMND like '%"+toSearch+"%'";
                    break;
            }
            if(!startDate.equals("")&&!endDate.equals("")) sql += " AND (STR_TO_DATE(birthDate,'%d/%m/%Y') between '"+startDate+"' and '"+endDate+"')";
            employee = listNV(sql);
            System.out.println(sql);
            return employee;
        }
}
