package cn.itcast.bos.action.handlecenter;

import cn.itcast.bos.action.BaseAction;
import cn.itcast.bos.service.handlecenter.HandleCenterService;


/**
 * 受理中心基础控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 下午4:51:13
 * @version 1.0
 */
public class HandlecenterAction extends BaseAction {
	
	private static final long serialVersionUID = 4126433117330096893L;
	/** 注入业务层 */
	protected HandleCenterService handleCenterService;
	
	public void setHandleCenterService(HandleCenterService handleCenterService) {
		this.handleCenterService = handleCenterService;
	}
}
