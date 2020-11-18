/*package BUS;

import DTO.Khuyenmai;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Quanlykhuyenmai_BUS {




    private ArrayList<Khuyenmai> dskm = new ArrayList<>();
    Quanlykhuyenmai dskmDAO = new Quanlykhuyenmai();

    public Quanlykhuyenmai_BUS() {
        dskm = dskmDAO.readDB();
    }

    public void showConsole() {
        dskm.forEach((km) -> {
            System.out.print(km.getMaKM()+ " ");
            System.out.print(km.getLoaiKM()+ " ");
            System.out.print(km.getChitietKM()+ " ");
            //System.out.println(km.getPhanTramKM()+ " ");
            System.out.println(km.getNgayBD()+ " ");
            System.out.println(km.getNgayKT());
        });
    }

    public String[] getHeaders() {
        return new String[]{"Mã khuyến mãi", "Tên khuyến mãi", "Chi tiết khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc"};
    }

    public void readDB() {
        dskm = dskmDAO.readDB();
    }
    
    public String getNextID() {
        return "KM" + String.valueOf(this.dskm.size() + 1);
    }

    public Khuyenmai getKhuyenmai(String makm) {
        for (Khuyenmai km : dskm) {
            if (km.getMaKM().equals(makm)) {
                return km;
            }
        }
        return null;
    }

    public ArrayList<Khuyenmai> search(String value, String type, LocalDate ngay1, LocalDate ngay2) {
        ArrayList<Khuyenmai> result = new ArrayList<>();

        dskm.forEach(new Consumer<Khuyenmai>() {

            public void accept(Khuyenmai km) {
                if (type.equals("Tất cả")) {
                    if (km.getMaKM().toLowerCase().contains(value.toLowerCase())
                           
                            || km.getLoaiKM().toLowerCase().contains(value.toLowerCase())
                             || km.getChitietKM().toLowerCase().contains(value.toLowerCase())
                            //  || String.valueOf(km.getPhanTramKM()).toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(km.getNgayBD()).toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(km.getNgayKT()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(km);
                    }
                } else {
                    switch (type) {
                        case "Mã khuyến mãi":
                            if (km.getMaKM().toLowerCase().contains(value.toLowerCase())) {
                                result.add(km);
                            }
                            break;
                        case "Loại khuyến mãi":
                            if (km.getLoaiKM().toLowerCase().contains(value.toLowerCase())) {
                                result.add(km);
                            }
                            break;
                        case "Chi tiết khuyến mãi":
                            if (km.getChitietKM().toLowerCase().contains(value.toLowerCase())) {
                                result.add(km);
                            } 
                            break;
                        case "Ngày bắt đầu":
                            if (String.valueOf(km.getNgayBD()).toLowerCase().contains(value.toLowerCase())) {
                                result.add(km);
                            }
                            break;
                        case "Ngày kết thúc":
                            if (String.valueOf(km.getNgayKT()).toLowerCase().contains(value.toLowerCase())) {
                                result.add(km);
                            }
                            break;
                    }
                }
            }
        });

        for (int i = result.size() - 1; i >= 0; i--) {
            Khuyenmai km = result.get(i);
            //float dkkm = km.getDieuKienKM();
           // float phantram = km.getPhanTramKM();
            LocalDate ngaybd = km.getNgayBD();
            LocalDate ngaykt = km.getNgayKT();
            
            //Boolean dkKhongThoa = (dk1 != -1 && dkkm < dk1) || (dk2 != -1 && dkkm > dk2);
            //Boolean phantramKhongThoa = (phantram1 != -1 && phantram < phantram1) || (phantram2 != -1 && phantram > phantram2);
            Boolean ngayBDKhongThoa = (ngay1 != null && ngaybd.isBefore(ngay1)) || (ngay2 != null && ngaybd.isAfter(ngay2));
            Boolean ngayKTKhongThoa = (ngay1 != null && ngaykt.isBefore(ngay1)) || (ngay2 != null && ngaykt.isAfter(ngay2));

            if ( (ngayBDKhongThoa && ngayKTKhongThoa)) {
                result.remove(i);
            }
        }

        return result;
    }

    public Boolean add(Khuyenmai km) {
        Boolean ok = dskmDAO.add(km);

        if (ok) {
            dskm.add(km);
        }
        return ok;
    }

    public Boolean add(String makm, String loaikm, String chitietkm, LocalDate ngaybd, LocalDate ngaykt) {
        Khuyenmai sp = new Khuyenmai(makm, loaikm, chitietkm, ngaybd, ngaykt);
        return add(sp);
    }

    public Boolean delete(String makm) {
        Boolean ok = dskmDAO.delete(makm);

        if (ok) {
            for (int i = (dskm.size() - 1); i >= 0; i--) {
                if (dskm.get(i).getMaKM().equals(makm)) {
                    dskm.remove(i);
                }
            }
        }
        return ok;
    }

     public Boolean update(String makm, String loaikm, String chitietkm, LocalDate ngaybd, LocalDate ngaykt) {
        Boolean ok = dskmDAO.update(makm, loaikm, chitietkm, ngaybd, ngaykt);

        if (ok) {
            dskm.forEach((km) -> {
                if (km.getMaKM().equals(makm)) {
                    km.setLoaiKM(loaikm);
                    km.setChitietKM(chitietkm);
                   // km.setPhanTramKM(phantramkm);
                    km.setNgayBD(ngaybd);
                    km.setNgayKT(ngaykt);
                }
            });
        }

        return ok;
    }

    public ArrayList<Khuyenmai> getDskm() {
        return dskm;
    }

    private static class Quanlykhuyenmai {

        public Quanlykhuyenmai() {
        }

        private Boolean delete(String makm) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Boolean add(Khuyenmai km) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Boolean update(String makm, String loaikm, String chitietkm, LocalDate ngaybd, LocalDate ngaykt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private ArrayList<Khuyenmai> readDB() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}

*/
