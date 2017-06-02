package com.xiaohoo.api.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xiaohoo.api.domain.BankType;
import com.xiaohoo.api.domain.BankTypeExample;

/**
 * Desc: BankTypeService
 * 
 * @author Kavin
 * @since  2017-Mar-6 
 */
public interface BankTypeService {

	/**  
	* @Title: save  
	* @Description: save 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> save(BankType record);

	/**  
	* @Title: delete  
	* @Description: delete 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> delete(BankType record);

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
	Map<String, Object> saveOrUpdate(BankType record);
	
	/**  
	* @Title: queryListByPage  
	* @Description: queryListByPage 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	Map<String, Object> queryListByPage(BankType record);
	
	
	int countByExample(BankTypeExample example);

    int deleteByExample(BankTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BankType record);

    int insertSelective(BankType record);

    List<BankType> selectByExample(BankTypeExample example);

    BankType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BankType record, @Param("example") BankTypeExample example);

    int updateByExample(@Param("record") BankType record, @Param("example") BankTypeExample example);

    int updateByPrimaryKeySelective(BankType record);

    int updateByPrimaryKey(BankType record);
	
}