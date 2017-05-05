package cn.itcast.bos.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.itcast.bos.service.identity.IdentityService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 加载用户菜单
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月19日 下午4:52:25
 * @version 1.0
 */
public class LoadUserMenuAction extends ActionSupport {
	
	private static final long serialVersionUID = 792718674944815666L;
	private List<Map<String, Object>> userMenuData;
	@Resource
	private IdentityService identityService;
	
	@Override
	public String execute() throws Exception {
		try{
			/** 获取当前登录用户的菜单 */
			userMenuData = identityService.getUserMenu();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 返回用户菜单数据 */
	public List<Map<String, Object>> getUserMenuData() {
		return userMenuData;
	}
}
