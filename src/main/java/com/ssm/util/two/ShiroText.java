package com.ssm.util.two;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import com.hazelcast.config.matcher.WildcardConfigPatternMatcher;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroText {
	 
   public static void main(String[] args) {
	 Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
	 SecurityManager securityManager = factory.getInstance();
	 SecurityUtils.setSecurityManager(securityManager);
	 Subject subject = SecurityUtils.getSubject();
	 UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
	 token.setRememberMe(true);
	// System.out.println(subject.isAuthenticated()); // 是否验证过
	 try {
		 subject.login(token);
		 if(subject.isAuthenticated()) {
			 System.out.println("success"); 
			 if(subject.hasRole("admainistrator")) {
				 System.out.println("you");
			 }else {
				 System.out.println("muyou");
			 }
			 if(subject.isPermittedAll("select","update")) {
				 System.out.println("qyou");
			 }else {
				 System.out.println("qmuyou");
			 }
		 }
	 }catch(Exception e) {
		 System.out.println("error"); 
	 }
	 
   }
   @Test
   public void show() {
	   DefaultSecurityManager securityManager = new DefaultSecurityManager();
	   ModularRealmAuthenticator then = new ModularRealmAuthenticator();
	   then.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
	   securityManager.setAuthenticator(then);
	   
	   ModularRealmAuthorizer auth = new ModularRealmAuthorizer();
	   auth.setPermissionResolver(new WildcardPermissionResolver());
	   securityManager.setAuthorizer(auth);
	   securityManager.setRealm(new myrleam());
	   SecurityUtils.setSecurityManager(securityManager);
	   
	   
	   Subject subject = SecurityUtils.getSubject();
		 UsernamePasswordToken token = new UsernamePasswordToken("bjj","bjj");
		 try {
			 subject.login(token);
			 System.out.println("登陆成功");
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
   
   
   }
}
