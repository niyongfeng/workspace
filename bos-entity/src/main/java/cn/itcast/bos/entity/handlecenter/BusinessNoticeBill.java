package cn.itcast.bos.entity.handlecenter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cn.itcast.bos.entity.identity.User;

/**
 * 业务通知单实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-10-3 下午4:48:21
 * @version 1.0
 */
@Entity @Table(name="BOS_HC_BUSNOTICEBILL")
public class BusinessNoticeBill implements java.io.Serializable {

	private static final long serialVersionUID = 5567087426573529668L;
	/** ID	Number	编码	PK(主键，自增长)*/
	@Id 
	@SequenceGenerator(name="hc_businessNoticeBill", 
		sequenceName="HC_BUSINESSNOTICEBILL_SEQUENCE",
		allocationSize=1)
	@GeneratedValue(generator="hc_businessNoticeBill")
	@Column(name="ID")
	private Long id;
	/** USER_ID	VARCHAR(50)	受理人当前登录用户 FK(BOS_ID_USER)*/
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	private User user;
	/** customer_id	VARCHAR(50)	客户编号 */
	@Column(name="CUSTOMER_ID", length=50)
	private String customerId;
	/** customer_name	VARCHAR(50)	客户姓名 */
	@Column(name="CUSTOMER_NAME", length=50)
	private String customerName;
	/** CUSTOMER_PHONE	VARCHAR(20)	客户手机号 */
	@Column(name="CUSTOMER_PHONE", length=20)
	private String customerPhone;
	/** DELIVERY_ADDRESS VARCHAR(200) 派送地址 */
	@Column(name="DELIVERY_ADDRESS", length=200)
	private String deliveryAddress;
	/** ORDER_TYPE	SMALLINT(6)	分单类型  0:自动  1:手动  2:人工 */
	@Column(name="ORDER_TYPE")
	private Short orderType = 0;
	/** SGB_ID NUMBER	发货单编号 FK(BOS_HC_SENDGOODSBILL) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=SendGoodsBill.class)
	@JoinColumn(name="SGB_ID", referencedColumnName="ID")
	private SendGoodsBill sendGoodsBill;
	
	/** setter and getter method */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public SendGoodsBill getSendGoodsBill() {
		return sendGoodsBill;
	}
	public void setSendGoodsBill(SendGoodsBill sendGoodsBill) {
		this.sendGoodsBill = sendGoodsBill;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public Short getOrderType() {
		return orderType;
	}
	public void setOrderType(Short orderType) {
		this.orderType = orderType;
	}
}