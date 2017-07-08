/******************************************************************************
 * @File name   :      TaobaoFavoriteDto.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月8日
 *
 * @Copyright Notice: 
 * Copyright (c) 2014 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年7月8日 上午11:17:36        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.taobao.model;

import java.util.Date;

/**
 *
 */
public class TaobaoFavorite {
	private int type;
	private long favorites_id;
	private String favorites_title;
	private Integer goods_count;
	private Date create_time;
	private Date update_time;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getFavorites_id() {
		return favorites_id;
	}
	public void setFavorites_id(long favorites_id) {
		this.favorites_id = favorites_id;
	}
	public String getFavorites_title() {
		return favorites_title;
	}
	public void setFavorites_title(String favorites_title) {
		this.favorites_title = favorites_title;
	}
	public Integer getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(Integer goods_count) {
		this.goods_count = goods_count;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
	

}
