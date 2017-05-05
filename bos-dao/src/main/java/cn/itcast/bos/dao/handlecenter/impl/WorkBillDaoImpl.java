package cn.itcast.bos.dao.handlecenter.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.handlecenter.WorkBillDao;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;

/**
 * 工单数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:19:27
 * @version 1.0
 */
@Repository("workBillDao")
public class WorkBillDaoImpl extends HibernateDaoImpl implements WorkBillDao {
	
}
