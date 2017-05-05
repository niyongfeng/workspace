package cn.itcast.bos.action.basic;

import cn.itcast.bos.action.BaseAction;
import cn.itcast.bos.service.basic.BasicService;


/**
 * 基础数据模块基础的控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月20日 上午10:20:27
 * @version 1.0
 */
public class BasicAction extends BaseAction {
	
	private static final long serialVersionUID = -2069415316197683673L;
	/** 注入业务层 */
	protected BasicService basicService;
	
	public void setBasicService(BasicService basicService) {
		this.basicService = basicService;
	}
}
