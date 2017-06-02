package com.xiaohoo.api.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xiaohoo.api.domain.Major;
import com.xiaohoo.api.domain.MajorExample;

/**
 * Desc: MajorService
 * 
 * @author Kavin
 * @since  2017-May-6 
 */
public interface MajorService {

	/**  
	* @Title: save  
	* @Description: save 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> save(Major record);

	/**  
	* @Title: delete  
	* @Description: delete 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> delete(Major record);

	/**  
	* @Title: selectOneByPrimaryKey  
	* @Description: selectOneByPrimaryKey 
	* @param @param id
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> selectOneByPrimaryKey(Integer id);

	/**  
	* @Title: saveOrUpdate  
	* @Description: saveOrUpdate 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> saveOrUpdate(Major record);
	
	/**  
	* @Title: queryListByPage  
	* @Description: queryListByPage 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> queryListByPage(Major record);
	
	Map<String, Object> queryListByPage(int startPage, int pageSize);
	
	
	int countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);

    Major selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

	
}