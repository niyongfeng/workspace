package cn.itcast.bos.dao.identity.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.identity.RoleDao;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 角色数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:10:49
 * @version 1.0
 */
@Repository("roleDao")
public class RoleDaoImpl extends HibernateDaoImpl implements RoleDao {
	/**
	 * 分页查询角色
	 * @param pageModel 分页实体
	 * @return List
	 */
	public List<Map<String, Object>> getRoleByPage(PageModel pageModel){
		String hql = "select new map(id as id,name as name,code as code,remark as remark) from Role r order by id asc";
		return this.findByPage(hql, pageModel, null);
	}
	/**
	 * 批量删除角色
	 * @param ids
	 */
	public void deleteRole(String[] ids){
		StringBuilder hql = new StringBuilder();
		hql.append("delete from Role where id in(");
		Integer[] params = new Integer[ids.length];
		for (int i = 0; i < ids.length; i++){
			hql.append(i == 0 ? "?" : ",?");
			params[i] = Integer.valueOf(ids[i]);
		}
		hql.append(")");
		this.bulkUpdate(hql.toString(), params);
	}
	/**
	 * 获取所有的角色
	 * @return List
	 */
	public List<Map<String, Object>> getAllRole(){
		String hql = "select new map(id as id,name as name,code as code,remark as remark) from Role r order by id asc";
		return this.find(hql);
	}
}
