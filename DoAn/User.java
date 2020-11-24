package DTO;

public class User {
	private String userName, password, maKH, email, tenUser, sdt, loginDate, maNV;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
	public User() {
		
	}
	public User(String userName, String password, String maKH, String email, String tenUser, String sdt, String loginDate, String maNV) {
		this.userName = userName;
		this.password = password;
		this.maKH = maKH;
                this.maNV = maNV;
		this.email = email;
		this.tenUser = tenUser;
		this.sdt = sdt;
		this.loginDate = loginDate;
	}
	//GETTER
		public String getUserName() {
			return userName;
		}
		public String getPassword() {
			return password;
		}
		public String getMaKH() {
			return maKH;
		}
		public String getEmail() {
			return email;
		}
		public String getTenUser() {
			return tenUser;
		}
		public String getSdt() {
			return sdt;
		}
		public String getLoginDate() {
			return loginDate;
		}
	//SETTER
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setTenUser(String tenUser) {
			this.tenUser = tenUser;
		}
		public void setSdt(String sdt) {
			this.sdt = sdt;
		}
		public void setLoginDate(String loginDate) {
			this.loginDate = loginDate;
		}
}
