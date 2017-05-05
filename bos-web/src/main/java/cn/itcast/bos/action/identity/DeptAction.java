package cn.itcast.bos.action.identity;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import cn.itcast.bos.entity.identity.Dept;

/**
 * 部门控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月13日 下午3:52:11
 * @version 1.0
 */
public class DeptAction extends IdentityAction {
	
	private static final long serialVersionUID = 6027926919931566247L;
	/** 定义部门实体 */
	private Dept dept;
	/** 定义多个部门id */
	private String ids;
	/** 定义异步加载部门的数据 */
	private List<Map<String, Object>> deptData;

	/** 跳转到分页查询部门页面 */
	@RequiresPermissions("dept:view")
	public String showSelectDept(){
		return SUCCESS;
	}
	/** 分页查询部门 */
	@RequiresPermissions("dept:view")
	public String selectDept(){
		try{
			List<Dept> data = identityService.getDeptByPage(pageModel);
			getResponseData().put("total", pageModel.getRecordCount());
			getResponseData().put("rows", data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到添加部门页面 */
	@RequiresPermissions("dept:add")
	public String showAddDept(){
		return SUCCESS;
	}
	/** 添加部门 */
	@RequiresPermissions("dept:add")
	public String addDept(){
		try{
			identityService.saveDept(dept);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到修改部门的页面 */
	@RequiresPermissions("dept:update")
	public String showUpdateDept(){
		try{
			dept = identityService.getDept(dept.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 修改部门 */
	@RequiresPermissions("dept:update")
	public String updateDept(){
		try{
			identityService.updateDept(dept);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 批量删除部门 */
	@RequiresPermissions("dept:delete")
	public String deleteDept(){
		try{
			identityService.deleteDept(ids.split(","));
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 异步加载部门 */
	@RequiresPermissions("user:view")
	public String loadDept(){
		try{
			deptData = identityService.loadDept();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	/** setter and getter method */
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<Map<String, Object>> getDeptData() {
		return deptData;
	}
}