package cn.itcast.bos.action.identity;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.json.JSONUtil;

import cn.itcast.bos.entity.identity.User;

/**
 * 用户控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月16日 上午9:32:15
 * @version 1.0
 */
public class UserAction extends IdentityAction {
	
	private static final long serialVersionUID = -5915293676338802658L;
	/** 定义用户实体 */
	private User user;
	/** 定义部门与职位数据 */
	private Map<String, List<Map<String,Object>>> deptJobData;
	/** 定义多个userId组成的字符串属性 */
	private String userIds;
	/** 定义属性接收多个角色id */
	private String ids;
	
	/** 跳转到多条件分页查询用户页面 */
	@RequiresPermissions("user:view")
	public String showSelectUser(){
		return SUCCESS;
	}
	/** 多条件分页查询用户 */
	@RequiresPermissions("user:view")
	public String selectUser(){
		try{
			List<Map<String,Object>> data = identityService.getUserByPage(pageModel, user);
			getResponseData().put("total", pageModel.getRecordCount());
			getResponseData().put("rows", data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到添加用户页面 */
	@RequiresPermissions("user:add")
	public String showAddUser(){
		return SUCCESS;
	}
	/** 加载部门与职位 */
	@RequiresPermissions("user:add")
	public String loadDeptJob(){
		try{
			// data: {"depts" : [{id:1,name:''},{}], "jobs" : [{id:1,name:''},{}]}
			// Map<String, List<Map<String,Object>>>
			deptJobData = identityService.getDeptJob();
			System.out.println(JSONUtil.serialize(deptJobData));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 异步验证登录名是否重复 */
	@RequiresPermissions("user:add")
	public String validUserId(){
		try{
			setTipStatus(identityService.validUserId(user.getUserId()));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 添加用户 */
	@RequiresPermissions("user:add")
	public String addUser(){
		try{
			identityService.saveUser(user);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到修改用户的页面 */
	@RequiresPermissions("user:update")
	public String showUpdateUser(){
		try{
			user = identityService.getUpdateUser(user.getUserId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 修改用户 */
	@RequiresPermissions("user:update")
	public String updateUser(){
		try{
			identityService.updateUser(user);
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 批量删除用户 */
	@RequiresPermissions("user:delete")
	public String deleteUser(){
		try{
			identityService.deleteUser(userIds.split(","));
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 批量审核用户 */
	@RequiresPermissions("user:check")
	public String checkUser(){
		try{
			identityService.checkUser(userIds.split(","), user.getStatus());
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 跳转到用户绑定角色的页面 */
	@RequiresPermissions("user:bind")
	public String showBindRole(){
		return SUCCESS;
	}
	/** 用户绑定角色 */
	@RequiresPermissions("user:bind")
	public String bindRole(){
		try{
			identityService.bindRole(user.getUserId(),
					StringUtils.isEmpty(ids) ? null : ids.split(","));
			setTipStatus(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	/** setter and getter method */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<String, List<Map<String, Object>>> getDeptJobData() {
		return deptJobData;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
}
