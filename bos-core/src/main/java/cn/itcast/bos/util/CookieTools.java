package cn.itcast.bos.util;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

/**
 * 操作Cookie工具类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月11日 上午9:30:24
 * @version 1.0
 */
public class CookieTools {
	/**
	 * 新增Cookie到用户浏览器
	 * @param cookieName cookie名称
	 * @param cookieValue cookie值
	 * @param maxAge cookie的有效时间(按秒计算)
	 */
	public static void addCookie(String cookieName,String cookieValue, int maxAge){
		/** 获取Cookie */
		Cookie cookie = getCookie(cookieName);
		/** 判断Cookie是否存在 */
		if (cookie == null){
			/** 创建新的Cookie */
			cookie = new Cookie(cookieName, cookieValue);
		}
		/** 设置cookie的失效时间 */
		cookie.setMaxAge(maxAge);
		/** 设置cookie的访问路径 http://localhost:8080/  http:www.it.com*/
		cookie.setPath("/");
		/** 设置cookie可跨子域访问(二级域名) 
		 *  http://www.it.com
		 *  http://res.it.com
		 *  */
		//cookie.setDomain(".it.com");
		/** 把Cookie添加到用户的浏览器 */
		ServletActionContext.getResponse().addCookie(cookie);
	}
	
	/**
	 * 根据cookie的名称获取指定的cookie
	 * @param cookieName 名称
	 * @return cookie
	 */
	public static Cookie getCookie(String cookieName){
		/** 获取该用户浏览器中所有的Cookie */
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		/** 判断cookie数组 */
		if (cookies != null && cookies.length > 0){
			/** 迭代所有的cookie */
			for (Cookie cookie : cookies){
				if (cookie.getName().equals(cookieName)){
					return cookie;
				}
			}
		}
		return null;
	}
	/**
	 * 删除Cookie
	 * @param cookieName cookie的名称
	 */
	public static void removeCookie(String cookieName){
		/** 获取Cookie */
		Cookie cookie = getCookie(cookieName);
		/** 判断Cookie是否存在 */
		if (cookie != null){
			/** 设置cookie的失效时间 */
			cookie.setMaxAge(0);
			/** 设置cookie的访问路径 http://localhost:8080/  http:www.it.com*/
			cookie.setPath("/");
			/** 设置cookie可跨子域访问(二级域名) 
			 *  http://www.it.com
			 *  http://res.it.com
			 *  */
			//cookie.setDomain(".it.com");
			/** 把Cookie添加到用户的浏览器 */
			ServletActionContext.getResponse().addCookie(cookie);
		}
	}
}