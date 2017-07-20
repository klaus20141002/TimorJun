/******************************************************************************
 * @File name   :      GoodsService.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月20日
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
 * 2017年7月20日 下午9:33:36        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.solr.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.timorjun.base.common.dto.JsonData;
import com.timorjun.solr.domain.Goods;
import com.timorjun.solr.repository.GoodsRepository;

/**
 *
 */
@Service
public class GoodsService {
	

    @Autowired
    GoodsRepository goodsRepository;

    public List<Goods> findByName(String name){
        if(StringUtils.isEmpty(name)){
            return new ArrayList<>();
        }
        return goodsRepository.findByName(name);
    }
    public void save(Goods product){
        if(product != null) {
        	goodsRepository.save(product);
        }
    }

    public Page<Goods> query(String queryString, Pageable pageable) throws Exception {
        return goodsRepository.findByNameContaining(queryString, pageable);
    }
    
    
    

    /**
     * 将goods加入索引倒solr里
     * @Date        :      2017年7月20日
     * @param goods
     * @return
     */
    public JsonData synGoodsToSolr(List<Goods> goods) {
    	Iterable<Goods> result = goodsRepository.save(goods);
    	return JsonData.success(result, "", 1);
    }



}
