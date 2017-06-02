package com.xiaohoo.api.common.helper;

import org.apache.commons.lang3.StringUtils;

import com.xiaohoo.api.common.util.PrivacyEncryptionUtil;

/**
 * 账号辅助类
 * @author hzlihonglin
 *
 */
public class AccountHelper {
	
	/**
	* 通过md5的密码生成加扰的密码
	* @param md5Password
	* @return
	*/
	public static String generateSecurePayPassword(String accountId, String md5Password)
	{
		if (StringUtils.isBlank(accountId) || StringUtils.isBlank(md5Password))
		{
			return StringUtils.EMPTY;
		}
		return PrivacyEncryptionUtil.generateIndex(accountId.toLowerCase() + md5Password.toLowerCase());
	}

}
