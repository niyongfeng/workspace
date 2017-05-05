package cn.itcast.bos.dao.basic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.itcast.bos.dao.basic.RegionDao;
import cn.itcast.bos.entity.basic.Region;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 区域数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:16:58
 * @version 1.0
 */
@Repository("regionDao")
public class RegionDaoImpl extends HibernateDaoImpl implements RegionDao {
	/**
	 * 分页查询区域
	 * @param pageModel 分页实体
	 * @return 区域集合
	 */
	public List<Region> getRegionByPage(PageModel pageModel){
		String hql = "select r from Region r order by r.id asc";
		return this.findByPage(hql, pageModel, null);
	}
	/**
	 * 删除区域
	 * @param ids
	 */
	public void deleteRegion(String[] ids){
		StringBuilder hql = new StringBuilder();
		hql.append("delete from Region where id in(");
		for (int i = 0; i < ids.length; i++){
			hql.append(i == 0 ? "?" : ",?");
		}
		hql.append(")");
		this.bulkUpdate(hql.toString(), ids);
	}
	/**
	 * 查询区域
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getRegionByIdAndName(String q){
		StringBuilder hql = new StringBuilder();
		// select id, province||city|| district as name from bos_bc_region
		hql.append("select new map(id as id, concat(province,city,district) as name) from Region");
		List<Object> params = new ArrayList<>();
		if (!StringUtils.isEmpty(q)){
			hql.append(" where province like ? or city like ? or district like ? or shortCode like ? or cityCode like ?");
			params.add("%" + q + "%");
			params.add("%" + q + "%");
			params.add("%" + q + "%");
			params.add("%" + q + "%");
			params.add("%" + q + "%");
		}
		hql.append(" order by id asc");
		return (List<Map<String, Object>>)this.find(hql.toString(), params.toArray());
	}
}
