package cn.itcast.bos.entity.basic;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 区域实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-10-3 下午4:11:10
 * @version 1.0
 */
@Entity @Table(name="BOS_BC_REGION")
public class Region implements Serializable{

	private static final long serialVersionUID = 3181598372906907229L;
	/** ID	VARCHAR(50)	编号	PK(主键)*/
	@Id
	@Column(name="ID", length=50)
	private String id;
	/** province	VARCHAR(50)	省份	*/
	@Column(name="PROVINCE", length=50)
	private String province;
	/** city	VARCHAR(50)	城市	*/
	@Column(name="CITY", length=50)
	private String city;
	/** district	VARCHAR(50)	市区	*/
	@Column(name="DISTRICT", length=50)
	private String district;
	/** post_code	VARCHAR(50)	邮政编码	*/
	@Column(name="POST_CODE", length=50)
	private String postCode;
	/** short_code	VARCHAR(30)	简码	*/
	@Column(name="SHORT_CODE", length=30)
	private String shortCode;
	/** city_code	VARCHAR(30)	城市编码	*/
	@Column(name="CITY_CODE", length=30)
	private String cityCode;
	
	/** setter and getter method */
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getShortCode() {
		return shortCode;
	}
	public String getPCD(){
		return province.substring(0, province.length() - 1) 
			   + city.substring(0, city.length() - 1)
			   + district.substring(0, district.length() - 1);
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}