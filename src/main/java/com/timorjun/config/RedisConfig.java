/******************************************************************************
 * @File name   :      RedisConfig.java
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
 * 2017年8月1日 下午2:13:28        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis config
 */
@Configuration  
@EnableAutoConfiguration  
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
	private static final Logger logger = LoggerFactory.getLogger( RedisConfig.class );  
    
    private String hostName;  
  
    private int port;  
  
    private String password;  
  
    private int timeout;  
      
    @Bean  
    public JedisPoolConfig getRedisConfig(){  
        JedisPoolConfig config = new JedisPoolConfig();  
        return config;  
    }  
      
    @Bean  
    public JedisPool getJedisPool(){  
        JedisPoolConfig config = getRedisConfig();  
        JedisPool pool = new JedisPool(config,hostName,port,timeout,password);  
        logger.info("init JredisPool ...");  
        return pool;  
    }  
  
    public String getHostName() {  
        return hostName;  
    }  
  
    public void setHostName(String hostName) {  
        this.hostName = hostName;  
    }  
  
    public int getPort() {  
        return port;  
    }  
  
    public void setPort(int port) {  
        this.port = port;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public int getTimeout() {  
        return timeout;  
    }  
  
    public void setTimeout(int timeout) {  
        this.timeout = timeout;  
    }

}
