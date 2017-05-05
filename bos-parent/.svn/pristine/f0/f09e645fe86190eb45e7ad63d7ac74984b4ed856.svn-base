package cn.itcast.bos.dao.basic;

import java.util.List;

import cn.itcast.bos.entity.basic.SubArea;
import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;
import cn.itcast.bos.pojo.SubAreaBean;

/**
 * 分区数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:12:26
 * @version 1.0
 */
public interface SubAreaDao extends HibernateDao {
	/**
	 * 多条件分页查询分区
	 * @param subArea 分区实体
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	List<SubArea> getSubAreaByPage(SubArea subArea, PageModel pageModel);
	/**
	 * 查询分区数据
	 * @return 集合
	 */
	List<SubAreaBean> getAllSubArea();
	/**
	 * 根据定区id查询关联的分区
	 * @param id 定义的id
	 * @return 分区的集合
	 */
	List<SubArea> getSubAreaByFixedArea(Long id);

}
