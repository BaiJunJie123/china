package com.ssm.service.serviceUsers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import com.ssm.entity.user;

public interface userService {
	@Cacheable(value="test",key="#user.id+'aa'")
	public List<user> findusers(@Param("user")user user);
}
