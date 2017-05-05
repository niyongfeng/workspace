package cn.itcast.bos.dao.identity.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.identity.JobDao;
import cn.itcast.bos.entity.identity.Job;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 职位数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:09:33
 * @version 1.0
 */
@Repository("jobDao")
public class JobDaoImpl extends HibernateDaoImpl implements JobDao {
	/**
	 * 分页查询职位
	 * @param pageModel 分页实体
	 * @return 职位集合
	 */
	public List<Job> getJobByPage(PageModel pageModel){
		String hql = "select j from Job j order by j.id asc";
		return this.findByPage(hql, pageModel, null);
	}
	/**
	 * 批量删除职位
	 * @param ids
	 */
	public void deletJob(String[] ids){
		// delete from bos_id_job where id in(?,?,?)
		StringBuilder hql = new StringBuilder();
		hql.append("delete from Job where id in(");
		/** 定义数组封装hql语句占符中的值 */
		Integer[] params = new Integer[ids.length];
		for (int i = 0; i < ids.length; i++){
			hql.append(i == 0 ? "?" : ",?");
			params[i] = Integer.valueOf(ids[i]);
		}
		hql.append(")");
		this.bulkUpdate(hql.toString(), params);
	}
	/**
	 * 查询职位(id与name)
	 * @return List
	 */
	public List<Map<String, Object>> getJobByIdAndName(){
		String hql = "select new map(id as id, name as name) from Job order by id asc";
		return this.find(hql);
	}
}
