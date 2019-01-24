package com.ssm.service.serviceUsers.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.ssm.dao.users.*;
import com.ssm.entity.user;
import com.ssm.service.serviceUsers.userService;
@Service
public class userServiceImpl implements userService {
     @Resource
	private userInterface userInterface;
	
     @Cacheable(value="test",key="#root.methodName")
	@Override
	public List<user> findusers(user user) {
		// TODO Auto-generated method stub
		return userInterface.findusers(user);
	}
	@CacheEvict(value="test",allEntries=true)
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

}
