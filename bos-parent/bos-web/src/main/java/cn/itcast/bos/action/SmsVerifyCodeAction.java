package cn.itcast.bos.action;

import javax.annotation.Resource;

import cn.itcast.bos.service.identity.IdentityService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 短信验证码控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月8日 下午3:39:00
 * @version 1.0
 */
public class SmsVerifyCodeAction extends ActionSupport {
	
	private static final long serialVersionUID = 8793990107166978652L;
	/** 定义属性 */
	private int tipStatus;
	private String phone;
	private String userId;
	private String verifyCode;
	
	@Resource
	private IdentityService identityService;
	
	@Override
	public String execute() throws Exception {
		try{
			boolean flag = identityService.sendSmsVerifyCode(phone);
			if (flag){
				setTipStatus(1);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 验证短信验证码 */
	public String verifyFindPwdSms(){
		try{
			boolean flag = identityService.verifyFindPwdSms(userId,phone,verifyCode);
			if (flag){
				setTipStatus(1);
			}
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
}
