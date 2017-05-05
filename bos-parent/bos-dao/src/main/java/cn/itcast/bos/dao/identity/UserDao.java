package cn.itcast.bos.dao.identity;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.entity.identity.User;
import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;

/**
 * 用户数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午2:39:16
 * @version 1.0
 */
public interface UserDao extends HibernateDao{
	/**
	 * 多条件分页查询用户
	 * @param pageModel 分页实体
	 * @param user 用户实体
	 * @return 集合
	 */
	List<Map<String, Object>> getUserByPage(PageModel pageModel, User user);
	/**
	 * 批量删除用户
	 * @param userIds
	 */
	void deleteUser(String[] userIds);
	/**
	 * 批量审核用户
	 * @param userIds
	 * @param status
	 */
	void checkUser(String[] userIds, Short status);
	
}
