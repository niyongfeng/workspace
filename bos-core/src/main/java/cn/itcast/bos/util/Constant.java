package cn.itcast.bos.util;
/**
 * 常量类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月11日 上午9:26:45
 * @version 1.0
 */
public class Constant {
	/** 定义存放在Session中的用户 */
	public static final String SESSION_USER = "session_user";
	/** 定义cookie的名称 */
	public static final String COOKIE_NAME = "bos_cookie_name";
	/** 定义cookie的失效时间(按秒) 7天 */
	public static final int MAX_AGE = 60 * 60 * 24 * 7;
	/** 定义存放在Session中登录用户的总数量 */
	public static final String LOGIN_USER_COUNT = "login_user_count";
	/** 定义存放在Session中的短信验证码 */
	public static final String SMS_VERIFY_CODE = "sms_verify_code";
	/** 定义找回密码存放在Session中的用户ID */
	public static final String FIND_PWD_USER = "find_pwd_user";

}
