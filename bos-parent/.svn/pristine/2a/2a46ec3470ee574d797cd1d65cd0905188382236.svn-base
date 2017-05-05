package cn.itcast.bos.action.basic;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import cn.itcast.bos.entity.basic.Region;
import cn.itcast.bos.util.ExcelUtil;

/**
 * 区域控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月20日 上午10:23:02
 * @version 1.0
 */
public class RegionAction extends BasicAction {

	private static final long serialVersionUID = -4145388384409601417L;
	/** 定义属性接收文件 */
	private File regionFile;
	private Region region;
	private String ids;
	
	/** 跳转到区域分页查询的页面 */
	@RequiresPermissions("region:view")
	public String showSelectRegion(){
		return SUCCESS;
	}
	
	/** 分页查询区域 */
	@RequiresPermissions("region:view")
	public String selectRegion(){
		try{
			List<Region> data =  basicService.getRegionByPage(pageModel);
			writeResponseDataPage(data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 导入区域数据 */
	@RequiresPermissions("region:import")
	public String importRegion(){
		try{
			/** 调用工具类解析Excel中的数据 */
			List<Map<Integer, Object>> excelData = ExcelUtil.parseExcel(regionFile);
			basicService.saveExcel(excelData);
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 跳转到添加区域的页面 */
	@RequiresPermissions("region:add")
	public String showAddRegion(){
		return SUCCESS;
	}
	/** 添加区域 */
	@RequiresPermissions("region:add")
	public String addRegion(){
		try{
			basicService.saveRegion(region);
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 跳转到修改区域的页面 */
	@RequiresPermissions("region:update")
	public String showUpdateRegion(){
		try{
			region = basicService.getRegion(region.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	/** 修改区域 */
	@RequiresPermissions("region:update")
	public String updateRegion(){
		try{
			basicService.updateRegion(region);
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}
	/** 删除区域 */
	@RequiresPermissions("region:delete")
	public String deleteRegion(){
		try{
			basicService.deleteRegion(ids.split(","));
			writeResponseDataStr("1");
		}catch(Exception ex){
			writeResponseDataStr("0");
			ex.printStackTrace();
		}
		return NONE;
	}
	
	/** setter and getter method */
	public File getRegionFile() {
		return regionFile;
	}
	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
}
