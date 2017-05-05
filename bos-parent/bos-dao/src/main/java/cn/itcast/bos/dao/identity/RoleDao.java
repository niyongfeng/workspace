package cn.itcast.bos.dao.identity;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;

/**
 * 角色数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午2:39:16
 * @version 1.0
 */
public interface RoleDao extends HibernateDao{
	/**
	 * 分页查询角色
	 * @param pageModel 分页实体
	 * @return List
	 */
	List<Map<String, Object>> getRoleByPage(PageModel pageModel);
	/**
	 * 批量删除角色
	 * @param ids
	 */
	void deleteRole(String[] ids);
	/**
	 * 获取所有的角色
	 * @return List
	 */
	List<Map<String, Object>> getAllRole();
	
}
