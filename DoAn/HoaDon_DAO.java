package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.OrderDTO;
import DTO.DetailOrDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDon_DAO {
	private ArrayList <OrderDTO> bill;
        private ArrayList <DetailOrDTO> dtbill;
	private MySQLConnect connect = new MySQLConnect();
	
	public HoaDon_DAO() {
		
	}
	
        public ArrayList<DetailOrDTO> getCTHD(String sql){
            dtbill = new ArrayList();
            try{
                ResultSet rs = connect.executeQuery(sql);
                while(rs.next()){
                    DetailOrDTO e = new DetailOrDTO(rs.getInt("mã đơn hàng"), rs.getInt("mã sản phẩm"), rs.getInt("số lượng"), rs.getInt("Tổng tiền"), rs.getString("tình trạng đơn hàng"));
                    dtbill.add(e);
                }
                connect.Close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return dtbill;
        }
        
	public ArrayList <OrderDTO> listBill(String sql){
		bill = new ArrayList <OrderDTO>();
		try {
			ResultSet rs = connect.executeQuery(sql);
			while(rs.next()) {
				int maHD = rs.getInt("Mã đơn hàng");
				int maKH = rs.getInt("Mã người dùng");
				String ngayLap = rs.getString("Ngày khởi tạo");
				int tongTien = rs.getInt("Tổng tiền");
                                String gioLap = rs.getString("gioLap");
				OrderDTO hd = new OrderDTO(maHD, maKH, tongTien, ngayLap, gioLap);
				bill.add(hd);
			}
                        connect.Close();
		}catch(SQLException e) {
			System.out.println("Lỗi SQL: " + e.getClass().getName());
			System.out.println("Thông Báo Lỗi: " + e.getMessage());
			System.out.println("Số Hiệu Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
		}
		return bill;
	}
	
	public boolean Insert(OrderDTO hd) {
		String sql = "INSERT INTO `đơn hàng` VALUES(";
		sql += "'" + hd.getIdOrder() + "', ";
		sql += "'" + hd.getId()+ "', ";
                if(hd.getManv()!=null) sql += "'" + hd.getManv()+ "', ";
                else sql += "null,";
		sql += "'" + hd.getTotalmoney()+ "', ";
		sql += "'" + hd.getOrderdate()+ "', ";
                sql += "'" + hd.getTime()+ "' ";
		sql += ")";
		System.out.println(sql);
		return connect.executeUpdate(sql);
	}
        
        public boolean InsertCTHD(DetailOrDTO dt){
            String sql = "INSERT INTO `chi tiết đơn hàng` VALUES(";
            sql += "'" + dt.getIdOrder() + "', ";
            sql += "'" + dt.getIdProd()+ "', ";
            sql += "'" + dt.getSl()+ "', ";
            sql += "'" + dt.getMoney()+ "', ";
            sql += "'" + dt.getOrderstatus()+ "'";
            sql += ")";
            return connect.executeUpdate(sql);
        }
	
	public void Update(OrderDTO hd) {
		String sql = "UPDATE `đơn hàng` SET";
		sql += " `Mã người dùng` = '" + hd.getId()+ "', ";
		sql += " `Ngày khởi tạo` = '" + hd.getOrderdate()+ "', ";
                sql += " gioLap = '" + hd.getTime()+ "', ";
		sql += " `Tổng tiền` = '" + hd.getTotalmoney()+"'";
		sql += " WHERE";
		sql += " `Mã đơn hàng` = '" + hd.getIdOrder()+ "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
	}
	
	public void Delete(String maHD) {
		String sql = "DELETE FROM `đơn hàng` WHERE `Mã đơn hàng` = '" + maHD + "'";
		System.out.println(sql);
		connect.executeUpdate(sql);
	}
        public void xetDuyet(int mahd){
            String sql = "UPDATE `chi tiết đơn hàng` SET `tình trạng đơn hàng`=1 where `mã đơn hàng`="+mahd;
            connect.executeUpdate(sql);
        }
        
        public void addToCart(OrderDTO hd, ArrayList<DetailOrDTO> dts){
               Insert(hd);               
               for(int i=0 ; i<dts.size();i++) {
                   DetailOrDTO dt = dts.get(i);
                   InsertCTHD(dt);
               }
        }
        
        public void thanhToan(int mahd){
            String sql = "UPDATE `chi tiết đơn hàng` SET `tình trạng đơn hàng`=0 where `mã đơn hàng`="+mahd;
            connect.executeUpdate(sql);
        }
        
        public int getMaxId(){
            String sql = "SELECT MAX(`Mã đơn hàng`) max from `đơn hàng`";
            ResultSet rs = connect.executeQuery(sql);
            int i = 0;
            try {
                while(rs.next()){
                    i = rs.getInt("max");
                }
                connect.Close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            i++;
            return i;
        }
}
