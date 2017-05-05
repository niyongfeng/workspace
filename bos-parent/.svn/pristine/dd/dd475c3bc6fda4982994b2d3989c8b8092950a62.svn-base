package cn.itcast.bos.dao.basic;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.entity.basic.Region;
import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;

/**
 * 区域数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:12:26
 * @version 1.0
 */
public interface RegionDao extends HibernateDao {
	/**
	 * 分页查询区域
	 * @param pageModel 分页实体
	 * @return 区域集合
	 */
	List<Region> getRegionByPage(PageModel pageModel);
	/**
	 * 删除区域
	 * @param ids
	 */
	void deleteRegion(String[] ids);
	/**
	 * 查询区域
	 * @return List
	 */
	List<Map<String, Object>> getRegionByIdAndName(String q);

}
