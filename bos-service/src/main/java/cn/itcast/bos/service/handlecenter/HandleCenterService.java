package cn.itcast.bos.service.handlecenter;

import java.util.List;

import cn.itcast.bos.entity.handlecenter.SendGoodsBill;
import cn.itcast.bos.pojo.PageModel;

/**
 * 受理中心模块业务处理接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:27:38
 * @version 1.0
 */
public interface HandleCenterService {
	/**
	 * 分页查询发货单
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	List<SendGoodsBill> getSendGoodsBillByPage(PageModel pageModel);
	/**
	 * 添加或修改发货单
	 * @param sendGoodsBill 发货单
	 */
	void saveOrUpdate(SendGoodsBill sendGoodsBill);

}
