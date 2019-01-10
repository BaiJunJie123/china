package com.ssm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
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
public String getId() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void putObject(Object key, Object value) {
	// TODO Auto-generated method stub
	System.out.println("写入一个value");
	final String keys = key.toString();
	final Object zhi = value;
	redisTemplate.execute(new RedisCallback<Long>(){

		@Override
		public Long doInRedis(RedisConnection connection) throws DataAccessException {
			// TODO Auto-generated method stub
			byte[] jian = keys.getBytes();
			byte[] data = toArrays(zhi);
			connection.set(jian, data);
			return 1L;
		}
		
		
	});
}

@Override
public Object getObject(Object key) {
	// TODO Auto-generated method stub
	
	System.out.println("得到一个key");
	Object obj = null;
	final String keys = key.toString();
	obj =redisTemplate.execute(new RedisCallback<Object>() {

		@Override
		public Object doInRedis(RedisConnection connection) throws DataAccessException {
			// TODO Auto-generated method stub
			byte[] b1 = keys.getBytes();
			byte[] data = connection.get(b1);
			if(data==null) {
			   return null;	
			}
			return toObject(data);
		}
		
		
		
	});
	
	return obj==null ? null : obj;
}

@Override
public Object removeObject(Object key) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	
}

@Override
public int getSize() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public ReadWriteLock getReadWriteLock() {
	// TODO Auto-generated method stub
	return null;
}

// 序列化
private byte[] toArrays(Object obj){
	byte[] by = null;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	ObjectOutputStream xie;
	try {
		xie = new ObjectOutputStream(out);
		xie.writeObject(obj);
		xie.flush();
		by = out.toByteArray();
		xie.close();
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return by;
	
}
//反序列化
private Object toObject(byte[] by) {
	Object obj = null;
	ByteArrayInputStream put = new ByteArrayInputStream(by);
	
	ObjectInputStream ob;
	try {
		ob = new ObjectInputStream(put);
		try {
			obj = ob.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ob.close();
		put.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	return obj;
}
   
}
