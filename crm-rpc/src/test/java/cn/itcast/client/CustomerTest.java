package cn.itcast.client;

import java.util.List;

import org.junit.Test;

import cn.itcast.crm.ws.Customer;
import cn.itcast.crm.ws.impl.CrmService;
import cn.itcast.crm.ws.impl.CrmWebService;

/**
 * CustomerTest
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午10:51:29
 * @version 1.0
 */
public class CustomerTest {
	
	@Test
	public void findCustomer(){
		/** 创建WebService服务工厂 */
		CrmService crmService = new CrmService();
		/** 通过WS服务工厂获取WS服务组件接口的代理对象 */
		CrmWebService crmWebService = crmService.getCrmWebServiceImplPort();
		/** 调用操作 */
		List<Customer> customers = crmWebService.findCustomerByFixedArea(1);
		for (Customer c : customers){
			System.out.println(c.getName() + "==" + c.getPhone());
		}
	}
}
