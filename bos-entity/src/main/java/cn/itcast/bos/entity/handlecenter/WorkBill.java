package cn.itcast.bos.entity.handlecenter;

import java.util.Date;

import javax.persistence.*;

import cn.itcast.bos.entity.basic.Staff;


/**
 * 工单实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-10-3 下午5:08:38
 * @version 1.0
 */
@Entity @Table(name="BOS_HC_WORKBILL")
public class WorkBill implements java.io.Serializable {

	private static final long serialVersionUID = 3004191333543873724L;
	/** ID	VARCHER(100) 工单编号	PK(主键)*/
	@Id @Column(name="ID")
	private String id;
	/** BNB_ID	number	对应的业务通知单	FK(BOS_HC_BUSINESSNOTICEBILL)*/
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BNB_ID", referencedColumnName="ID")
	private BusinessNoticeBill businessNoticeBill;
	/** staff_id	number	对应的取派员	FK(BOS_BC_STAFF)*/
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STAFF_ID", referencedColumnName="ID")
	private Staff staff;
	/** type SMALLINT(6) 工单类型	1新单、2改单、3销单*/
	@Column(name="TYPE")
	private Short type = 1;
	/** take_state	SMALLINT(6)	取件状态	1未取件、2取件中、3已取件、4已销单*/
	@Column(name="TAKE_STATE")
	private Short takeState = 1;
	/** build_time	DATETIME 工单生成时间	*/
	@Column(name="BUILD_TIME")
	private Date buildTime;
	/** remark	VARCHAR(255)	备注	*/
	@Column(name="REMARK", length=255)
	private String remark;
	
	/** setter and getter method */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BusinessNoticeBill getBusinessNoticeBill() {
		return businessNoticeBill;
	}
	public void setBusinessNoticeBill(BusinessNoticeBill businessNoticeBill) {
		this.businessNoticeBill = businessNoticeBill;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Short getTakeState() {
		return takeState;
	}
	public void setTakeState(Short takeState) {
		this.takeState = takeState;
	}
}