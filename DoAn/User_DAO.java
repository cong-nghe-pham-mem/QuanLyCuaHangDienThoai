package DAO;

import java.util.ArrayList;
import java.sql.*;

import DTO.User;

public class User_DAO {
	private ArrayList <User> user;
	private MySQLConnect connect = new MySQLConnect();
	public User_DAO() {
		
	}
	public ArrayList <User> listUser(String sql){
		user = new ArrayList <User>();
		try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				String userName = rs.getString("idUser");
				String password = rs.getString("pass");
				String maKH = rs.getString("maKH");
				String email = rs.getString("email");
				String tenUser = rs.getString("tenUser");
				String sdt = rs.getString("sdt");
				String loginDate = rs.getString("loginDate");
                                String manv = rs.getString("MaNV");
				User a = new User(userName, password, maKH, email, tenUser, sdt, loginDate,manv);
				user.add(a);
			}
                        connect.Close();
		}catch(SQLException e) {
			
		}
		return user;
	}
	
	public boolean Insert(User a) {
		String sql = "INSERT INTO user VALUES(";
		sql += "'" + a.getUserName() + "', ";
		sql += "'" + a.getPassword() + "', ";		
                if(a.getMaKH()!=null) sql += "'" + a.getMaKH() + "', ";
                else sql += "null, ";
                if(a.getMaNV()!=null) sql += "'" + a.getMaNV()+ "', ";
                else sql += "null, ";
		if(a.getEmail()!=null) sql += "'" + a.getEmail() + "', ";
                else sql += "null, ";
		if(a.getTenUser()!=null) sql += "'" + a.getTenUser() + "', ";
                else sql += "null, ";
		if(a.getSdt()!=null) sql += "'" + a.getSdt() + "', ";
		else sql += "null, ";
                sql += "'" + a.getLoginDate() + "')";
		System.out.println(sql);
		return connect.executeUpdate(sql);
	}
	
	public void Update(String a, String id) {
		String sql = "UPDATE user SET loginDate = '" + a + "' WHERE idUser = '" + id + "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
		
	}
        
        public boolean update(String user, String pass, String manv){
                String sql = "UPDATE user SET pass='"+pass+"', MaNV='"+manv+"' where idUser='"+user+"'";
                System.out.println(sql);
		return connect.executeUpdate(sql);
        }
        
        public void delete(String user){
            String sql = "delete from user where idUser='"+user+"'";
            System.out.println(sql);
            connect.executeUpdate(sql);
        }
}
