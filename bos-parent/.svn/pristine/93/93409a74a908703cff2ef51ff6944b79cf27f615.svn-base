package cn.itcast.bos.action.basic;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;

import cn.itcast.bos.entity.basic.SubArea;
import cn.itcast.bos.pojo.SubAreaBean;
import cn.itcast.bos.util.ExcelUtil;

/**
 * 分区管理控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月8日 下午5:00:12
 * @version 1.0
 */
public class SubAreaAction extends BasicAction {
	
	private static final long serialVersionUID = -3292813764571941142L;
	/** 定义分区实体 */
	private SubArea subArea;
	private String q;

	/** 跳转到分页查询页面 */
	@RequiresPermissions("subarea:view")
	public String showSelectSubArea(){
		return SUCCESS;
	}
	
	/** 多条件分页查询分区 */
	@RequiresPermissions("subarea:view")
	public String selectSubArea(){
		try{
			List<SubArea> data =  basicService.getSubAreaByPage(subArea, pageModel);
			writeResponseDataPage(data, "staff","pCD");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 导出分区数据到Excel */
	@RequiresPermissions("subarea:export")
	public String exportSubArea(){
		try{
			/** 查询分区数据 */
			List<SubAreaBean> data = basicService.getAllSubArea();
			/** 定义Excel中第一行数据(标题行) */
			String[] titles = {"编号","省","市","区(县)","关键字","位置"};
			/** 把分区数据写入Excel文件，再向浏览器输出Excel文件 */
			ExcelUtil.exportExcel("分区信息表","分区数据",titles, data, ServletActionContext.getResponse());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	
	/** 跳转到添加分区页面 */
	@RequiresPermissions("subarea:add")
	public String showAddSubArea(){
		return SUCCESS;
	}
	/** 加载定区数据 */
	@RequiresPermissions("subarea:add")
	public String loadFixedArea(){
		try{
			// [{id : 1, name : ''},{},{}]
			List<Map<String, Object>> data = basicService.loadFixedArea();
			writeResponseDataObject(data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 查询区域 */
	@RequiresPermissions("subarea:add")
	public String loadRegion(){
		try{
			// [{id : 1, name : ''},{},{}]
			List<Map<String, Object>> data = basicService.loadRegion(q);
			writeResponseDataObject(data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 添加分区 */
	@RequiresPermissions("subarea:add")
	public String addSubArea(){
		try{
			basicService.saveSubArea(subArea);
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}

	/** setter and getter method */
	public SubArea getSubArea() {
		return subArea;
	}
	public void setSubArea(SubArea subArea) {
		this.subArea = subArea;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
}
