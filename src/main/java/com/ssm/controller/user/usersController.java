package com.ssm.controller.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
/* @RequestMapping("/guo") */
public class usersController {
	@Resource
	private userService userService;
	 @RequestMapping("/cheng.html")
		public String login4() {
			/*
			 * user uu = new user(); uu.setId(86101); List<user> ji =
			 * userService.findusers(uu); for(user s : ji) {
			 * System.out.println(s.getAgent_status()+"======================"); }
			 */
			
			return "userjsp/cheng";
	 }
    @RequestMapping("/login.html")
	public String login(HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
		/*
		 * user uu = new user(); uu.setId(86101); List<user> ji =
		 * userService.findusers(uu); for(user s : ji) {
		 * System.out.println(s.getAgent_status()+"======================"); }
		 */
		
		return "userjsp/login";
	}
    @RequestMapping("/success")
    @ResponseBody
 	public String login2(@RequestParam("name") String name,@RequestParam("pass") String pass,HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
 		System.out.println("good success");
 		 String zhi ="";
 		try {
 			 Subject subject = SecurityUtils.getSubject();
 	 	     UsernamePasswordToken token = new UsernamePasswordToken(name,pass);
			/* token.setRememberMe(true); */
 	 		 subject.login(token);
 	 		System.out.println( subject.hasRole("admin")+"是否有这个角色");
 	 		 System.out.println("Contorller验证成功");
 	 		//return "redirect:/cheng.html";
 	 		 zhi = "{\"fan\":\"success\"}";
 	 		return zhi;
 		}catch(Exception e) {
 			 System.out.println("Contorller验证失败");
 			//return "userjsp/error";
 			 zhi = "{\"fan\":\"Nosuccess\"}";
 			return zhi;
 		}
 	    
 		/*
 		 * user uu = new user(); uu.setId(86101); List<user> ji =
 		 * userService.findusers(uu); for(user s : ji) {
 		 * System.out.println(s.getAgent_status()+"======================"); }
 		 */
 	//	return "userjsp/success";
 	}
 @RequestMapping("/error.html")
    
 	public String login3() {
 		
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
