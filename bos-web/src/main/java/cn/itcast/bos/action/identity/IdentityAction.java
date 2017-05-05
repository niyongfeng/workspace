package cn.itcast.bos.action.identity;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.bos.pojo.PageModel;
import cn.itcast.bos.service.identity.IdentityService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 系统管理模块控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月13日 下午3:56:42
 * @version 1.0
 */
public class IdentityAction extends ActionSupport {
	
	private static final long serialVersionUID = -1134709700940649944L;
	/** 注入业务层 */
	protected IdentityService identityService;
	/** 定义分页实体 */
	protected PageModel pageModel = new PageModel();
	/** 定义Map集合返回响应数据 */
	private Map<String,Object> responseData = new HashMap<>();
	/** 定义状态码 */
	private int tipStatus;
	
	/** setter and getter method */
	/** 返回响应数据的方法 */
    public Map<String,Object> getResponseData(){
    	return responseData;
	}
    /** 当前页码 */
    public void setPage(int page){
    	pageModel.setPageIndex(page);
    }
    /** 每页显示的记录条数 */
    public void setRows(int rows){
    	pageModel.setPageSize(rows);
    }
	public int getTipStatus() {
		return tipStatus;
	}
	public void setTipStatus(int tipStatus) {
		this.tipStatus = tipStatus;
	}
	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}
}
