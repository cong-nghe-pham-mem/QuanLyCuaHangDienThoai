package DTO;

public class NhanVien {
	private String maNV, tenNV, gender, birthDate, sdt, CMND, chucvu, ngayvaolam;
	private int roleID;
	public NhanVien() {
		
	}
	/**
	 * @param maNV
	 * @param tenNV
	 * @param gender
	 * @param birthDate
	 * @param sdt
	 * @param cMND
	 * @param chucvu
	 * @param ngayvaolam
	 */
	public NhanVien(String maNV, String tenNV, String gender, String birthDate, String sdt, String cMND, String chucvu,
			String ngayvaolam, int roleID) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gender = gender;
		this.birthDate = birthDate;
		this.sdt = sdt;
		CMND = cMND;
		this.chucvu = chucvu;
		this.ngayvaolam = ngayvaolam;
		this.roleID = roleID;
	}

    public NhanVien(String text, String text0, String gend, String birthDate, String text1, String text2, String workDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	//GETTER
		/**
		 * @return the maNV
		 */
		public String getMaNV() {
			return maNV;
		}
		/**
		 * @return the tenNV
		 */
		public String getTenNV() {
			return tenNV;
		}
		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * @return the birthDate
		 */
		public String getBirthDate() {
			return birthDate;
		}
		/**
		 * @return the sdt
		 */
		public String getSdt() {
			return sdt;
		}
		/**
		 * @return the cMND
		 */
		public String getCMND() {
			return CMND;
		}
		/**
		 * @return the chucvu
		 */
		public String getChucvu() {
			return chucvu;
		}
		/**
		 * @return the ngayvaolam
		 */
		public String getNgayvaolam() {
			return ngayvaolam;
		}
		public int getRoleID() {
			return roleID;
		}
	//END OF GETTER
		
	//SETTER
		/**
		 * @param maNV the maNV to set
		 */
		public void setMaNV(String maNV) {
			this.maNV = maNV;
		}
		/**
		 * @param tenNV the tenNV to set
		 */
		public void setTenNV(String tenNV) {
			this.tenNV = tenNV;
		}
		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}
		/**
		 * @param birthDate the birthDate to set
		 */
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		/**
		 * @param sdt the sdt to set
		 */
		public void setSdt(String sdt) {
			this.sdt = sdt;
		}
		/**
		 * @param cMND the cMND to set
		 */
		public void setCMND(String cMND) {
			CMND = cMND;
		}
		/**
		 * @param chucvu the chucvu to set
		 */
		public void setChucvu(String chucvu) {
			this.chucvu = chucvu;
		}
		/**
		 * @param ngayvaolam the ngayvaolam to set
		 */
		public void setNgayvaolam(String ngayvaolam) {
			this.ngayvaolam = ngayvaolam;
		}
		public void setRoleID(int roleID) {
			this.roleID = roleID;
		}
	//END OF SETTER
}	
