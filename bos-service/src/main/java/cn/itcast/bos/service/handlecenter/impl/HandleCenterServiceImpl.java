package cn.itcast.bos.service.handlecenter.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.bos.dao.handlecenter.BusinessNoticeBillDao;
import cn.itcast.bos.dao.handlecenter.SendGoodsBillDao;
import cn.itcast.bos.dao.handlecenter.WorkBillDao;
import cn.itcast.bos.entity.handlecenter.SendGoodsBill;
import cn.itcast.bos.pojo.PageModel;
import cn.itcast.bos.service.handlecenter.HandleCenterService;
import cn.itcast.crm.ws.Customer;
import cn.itcast.crm.ws.impl.CrmWebService;

/**
 * 受理中心模块业务处理接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:28:16
 * @version 1.0
 */
@Service("handleCenterService")
public class HandleCenterServiceImpl implements HandleCenterService {
	/** 定义该模块所有的数据访问接口 */
	@Resource
	private WorkBillDao workBillDao;
	@Resource
	private SendGoodsBillDao sendGoodsBillDao;
	@Resource
	private BusinessNoticeBillDao businessNoticeBillDao;
	@Resource
	private CrmWebService crmWebService;
	
	/**
	 * 分页查询发货单
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	public List<SendGoodsBill> getSendGoodsBillByPage(PageModel pageModel){
		try{
			return sendGoodsBillDao.getSendGoodsBillByPage(pageModel);
		}catch(Exception ex){
			throw new RuntimeException("分页查询发货单方法出现了异常！", ex);
		}
	}
	/**
	 * 添加或修改发货单
	 * @param sendGoodsBill 发货单
	 */
	public void saveOrUpdate(SendGoodsBill sendGoodsBill){
		try{
			/** 判断是添加还是修改 */
			if (sendGoodsBill.getId() != null && sendGoodsBill.getId() > 0){
				sendGoodsBillDao.update(sendGoodsBill);
			}else{
				sendGoodsBill.setCreateDate(new Date());
				sendGoodsBillDao.save(sendGoodsBill);
				/** 调用WebService接口，同步客户数据到CRM系统 */
				Customer customer = new Customer();
				customer.setName(sendGoodsBill.getReceiverName());
				customer.setPhone(sendGoodsBill.getReceiverPhone());
				customer.setAddress(sendGoodsBill.getReceiverAddress());
				crmWebService.saveCustomer(customer);
			}
		}catch(Exception ex){
			throw new RuntimeException("分页查询发货单方法出现了异常！", ex);
		}
	}
}
