package com.xiaohoo.api.service;

import java.util.List;
import java.util.Map;

import com.xiaohoo.api.domain.UserInformation;
import com.xiaohoo.api.domain.UserInformationExample;

/**
 * Desc: UserInformationService
 * 
 * @author Kavin
 * @since  2017-Mar-6 
 */
public interface UserInformationService {

	Map<String, Object> save(UserInformation record);

	Map<String, Object> delete(UserInformation record);

	Map<String, Object> selectByPrimaryKey(Integer id);

	Map<String, Object> saveOrUpdate(UserInformation record);

	List<UserInformation> selectByExample(UserInformationExample example);

	int insertSelective(UserInformation record);

	int countByExample(UserInformationExample example);

	void updateByExampleSelective(UserInformation record,
			UserInformationExample example);

	Map<String, Object> checkLogin(UserInformation dto);

	Map<String, Object> resetPswd(UserInformation record);

	Map<String, Object> changePswd(UserInformation record);

	Map<String, Object> checkLoginThird(UserInformation record);

	Map<String, Object> queryListByPage(UserInformation record);

}