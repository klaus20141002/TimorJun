/******************************************************************************
 * @File name   :      IRedisService.java
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
 * 2017年8月1日 下午2:15:56        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.base.service;

import java.util.List;

/**
 *
 */
public interface IRedisService {
	public boolean set(String key, String value);  
    
    public String get(String key);  
      
    public boolean expire(String key,long expire);  
      
    public <T> boolean setList(String key ,List<T> list);  
      
    public <T> List<T> getList(String key,Class<T> clz);  
      
    public long lpush(String key,Object obj);  
      
    public long rpush(String key,Object obj);  
      
    public String lpop(String key);  
}
