package cn.itcast.bos.dao.handlecenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.bos.dao.handlecenter.SendGoodsBillDao;
import cn.itcast.bos.entity.handlecenter.SendGoodsBill;
import cn.itcast.bos.hibernate.impl.HibernateDaoImpl;
import cn.itcast.bos.pojo.PageModel;

/**
 * 发货单数据访问接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:19:27
 * @version 1.0
 */
@Repository("sendGoodsBillDao")
public class SendGoodsBillDaoImpl extends HibernateDaoImpl implements SendGoodsBillDao {
	/**
	 * 分页查询发货单
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	public List<SendGoodsBill> getSendGoodsBillByPage(PageModel pageModel){
		String hql = "select sgb from SendGoodsBill as sgb where sgb.workStatus = ? order by sgb.id asc";
		List<Object> params = new ArrayList<>();
		params.add((short)0);
		return this.findByPage(hql, pageModel, params);
	}
}
