package cn.itcast.crm.domain;

import java.io.Serializable;

/**
 * 客户实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午9:09:19
 * @version 1.0
 */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -7731334266219547588L;
	/** 编号 */
	private int id;
	/** 姓名 */
	private String name;
	/** 所属单位 */
	private String station;
	/** 手机号码 */
	private String phone;
	/** 联系地址 */
	private String address;
	/** 定区id */
	private long fixedAreaId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getFixedAreaId() {
		return fixedAreaId;
	}
	public void setFixedAreaId(long fixedAreaId) {
		this.fixedAreaId = fixedAreaId;
	}
}
