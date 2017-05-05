package cn.itcast.crm.ws.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.ws.CrmWebService;

/**
 * WS服务接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午10:02:07
 * @version 1.0
 */
@WebService(endpointInterface="cn.itcast.crm.ws.CrmWebService", 
	serviceName="CrmService")
public class CrmWebServiceImpl implements CrmWebService {
	@Resource
	private CustomerService customerService; 
	
	/** 根据定区id查询客户 */
	public List<Customer> findCustomerByFixedArea(long id){
		return customerService.getCustomerByFixedArea(id);
	}
	
	/** 解除关联的客户 */
	public void deleteRelationCustomer(int id){
		customerService.deleteCustomer(id);
	}
	/**
	 * 分页查询需要关联的客户
	 * @param pageIndex 当前页码
	 * @param pageSize 每页显示的记录条数
	 * @return JSON格式的字符串 
	 */
	public String findRelationCustomerByPage(int pageIndex, int pageSize){
		return customerService.getRelationCustomerByPage(pageIndex, pageSize);
	}
	/**
	 * 定区关联客户
	 * @param ids 多个客户的id
	 * @param fixedAreaId 定区id
	 */
	public void relationCustomer(String ids, long fixedAreaId){
		customerService.updateCustomer(ids, fixedAreaId);
	}
	/**
	 * 添加客户信息
	 * @param customer 客户
	 */
	public void saveCustomer(Customer customer){
		customerService.save(customer);
	}
}
