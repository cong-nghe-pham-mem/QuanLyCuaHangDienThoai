/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Khuyenmai {

    String MaKM, LoaiKM, ChitietKM;
    //float DieuKienKM, PhanTramKM;
    LocalDate NgayBD, NgayKT;

    public Khuyenmai(String makm, String loaikm, String chitietkm, LocalDate ngaybd, LocalDate ngaykt) {
        this.MaKM = makm;
        this.LoaiKM = loaikm;
        this.ChitietKM = chitietkm;
        //this.PhanTramKM = phantramkm;
        this.NgayBD = ngaybd;
        this.NgayKT = ngaykt;
    }

    public String getTrangThai() {
        LocalDate now = LocalDate.now();
        if (now.isBefore(this.NgayBD)) {
            return "Chưa bắt đầu";
        } else if (now.isAfter(this.NgayKT)) {
            return "Đã kết thúc";
        } else {
            return "Đang diễn ra";
        }
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getLoaiKM() {
        return LoaiKM;
    }

    public void setLoaiKM(String LoaiKM) {
        this.LoaiKM = LoaiKM;
    }

    public String ChitietKM() {
        return ChitietKM;
    }

    public void setChitietKM(String TenKM) {
        this.ChitietKM = ChitietKM;
    }

    public LocalDate getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(LocalDate NgayBD) {
        this.NgayBD = NgayBD;
    }

    public LocalDate getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(LocalDate NgayKT) {
        this.NgayKT = NgayKT;
    }

    public Object getChitietKM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

