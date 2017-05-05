package cn.itcast.bos.dao.identity;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.entity.identity.Dept;
import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;

/**
 * 部门数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午2:39:16
 * @version 1.0
 */
public interface DeptDao extends HibernateDao{
	/**
	 * 分页查询部门
	 * @param pageModel 分页实体
	 * @return 部门集合
	 */
	List<Dept> getDeptByPage(PageModel pageModel);
	/**
	 * 批量删除部门
	 * @param ids
	 */
	void deleteDept(String[] ids);
	/**
	 * 查询部门(id与name)
	 * @return List
	 */
	List<Map<String, Object>> getDeptByIdAndName();
	
}
