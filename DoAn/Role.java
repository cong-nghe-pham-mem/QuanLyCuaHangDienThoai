package DTO;

public class Role {
	private String roleName;
	private int roleID;
        private String chitiet;
	public Role() {
		
	}
	public Role(int roleID, String roleName, String chitiet) {
		this.roleID = roleID;
		this.roleName = roleName;
                this.chitiet = chitiet;
	}

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }
	//GETTER
		public int getRoleID() {
			return roleID;
		}
		public String getRoleName() {
			return roleName;
		}
	//SETTER
		public void setRoleID(int roleID) {
			this.roleID = roleID;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
                
                @Override
                public String toString(){
                    return this.roleName;
                }
}
