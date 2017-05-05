package cn.itcast.bos.service.basic;

import java.util.List;
import java.util.Map;

import cn.itcast.bos.entity.basic.FixedArea;
import cn.itcast.bos.entity.basic.Region;
import cn.itcast.bos.entity.basic.SubArea;
import cn.itcast.bos.pojo.PageModel;
import cn.itcast.bos.pojo.SubAreaBean;

/**
 * 基础数据模块业务处理接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:28:47
 * @version 1.0
 */
public interface BasicService {
	/**
	 * 分页查询区域
	 * @param pageModel 分页实体
	 * @return 区域集合
	 */
	List<Region> getRegionByPage(PageModel pageModel);
	/**
	 * 保存Excel中区域数据
	 * @param excelData Excel文件中的数据
	 */
	void saveExcel(List<Map<Integer, Object>> excelData);
	/**
	 * 添加区域
	 * @param region 区域对象
	 */
	void saveRegion(Region region);
	/**
	 * 根据主鍵获取区域
	 * @param id
	 * @return 区域
	 */
	Region getRegion(String id);
	/**
	 * 修改区域
	 * @param region 区域
	 */
	void updateRegion(Region region);
	/**
	 * 删除区域
	 * @param ids
	 */
	void deleteRegion(String[] ids);
	/**
	 * 多条件分页查询分区
	 * @param subArea 分区实体
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	List<SubArea> getSubAreaByPage(SubArea subArea, PageModel pageModel);
	/**
	 * 查询分区数据
	 * @return 集合
	 */
	List<SubAreaBean> getAllSubArea();
	/**
	 * 查询定区的数据
	 * @return List
	 */
	List<Map<String, Object>> loadFixedArea();
	/**
	 *  查询区域
	 * @return List
	 */
	List<Map<String, Object>> loadRegion(String q);
	/**
	 * 添加分区
	 * @param subArea
	 */
	void saveSubArea(SubArea subArea);
	/**
	 * 分页查询定区
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	List<FixedArea> getFixedAreaByPage(PageModel pageModel);
	/**
	 * 根据定区id查询关联的分区
	 * @param id 定义的id
	 * @return 分区的集合
	 */
	List<SubArea> getSubAreaByFixedArea(Long id);

}
