package cn.itcast.bos.dao.identity;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.entity.identity.Job;
import cn.itcast.bos.hibernate.HibernateDao;
import cn.itcast.bos.pojo.PageModel;

/**
 * 职位数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午2:39:16
 * @version 1.0
 */
public interface JobDao extends HibernateDao{
	/**
	 * 分页查询职位
	 * @param pageModel 分页实体
	 * @return 职位集合
	 */
	List<Job> getJobByPage(PageModel pageModel);
	/**
	 * 批量删除职位
	 * @param ids
	 */
	void deletJob(String[] ids);
	/**
	 * 查询职位(id与name)
	 * @return List
	 */
	List<Map<String, Object>> getJobByIdAndName();
	
}
