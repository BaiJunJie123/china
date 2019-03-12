package com.ssm.util.two;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class myrleam implements Realm{

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		arg0.getPrincipal(); //用户名
		new String((char[])arg0.getCredentials()); //密码
		String name = arg0.getPrincipal().toString();
		String pass = new String((char[])arg0.getCredentials()); 
		if(!name.equals("bjj")) {
			throw new UnknownAccountException();
		}
		if(!pass.equals("bjj")) {
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(name,pass,this.getName());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "myRealm1";
	}

	@Override
	public boolean supports(AuthenticationToken arg0) {
		// TODO Auto-generated method stub
		return arg0 instanceof UsernamePasswordToken;
	}

}
