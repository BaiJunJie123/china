package com.ssm.util;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

public class redisUtil implements Cache {
    
	private org.springframework.data.redis.core.RedisTemplate<String,Object> redisTemplate;
	private String name;
	


	public org.springframework.data.redis.core.RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(org.springframework.data.redis.core.RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Object getNativeCache() {
		// TODO Auto-generated method stub
		return this.redisTemplate;
	}

	@Override
	 public ValueWrapper get(Object key) {
        // TODO Auto-generated method stub
        System.out.println("�õ� key");
        final String keyf = key.toString();
        Object object = null;
        object = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                return toObject(value);
            }
        });
        return (object != null ? new SimpleValueWrapper(object) : null);
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
        System.out.println("д�� key");
        final String keyf = key.toString();
        final Object valuef = value;
        final long liveTime = 86400;
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyb = keyf.getBytes();
                byte[] valueb = toByteArray(valuef);
                connection.set(keyb, valueb);
                if (liveTime > 0) {
                    connection.expire(keyb, liveTime);
                }
                return 1L;
            }
        });
    }

	 private byte[] toByteArray(Object obj) {
	        byte[] bytes = null;
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        try {
	            ObjectOutputStream oos = new ObjectOutputStream(bos);
	            oos.writeObject(obj);
	            oos.flush();
	            bytes = bos.toByteArray();
	            oos.close();
	            bos.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return bytes;
	    }
	  private Object toObject(byte[] bytes) {
	        Object obj = null;
	        try {
	            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
	            ObjectInputStream ois = new ObjectInputStream(bis);
	            obj = ois.readObject();
	            ois.close();
	            bis.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        return obj;
	    }
	
	
	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 public void evict(Object key) {
        // TODO Auto-generated method stub
        System.out.println("del key");
        final String keyf = key.toString();
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.del(keyf.getBytes());
            }
        });
    }

	@Override
	 public void clear() {
	        // TODO Auto-generated method stub
	        System.out.println("clear key");
	        redisTemplate.execute(new RedisCallback<String>() {
	            @Override
	            public String doInRedis(RedisConnection connection)
	                    throws DataAccessException {
	                connection.flushDb();
	                return "ok";
	            }
	        });
	    }
	public void show() {
		
		redisTemplate.opsForList().leftPush("aa", "hello");
		
	}
}
