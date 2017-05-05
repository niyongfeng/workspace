package cn.itcast.bos.dao.identity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.itcast.bos.dao.identity.ResourceDao;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 资源数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:10:17
 * @version 1.0
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends HibernateDaoImpl implements ResourceDao {
	/**
	 * 获取资源树的数据 
	 * @return List
	 */
	public List<Map<String, Object>> getResourceByCodeAndName(){
		String hql = "select new map(code as id, name as name) from Resource order by code asc";
		return this.find(hql);
	}
	/**
	 * 分页查询资源
	 * @param parentCode 父级code
	 * @param pageModel 分页实体
	 * @return List
	 */
	public List<Map<String, Object>> getResourceByPage(String parentCode,
			PageModel pageModel, int codeLen){
		//select * from bos_id_resource where length(code) = 4 // 没有传父级code
        //select * from bos_id_resource where length(code) = 8 and code like '0001%' // 传父级code 0001
		StringBuilder hql = new StringBuilder();
		hql.append("select new map(code as code, name as name,type as type,")
		   .append("permission as permission,url as url) from Resource where length(code) = ?");
		/** 定义List集合封装查询条件 */
		List<Object> params = new ArrayList<>();
		if (!StringUtils.isEmpty(parentCode)){
			hql.append(" and code like ?");
			params.add(parentCode.length() + codeLen);
			params.add(parentCode + "%");
		}else{
			params.add(codeLen);
		}
		hql.append(" order by code asc");
		return this.findByPage(hql.toString(), pageModel, params);
	}
	/**
	 * 批量删除资源
	 * @param codes
	 */
	public void deleteResource(String[] codes){
		// delete from bos_id_resource where code like '0006%' or code like '0007%'
		StringBuilder hql = new StringBuilder();
		hql.append("delete from Resource where");
		List<Object> params = new ArrayList<>();
		for (int i = 0; i < codes.length; i++){
			hql.append( i == 0 ? " code like ?" : " or code like ?");
			params.add(codes[i] + "%");
		}
		this.bulkUpdate(hql.toString(), params.toArray());
	}
	/**
	 * 查询所有的资源
	 * @return List
	 */
	public List<Map<String, Object>> getAllResource(){
		StringBuilder hql = new StringBuilder();
		hql.append("select new map(code as code, name as name,type as type,")
		   .append("permission as permission,url as url) from Resource order by code asc");
		return this.find(hql.toString());
	}
	/**
	 * 根据登录用户userId，查询他所有角色，再根据角色查询他所有的资源
	 * @param userId 用户id
	 * @return 集合
	 */
	@SuppressWarnings("unchecked")
	public List<String> getResourceByUserId(String userId){
		StringBuilder hql = new StringBuilder();
		hql.append("select r.code from Resource r inner join r.roles as ro ")
		   .append(" inner join ro.users as u where u.userId = ? ")
		   .append(" group by r.code order by r.code asc");
		return (List<String>)this.find(hql.toString(), new Object[]{userId});
	}
}
