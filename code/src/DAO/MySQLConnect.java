package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class MySQLConnect {
	private String user = "root";
	private String pass = "";
	private String url  = "jdbc:mysql://localhost:3306/java_phone_data?useUnicode=true&characterEncoding=utf-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection connect = null;
	private Statement stm = null;
	private ResultSet rs = null;
	public void MySQLConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, pass);
		}catch(ClassNotFoundException e) {
             e.printStackTrace();
		}catch(SQLException e){
			System.out.println("Lỗi SQL: " + e.getClass().getName());
			System.out.println("Thông Báo Lỗi: " + e.getMessage());
			System.out.println("Số Hiệu Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
         }
	}
	public ResultSet executeQuery(String sql) {
		try {
			MySQLConnect();
			stm = connect.createStatement();
			rs = stm.executeQuery(sql);
                        
		}catch(SQLException e) {
			System.out.println("Lỗi SQL: " + e.getClass().getName());
			System.out.println("Thông Báo Lỗi: " + e.getMessage());
			System.out.println("Số Hiệu Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
		}
		return rs;
	}
	public boolean executeUpdate(String sql) {
		try {
			MySQLConnect();
			stm = connect.createStatement();
			stm.executeUpdate(sql);
			Close();
		}catch(SQLException e) {
                        e.printStackTrace();
				return false;
			
			//Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
		}
		return true;
	}
	public void Close() throws SQLException {
		if(this.rs != null && !this.rs.isClosed()) {
			this.rs.close();
			this.rs = null;
		}
		if(this.stm != null && !this.stm.isClosed()) {
			this.stm.close();
			this.stm = null;
		}
		if(this.connect != null && !this.connect.isClosed()) {
			this.connect.close();
			this.connect = null;
		}
	}
}
