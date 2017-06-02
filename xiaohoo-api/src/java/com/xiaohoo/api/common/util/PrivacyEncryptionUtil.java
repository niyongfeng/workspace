package com.xiaohoo.api.common.util;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * 隐私信息加解密工具
 * @author hzlihonglin
 *
 */
public class PrivacyEncryptionUtil
{
	private final static Log log = LogFactory.getLog(PrivacyEncryptionUtil.class);

	protected static String keyFromDB; //= "QmvT6nQ~:iNVBf:gJ9^tv5ladneAtYO@Gj)c";
	protected static String keyFromServer;// = "LfC^kvPsZbY=gR<Pk%`HZBn$+6x=sT=P-%kat";
	protected static String keyFromCode = "LOYIIG4H>,IF;Zklc%5uJGo0Z@JVe1t5IHx5";


	/**
	 * 生成隐私字段查询用的索引字段
	 * @param plainText
	 * @return
	 */
	public static String generateIndex(String plainText)
	{
		if (StringUtils.isBlank(plainText))
		{
			return plainText;
		}
		return SecurityUtil.getMd5(plainText + keyFromCode).toLowerCase();
	}
	
	private static SecretKeySpec getAesKey(String seed)
	{
		String keyStr = SecurityUtil.getMd5(keyFromDB + keyFromCode + keyFromServer + seed).toLowerCase();
		return new SecretKeySpec(keyStr.getBytes(), "AES");
	}

}
