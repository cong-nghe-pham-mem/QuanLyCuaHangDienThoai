package BUS;

import java.util.ArrayList;

import DAO.User_DAO;
import DTO.User;

public class User_BUS {
	private ArrayList <User> user;
	private User_DAO u_dao = new User_DAO();
	public User_BUS() {
		
	}
	public ArrayList <User> getArrayList(){
		user = u_dao.listUser("SELECT * FROM user");
		return user;
	}
	
	public boolean Insert(User a) {
		return u_dao.Insert(a);
	}
	
	public void Update_LoginDate(String a, String id) {
		u_dao.Update(a, id);
	}
        
        public boolean update(String username, String pass, String manv){
            return u_dao.update(manv, pass, manv);
        }
        
        public ArrayList<User> search(String toSearch, String key){
            String sql = "select * from user";
                sql += " where";
                switch(key){
                    case "Tên tài khoản":
                        sql += " idUser like '%"+toSearch+"%'";
                        break;
                    case "Mã nhân viên":
                        sql += " MaNV like '%"+toSearch+"%'";
                        break;
                    default:
                        sql += " idUser like '%"+toSearch+"%' or MaNV like '%"+toSearch+"%'";
                        break;
                }
            return u_dao.listUser(sql);
        }
        public void delete(String user){
            u_dao.delete(user);
        }
}
