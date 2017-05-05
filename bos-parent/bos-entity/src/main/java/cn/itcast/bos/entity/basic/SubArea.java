package cn.itcast.bos.entity.basic;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 分区实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-10-3 下午4:11:10
 * @version 1.0
 */
@Entity @Table(name="BOS_BC_SUBAREA")
public class SubArea implements Serializable{
	
	private static final long serialVersionUID = 4999237424921659701L;
	/** ID	NUMBER	编号	PK(主键，自动增长)*/
	@Id 
	@SequenceGenerator(name="bc_subArea", 
			sequenceName="BC_SUBAREA_SEQUENCE", allocationSize=1)
	@GeneratedValue(generator="bc_subArea")
	@Column(name="ID")
	private Long id;
	/** FIXEDAREA_ID	number	 FK(BOS_BC_FIXEDAREA) 定区实体*/
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=FixedArea.class)
	@JoinColumn(name="FIXEDAREA_ID", referencedColumnName="ID")
	private FixedArea fixedArea;
	/** region_id	number		FK(BOS_BC_REGION) 区域实体 */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Region.class)
	@JoinColumn(name="REGION_ID", referencedColumnName="ID")
	private Region region;
	/** Address_key	VARCHAR(100) 关键字 */
	@Column(name="ADDRESS_KEY", length=100)
	private String addressKey;
	/** Start_num	number	开始号	*/
	@Column(name="START_NUM")
	private Integer startNum;
	/** End_num	number	终止号	*/
	@Column(name="END_NUM")
	private Integer endNum;
	/** single	Number 单双号	*/
	@Column(name="SINGLE")
	private Integer single;
	/** position VARCHAR(255) 位置 */	
	@Column(name="POSITION", length=255)
	private String position;
	
	/** setter and getter method */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FixedArea getFixedArea() {
		return fixedArea;
	}
	public void setFixedArea(FixedArea fixedArea) {
		this.fixedArea = fixedArea;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getAddressKey() {
		return addressKey;
	}
	public void setAddressKey(String addressKey) {
		this.addressKey = addressKey;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getEndNum() {
		return endNum;
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	public Integer getSingle() {
		return single;
	}
	public void setSingle(Integer single) {
		this.single = single;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}