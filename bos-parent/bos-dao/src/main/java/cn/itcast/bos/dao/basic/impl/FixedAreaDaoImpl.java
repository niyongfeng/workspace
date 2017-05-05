package cn.itcast.bos.dao.basic.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.basic.FixedAreaDao;
import cn.itcast.bos.entity.basic.FixedArea;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 定区数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:16:58
 * @version 1.0
 */
@Repository("fixedAreaDao")
public class FixedAreaDaoImpl extends HibernateDaoImpl implements FixedAreaDao {
	/**
	 * 查询定区的数据(id与name)
	 * @return List
	 */
	public List<Map<String, Object>> getFixedAreaByIdAndName(){
		String hql = "select new map(id as id, name as name) from FixedArea order by id asc";
		return this.find(hql);
	}
	/**
	 * 分页查询定区
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	public List<FixedArea> getFixedAreaByPage(PageModel pageModel){
		String hql = "select fa from FixedArea fa order by id asc";
		return this.findByPage(hql, pageModel, null);
	}
}
