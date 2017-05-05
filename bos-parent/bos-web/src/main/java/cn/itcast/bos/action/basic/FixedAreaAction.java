package cn.itcast.bos.action.basic;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import cn.itcast.bos.entity.basic.FixedArea;
import cn.itcast.bos.entity.basic.SubArea;
import cn.itcast.crm.ws.Customer;
import cn.itcast.crm.ws.impl.CrmWebService;

/**
 * 定区管理控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月10日 下午4:01:39
 * @version 1.0
 */
public class FixedAreaAction extends BasicAction {

	private static final long serialVersionUID = 4691210798456940401L;
	private FixedArea fixedArea;
	private CrmWebService crmWebService;
	private int customerId;
	private String ids;
	
	/** 跳转到分页查询定区的页面  */
	@RequiresPermissions("fixedarea:view")
	public String showSelectFixedArea(){
		return SUCCESS;
	}
	
	/** 分页查询定区  */
	@RequiresPermissions("fixedarea:view")
	public String selectFixedArea(){
		try{
			List<FixedArea> data = basicService.getFixedAreaByPage(pageModel);
			writeResponseDataPage(data, "standard");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	
	/** 根据定区id查询关联的分区 */
	@RequiresPermissions("fixedarea:relation")
	public String relationSubArea(){
		try{
			List<SubArea> data = basicService.getSubAreaByFixedArea(fixedArea.getId());
			writeResponseDataPage(data, "staff");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 根据定义id查询关联的客户 */
	@RequiresPermissions("fixedarea:relation")
	public String selectRelationCustomer(){
		try{
			List<Customer> data = crmWebService.findCustomerByFixedArea(fixedArea.getId());
			writeResponseDataPage(data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 解除关联的客户 */
	@RequiresPermissions("fixedarea:relation")
	public String deleteRelationCustomer(){
		try{
			crmWebService.deleteRelationCustomer(customerId);
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 跳转到定区关联客户的页面 */
	@RequiresPermissions("fixedarea:relation")
	public String showRelationCustomer(){
		return SUCCESS;
	}
	
	/** 分页查询定区没有关联的客户 */
	@RequiresPermissions("fixedarea:relation")
	public String selectUnRelationCustomer(){
		try{
			/** {"total" : 5, "rows" : [{},{}]} */
			String data = crmWebService.findRelationCustomerByPage(pageModel.getPageIndex(),
					pageModel.getPageSize());
			writeResponseDataStr(data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 定区关联客户 */
	@RequiresPermissions("fixedarea:relation")
	public String relationCustomer(){
		try{
			crmWebService.relationCustomer(ids, fixedArea.getId());
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}

	/** setter and getter method */
	public FixedArea getFixedArea() {
		return fixedArea;
	}
	public void setFixedArea(FixedArea fixedArea) {
		this.fixedArea = fixedArea;
	}
	public void setCrmWebService(CrmWebService crmWebService) {
		this.crmWebService = crmWebService;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}