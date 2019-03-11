package com.ssm.util;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject; 
public class MyRealm extends AuthorizingRealm {
	/* 授权 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String currentUserName = super.getAvailablePrincipal(principals).toString();
		SimpleAuthorizationInfo sm = new SimpleAuthorizationInfo();
		if(currentUserName!=null && "bjj".equals("currentUserName")) {
			sm.addRole("admin");
			sm.addStringPermission("admin:good");
			System.out.println("已为用户[bjj]赋予了[admin]角色和[admin:good]权限");  
			return sm;
		}else  if(currentUserName!=null && "sw".equals("currentUserName")) {
			 System.out.println("当前用户[sw]无授权");  
	            return sm; 
		}
		
		return null;
	}
	/* 验证 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken tokens = (UsernamePasswordToken)token;
		 System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
		 AuthenticationInfo authInfo =null;
		 if("bjj".equals(tokens.getUsername())) {
			 authInfo = new SimpleAuthenticationInfo("bjj","bjj",this.getName());
			 this.setSession("currentUser", "bjj");  
			 return authInfo;
		 }else if("sw".equals(tokens.getUsername())) {
			  authInfo = new SimpleAuthenticationInfo("sw","sw",this.getName());
			 this.setSession("currentUser", "sw");
			 return authInfo;
		 }
		return authInfo;
	}
	private void setSession(Object key,Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser!=null) {
			Session session = currentUser.getSession();
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
			if(session!=null) {
				session.setAttribute(key, value);	
			}
		}
		
	}
  
}
