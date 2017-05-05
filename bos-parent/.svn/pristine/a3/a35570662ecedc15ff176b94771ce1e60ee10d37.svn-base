package cn.itcast.bos.entity.identity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 角色持久化类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 上午10:38:45
 * @version 1.0
 */
@Entity @Table(name="BOS_ID_ROLE")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 7864789039563277422L;
	/** ID	NUMBER	ID	PK*/
	@Id
	@SequenceGenerator(name="ID_ROLE", // 主键值生成器
			sequenceName="ID_ROLE_SEQUENCE", 
			allocationSize=1) // 指定主键列的步长
	@GeneratedValue(generator="ID_ROLE")
	@Column(name="ID")
	private Integer id;
	/** NAME VARCHAR2(50) 角色名字*/	
	@Column(name="NAME", length=50)
	private String name;
	/** CODE	VARCHAR2(50)	角色代号 */
	@Column(name="CODE", length=50)
	private String code;
	/** REMARK	VARCHAR2(200) 备注	*/
	@Column(name="REMARK", length=200)
	private String remark;
	/** 角色与用户存在多对多 (中间表BOS_ID_USER_ROLE) mappedBy: 写关联的持久类中哪个属性关联了自己，代表不维护中间表 */
	@ManyToMany(fetch=FetchType.LAZY, targetEntity=User.class, mappedBy="roles")
	private Set<User> users = new HashSet<>(0);
	/** 角色与资源存在多对多 (中间表BOS_ID_ROLE_RESOURCE) 维护中间表 */
	@ManyToMany(fetch=FetchType.LAZY, targetEntity=Resource.class)
	/** 生成中间表 */
	@JoinTable(name="BOS_ID_ROLE_RESOURCE", 
			   joinColumns=@JoinColumn(name="ROLE_ID", referencedColumnName="ID"),
			   inverseJoinColumns=@JoinColumn(name="RESOURCE_CODE", referencedColumnName="CODE")) // mappedBy的属性这边
	private Set<Resource> resources = new HashSet<>(0);
	
	
	/** setter and getter method */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
}