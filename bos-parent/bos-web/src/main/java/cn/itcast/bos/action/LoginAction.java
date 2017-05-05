package cn.itcast.bos.action;

import java.util.Map;

import javax.annotation.Resource;

import cn.itcast.bos.service.identity.IdentityService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 异步请求登录
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月10日 下午4:43:47
 * @version 1.0
 */
public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 7378386972457831827L;
	/** 定义属性封装请求参数  */
	private String userId;
	private String password;
	private String vcode;
	private int key;
	/** 注入业务层接口 */
	@Resource
	private IdentityService identityService;
	/** 定义响应数据 */
	private Map<String, Object> responseData;
	
	@Override
	public String execute() throws Exception {
		// {status : 0, tip : ""}
		responseData = identityService.login(userId, password,vcode,key);
		// {tip=验证码不正确！, status=1}
		System.out.println(responseData);
		return SUCCESS;
	}

	/** setter and getter method */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public void setKey(int key) {
		this.key = key;
	}
	/** 该getter方法作为异步请求登录需要的响应数据 */
	public Map<String, Object> getResponseData() {
		return responseData;
	}
}