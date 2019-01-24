package com.ssm.service.serviceUsers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;

import com.ssm.entity.user;

public interface userService {
	//,condition="#user.id%2==0"  什么情况下缓存
	
	
	public List<user> findusers(@Param("user")user user);
	
	 public void clean();
}
