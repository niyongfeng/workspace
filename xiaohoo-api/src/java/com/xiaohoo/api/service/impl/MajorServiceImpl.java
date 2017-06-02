package com.xiaohoo.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaohoo.api.dao.MajorMapper;
import com.xiaohoo.api.domain.Major;
import com.xiaohoo.api.domain.MajorExample;
import com.xiaohoo.api.service.MajorService;


/** 
* @ClassName: MajorServiceImpl 
* @Description: MajorServiceImpl class
* @author  Kavin
* @date 2017年5月15日 上午9:35:55 
*  
*/
@Service
public class MajorServiceImpl extends BaseService implements MajorService {

	@Autowired
	private MajorMapper majorMapper;
	
	/* (非 Javadoc)  
	* <p>Title: save</p>  
	* <p>Description: </p>  
	* @param record
	* @return  
	* @see com.xiaohoo.api.service.MajorService#save(com.xiaohoo.api.domain.Major)  
	*/
	@Override
	public Map<String, Object> save(Major record) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			majorMapper.insertSelective(record);
			//refresh the record from DB.
			if(record.getId()!=null && record.getId()!=0){
				record = majorMapper.selectByPrimaryKey(record.getId());
			}
			result = generateNomalResult(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}

	/* (非 Javadoc)  
	* <p>Title: delete</p>  
	* <p>Description: </p>  
	* @param record
	* @return  
	* @see com.xiaohoo.api.service.MajorService#delete(com.xiaohoo.api.domain.Major)  
	*/
	@Override
	public Map<String, Object> delete(Major record) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			majorMapper.deleteByPrimaryKey(record.getId());
			result = generateNomalResult(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}

	

	/* (非 Javadoc)  
	* <p>Title: selectOneByPrimaryKey</p>  
	* <p>Description: </p>  
	* @param id
	* @return  
	* @see com.xiaohoo.api.service.MajorService#selectOneByPrimaryKey(java.lang.Integer)  
	*/
	@Override
	public Map<String, Object> selectOneByPrimaryKey(Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Major record = majorMapper.selectByPrimaryKey(id);
			if(record!=null ){
				result = generateNomalResult(record);
			}else{
				result = generateNomalResultWithNoDataFound();
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		
		return result;
	}

	/* (非 Javadoc)  
	* <p>Title: saveOrUpdate</p>  
	* <p>Description: </p>  
	* @param record
	* @return  
	* @see com.xiaohoo.api.service.MajorService#saveOrUpdate(com.xiaohoo.api.domain.Major)  
	*/
	@Override
	public Map<String, Object> saveOrUpdate(Major record) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			
			if(record.getId()!=null && record.getId()!=0){
				
				Major dto = majorMapper.selectByPrimaryKey(record.getId());
				
				if(dto!=null ){
					majorMapper.updateByPrimaryKeySelective(record);
				}else{
					majorMapper.insertSelective(record);
				}
			}else{
				majorMapper.insertSelective(record);
			}
			
			//refresh the record from DB.
			if(record.getId()!=null && record.getId()!=0){
				record = majorMapper.selectByPrimaryKey(record.getId());
			}
			result = generateNomalResult(record);
			
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	/* (非 Javadoc)  
	* <p>Title: queryListByPage</p>  
	* <p>Description: </p>  
	* @param record
	* @return  
	* @see com.xiaohoo.api.service.MajorService#queryListByPage(com.xiaohoo.api.domain.Major)  
	*/
	@Override
	public Map<String, Object> queryListByPage(Major record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MajorExample example = new MajorExample();
			setOrderByClause(record, example);
			List<Major> list = majorMapper.selectByExample(example);
			if(list!=null ){
				result = generateNomalResult(list);
			}else{
				result = generateNomalResultWithNoDataFound();
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		
		return result;
	}
	
	@Override
	public Map<String, Object> queryListByPage(int startPage,int pageSize)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MajorExample example = new MajorExample();
			setOrderByClause(startPage, pageSize, example);
			List<Major> list = majorMapper.selectByExample(example);
			if(list!=null ){
				result = generateNomalResult(list);
			}else{
				result = generateNomalResultWithNoDataFound();
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		
		return result;
	}
	
	
	
	
	@Override
	public int countByExample(MajorExample example){
		return majorMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MajorExample example){
		return majorMapper.deleteByExample(example);
	}
    
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return majorMapper.deleteByPrimaryKey(id);
	}
    
    @Override
    public int insert(Major record) {
		return majorMapper.insert(record);
	}

	@Override
    public int insertSelective(Major record) {
		return majorMapper.insertSelective(record);
	}

	@Override
	public List<Major> selectByExample(MajorExample example) {
		return majorMapper.selectByExample(example);
	}

	@Override
    public Major selectByPrimaryKey(Integer id) {
		return majorMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example) {
		return majorMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(@Param("record") Major record, @Param("example") MajorExample example) {
		return majorMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Major record) {
		return majorMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Major record) {
		return majorMapper.updateByPrimaryKey(record);
	}
	
}
