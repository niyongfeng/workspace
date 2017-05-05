package cn.itcast.bos.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.itcast.bos.entity.identity.User;
import cn.itcast.bos.service.identity.IdentityService;

/**
 * 安全数据源
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月5日 上午10:45:27
 * @version 1.0
 */
public class UserAuthorizingRealm extends AuthorizingRealm {
	/** 注入业务层接口 */
	@Resource
	private IdentityService identityService;
	
	/** 授权方法(角色与权限) */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("=========授权方法======doGetAuthorizationInfo================");
		/** 获取当前登录用户名 */
		String userId = (String)principals.getPrimaryPrincipal();
		System.out.println("AuthorizationInfo: " + userId);
		/** 创建简单的授权信息对象 */
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		/** 根据userId查询该用户所有的角色字符串 */
		Set<String> roles = identityService.getRoleByUserId(userId);
		System.out.println("角色：" + roles);
		/** 添加当前用户所有的角色字符串 */
		authorizationInfo.setRoles(roles);
		
		/** 根据userId查询该用户所有的权限字符串 */
		Set<String> permissions = identityService.getPermissionsByUserId(userId);
		System.out.println("权限：" + permissions);
		/** 添加当前用户所有的权限字符串 */
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}
	/** 身份认证方身份法(登录) */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("======身份认证方身份法====doGetAuthenticationInfo======");
		/** 获取当前登录用户名 */
		String userId = (String)token.getPrincipal();
		/** 调用业务层查询用户 */
		User user = identityService.getUser(userId);
		/** 判断用户对象 */
		if (user == null){
			throw new UnknownAccountException("账号不正确！");
		}
		/** 
		 * 创建简单的身份认证信息对象 
		 * 第一个参数：principal 登录用户名
		 * 第二个参数：hashedCredentials 用户密码(加密过后的)
		 * 第三个参数：credentialsSalt 密码加盐字符串
		 * 第四个参数：realmName 域的名称
		 * */
		return new SimpleAuthenticationInfo(userId, 
				user.getPassword(), 
				ByteSource.Util.bytes(user.getSalt()), 
				this.getName());
	}
	
	public static void main(String[] args) {
		// 7e7ad35c73a0034f626ae83beacd7fa6
		System.out.println(new Md5Hash("123456", "0386de0176e2478e56b57d982f862a9d", 5).toHex());
	}

}
