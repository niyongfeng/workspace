package cn.itcast.bos.action;

import javax.annotation.Resource;

import cn.itcast.bos.service.identity.IdentityService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 修改密码控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月8日 上午10:17:23
 * @version 1.0
 */
public class UpdatePwdAction extends ActionSupport {
	
	private static final long serialVersionUID = -503191054710076611L;
	/** 返回响应数据 */
	private int tipStatus;
	/** 接收请求参数 */
	private String oldPwd;
	private String newPwd;
	private String okPwd;
	/** 注入业务层 */
	@Resource
	private IdentityService identityService;
	
	@Override
	public String execute() throws Exception {
		try{
			boolean flag = identityService.updatePwd(oldPwd, newPwd, okPwd);
			setTipStatus(flag ? 1 : 0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	/** 短信验证码修改用户密码(找回密码) */
	public String verifyUpdatePwd(){
		try{
			boolean flag = identityService.updatePwd(newPwd, okPwd);
			setTipStatus(flag ? 1 : 0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	
	/** setter and getter method */
	public int getTipStatus() {
		return tipStatus;
	}

	public void setTipStatus(int tipStatus) {
		this.tipStatus = tipStatus;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getOkPwd() {
		return okPwd;
	}

	public void setOkPwd(String okPwd) {
		this.okPwd = okPwd;
	}
}