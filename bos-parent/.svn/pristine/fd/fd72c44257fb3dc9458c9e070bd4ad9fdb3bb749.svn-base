package cn.itcast.bos.entity.basic;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 定区实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-10-3 下午4:11:10
 * @version 1.0
 */
@Entity @Table(name="BOS_BC_FIXEDAREA")
public class FixedArea implements Serializable{
	
	private static final long serialVersionUID = 8422529775321785456L;
	/** ID	INT(11)	主键id 定区编号	PK主键 自增长*/
	@Id 
	@SequenceGenerator(name="bc_fixedArea", 
		sequenceName="BC_FIXEDAREA_SEQUENCE",allocationSize=1)
	@GeneratedValue(generator="bc_fixedArea")
	@Column(name="ID")
	private Long id;
	/** name VARCHAR(100)	定区名称	*/
	@Column(name="NAME", length=100)
	private String name;
	/** staff_id int(11) 外键列 FK(BOS_BC_STAFF) 取派员*/
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Staff.class)
	@JoinColumn(name="STAFF_ID", referencedColumnName="ID")
	private Staff staff;
	
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
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}