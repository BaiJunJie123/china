package com.ssm.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.entity.user;
import com.ssm.service.serviceUsers.*;;
@Controller
public class usersController {
	@Resource
	private userService userService;
	
    @RequestMapping("/login.html")
   
	public String login() {
		System.out.println("good javas");
		/*
		 * user uu = new user(); uu.setId(86101); List<user> ji =
		 * userService.findusers(uu); for(user s : ji) {
		 * System.out.println(s.getAgent_status()+"======================"); }
		 */
		return "userjsp/login";
	}
    @RequestMapping("/chuli")
    @CrossOrigin
    @ResponseBody
    public Object show(@RequestParam("tu") MultipartFile tu) {
    	 if(tu.isEmpty()) {
    		 System.out.println("空的");
    	 }else {
    		 System.out.println("不是空的");
    	 }
    	//userService.clean();
    	System.out.println("aaaa");
    	String zhi = "{\"bjj\":\"success\"}";
    	return zhi;
    }
}
