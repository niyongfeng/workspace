package cn.itcast.bos.entity.basic;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 取派员实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-10-3 下午4:11:10
 * @version 1.0
 */
@Entity @Table(name="BOS_BC_STAFF")
public class Staff implements Serializable{
	
	private static final long serialVersionUID = 6670028275248371072L;
	/** ID	NUMBER	编号	PK(主键，自动增长)*/
	@Id 
	@SequenceGenerator(name="bc_staff", sequenceName="BC_STAFF_SEQUENCE",allocationSize=1)
	@GeneratedValue(generator="bc_staff")
	@Column(name="ID")
	private Long id;
	/** name  VARCHAR(100)	姓名	*/
	@Column(name="NAME", length=100)
	private String name;
	/** phone VARCHAR(20) 手机号码	*/
	@Column(name="PHONE", length=20)
	private String phone;
	/** DEL_FLAG smallint(6)	 删除标识位，1：已删除 0：未删除*/
	@Column(name="DEL_FLAG")
	private Short delFlag = 0;
	/** station	VARCHAR(50)	所属单位 */
	@Column(name="STATION", length=50)
	private String station;
	/** standard	VARCHAR(100) 取派标准 */
	@Column(name="STANDARD", length=100)
	private String standard;
	
	/** setter and getter method */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Short getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Short delFlag) {
		this.delFlag = delFlag;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
}