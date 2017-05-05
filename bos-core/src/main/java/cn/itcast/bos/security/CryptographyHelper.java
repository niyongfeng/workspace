package cn.itcast.bos.security;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 加密算法帮助类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月8日 上午9:11:53
 * @version 1.0
 */
public final class CryptographyHelper {
	/** 定义安全随机数生成器对象 */
	private static SecureRandomNumberGenerator secureRandomNumberGenerator 
			= new SecureRandomNumberGenerator();
	/** 定义加密算法的名称 */
	private final static String ALGORITHM_NAME = "md5";
	/** 定义加密迭代次数 */
	private final static int HASH_ITERATIONS = 5;
	
	/**
	 * 获取随机盐的方法
	 * @return 32长度的字符串(md5)
	 */
	public static String getRandomSalt() {
		return secureRandomNumberGenerator.nextBytes().toHex();
	}
	/**
	 * 加密方法
	 * @param password 明文
	 * @param salt 盐
	 * @return MD5加密的字符串
	 */
	public static String encrypt(String password, String salt) {
		return new SimpleHash(ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toHex();
	}
}
