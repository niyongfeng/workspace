package cn.itcast.crm.ws;

import java.util.List;

import javax.jws.WebService;

import cn.itcast.crm.domain.Customer;

/**
 * WS服务接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午10:01:31
 * @version 1.0
 */
@WebService
public interface CrmWebService {
	
	/** 根据定区id查询客户 */
	List<Customer> findCustomerByFixedArea(long id);
	
	/** 解除关联的客户 */
	void deleteRelationCustomer(int id);
	
	/**
	 * 分页查询需要关联的客户
	 * @param pageIndex 当前页码
	 * @param pageSize 每页显示的记录条数
	 * @return JSON格式的字符串 
	 */
	String findRelationCustomerByPage(int pageIndex, int pageSize);
	/**
	 * 定区关联客户
	 * @param ids 多个客户的id
	 * @param fixedAreaId 定区id
	 */
	void relationCustomer(String ids, long fixedAreaId);
	/**
	 * 添加客户信息
	 * @param customer 客户
	 */
	void saveCustomer(Customer customer);
}
