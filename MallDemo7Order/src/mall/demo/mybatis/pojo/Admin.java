package mall.demo.mybatis.pojo;

public class Admin {
	private int adminId;
	private String loginName;
	private String password;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "[adminId:" + this.adminId + ",loginName:"
				+ this.loginName + ",password:******]";
	}

}
