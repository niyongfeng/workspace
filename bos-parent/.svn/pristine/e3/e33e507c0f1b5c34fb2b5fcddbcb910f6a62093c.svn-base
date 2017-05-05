package cn.itcast.bos.entity.identity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 部门持久化类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 上午10:38:45
 * @version 1.0
 */
@Entity @Table(name="BOS_ID_DEPT")
public class Dept implements Serializable {
	
	private static final long serialVersionUID = -5607794123961084706L;
	/** ID	NUMBER	编号	PK主键自增长*/
	@Id 
	@SequenceGenerator(name="ID_DEPT", sequenceName="ID_DEPT_SEQUENCE", allocationSize=1)// 主键值生成器
	@GeneratedValue(generator="ID_DEPT")
	@Column(name="ID")
	private Integer id;
	/** NAME VARCHAR2(50) 部门名称 */
	@Column(name="NAME", length=50)
	private String name;
	/** REMARK	VARCHAR2(200) 备注 */
	@Column(name="REMARK", length=200)
	private String remark;
	
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
