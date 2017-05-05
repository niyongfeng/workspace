package cn.itcast.bos.action.identity;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import cn.itcast.bos.entity.identity.Resource;

/**
 * 资源管理控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月17日 上午11:18:09
 * @version 1.0
 */
public class ResourceAction extends IdentityAction {
	
	private static final long serialVersionUID = -8842018337959930774L;
	/** 定义属性封装树的数据 */
	private List<Map<String, Object>> resourceTreeData;
	/** 定义父级编号 */
	private String parentCode;
	/** 定义资源实体 */
	private Resource resource;
	/** 定义codes封装多个code */
	private String codes;
	/** 定义角色id */
	private int roleId;

	/** 跳转到资源管理的主界面 */
	@RequiresPermissions("resource:view")
	public String showSelectResource(){
		return SUCCESS;
	}
	/** 异步加载资源树 */
	@RequiresPermissions("resource:view")
	public String loadResourceTree(){
		try{
			// [{id:0, pid:-1, name:"资源树"},{},...]
			resourceTreeData = identityService.getResourceTree();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	/** 分页查询资源 */
	@RequiresPermissions("resource:view")
	public String selectResource(){
		try{
			List<Map<String,Object>> data = identityService
						.getResourceByPage(parentCode, pageModel);
			getResponseData().put("total", pageModel.getRecordCount());
			getResponseData().put("rows", data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到添加资源的页面 */
	@RequiresPermissions("resource:add")
	public String showAddResource(){
		return SUCCESS;
	}
	/** 添加资源 */
	@RequiresPermissions("resource:add")
	public String addResource(){
		try{
			resource.setCode(parentCode);
			identityService.saveResource(resource);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到修改资源的页面 */
	@RequiresPermissions("resource:update")
	public String showUpdateResource(){
		try{
			resource = identityService.getResource(resource.getCode());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 修改资源 */
	@RequiresPermissions("resource:update")
	public String updateResource(){
		try{
			identityService.updateResource(resource);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 删除资源 */
	@RequiresPermissions("resource:delete")
	public String deleteResource(){
		try{
			identityService.deleteResource(codes.split(","));
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 查询所有的资源 */
	@RequiresPermissions("role:bind")
	public String selectAllResource(){
		try{
			List<Map<String,Object>> data = identityService.getAllResource(roleId);
			getResponseData().put("rows", data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	/** setter and getter method */
	public List<Map<String, Object>> getResourceTreeData() {
		return resourceTreeData;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
