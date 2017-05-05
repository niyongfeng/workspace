package cn.itcast.bos.entity.identity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 资源持久化类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 上午10:38:45
 * @version 1.0
 */
@Entity @Table(name="BOS_ID_RESOURCE")
public class Resource implements Serializable {
	private static final long serialVersionUID = -789245912654524752L;
	/**
	 * CODE	VARCHAR2(100)	资源代码	
	 * PK主键(0001...0002)四位 (00010001..)八位
	 */
	@Id @Column(name="CODE", length=100)
	private String code;
	/** NAME	VARCHAR2(50)	资源名称 */
	@Column(name="NAME", length=50)
	private String name;
	/** TYPE	VARCHAR2(10)	资源类型	MENU与BUTTON*/
	@Column(name="TYPE", length=10)
	private String type;
	/** URL	VARCHAR2(100)	资源请求URL */
	@Column(name="URL", length=100)
	private String url;
	/** PERMISSION	VARCHAR2(100)	资源请求权限	*/
	@Column(name="PERMISSION", length=100)
	private String permission;
	/** 资源与角色存在多对多 (中间表) mappedBy: 写关联的持久类中哪个属性关联了自己，代表不维护中间表 */
	@ManyToMany(fetch=FetchType.LAZY, targetEntity=Role.class, mappedBy="resources")
	private Set<Role> roles = new HashSet<>(0);
	
	/** setter and getter method */
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}