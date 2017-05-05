package cn.itcast.bos.dao.basic;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.entity.basic.FixedArea;
import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;

/**
 * 定区数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:12:26
 * @version 1.0
 */
public interface FixedAreaDao extends HibernateDao {
	/**
	 * 查询定区的数据(id与name)
	 * @return List
	 */
	List<Map<String, Object>> getFixedAreaByIdAndName();
	/**
	 * 分页查询定区
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	List<FixedArea> getFixedAreaByPage(PageModel pageModel);

}
