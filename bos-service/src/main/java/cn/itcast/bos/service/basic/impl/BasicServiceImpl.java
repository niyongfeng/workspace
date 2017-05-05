package cn.itcast.bos.service.basic.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.bos.dao.basic.FixedAreaDao;
import cn.itcast.bos.dao.basic.RegionDao;
import cn.itcast.bos.dao.basic.StaffDao;
import cn.itcast.bos.dao.basic.SubAreaDao;
import cn.itcast.bos.entity.basic.FixedArea;
import cn.itcast.bos.entity.basic.Region;
import cn.itcast.bos.entity.basic.SubArea;
import cn.itcast.bos.pojo.PageModel;
import cn.itcast.bos.pojo.SubAreaBean;
import cn.itcast.bos.service.basic.BasicService;
import cn.itcast.bos.util.PinyinUtil;

/**
 * 基础数据模块业务处理接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午3:29:29
 * @version 1.0
 */
@Service("basicService")
public class BasicServiceImpl implements BasicService {
	/** 定义该模块所有的数据访问接口 */
	@Resource
	private FixedAreaDao fixedAreaDao;
	@Resource
	private SubAreaDao subAreaDao;
	@Resource
	private RegionDao regionDao;
	@Resource
	private StaffDao staffDao;
	
	/** TODO################## 区域业务管理 ######################## */
	/**
	 * 分页查询区域
	 * @param pageModel 分页实体
	 * @return 区域集合
	 */
	public List<Region> getRegionByPage(PageModel pageModel){
		try{
			return regionDao.getRegionByPage(pageModel);
		}catch(Exception ex){
			throw new RuntimeException("分页查询区域方法出现了异常！", ex);
		}
	}
	/**
	 * 保存Excel中区域数据
	 * @param excelData Excel文件中的数据
	 */
	public void saveExcel(List<Map<Integer, Object>> excelData){
		try{
			/** 循环Excel文件中的数据 */
			for (Map<Integer, Object> rowData : excelData){
				/** 把rowData一行数据转化成Region对象 */
				Region region = new Region();
				region.setId(rowData.get(0).toString());
				region.setProvince(rowData.get(1).toString());
				region.setCity(rowData.get(2).toString());
				region.setDistrict(rowData.get(3).toString());
				region.setPostCode(rowData.get(4).toString());
				// 市对应的汉字的拼音
				region.setCityCode(PinyinUtil.toPinyin(region.getCity()
							.substring(0, region.getCity().length() - 1)));
				// 生成简码 (省市区) 取每一个汉字的拼音首字母
				region.setShortCode(PinyinUtil.toHeadPinyin(region.getPCD()));
				regionDao.saveOrUpdate(region);
			}
		}catch(Exception ex){
			throw new RuntimeException("保存Excel中区域数据方法出现了异常！", ex);
		}
	}
	/**
	 * 添加区域
	 * @param region 区域对象
	 */
	public void saveRegion(Region region){
		try{
			// 市对应的汉字的拼音
			region.setCityCode(PinyinUtil.toPinyin(region.getCity()
						.substring(0, region.getCity().length() - 1)));
			// 生成简码 (省市区) 取每一个汉字的拼音首字母
			region.setShortCode(PinyinUtil.toHeadPinyin(region.getPCD()));
			regionDao.save(region);
		}catch(Exception ex){
			throw new RuntimeException("添加区域方法出现了异常！", ex);
		}
	}
	/**
	 * 根据主鍵获取区域
	 * @param id
	 * @return 区域
	 */
	public Region getRegion(String id){
		try{
			return regionDao.get(Region.class, id);
		}catch(Exception ex){
			throw new RuntimeException("根据主鍵获取区域方法出现了异常！", ex);
		}
	}
	/**
	 * 修改区域
	 * @param region 区域
	 */
	public void updateRegion(Region region){
		try{
			// 市对应的汉字的拼音
			region.setCityCode(PinyinUtil.toPinyin(region.getCity()
						.substring(0, region.getCity().length() - 1)));
			// 生成简码 (省市区) 取每一个汉字的拼音首字母
			region.setShortCode(PinyinUtil.toHeadPinyin(region.getPCD()));
			regionDao.update(region);
		}catch(Exception ex){
			throw new RuntimeException("修改区域方法出现了异常！", ex);
		}
	}
	/**
	 * 删除区域
	 * @param ids
	 */
	public void deleteRegion(String[] ids){
		try{
			regionDao.deleteRegion(ids);
		}catch(Exception ex){
			throw new RuntimeException("删除区域方法出现了异常！", ex);
		}
	}
	
	
	/** TODO################## 分区业务管理 ######################## */
	/**
	 * 多条件分页查询分区
	 * @param subArea 分区实体
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	public List<SubArea> getSubAreaByPage(SubArea subArea, PageModel pageModel){
		try{
			List<SubArea> data = subAreaDao.getSubAreaByPage(subArea, pageModel);
			/** 查询延迟的属性 */
			for (SubArea sa : data){
				if (sa.getRegion() != null) sa.getRegion().getCity();
				if (sa.getFixedArea() != null) sa.getFixedArea().getName();
			}
			return data;
		}catch(Exception ex){
			throw new RuntimeException("多条件分页查询分区方法出现了异常！", ex);
		}
	}
	/**
	 * 查询分区数据
	 * @return 集合
	 */
	public List<SubAreaBean> getAllSubArea(){
		try{
			return subAreaDao.getAllSubArea();
		}catch(Exception ex){
			throw new RuntimeException("查询分区数据方法出现了异常！", ex);
		}
	}
	/**
	 * 查询定区的数据
	 * @return List
	 */
	public List<Map<String, Object>> loadFixedArea(){
		try{
			return fixedAreaDao.getFixedAreaByIdAndName();
		}catch(Exception ex){
			throw new RuntimeException("查询定区的数据方法出现了异常！", ex);
		}
	}
	/**
	 * 查询区域
	 * @return List
	 */
	public List<Map<String, Object>> loadRegion(String q){
		try{
			return regionDao.getRegionByIdAndName(q);
		}catch(Exception ex){
			throw new RuntimeException("查询区域方法出现了异常！", ex);
		}
	}
	/**
	 * 添加分区
	 * @param subArea
	 */
	public void saveSubArea(SubArea subArea){
		try{
			subAreaDao.save(subArea);
		}catch(Exception ex){
			throw new RuntimeException("添加分区方法出现了异常！", ex);
		}
	}
	
	
	/** TODO################## 定区业务管理 ######################## */
	/**
	 * 分页查询定区
	 * @param pageModel 分页实体
	 * @return 集合
	 */
	public List<FixedArea> getFixedAreaByPage(PageModel pageModel){
		try{
			List<FixedArea> fixedAreas = fixedAreaDao.getFixedAreaByPage(pageModel);
			for (FixedArea fixedArea : fixedAreas){
				if (fixedArea.getStaff() != null) fixedArea.getStaff().getName(); 
			}
			return fixedAreas;
		}catch(Exception ex){
			throw new RuntimeException("分页查询定区方法出现了异常！", ex);
		}
	}
	/**
	 * 根据定区id查询关联的分区
	 * @param id 定义的id
	 * @return 分区的集合
	 */
	public List<SubArea> getSubAreaByFixedArea(Long id){
		try{
			List<SubArea> subAreas = subAreaDao.getSubAreaByFixedArea(id);
			for (SubArea subArea : subAreas){
				if (subArea.getRegion() != null) subArea.getRegion().getProvince();
				if (subArea.getFixedArea() != null) subArea.getFixedArea().getName();
			}
			return subAreas;
		}catch(Exception ex){
			throw new RuntimeException("根据定区id查询关联的分区方法出现了异常！", ex);
		}
	}
}
