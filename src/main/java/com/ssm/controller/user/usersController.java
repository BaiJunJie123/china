package com.ssm.controller.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.entity.user;
import com.ssm.service.serviceUsers.*;
import com.ssm.util.WenJianChuLi;;
@Controller
@RequestMapping("/guo")
public class usersController {
	@Resource
	private userService userService;
	
    @RequestMapping("/login.html")
   
	public String login() {
    	String url = "";
    	String name ="ss";
    	String pass = "ss";
    	UsernamePasswordToken token = new UsernamePasswordToken(name,pass);
		token.setRememberMe(true);
	    System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
    	Subject subject = SecurityUtils.getSubject();
    	 System.out.println("对用户[" + name + "]进行登录验证..验证开始"); 
    	 try {
    		 subject.login(token);
    		 System.out.println("对用户[" + name + "]进行登录验证..验证通过");  
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	
    	 
    	if(subject.isAuthenticated()) {
    		 System.out.println("用户[" + name + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)"); 
    		 url = "userjsp/success";
    	}else {
    		token.clear();
    	}
    	System.out.println("good login");
		/*
		 * user uu = new user(); uu.setId(86101); List<user> ji =
		 * userService.findusers(uu); for(user s : ji) {
		 * System.out.println(s.getAgent_status()+"======================"); }
		 */
		
		return url;
	}
    @RequestMapping("/success.html")
    
 	public String login2() {
 		System.out.println("good success");
 		/*
 		 * user uu = new user(); uu.setId(86101); List<user> ji =
 		 * userService.findusers(uu); for(user s : ji) {
 		 * System.out.println(s.getAgent_status()+"======================"); }
 		 */
 		return "userjsp/success";
 	}
 @RequestMapping("/error.html")
    
 	public String login3() {
 		System.out.println("good success");
 		/*
 		 * user uu = new user(); uu.setId(86101); List<user> ji =
 		 * userService.findusers(uu); for(user s : ji) {
 		 * System.out.println(s.getAgent_status()+"======================"); }
 		 */
 		return "userjsp/error";
 	}
    @RequestMapping("/chuli")
    @CrossOrigin
    @ResponseBody
    public Object show(@RequestParam("tu") MultipartFile tu) {
    	InputStream in = null;
    	String data = "";
    	 if(tu.isEmpty()) {
    		 System.out.println("空的");
    	 }else {
    		 WenJianChuLi wu = new WenJianChuLi();
    		 try {
    				in = tu.getInputStream();
    				 data =wu.chuLiTxt(in);
    				in.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	 }
    	
    	
    	//userService.clean();
    	System.out.println("aaaa");
    	String zhi = "{\"bjj\":\""+data+"\"}";
    	return zhi;
    }
}
