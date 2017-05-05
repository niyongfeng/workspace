package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.Customer;

/**
 * 客户数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午9:14:47
 * @version 1.0
 */
public interface CustomerDao {
	/**
	 * 根据定区id查询客户 
	 * @param id 定区的id
	 * @return 客户集合
	 */
	List<Customer> getCustomerByFixedArea(long id);
	/**
	 * 解除关联的客户
	 * @param id
	 */
	void deleteCustomer(int id);
	/**
	 * 统计查询
	 * @return 总记录条数
	 */
	int count();
	/**
	 * 分页查询客户
	 * @param pageIndex 当前页码
	 * @param pageSize 每页显示的记录条数
	 * @return 客户的集合
	 */
	List<Customer> getRelationCustomerByPage(int pageIndex, int pageSize);
	/**
	 * 修改用户
	 * @param ids
	 * @param fixedAreaId
	 */
	void updateCustomer(String ids, long fixedAreaId);
	/**
	 * 添加客户信息
	 * @param customer 客户
	 */
	void save(Customer customer);

}
