package mall.demo.mybatis.pojo;

import mall.demo.util.UserStatus;

public class User {
	private int userId;
	private String loginName;
	private String password;
	private String nickname;
	private String email;
	private int status;
	private String photoPath;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getStatusDisplay() {
		return UserStatus.getDisplay(status);
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getDisplayName() {
		if(this.nickname == null || "".equals(this.nickname.trim())) {
			return this.loginName;
		}
		return this.nickname;
	}
	
	public String toString() {
		return "[userId:" + this.userId + ",loginName:" + this.loginName
				+ ",password:******,nickname:" + this.nickname
				+ ",email:" + this.email + "]";
	}

}
