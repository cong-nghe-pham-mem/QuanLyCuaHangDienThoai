package DTO;

public class KhachHang {
	private String maKh, tenKH, gender, CMND, sdt, birthDate, maGiamGia;
	public KhachHang() {
		
	}
	/**
	 * @param maKh
	 * @param tenKH
	 * @param gender
	 * @param cMND
	 * @param sdt
	 * @param birthDate
	 * @param maGiamGia
	 */
	public KhachHang(String maKh, String tenKH, String gender, String cMND, String sdt, String birthDate,
			String maGiamGia) {
		this.maKh = maKh;
		this.tenKH = tenKH;
		this.gender = gender;
		CMND = cMND;
		this.sdt = sdt;
		this.birthDate = birthDate;
		this.maGiamGia = maGiamGia;
	}

    public KhachHang(String text, String text0, String gend, String birthDate, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	//GETTER
		/**
		 * @return the maKh
		 */
		public String getMaKh() {
			return maKh;
		}
		/**
		 * @return the tenKH
		 */
		public String getTenKH() {
			return tenKH;
		}
		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * @return the cMND
		 */
		public String getCMND() {
			return CMND;
		}
		/**
		 * @return the sdt
		 */
		public String getSdt() {
			return sdt;
		}
		/**
		 * @return the birthDate
		 */
		public String getBirthDate() {
			return birthDate;
		}
		/**
		 * @return the maGiamGia
		 */
		public String getMaGiamGia() {
			return maGiamGia;
		}
	//END OF GETTER
		
	//SETTER
		/**
		 * @param maKh the maKh to set
		 */
		public void setMaKh(String maKh) {
			this.maKh = maKh;
		}
		/**
		 * @param tenKH the tenKH to set
		 */
		public void setTenKH(String tenKH) {
			this.tenKH = tenKH;
		}
		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}
		/**
		 * @param cMND the cMND to set
		 */
		public void setCMND(String cMND) {
			CMND = cMND;
		}
		/**
		 * @param sdt the sdt to set
		 */
		public void setSdt(String sdt) {
			this.sdt = sdt;
		}
		/**
		 * @param birthDate the birthDate to set
		 */
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		/**
		 * @param maGiamGia the maGiamGia to set
		 */
		public void setMaGiamGia(String maGiamGia) {
			this.maGiamGia = maGiamGia;
		}
		
	//END OF SETTER

    public String getMaKH() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
