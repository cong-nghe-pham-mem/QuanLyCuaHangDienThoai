/*package DAO;


import DTO.Khuyenmai;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
/*public class Quanlykhuyenmai_DAO {
   MySQLConnect connect = new MySQLConnect();
    private Object dskm;
    private ArrayList<Khuyenmai> km;
    private ConnectionDB dskmConnection;

          public ArrayList readDB() {
        ArrayList<Khuyenmai> km = new ArrayList<>();
        /*try {
            String r = "SELECT * FROM chương trình khuyến mãi";
            ResultSet r = connect.executeQuery(qry);
            if (r != null) {

                while (r.next()) {
                    Khuyenmai km = new Khuyenmai();
        ArrayList<Khuyenmai> km = new ArrayList<>();*/
      /*  try {
            String rs = "SELECT * FROM chương trình khuyến mãi";
            ResultSet r = null;
            String qry = null;
            r = dskmConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String makm = r.getString("MaKM");
                    //String tenct = r.getString("TenCT");
                    String loaikm = r.getString("LoaiKM");
                    String chitietkm = r.getString("ChitietKM");
                   // float dkkm = r.getFloat("DieuKienKM");
                   // float phantramkm = r.getFloat("PhanTramKM");
                    LocalDate ngaybd = r.getDate("NgayBD").toLocalDate();
                    LocalDate ngaykt = r.getDate("NgayKT").toLocalDate();
                    km.add(new Khuyenmai(makm, chitietkm, loaikm, ngaybd, ngaykt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng khuyến mãi");
        } finally {
            dskmConnection.closeConnect();
        }
        return km;
    }

    public Object search(String columnName, String value) {
        dskmConnection = new ConnectionDB();
        ArrayList<Khuyenmai> km = new ArrayList<>();

        try {
            String qry = "SELECT * FROM khuyenmai WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = dskmConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String makm = r.getString("MaKM");
                    String loaikm = r.getString("LoaiKM");
                    String chitietkm = r.getString("ChitietKM");
                    //float dkkm = r.getFloat("DieuKienKM");
                    //float phantramkm = r.getFloat("PhanTramKM");
                    LocalDate ngaybd = r.getDate("NgayBD").toLocalDate();
                    LocalDate ngaykt = r.getDate("NgayKT").toLocalDate();
                    km.add(new Khuyenmai(makm, loaikm, chitietkm, ngaybd, ngaykt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng khuyến mãi");
        } finally {
            dskmConnection.closeConnect();
        }

        return dskm;
    }

    public Boolean add(Khuyenmai km) {
        dskmConnection = new ConnectionDB();
        Boolean ok = dskmConnection.sqlUpdate("INSERT INTO `khuyenmai` (`MaKM`, `LoaiKM`, `ChitietKM`, `NgayBD`, `NgayKT`) VALUES ('"
                + km.getMaKM()+ "', '"
                + km.getLoaiKM() + "', '"
                + km.getChitietKM() + "', '"
                //+ km.getPhanTramKM() + "', '"
                + km.getNgayBD() + "', '"
                + km.getNgayKT() + "');");
        dskmConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String makm) {
        dskmConnection = new ConnectionDB();
        Boolean ok = dskmConnection.sqlUpdate("DELETE FROM `chương trình khuyến mãi` WHERE `chương trình khuyến mãi`.`mã giảm giá` = '" + makm + "'");
        dskmConnection.closeConnect();
        return ok;
    }

    public Boolean update(String makm, String loaikm, String chitietkm, LocalDate ngaybd, LocalDate ngaykt) {
        dskmConnection = new ConnectionDB();
        Boolean ok = dskmConnection.sqlUpdate("Update Khuyenmai Set "
                + "MaKM='" + makm
                + "', LoaiKM='" + loaikm
                + "', ChitietKM='" + chitietkm
                + "', NgayBD='" + ngaybd
                + "', NgayKT='" + ngaykt
                + "' where MaKM='" + makm + "'");
        dskmConnection.closeConnect();
        return ok;
    }

    public void close() {
        dskmConnection.closeConnect();
    

   private static class ConnectionDB {

        public ConnectionDB() {
        }

        private Boolean sqlUpdate(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void closeConnect() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private ResultSet sqlQuery(String qry) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

   private static class dskmConnection {

        private static void closeConnect() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public dskmConnection() {
        }
    }
}

    */