package cn.itcast.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;

/**
 * 客户业务处理接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午9:16:38
 * @version 1.0
 */
@Service("customerService")
/** 事务注解加在类上面，对这个类中所有的方法都有效 */
@Transactional(readOnly=false, rollbackFor=RuntimeException.class) // 事务注解
public class CustomerServiceImpl implements CustomerService {
	/** 注入数据访问接口 */
	@Resource
	private CustomerDao customerDao;
	
	/**
	 * 根据定区id查询客户 
	 * @param id 定区的id
	 * @return 客户集合
	 */
	@Transactional(readOnly=true)// 事务注解对该方法有效
	public List<Customer> getCustomerByFixedArea(long id){
		try{
			return customerDao.getCustomerByFixedArea(id);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 解除关联的客户
	 * @param id
	 */
	public void deleteCustomer(int id){
		try{
			customerDao.deleteCustomer(id);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 分页查询需要关联的客户
	 * @param pageIndex 当前页码
	 * @param pageSize 每页显示的记录条数
	 * @return JSON格式的字符串 
	 */
	public String getRelationCustomerByPage(int pageIndex, int pageSize){
		try{
			// {"total" : 5, "rows" : [{},{}]}
			Map<String, Object> data = new HashMap<>();
			/** 统计查询 */
			int recordCount = customerDao.count();
			data.put("total", recordCount);
			if (recordCount == 0){
				// {"total" : 0, "rows" :[]}
				data.put("rows", "");
			}else{
				/** 分页查询 */
				List<Customer> customers = customerDao
						.getRelationCustomerByPage(pageIndex, pageSize);
				data.put("rows", customers);
			}
			return JSON.toJSONString(data);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 修改用户
	 * @param ids
	 * @param fixedAreaId
	 */
	public void updateCustomer(String ids, long fixedAreaId){
		try{
			customerDao.updateCustomer(ids, fixedAreaId);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 添加客户信息
	 * @param customer 客户
	 */
	public void save(Customer customer){
		try{
			customerDao.save(customer);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
