package com.ssm.util;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Shiyan {
    public static JedisPool pool = null;
	static {
		
		Jedis jedis = null;
		JedisPoolConfig conf = new JedisPoolConfig();
		conf.setMaxTotal(100);
		conf.setMinIdle(100);
		pool = new JedisPool(conf,"127.0.0.1",6379);
	}
	public static Jedis getJedis() {
		return pool.getResource();
	}
	public void close(Jedis jedis) {
		jedis.close();
	}
	public static void lPush(String key,String value) {
		Jedis jedis = getJedis();
		jedis.lpush(key, value);
		jedis.close();
	}
	public String rpop(String key) {
		Jedis jedis = getJedis();
		String ss = jedis.rpop(key);
		jedis.close();
		return ss;
	}
}
