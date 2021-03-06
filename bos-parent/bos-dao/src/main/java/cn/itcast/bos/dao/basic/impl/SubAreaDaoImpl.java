package cn.itcast.bos.dao.basic.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.basic.SubAreaDao;
import cn.itcast.bos.entity.basic.SubArea;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;
import cn.itcast.bos.pojo.SubAreaBean;

/**
 * 分区数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:16:58
 * @version 1.0
 */
@Repository("subAreaDao")
public class SubAreaDaoImpl extends HibernateDaoImpl implements SubAreaDao {
	/**
	 * 多条件分页查询分区
	 * @param subArea 分区实体
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	public List<SubArea> getSubAreaByPage(SubArea subArea, PageModel pageModel){
		StringBuilder hql = new StringBuilder();
		hql.append("select sa from SubArea as sa where 1=1");
		/** 定义List集合封装查询条件 */
		List<Object> params = new ArrayList<>();
		/** 判断添加查询条件 */
		if (subArea != null && subArea.getRegion() != null){
			/** 省 */
			if (!StringUtils.isEmpty(subArea.getRegion().getProvince())){
				hql.append(" and sa.region.province like ?");
				params.add("%" + subArea.getRegion().getProvince() + "%");
			}
			/** 市 */
			if (!StringUtils.isEmpty(subArea.getRegion().getCity())){
				hql.append(" and sa.region.city like ?");
				params.add("%" + subArea.getRegion().getCity() + "%");
			}
			/** 区 */
			if (!StringUtils.isEmpty(subArea.getRegion().getDistrict())){
				hql.append(" and sa.region.district like ?");
				params.add("%" + subArea.getRegion().getDistrict() + "%");
			}
		}
		if (subArea != null && !StringUtils.isEmpty(subArea.getAddressKey())){
			hql.append(" and sa.addressKey like ?");
			params.add("%" + subArea.getAddressKey() + "%");
		}
		return this.findByPage(hql.toString(), pageModel, params);
	}
	/**
	 * 查询分区数据
	 * @return 集合
	 */
	public List<SubAreaBean> getAllSubArea(){
		String hql = "select new cn.itcast.bos.pojo.SubAreaBean(sa) from SubArea sa order by sa.id asc";
		return this.find(hql);
	}
	/**
	 * 根据定区id查询关联的分区
	 * @param id 定义的id
	 * @return 分区的集合
	 */
	@SuppressWarnings("unchecked")
	public List<SubArea> getSubAreaByFixedArea(Long id){
		String hql = "select sa from SubArea sa where sa.fixedArea.id = ? order by id asc";
		return (List<SubArea>)this.find(hql, new Object[]{id});
	}
}
