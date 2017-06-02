package com.xiaohoo.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaohoo.api.dao.UserInformationMapper;
import com.xiaohoo.api.domain.UserInformation;
import com.xiaohoo.api.domain.UserInformationExample;
import com.xiaohoo.api.service.UserInformationService;

/**
 * Desc: UserInformationServiceImpl class
 * 
 * @author Kavin
 * @since  2017-Mar-6 
 */
@Service
public class UserInformationServiceImpl extends BaseService implements UserInformationService {

	@Autowired
	private UserInformationMapper userInformationMapper;

	
	/**
	 * @param dto
	 * @param result
	 */
	@Override
	public Map<String, Object> checkLogin(UserInformation record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			UserInformationExample example = new UserInformationExample();
			example.createCriteria().andPhoneEqualTo(record.getPhone());
			List<UserInformation> userlist = userInformationMapper.selectByExample(example);
			if(userlist==null || userlist.size()<1){
				//if user does NOT exist, then regist -> insert user into DB
				
				try {
					userInformationMapper.insertSelective(record);
					Map<String, Object> data = new HashMap<String, Object>();
					result = generateNomalResult(userInformationMapper.selectByPrimaryKey(record.getUid()));
				} catch (Exception e) {
					result = generateErrorResult(e);
				}
				return result;
				
				
				
			}else{
				Map<String, Object> data = new HashMap<String, Object>();
				result = generateNomalResult(userlist.get(0));
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	/**
	 * @param dto
	 * @param result
	 */
	@Override
	public Map<String, Object> checkLoginThird(UserInformation record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			UserInformationExample example = new UserInformationExample();
			if(record.getOpenid() != null && !"".equals(record.getOpenid())){
				example.or().andOpenidEqualTo(record.getOpenid());
			}
			if(record.getAccesstoken() != null && !"".equals(record.getAccesstoken())){
				example.or().andAccesstokenEqualTo(record.getAccesstoken());
			}
			List<UserInformation> userlist = userInformationMapper.selectByExample(example);
			if(userlist==null || userlist.size()<1){
				//if user does NOT exist, then regist -> insert user into DB
				
				try {
					userInformationMapper.insertSelective(record);
					Map<String, Object> data = new HashMap<String, Object>();
					result = generateNomalResult(userInformationMapper.selectByPrimaryKey(record.getUid()));
				} catch (Exception e) {
					result = generateErrorResult(e);
				}
				return result;
				
				
				
			}else{
				Map<String, Object> data = new HashMap<String, Object>();
				result = generateNomalResult(userlist.get(0));
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	
	/**
	 * @param dto
	 * @param result
	 */
	@Override
	public Map<String, Object> resetPswd(UserInformation record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			UserInformationExample example = new UserInformationExample();
			example.createCriteria().andPhoneEqualTo(record.getPhone());
			List<UserInformation> userlist = userInformationMapper.selectByExample(example);
			if(userlist==null || userlist.size()<1){
				//if user does NOT exist, then remind that no user for this phone
				result = generateErrorResult(record,"There is no such user on the phone of "+record.getPhone());
			}else{
				
				userInformationMapper.updateByExampleSelective(record, example);
				userlist = userInformationMapper.selectByExample(example);
				result = generateNomalResult(userlist.get(0));
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	
	/**
	 * @param dto
	 * @param result
	 */
	@Override
	public Map<String, Object> changePswd(UserInformation record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			UserInformationExample example = new UserInformationExample();
			example.createCriteria().andPhoneEqualTo(record.getPhone()).andPasswordEqualTo(record.getPassword());
			List<UserInformation> userlist = userInformationMapper.selectByExample(example);
			if(userlist==null || userlist.size()<1){
				//if user does NOT exist, then remind that no user for this phone
				result = generateErrorResult(record,"There is no such user on the phone of "+record.getPhone());
			}else{
				record.setPassword(record.getNewpassword());
				userInformationMapper.updateByExampleSelective(record, example);
				
				example.clear();
				example.createCriteria().andPhoneEqualTo(record.getPhone());
				userlist = userInformationMapper.selectByExample(example);
				result = generateNomalResult(userlist.get(0));
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	
	@Override
	public Map<String, Object> save(UserInformation record) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			userInformationMapper.insertSelective(record);
			result = generateNomalResult(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}

	@Override
	public Map<String, Object> delete(UserInformation record) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			userInformationMapper.deleteByPrimaryKey(record.getUid());
			result = generateNomalResult(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}

	

	@Override
	public Map<String, Object> selectByPrimaryKey(Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			UserInformation record = userInformationMapper.selectByPrimaryKey(id);
			if(record!=null ){
				result = generateNomalResult(record);
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		
		return result;
	}

	@Override
	public Map<String, Object> saveOrUpdate(UserInformation record) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			
			if(record.getUid()!=null && record.getUid()!=0){
				
				UserInformation dto = userInformationMapper.selectByPrimaryKey(record.getUid());
				
				if(dto!=null ){
					userInformationMapper.updateByPrimaryKeySelective(record);
				}else{
					userInformationMapper.insertSelective(record);
				}
			}else{
				userInformationMapper.insertSelective(record);
			}
			
			result = generateNomalResult(record);
			
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}

	@Override
	public List<UserInformation> selectByExample(UserInformationExample example) {
		return userInformationMapper.selectByExample(example);
	}

	@Override
	public int insertSelective(UserInformation record) {
		return userInformationMapper.insertSelective(record);
	}

	@Override
	public int countByExample(UserInformationExample example) {
		return userInformationMapper.countByExample(example);
	}

	@Override
	public void updateByExampleSelective(UserInformation record,
			UserInformationExample example) {
		userInformationMapper.updateByExampleSelective(record, example);
	}
	
	/**  
	* @Title: queryListByPage  
	* @Description: queryListByPage 
	* @param @param record
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@Override
	public Map<String, Object> queryListByPage(UserInformation record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			UserInformationExample example = new UserInformationExample();
			if(record.getPageSize()>0 && record.getStartPage()>0){
				setOrderByClause(record, example, " uid desc ");
			}
			List<UserInformation> list = userInformationMapper.selectByExample(example);
			if(list!=null ){
				result = generateNomalResult(list);
			}
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		
		return result;
	}
	
	
	
	
}
