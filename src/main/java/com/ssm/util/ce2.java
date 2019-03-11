package com.ssm.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
public class ce2 {
	@Test
  public void show() {
	  
	  Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
	  SecurityManager securitityManager = factory.getInstance();
	  SecurityUtils.setSecurityManager(securitityManager);
	  
	  Subject currentUser = SecurityUtils.getSubject();
	  Session session = currentUser.getSession();
	  session.setAttribute("someKey", "aValue");
	  String value = session.getAttribute("someKey").toString();
	  if(value.equals("aValue")) {
		  System.out.println("someKey 的值：" + value);
	  }
	  
	  //登陆
	  UsernamePasswordToken tokan = new UsernamePasswordToken("zhangsan","zhangsan");
	  tokan.setRememberMe(true);
	  currentUser.login(tokan);
	  if(currentUser.isAuthenticated()) {
		  
		   System.out.println("用户 " + currentUser.getPrincipal() + " 登陆成功！");
		 //测试角色
           System.out.println("是否拥有 manager 角色：" + currentUser.hasRole("manager"));
           
           //测试权限
           System.out.println("是否拥有 user:create 权限" + currentUser.isPermitted("user:created"));
	    currentUser.logout();
	  }
	
	
	
	
	
	
	
	}
}
