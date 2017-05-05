package cn.itcast.bos.interceptor;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;

import cn.itcast.bos.entity.identity.User;
import cn.itcast.bos.service.identity.IdentityService;
import cn.itcast.bos.util.Constant;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录拦截器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月11日 上午10:34:15
 * @version 1.0
 */
public class LoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 2762407143361520359L;
	@Resource
	private IdentityService identityService;
	/** 注入SessionDAO */
	@Resource
	private SessionDAO sessionDAO;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		/** 获取当前Session中的用户 */
		User user = (User)invocation.getInvocationContext()
					.getSession().get(Constant.SESSION_USER);
		
		System.out.println("Session中的用户：" + user);
		
		if (user == null){ // 判断是否记住了用户
			/** 获取主体，获取当前用户登录名 */
			String userId = (String)SecurityUtils.getSubject().getPrincipal();
			System.out.println("LoginInterceptor: " + userId);
			/** 判断是否为空，不为空代表记住用户 */
			if (!StringUtils.isEmpty(userId)){
				/** 帮他登录 */
				user = identityService.getUser(userId);
				/** 把用户存入Session */
				invocation.getInvocationContext()
					.getSession().put(Constant.SESSION_USER, user);
			}
		}
		
		if (user != null){
			/** 获取所有活动的Session */
			Collection<Session> sessions = sessionDAO.getActiveSessions();
			System.out.println("在线人数总数量：" + sessions.size());
			/** 定义统计数量 */
			int count = 0;
			for (Session session : sessions){
				/** 判断该Session是不是有登录的用户 */
				if (session.getAttribute(Constant.SESSION_USER) != null){
					count++;
				}
			}
			System.out.println("登录人数总数量：" + count);
			invocation.getInvocationContext()
				.getSession().put(Constant.LOGIN_USER_COUNT, count);
		}
		
		return user == null ? Action.LOGIN : invocation.invoke();
	}
}
