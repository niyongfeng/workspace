package cn.itcast.bos.entity.handlecenter;

import java.util.Date;

import javax.persistence.*;

/**
 * 发货单实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-10-3 下午5:20:20
 * @version 1.0
 */
@Entity @Table(name="BOS_HC_SENDGOODSBILL")
public class SendGoodsBill implements java.io.Serializable {
	
	private static final long serialVersionUID = -5461051185356777859L;
	/** ID	NUMber	货物编号	PK(主键，自动增长)*/
	@Id 
	@SequenceGenerator(name="hc_sendGoodsBill", 
		sequenceName="HC_SENDGOODSBILL_SEQUENCE",allocationSize=1)
	@GeneratedValue(generator="hc_sendGoodsBill")
	@Column(name="ID")
	private Long id;
	/** weight	double	重量	*/
	@Column(name="WEIGHT")
	private Double weight;
	/** ACTL_WEIGHT	double	实际重量 */
	@Column(name="ACTL_WEIGHT")
	private Double actlWeight;
	/** VOLUMN	VARCHAR(20)	体积	*/
	@Column(name="VOLUMN")
	private String volumn;
	/** FEE_NUM	INT(11)	计费件数 */
	@Column(name="FEE_NUM")
	private Integer feeNum = 0;
	/** floadreqr VARCHAR(255) 配置要求	*/
	@Column(name="FLOADREQR", length=255)
	private String floadreqr;
	/** SENDER_NAME	VARCHAR(20)	寄件人姓名	*/
	@Column(name="SENDER_NAME", length=20)
	private String senderName;
	/** SENDER_PHONE	VARCHAR(20)	寄件人电话	*/
	@Column(name="SENDER_PHONE", length=20)
	private String senderPhone;
	/** SENDER_ADDRESS	VARCHAR(200) 寄件人地址	*/
	@Column(name="SENDER_ADDRESS", length=200)
	private String senderAddress;
	/** receiver_name	VARCHAR(20)	收件人姓名	*/
	@Column(name="RECEIVER_NAME", length=20)
	private String receiverName;
	/** receiver_phone	VARCHAR(20)	收件人电话	*/
	@Column(name="RECEIVER_PHONE", length=20)
	private String receiverPhone;
	/** receiver_address VARCHAR(200) 收件人地址	*/
	@Column(name="RECEIVER_ADDRESS", length=200)
	private String receiverAddress;
	/** 
	 * CHECK_STATUS SMALLINT(6) 是否审核 
	 * 0: 新建  1 :已审核
	 */
	@Column(name="CHECK_STATUS")
	private Short checkStatus = 0;
	/** WORK_STATUS	SMALLINT(6)	是否已生成业务通知单  0：否  1:是 */
	@Column(name="WORK_STATUS")
	private Short workStatus = 0;
	/** CREATE_DATE 创建日期 */
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	/** setter and getter method */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getActlWeight() {
		return actlWeight;
	}
	public void setActlWeight(Double actlWeight) {
		this.actlWeight = actlWeight;
	}
	public String getVolumn() {
		return volumn;
	}
	public void setVolumn(String volumn) {
		this.volumn = volumn;
	}
	public Integer getFeeNum() {
		return feeNum;
	}
	public void setFeeNum(Integer feeNum) {
		this.feeNum = feeNum;
	}
	public String getFloadreqr() {
		return floadreqr;
	}
	public void setFloadreqr(String floadreqr) {
		this.floadreqr = floadreqr;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public Short getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Short checkStatus) {
		this.checkStatus = checkStatus;
	}
	public Short getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(Short workStatus) {
		this.workStatus = workStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}