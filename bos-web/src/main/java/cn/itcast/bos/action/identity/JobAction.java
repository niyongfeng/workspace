package cn.itcast.bos.action.identity;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import cn.itcast.bos.entity.identity.Job;

/**
 * 职位控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月11日 下午4:37:30
 * @version 1.0
 */
public class JobAction extends IdentityAction {
	
	private static final long serialVersionUID = 1297386002588031849L;
	/** 定义职位实体 */
	private Job job;
	/** 定义多个职位id */
	private String ids;
	
	/** 跳转到分页查询职位的页面 */
	@RequiresPermissions("job:view")
	public String showSelectJob(){
		return SUCCESS;
	}
	/** 分页查询职位 */
	@RequiresPermissions("job:view")
    public String selectJob(){
    	try{
	    	List<Job> data = identityService.getJobByPage(pageModel);
	    	getResponseData().put("total", pageModel.getRecordCount());
	    	getResponseData().put("rows", data);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return SUCCESS;
	}
    /** 跳转到添加职位的页面 */
	@RequiresPermissions("job:add")
    public String showAddJob(){
    	return SUCCESS;
    }
    /** 添加职位 */
	@RequiresPermissions("job:add")
    public String addJob(){
    	try{
    		identityService.saveJob(job);
    		setTipStatus(1);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return SUCCESS;
    }
    /** 跳转到修改职位页面 */
	@RequiresPermissions("job:update")
    public String showUpdateJob(){
    	try{
    		job = identityService.getJob(job.getId());
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return SUCCESS;
    }
    /** 修改职位 */
	@RequiresPermissions("job:update")
    public String updateJob(){
    	try{
    		identityService.updateJob(job);
    		setTipStatus(1);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return SUCCESS;
    }
    /** 删除职位 */
	@RequiresPermissions("job:delete")
    public String deleteJob(){
    	try{
    		identityService.deleteJob(ids.split(","));
    		setTipStatus(1);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return SUCCESS;
    }
    
    
    /** setter and getter method */
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	} 
}