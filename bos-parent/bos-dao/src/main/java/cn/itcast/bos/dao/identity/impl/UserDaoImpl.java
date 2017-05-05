package cn.itcast.bos.dao.identity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.identity.UserDao;
import cn.itcast.bos.entity.identity.User;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 用户数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:11:28
 * @version 1.0
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoImpl implements UserDao {
	/**
	 * 多条件分页查询用户
	 * @param pageModel 分页实体
	 * @param user 用户实体
	 * @return 集合
	 */
	public List<Map<String, Object>> getUserByPage(PageModel pageModel, User user){
		StringBuilder hql = new StringBuilder();
		hql.append("select new map(u.userId as userId, u.name as name, u.sex as sex,")
		   .append("u.dept.name as deptName,u.job.name as jobName,u.phone as phone,")
		   .append("u.email as email,u.birthday as birthday, u.salary as salary,u.status as status)");
		hql.append(" from User u where 1=1 ");
		/** 定义List集合封装查询条件 */
		List<Object> params = new ArrayList<>();
		/** 添加查询条件 */
		if (user != null){
			/** 姓名 */
			if (!StringUtils.isEmpty(user.getName())){
				hql.append(" and u.name like ? ");
				params.add("%" + user.getName() +"%");
			}
			/** 手机号码 */
			if (!StringUtils.isEmpty(user.getPhone())){
				hql.append(" and u.phone like ? ");
				params.add("%" + user.getPhone() +"%");
			}
			/** 部门 */
			if (user.getDept() != null && user.getDept().getId() != null 
					&& user.getDept().getId() > 0){
				hql.append(" and u.dept.id = ?");
				params.add(user.getDept().getId());
			}
		}
		hql.append(" order by u.userId asc");
		return this.findByPage(hql.toString(), pageModel, params);
	}
	/**
	 * 批量删除用户
	 * @param userIds
	 */
	public void deleteUser(String[] userIds){
		StringBuilder hql = new StringBuilder();
		hql.append("delete from User where userId in(");
		for (int i = 0; i < userIds.length; i++){
			hql.append( i == 0 ? "?" : ",?");
		}
		hql.append(")");
		this.bulkUpdate(hql.toString(), userIds);
	}
	/**
	 * 批量审核用户
	 * @param userIds
	 * @param status
	 */
	public void checkUser(String[] userIds, Short status){
		StringBuilder hql = new StringBuilder();
		hql.append("update User set status = ? where userId in(");
		List<Object> params = new ArrayList<>();
		params.add(status);
		for (int i = 0; i < userIds.length; i++){
			hql.append( i == 0 ? "?" : ",?");
			params.add(userIds[i]);
		}
		hql.append(")");
		this.bulkUpdate(hql.toString(), params.toArray());
	}
}
