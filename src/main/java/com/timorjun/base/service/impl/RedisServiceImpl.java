/******************************************************************************
 * @File name   :      RedisServiceImpl.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年8月1日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年8月1日 下午2:16:38        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.base.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timorjun.base.service.IRedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * redis service
 */
@Service
public class RedisServiceImpl implements IRedisService {
	
	private static final Logger logger = LoggerFactory.getLogger( RedisServiceImpl.class );  
  
    @Autowired  
    private JedisPool jedisPool;  
      
    @Override  
    public Jedis getResource() {  
        return jedisPool.getResource();  
    }  
  
    @SuppressWarnings("deprecation")  
    @Override  
    public void returnResource(Jedis jedis) {  
        if(jedis != null){  
            jedisPool.returnResourceObject(jedis);  
        }  
    }  
  
    @Override  
    public void set(String key, String value) {  
        Jedis jedis=null;  
        try{  
            jedis = getResource();  
            jedis.set(key, value);
            logger.info("Redis set success - " + key + ", value:" + value);  
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);  
        }finally{  
            returnResource(jedis);  
        }  
    }  
      
    @Override  
    public String get(String key) {  
        String result = null;  
        Jedis jedis=null;  
        try{  
            jedis = getResource();  
            result = jedis.get(key);  
            logger.info("Redis get success - " + key + ", value:" + result);  
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);  
        }finally{  
            returnResource(jedis);  
        }  
        return result;  
    }  
}
