package com.ssm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReadWriteLock;

import org.springframework.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCachetwo implements Cache {
   private RedisTemplate<String,Object> redisTemplate;
   
   private String name;

public RedisTemplate<String, Object> getRedisTemplate() {
	return redisTemplate;
}

public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
	this.redisTemplate = redisTemplate;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public Object getNativeCache() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ValueWrapper get(Object key) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <T> T get(Object key, Class<T> type) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <T> T get(Object key, Callable<T> valueLoader) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void put(Object key, Object value) {
	// TODO Auto-generated method stub
	
}

@Override
public ValueWrapper putIfAbsent(Object key, Object value) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void evict(Object key) {
	// TODO Auto-generated method stub
	
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	
}
   
   




   
}
