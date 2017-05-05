package cn.itcast.bos.dao.identity;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;

/**
 * 资源数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午2:39:16
 * @version 1.0
 */
public interface ResourceDao extends HibernateDao{
	/**
	 * 获取资源树的数据 
	 * @return List
	 */
	List<Map<String, Object>> getResourceByCodeAndName();
	/**
	 * 分页查询资源
	 * @param parentCode 父级code
	 * @param pageModel 分页实体
	 * @return List
	 */
	List<Map<String, Object>> getResourceByPage(String parentCode,
			PageModel pageModel, int codeLen);
	/**
	 * 批量删除资源
	 * @param codes
	 */
	void deleteResource(String[] codes);
	/**
	 * 查询所有的资源
	 * @return List
	 */
	List<Map<String, Object>> getAllResource();
	/**
	 * 根据登录用户userId，查询他所有角色，再根据角色查询他所有的资源
	 * @param userId 用户id
	 * @return 集合
	 */
	List<String> getResourceByUserId(String userId);
	
}
