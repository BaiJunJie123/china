package com.ssm.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.entity.user;
import com.ssm.service.serviceUsers.*;;
@Controller
public class usersController {
	@Resource
	private userService userService;
	
    @RequestMapping("login.html")
	public String login() {
		System.out.println("good java");
		user uu = new user();
		uu.setId(86101);
		List<user> ji = userService.findusers(uu);
		for(user s : ji) {
			System.out.println(s.getAgent_status()+"======================");
		}
		return "userjsp/login";
	}
    @RequestMapping("clean.html")
    public String show() {
    	
    	userService.clean();
    	
    	return "userjsp/login";
    }
}
