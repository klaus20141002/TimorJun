/******************************************************************************
 * @File name   :      TaobaoFavoriteRepository.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月8日
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
 * 2017年7月8日 下午5:14:12        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.taobao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.timorjun.taobao.model.TaobaoDailyChooiseItem;

/**
 *
 */

//@NamedQuery("")
public interface TaobaoDailyChooseRepository extends JpaRepository<TaobaoDailyChooiseItem,Long>{
	
	@Query("select u from TaobaoDailyChooiseItem u where u.coupon_end_time > now() ")
	Page<TaobaoDailyChooiseItem> findAll(Pageable page);
}
