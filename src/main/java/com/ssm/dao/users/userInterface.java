package com.ssm.dao.users;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entity.user;

public interface userInterface {
   public List<user> findusers(@Param("user")user user);
}
