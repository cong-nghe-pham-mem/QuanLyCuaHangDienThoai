package BUS;

import java.util.ArrayList;

import DTO.OrderDTO;
import DTO.DetailOrDTO;
import DAO.HoaDon_DAO;

public class HoaDon_BUS {
	private ArrayList <OrderDTO> bill;
        private ArrayList <DetailOrDTO> dtbill;
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	public HoaDon_BUS() {
		
	}
	
	public ArrayList <OrderDTO> listBill(String sql){
		bill = hd_dao.listBill(sql);
		return bill;
	}
        
        public void thanhToan(int mahd){
            hd_dao.thanhToan(mahd);
        }
        
        public void addToCart(OrderDTO order, ArrayList<DetailOrDTO> dt){
               hd_dao.addToCart(order, dt);
        }
        
        public void insertCTHD(DetailOrDTO dt){
            hd_dao.InsertCTHD(dt);
        }
        
        public ArrayList <OrderDTO> getCart(String makh){
            String sql = "SELECT * FROM `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` WHERE ctdh.`tình trạng đơn hàng` = -1 and `Mã người dùng`="+makh+" GROUP BY dh.`Mã đơn hàng`";
            bill = listBill(sql);               
		return bill;
        }
	
	public ArrayList <OrderDTO> getArrayList_normal(){
		String sql = "SELECT * FROM `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` WHERE ctdh.`tình trạng đơn hàng` = 0 GROUP BY dh.`Mã đơn hàng`";
		bill = listBill(sql);
		return bill;
	}
	
	public ArrayList <OrderDTO> getArrayList(){
		String sql = "SELECT * FROM `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` WHERE ctdh.`tình trạng đơn hàng` = 1 GROUP BY dh.`Mã đơn hàng`";
		bill = listBill(sql);
		return bill;
	}
	
	public ArrayList <OrderDTO> getArrayList_condition(String key, String id){
		String sql = "SELECT * FROM `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` WHERE `tình trạng đơn hàng` = 0 AND " + key + " = '" + id + "' GROUP BY dh.`Mã đơn hàng`";
		bill = listBill(sql);
		return bill;
	}
	
        public ArrayList<DetailOrDTO> getCTHD(String mahd){
            String sql = "SELECT * FROM `chi tiết đơn hàng` where `mã đơn hàng`='"+mahd+"'";
            dtbill = hd_dao.getCTHD(sql);
            return dtbill;
        }
	
	public boolean Insert(OrderDTO hd) {
		return hd_dao.Insert(hd);
	}
	
	public void Update(OrderDTO hd) {
		hd_dao.Update(hd);
	}
	
	public void Delete(String maHD) {
		hd_dao.Delete(maHD);
	}
        
        public ArrayList <OrderDTO> getListDT(int tongtien){
            String sql = "SELECT * FROM `chi tiết đơn hàng` ctdh JOIN `đơn hàng` dh on dh.`mã đơn hàng`=ctdh.`mã đơn hàng` where ctdh.`tình trạng đơn hàng` = 1 and dh.`Tổng tiền` > "+tongtien+" GROUP BY dh.`Mã đơn hàng`";
            bill = hd_dao.listBill(sql);
            return bill;
        }
        
        public ArrayList <OrderDTO> getListSPBC(int sl){
            String sql = "SELECT * FROM `chi tiết đơn hàng` ctdh JOIN `đơn hàng` dh on dh.`mã đơn hàng`=ctdh.`mã đơn hàng` where ctdh.`mã đơn hàng` = any (SELECT ctdh1.`mã đơn hàng` from `chi tiết đơn hàng` ctdh1 join `đơn hàng` dh1 on dh1.`mã đơn hàng`=ctdh1.`mã đơn hàng` where ctdh1.`số lượng`>="+sl+" and ctdh.`tình trạng đơn hàng` = 1) GROUP BY dh.`Mã đơn hàng`";
            bill = hd_dao.listBill(sql);
            return bill;
        }
        
        public ArrayList <OrderDTO> orderBy(String toOrder){
            String sql = "SELECT * FROM `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` WHERE ctdh.`tình trạng đơn hàng` = 1 GROUP BY dh.`Mã đơn hàng` ORDER BY "+toOrder;
            bill = hd_dao.listBill(sql);
            return bill;
        }
        
        public ArrayList <OrderDTO> searchTK(String key, String id, String startDate, String endDate){
            String sql = "select * from `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` join `chi tiết sản phẩm` ctsp on ctsp.`Mã sản phẩm`=ctdh.`mã sản phẩm` join `danh mục` dm on dm.`Mã danh mục`=ctsp.`Mã danh mục` WHERE `tình trạng đơn hàng` = 1 and "+key+" like '%"+id+"%'";
            if(!startDate.equals("")&&!endDate.equals("")) sql += " AND (STR_TO_DATE(dh.`Ngày khởi tạo`,'%d/%m/%Y') between '"+startDate+"' and '"+endDate+"')";
            sql += " GROUP BY dh.`Mã đơn hàng`";
            System.out.print(sql);
            bill = hd_dao.listBill(sql);
            return bill;
        }
	
	public ArrayList <OrderDTO> search_coban(String key, String id){
		String sql = "SELECT * FROM `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` WHERE `tình trạng đơn hàng` = 0 AND " + key + " = '" + id + "' GROUP BY dh.`Mã đơn hàng`";
		bill = hd_dao.listBill(sql);
		return bill;
	}
	
	public ArrayList <OrderDTO> search_nangcao(String ngayLap, String priceTo, String priceEnd){
		String dk = "";
		if(!ngayLap.equals("")) {
			dk += " AND (";
			dk += " `Ngày khởi tạo`  LIKE '%" + ngayLap + "%'";
			dk += " )";
		}
		if(priceTo.equals("")) {
			priceTo = "0";
		}
		if(priceEnd.equals("")) {
			priceEnd = "100000000000";
		}
		dk += " AND (dh.`Tổng tiền` BETWEEN " + priceTo + " AND " + priceEnd + ") GROUP BY dh.`Mã đơn hàng`";
		String sql = "SELECT * FROM `đơn hàng` dh join `chi tiết đơn hàng` ctdh on dh.`Mã đơn hàng`=ctdh.`Mã đơn hàng` WHERE `tình trạng đơn hàng` = 0" + dk;
		System.out.println(sql);
		bill = listBill(sql);
		return bill;
	}
    public void xetDuyet(int mahd){
        hd_dao.xetDuyet(mahd);
    }    
    
    public int getMaxId(){
        return hd_dao.getMaxId();
    }
}
