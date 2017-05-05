package cn.itcast.bos.entity.identity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 用户持久化类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 上午10:38:45
 * @version 1.0
 */
@Entity @Table(name="BOS_ID_USER")
public class User implements Serializable {
	
	private static final long serialVersionUID = -7042107298321273325L;
	/** USER_ID	VARCHAR2(50)	用户ID	PK，大小写英文和数字*/
	@Id @Column(name="USER_ID", length=50)
	private String userId;
	/** PASS_WORD	VARCHAR2(50)	密码	MD5加密*/
	@Column(name="PASS_WORD", length=50)
	private String password;
	/** SALT	VARCHAR2(50)	加密盐	*/
	@Column(name="SALT", length=50)
	private String salt;
	/** NAME	VARCHAR2(50)	姓名	*/
	@Column(name="NAME", length=50)
	private String name;
	/** SEX	NUMBER	性别	1:男 2:女*/
	@Column(name="SEX")
	private Short sex = 1;
	/** 
	 * DEPT_ID	NUMBER	部门	FK(BOS_ID_DEPT)
	 * 用户与部门存在多对一
	 */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Dept.class)
	/** 生成外键列 */
	@JoinColumn(name="DEPT_ID", referencedColumnName="ID")
	private Dept dept;
	/**
	 * JOB_ID	NUMBER	职位	FK(BOS_ID_JOB)
	 * 用户与职位存在多对一
	 */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Job.class)
	/** 生成外键列 */
	@JoinColumn(name="JOB_ID", referencedColumnName="ID")
	private Job job;
	/** EMAIL	VARCHAR2(50) 邮箱	*/
	@Column(name="EMAIL", length=50)
	private String email;
	/** PHONE	VARCHAR2(50) 手机号码  */
	@Column(name="PHONE", length=50)
	private String phone;
	/** SALARY	NUMBER	薪水	*/
	@Column(name="SALARY")
	private Float salary;
	/** 
	 * BIRTHDAY DATETIME 生日
	 * TemporalType.DATE: yyyy-MM-dd
	 * TemporalType.TIMESTAMP: yyyy-MM-dd HH:mm:ss
	 * TemporalType.TIME: HH:mm:ss
	 **/
	@Column(name="BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	/** STATUS	NUMBER	状态	0新建,1审核,2不通过审核,3冻结 */
	@Column(name="STATUS")
	private Short status = 0;
	/** 用户与角色存在多对多 (中间表BOS_ID_USER_ROLE) 维护中间表 */
	@ManyToMany(fetch=FetchType.LAZY, targetEntity=Role.class)
	/** 生成中间表 */
	@JoinTable(name="BOS_ID_USER_ROLE", 
			   joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="USER_ID"),
			   inverseJoinColumns=@JoinColumn(name="ROLE_ID", referencedColumnName="ID")) // mappedBy的属性这边
	private Set<Role> roles = new HashSet<>(0);
	
	/** setter and getter method */
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}