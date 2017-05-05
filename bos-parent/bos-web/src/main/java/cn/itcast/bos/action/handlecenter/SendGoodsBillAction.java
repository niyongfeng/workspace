package cn.itcast.bos.action.handlecenter;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bos.entity.handlecenter.SendGoodsBill;

/**
 * 发货单管理
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 下午5:00:58
 * @version 1.0
 */
public class SendGoodsBillAction extends HandlecenterAction implements ModelDriven<SendGoodsBill> {
	
	private static final long serialVersionUID = 8640340388729941540L;
	private SendGoodsBill sendGoodsBill = new SendGoodsBill();
	
	/** 跳转到发货查询的页面 */
	@RequiresPermissions("sgbill:view")
	public String showSendGoodsBill(){
		return SUCCESS;
	}
	
	/** 分页查询发货单 */
	@RequiresPermissions("sgbill:view")
	public String selectSendGoodsBill(){
		try{
			List<SendGoodsBill> data = handleCenterService.getSendGoodsBillByPage(pageModel);
			writeResponseDataPage(data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 添加或修改发货单 */
	@RequiresPermissions(logical=Logical.OR, value={"sgbill:add","sgbill:update"})
	public String saveOrUpdateSendGoodsBill(){
		try{
			handleCenterService.saveOrUpdate(sendGoodsBill);
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}

	@Override
	public SendGoodsBill getModel() {
		return sendGoodsBill ;
	}
	
}
