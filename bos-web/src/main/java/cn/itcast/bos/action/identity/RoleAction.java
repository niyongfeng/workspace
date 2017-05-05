package cn.itcast.bos.action.identity;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import cn.itcast.bos.entity.identity.Role;

/**
 * 角色控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月14日 上午10:47:03
 * @version 1.0
 */
public class RoleAction extends IdentityAction {

	private static final long serialVersionUID = 2529560755010296180L;
	/** 定义角色实体 */
	private Role role;
	private String ids;
	private String userId;
	private String codes;

	/** 跳转到分页查询角色的页面 */
	@RequiresPermissions("role:view")
	public String showSelectRole(){
		return SUCCESS;
	}
	/** 分页查询角色 */
	@RequiresPermissions("role:view")
	public String selectRole(){
		try{
			List<Map<String,Object>> data = identityService.getRoleByPage(pageModel);
			getResponseData().put("total", pageModel.getRecordCount());
			getResponseData().put("rows", data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	/** 跳转到添加角色的页面 */
	@RequiresPermissions("role:add")
	public String showAddRole(){
		return SUCCESS;
	}
	/** 添加角色 */
	@RequiresPermissions("role:add")
	public String addRole(){
		try{
			identityService.saveRole(role);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到修改角色的页面 */
	@RequiresPermissions("role:update")
	public String showUpdateRole(){
		try{
			role = identityService.getRole(role.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 修改角色 */
	@RequiresPermissions("role:update")
	public String updateRole(){
		try{
			identityService.updateRole(role);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 批量删除角色 */
	@RequiresPermissions("role:delete")
	public String deleteRole(){
		try{
			identityService.deleteRole(ids.split(","));
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 查询所有的角色 */
	@RequiresPermissions("user:bind")
	public String selectAllRole(){
		try{
			List<Map<String,Object>> data = identityService.getAllRole(userId);
			getResponseData().put("rows", data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到角色绑定资源的页面 */
	@RequiresPermissions("role:bind")
	public String showBindResource(){
		return SUCCESS;
	}
	/** 角色绑定资源 */
	@RequiresPermissions("role:bind")
	public String bindResource(){
		try{
			identityService.bindResource(role.getId(),
					StringUtils.isEmpty(codes) ? null : codes.split(","));
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	/** setter and getter method */
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
}
