package DAO;

import java.util.ArrayList;
import java.sql.*;

import DTO.Role;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Role_DAO {
	private ArrayList <Role> role;
	private MySQLConnect connect = new MySQLConnect();
	public Role_DAO() {
		
	}
	public ArrayList <Role> listRole(String sql){
		role = new ArrayList <Role>();
		try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				int roleID = rs.getInt("roleID");
				String roleName = rs.getString("tenQuyen");
                                String chitiet = rs.getString("chiTiet");
				Role r = new Role(roleID, roleName, chitiet);
				role.add(r);
			}
                        connect.Close();
		}catch(SQLException e) {
			
		}
		return role;
	}
        public void delete(String idRole){
            String sql = "delete from phanquyen where roleID='"+idRole+"'";
            connect.executeUpdate(sql);
        }
        public String getNextID(){
            String sql = "select max(roleID) max from phanquyen";
            ResultSet rs = connect.executeQuery(sql);
            int max = 0;
            try {
                while(rs.next()){
                    max = rs.getInt("max");
                }
                connect.Close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            max++;
            return Integer.toString(max);
        }
        public boolean add(String roleId, String roleName, String roleDetail){
            String sql = "insert into phanquyen values("+roleId+",'"+roleName+"','"+roleDetail+"')";
            System.out.print(sql);
            return connect.executeUpdate(sql);
        }
        
        public boolean update(String roleId, String roleName, String roleDetail) {
            String sql = "update phanquyen set tenQuyen='"+roleName+"', chiTiet='"+roleDetail+"' where roleID="+roleId; 
            System.out.print(sql);
            return connect.executeUpdate(sql);
        }
}
