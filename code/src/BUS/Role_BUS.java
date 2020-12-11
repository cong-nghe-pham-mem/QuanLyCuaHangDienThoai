package BUS;

import java.util.ArrayList;

import DTO.Role;
import DAO.Role_DAO;
import java.util.Arrays;

public class Role_BUS {
	private ArrayList <Role> role;
	private Role_DAO r_dao = new Role_DAO();
	public Role_BUS() {
		
	}
	public ArrayList <Role> getList(){
		String sql = "SELECT * FROM phanquyen";
		role = r_dao.listRole(sql);
		return role;
	}
        public boolean checkRole(String manv, String DetailRole){
            String sql = "select pq.roleID,tenQuyen,chiTiet from phanquyen pq join nhanvien nv on pq.roleID=nv.roleID where maNV='"+manv+"'";
            role = r_dao.listRole(sql);
            for(int i=0;i<role.size();i++){
                String[] listRole = role.get(i).getChitiet().split(" ");
                for(int j=0;j<listRole.length;j++){
                    if(DetailRole.equals(listRole[j])) return true;
                }
            }
            return false;
        }
        public void delete(String idRole){
            r_dao.delete(idRole);
        }
        
        public ArrayList<Role> search(String toSearch, String tl){
            String sql = "SELECT * from phanquyen";
            if(!tl.equals("Tất cả")) {
                sql += " where ";
                switch(tl){
                    case "Mã quyền":
                        sql += "roleID="+toSearch;
                        break;
                    case "Tên quyền":
                        sql += "tenQuyen like '%"+toSearch+"%'";
                        break;
                    case "Chi tiết quyền":
                        sql += "chiTiet like '%"+toSearch+"%'";
                        break;
                }
            } else {
                sql += " where roleID like '%"+toSearch+"%' or tenQuyen like '%"+toSearch+"%' or chiTiet like '%"+toSearch+"%'";
            }
            System.out.print(sql);
            role = r_dao.listRole(sql);
            return role;
        }
        
        public String getNextID(){
            return r_dao.getNextID();
        }
        
        public boolean add(String roleId, String roleName, String roleDetail){
            return r_dao.add(roleId, roleName, roleDetail);
        }
        
        public boolean update(String roleId, String roleName, String roleDetail){
            return r_dao.update(roleId, roleName, roleDetail);
        }
}
