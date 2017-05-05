package cn.itcast.bos.dao.identity.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.identity.DeptDao;
import cn.itcast.bos.entity.identity.Dept;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 部门数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:07:37
 * @version 1.0
 */
@Repository("deptDao")
public class DeptDaoImpl extends HibernateDaoImpl implements DeptDao {
	/**
	 * 分页查询部门
	 * @param pageModel 分页实体
	 * @return 部门集合
	 */
	public List<Dept> getDeptByPage(PageModel pageModel){
		return this.findByPage("from Dept order by id asc", pageModel, null);
	}
	/**
	 * 批量删除部门
	 * @param ids
	 */
	public void deleteDept(String[] ids){
		StringBuilder hql = new StringBuilder();
		hql.append("delete from Dept where id in(");
		Integer[] params = new Integer[ids.length];
		for (int i = 0; i < ids.length; i++){
			hql.append(i == 0 ? "?" : ",?");
			params[i] = Integer.valueOf(ids[i]);
		}
		hql.append(")");
		this.bulkUpdate(hql.toString(), params);
	}
	/**
	 * 查询部门(id与name)
	 * @return List
	 */
	public List<Map<String, Object>> getDeptByIdAndName(){
		String hql = "select new map(id as id, name as name) from Dept order by id asc";
		return this.find(hql);
	}
}
