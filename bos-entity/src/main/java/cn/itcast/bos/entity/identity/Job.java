package cn.itcast.bos.entity.identity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 职位持久化类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 上午9:41:17
 * @version 1.0
 */
@Entity // 把pojo转化成持久化类
@Table(name="BOS_ID_JOB") // 指定表名
public class Job implements Serializable {
	
	private static final long serialVersionUID = 5660346992578974552L;
	/** ID	NUMBER	编号	PK主键自增长*/
	@Id 
	@SequenceGenerator(name="ID_JOB", sequenceName="ID_JOB_SEQUENCE",allocationSize=1)// 主键值生成器
	@GeneratedValue(generator="ID_JOB")
	@Column(name="ID")
	private Integer id;
	/** NAME VARCHAR2(50) 名称	*/
	@Column(name="NAME", length=50)
	private String name;
	/** REMARK	VARCHAR2(200) 职位说明*/
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