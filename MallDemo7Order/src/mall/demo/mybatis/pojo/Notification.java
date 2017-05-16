package mall.demo.mybatis.pojo;

import java.util.Calendar;
import java.util.Date;

public class Notification {
	private int notificationId;
	private String nType;
	private String token;
	private String info;
	private Date expireTime;

	public Notification() {
		// TODO Auto-generated constructor stub
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getnType() {
		return nType;
	}

	public void setnType(String nType) {
		this.nType = nType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	public boolean isExpired() {
		Calendar cal = Calendar.getInstance();
		if(this.expireTime == null 
				|| this.expireTime.getTime() < cal.getTimeInMillis()) {
			return false;
		}
		return true;
	}

}
