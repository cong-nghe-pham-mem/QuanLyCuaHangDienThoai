/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.ProductDTO;
import BUS.QuanLyPhieuNhapBUS;
import BUS.Product_BUS;
import DTO.ChiTietPhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QuanLyChiTietPhieuNhapBUS {

    DAO.QuanLyChiTietPhieuNhapDAO qlctpnDAO = new DAO.QuanLyChiTietPhieuNhapDAO();
    QuanLyPhieuNhapBUS qlpnBUS = new QuanLyPhieuNhapBUS();
    BUS.Product_BUS qlspBUS = new BUS.Product_BUS();
    ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<>();

    public QuanLyChiTietPhieuNhapBUS() {
        dsctpn = qlctpnDAO.readDB();
    }

    public void readDB() {
        dsctpn = qlctpnDAO.readDB();
    }

    public ArrayList<ChiTietPhieuNhap> search(String type, String value) {

        ArrayList<ChiTietPhieuNhap> result = qlctpnDAO.search(type, value);
        dsctpn.forEach((ctpn) -> {
            if (type.equals("Tất cả")) {
                if (ctpn.getMa().toLowerCase().contains(value.toLowerCase())
                        || ctpn.getMaSP().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(ctpn.getDonGia()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(ctpn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(ctpn);
                }
            } else {
                switch (type) {
                    case "Mã phiếu nhập":
                        if (ctpn.getMa().toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Mã sản phẩm":
                        if (ctpn.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Đơn giá":
                        if (String.valueOf(ctpn.getDonGia()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                    case "Số lượng":
                        if (String.valueOf(ctpn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(ctpn);
                        }
                        break;
                }
            }

        });

        return result;
    }

    public Boolean deleteAll(String _maPhieuNhap) {
        Boolean success = qlctpnDAO.deleteAll(_maPhieuNhap);
        if (success) {
            for (ChiTietPhieuNhap cthd : dsctpn) {
                if (cthd.getMa().equals(_maPhieuNhap)) {
                    dsctpn.remove(cthd);
                }
            }
            updateTongTien(_maPhieuNhap);
            return true;
        }
        return false;
    }

    public ChiTietPhieuNhap getChiTiet(String mapn, String masp) {
        for (ChiTietPhieuNhap ct : dsctpn) {
            if (ct.getMaSP().equals(masp) && ct.getMa().equals(mapn)) {
                return ct;
            }
        }
        return null;
    }
    
    public ArrayList<ChiTietPhieuNhap> getAllChiTiet(String mapn) {
        ArrayList<ChiTietPhieuNhap> result = qlctpnDAO.search("MaPN", mapn);
        for(ChiTietPhieuNhap ctpn : dsctpn) {
            if(ctpn.getMa().equals(mapn)) {
                result.add(ctpn);
            }
        }
        return result;
    }

    public Boolean delete(String _maPhieuNhap, String _maSanPham) {
        Boolean success = qlctpnDAO.delete(_maPhieuNhap, _maSanPham);
        if (success) {
            for (ChiTietPhieuNhap ctpn : dsctpn) {
                if (ctpn.getMa().equals(_maPhieuNhap) && ctpn.getMaSP().equals(_maSanPham)) {
                    updateSoLuongSanPham(_maSanPham, ctpn.getSoLuong());
                    dsctpn.remove(ctpn);
                    updateTongTien(_maPhieuNhap);
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean add(ChiTietPhieuNhap ct) {
        int soLuongChiTietMoi = ct.getSoLuong();

        // tìm các chi tiết cùng mã, và tính tổng số lượng
        ArrayList<ChiTietPhieuNhap> toRemove = new ArrayList<>();
        int tongSoLuong = ct.getSoLuong();

        for (ChiTietPhieuNhap ctpn : dsctpn) {
            if (ctpn.getMa().equals(ct.getMa()) && ctpn.getMaSP().equals(ct.getMaSP())) {
                tongSoLuong += ctpn.getSoLuong();
                toRemove.add(ctpn);
            }
        }
        // xóa chi tiết cũ cùng mã
        dsctpn.removeAll(toRemove);
        qlctpnDAO.delete(ct.getMa(), ct.getMaSP());

        // thêm chi tiết mới có số lượng = tổng số lượng tìm ở trên
        ct.setSoLuong(tongSoLuong);
        Boolean success = qlctpnDAO.add(ct);
        if (success) {
            dsctpn.add(ct);
            updateSoLuongSanPham(ct.getMaSP(), soLuongChiTietMoi);
            updateTongTien(ct.getMa());
            return true;
        }
        return false;
    }

    private boolean updateSoLuongSanPham(String _masp, int _soLuongThayDoi) {
        boolean success = false;
        for (ProductDTO sp : qlspBUS.getArrayList()) {
            if (Integer.toString(sp.getIdProd()).equals(_masp)) {
                success = qlspBUS.updateSoLuong(_masp, sp.getSL()+ _soLuongThayDoi);
            }
        }
        return success;
    }

    public boolean add(String ma, String masp, Integer soluong, Float dongia) {
        ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(ma, masp, soluong, dongia);
        return add(ctpn);
    }

    public boolean delete(String ma) {
        Boolean ok = qlctpnDAO.deleteAll(ma);
        if (ok) {
            for (int i = (dsctpn.size() - 1); i >= 0; i--) {
                if (dsctpn.get(i).getMa().equals(ma)) {
                    dsctpn.remove(i);
                }
            }

        }
        return ok;
    }

    public Boolean update(String mapn, String masp, int soluong, float dongia) {
        Boolean ok = qlctpnDAO.update(mapn, masp, soluong, dongia);

        if (ok) {
            dsctpn.forEach((ctpn) -> {
                if (ctpn.getMa().equals(mapn) && ctpn.getMaSP().equals(masp)) {
                    ChiTietPhieuNhap pn = new ChiTietPhieuNhap(mapn, masp, soluong, dongia);
                    dsctpn.add(pn);
                }
            });
        }

        return ok;
    }

    private Boolean updateTongTien(String _mapn) {
        float tong = 0;
        for (ChiTietPhieuNhap ct : dsctpn) {
            if (ct.getMa().equals(_mapn)) {
                tong += ct.getSoLuong() * ct.getDonGia();
            }
        }
        Boolean success = qlpnBUS.updateTongTien(_mapn, tong);

        return success;
    }
}
