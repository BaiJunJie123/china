package com.ssm.controller.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

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
