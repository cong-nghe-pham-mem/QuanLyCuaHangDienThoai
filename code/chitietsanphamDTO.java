/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tuong Vy
 */
public class chitietsanphamDTO {
    private int machitiet;
    private int masanpham;
    private String madanhmuc;
    private String kichthuoc;
    private String trongluong;
    private String mausac;
    private String bonhotrong;
    private String bonhodem;
    private String hedieuhanh;
    private String cameratruoc;
    private String camerasau;
    private String pin;
    private String baohanh;
    private String tinhtrang;
    private String filenamehinhanh;

    public String getFilenamehinhanh() {
        return filenamehinhanh;
    }

    public void setFilenamehinhanh(String filenamehinhanh) {
        this.filenamehinhanh = filenamehinhanh;
    }

    public chitietsanphamDTO(int machitiet, int masanpham, String madanhmuc, String kichthuoc, String trongluong, String mausac, String bonhotrong, String bonhodem, String hedieuhanh, String cameratruoc, String camerasau, String pin, String baohanh, String tinhtrang) {
        this.machitiet = machitiet;
        this.masanpham = masanpham;
        this.madanhmuc = madanhmuc;
        this.kichthuoc = kichthuoc;
        this.trongluong = trongluong;
        this.mausac = mausac;
        this.bonhotrong = bonhotrong;
        this.bonhodem = bonhodem;
        this.hedieuhanh = hedieuhanh;
        this.cameratruoc = cameratruoc;
        this.camerasau = camerasau;
        this.pin = pin;
        this.baohanh = baohanh;
        this.tinhtrang = tinhtrang;
    }

    public chitietsanphamDTO(String madanhmuc, String kichthuoc, String trongluong, String mausac, String bonhotrong, String bonhodem, String hedieuhanh, String cameratruoc, String camerasau, String pin, String baohanh, String tinhtrang) {
        this.madanhmuc = madanhmuc;
        this.kichthuoc = kichthuoc;
        this.trongluong = trongluong;
        this.mausac = mausac;
        this.bonhotrong = bonhotrong;
        this.bonhodem = bonhodem;
        this.hedieuhanh = hedieuhanh;
        this.cameratruoc = cameratruoc;
        this.camerasau = camerasau;
        this.pin = pin;
        this.baohanh = baohanh;
        this.tinhtrang = tinhtrang;
    }
    
    public chitietsanphamDTO(int machitiet, int masanpham, String madanhmuc, String kichthuoc, String trongluong, String mausac, String bonhotrong, String bonhodem, String hedieuhanh, String cameratruoc, String camerasau, String pin, String baohanh, String tinhtrang, String url) {
        this.machitiet=machitiet;
        this.masanpham = masanpham;
        this.madanhmuc = madanhmuc;
        this.kichthuoc = kichthuoc;
        this.trongluong = trongluong;
        this.mausac=mausac;
        this.bonhotrong=bonhotrong;
        this.bonhodem=bonhodem;
        this.hedieuhanh=hedieuhanh;
        this.cameratruoc=cameratruoc;
        this.camerasau=camerasau;
        this.pin=pin;
        this.baohanh=baohanh;
        this.tinhtrang=tinhtrang;
        this.filenamehinhanh=url;
      }

    public chitietsanphamDTO(String madanhmuc, String kichthuoc, String trongluong, String mausac, String bonhotrong, String bonhodem, String hedieuhanh, String cameratruoc, String camerasau, String pin, String baohanh, String tinhtrang, String filenamehinhanh) {
        this.madanhmuc = madanhmuc;
        this.kichthuoc = kichthuoc;
        this.trongluong = trongluong;
        this.mausac = mausac;
        this.bonhotrong = bonhotrong;
        this.bonhodem = bonhodem;
        this.hedieuhanh = hedieuhanh;
        this.cameratruoc = cameratruoc;
        this.camerasau = camerasau;
        this.pin = pin;
        this.baohanh = baohanh;
        this.tinhtrang = tinhtrang;
        this.filenamehinhanh = filenamehinhanh;
    }
    public chitietsanphamDTO(){
        
    }
   
    public int getmachitiet() {
        return machitiet;
    }
    public void setmachitiet(int machitiet) {
        this.machitiet = machitiet;
    } 
    public int getmasanpham() {
        return masanpham;
    }
    public void setmasanpham(int masanpham) {
        this.masanpham = masanpham;
    }
    public String getmadanhmuc() {
        return madanhmuc;
    }
    public void setmadanhmuc(String madanhmuc) {
        this.madanhmuc = madanhmuc;
    } 
    public String getkichthuoc() {
        return kichthuoc;
    }
    public void setkichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }
    public String gettrongluong() {
        return trongluong;
    }
    public void settrongluong(String trongluong) {
        this.trongluong = trongluong;
    }
    public String getmausac() {
        return mausac;
    }
    public void setmausac(String mausac) {
        this.mausac = mausac;
    }
    public String getbonhotrong() {
        return trongluong;
    }
    public void setbonhotrong(String bonhotrong) {
        this.bonhotrong = bonhotrong;
    }
    public String getbonhodem() {
        return bonhodem;
    }
    public void setbonhodem(String bonhodem) {
        this.bonhodem = bonhodem;
    }
    public String gethedieuhanh() {
        return hedieuhanh;
    }
    public void sethedieuhanh(String hedieuhanh) {
        this.hedieuhanh = hedieuhanh;
    }
    public String getcameratruoc() {
        return cameratruoc;
    }
    public void setcameratruoc(String cameratruoc) {
        this.cameratruoc = cameratruoc;
    }
    public String getcamerasau() {
        return camerasau;
    }
    public void setcamerasau(String camerasau) {
        this.camerasau = camerasau;
    }
    public String getpin() {
        return pin;
    }
    public void setpin(String pin) {
        this.pin = pin;
    }
    public String getbaohanh() {
        return baohanh;
    }
    public void setbaohanh(String baohanh) {
        this.baohanh = baohanh;
    }
    public String gettinhtrang() {
        return tinhtrang;
    }
    public void settinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}

