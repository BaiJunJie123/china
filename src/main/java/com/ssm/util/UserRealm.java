package com.ssm.util;

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
import org.junit.Test;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		String name = arg0.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo  info = new SimpleAuthorizationInfo();
		if(name.equals("bjj")) {
			info.addRole("admin");
			info.addStringPermission("good");
			System.out.println("进行了权限认证");
			//this.setSession("shouquan", "adminSuccess");
		}else {
			System.out.println("没有权限授权");
			//this.setSession("shouquan", "adminError");
		}

		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name = arg0.getPrincipal().toString();
		//System.out.println(name+"=====================");
		String pass = new String( (char[])arg0.getCredentials());
		UsernamePasswordToken token = new UsernamePasswordToken(name,pass);
		SimpleAuthenticationInfo info =null;
		/* token.setRememberMe(true); */
		if(name.equals("bjj")) {
			info = new SimpleAuthenticationInfo(name,pass,null,this.getName());
			System.out.println("验证通过");
			//this.setSession("yanzheng", "bjjSuccess");
		}else {
			System.out.println("验证失败");
			//this.setSession("yanzheng", "bjjError");
			//token.clear();
		}
		return info;
	}
	
	private void setSession(Object key,Object value) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if(key!=null) {
			session.setAttribute(key, value);
		}
		
	}

	 /* @Test
	  public void show() {
	
		  System.out.println("sdfdsfsd");
	 }*/
	 

}
