package cn.itcast.bos.pojo;

import cn.itcast.bos.entity.basic.SubArea;

/**
 * 分区数据传输类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月10日 上午10:51:10
 * @version 1.0
 */
public class SubAreaBean {
	// "编号","省","市","区(县)","关键字","位置"
	private Long id;
	private String province;
	private String city;
	private String district;
	private String addressKey;
	private String position;
	
	public SubAreaBean(){}
	public SubAreaBean(SubArea subArea){
		this.id = subArea.getId();
		this.province = subArea.getRegion().getProvince();
		this.city = subArea.getRegion().getCity();
		this.district = subArea.getRegion().getDistrict();
		this.addressKey = subArea.getAddressKey();
		this.position = subArea.getPosition();
	}
	/** setter and getter method */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddressKey() {
		return addressKey;
	}
	public void setAddressKey(String addressKey) {
		this.addressKey = addressKey;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}