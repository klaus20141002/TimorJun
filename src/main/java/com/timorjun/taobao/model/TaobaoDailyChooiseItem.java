/******************************************************************************
 * @File name   :      TaobaoFavoriteItemDto.java
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
 * 2017年7月8日 下午4:04:02        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.taobao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 */

@Entity
public class TaobaoDailyChooiseItem {
	
	@Id
	private long num_iid; // 商品id
	private String title; // 商品title
	@Column(name="pict_url",length=500)
	private String pict_url; // 商品主图
	@Column(name="item_url",length=500)
	private String item_url; // 商品详情页
	private String category; // 后台一级类目
	@Column(name="click_url",length=500)
	private String click_url; // 淘客地址 实际分销地址
	private String zk_final_price; // 商品折扣价格
	private Integer volume; // 30天销量
	private String tk_rate; // 收入比例，举例，取值为20.00，表示比例20.00%
	private String tk_money; // 活动佣金
	private String seller_wanwan; // 卖家旺旺
	private Long seller_id; // 卖家id
	private String shop_title; // 店名
	private String platform_type; // 平台类型，天猫/淘宝
	private String coupon_id;// 优惠券ID 
	private Long coupon_total_count;// 优惠券总量
	private Long coupon_remain_count;// 优惠券剩余量
	private String coupon_info;// 优惠券面额
	private Date coupon_start_time;// 优惠券开始时间
	private Date coupon_end_time;// 优惠券结束时间
	@Column(name="coupon_url",length=500)
	private String coupon_url;// 商品优惠券推广链接
	@Column(name="coupon_click_url",length=500)
	private String coupon_click_url;// 商品优惠券推广链接
	
	private Date create_time;// add to database时间
	private Date last_update_time;// last update 时间
	
	public long getNum_iid() {
		return num_iid;
	}

	public void setNum_iid(long num_iid) {
		this.num_iid = num_iid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPict_url() {
		return pict_url;
	}

	public void setPict_url(String pict_url) {
		this.pict_url = pict_url;
	}

	public String getItem_url() {
		return item_url;
	}

	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClick_url() {
		return click_url;
	}

	public void setClick_url(String click_url) {
		this.click_url = click_url;
	}

	public String getZk_final_price() {
		return zk_final_price;
	}

	public void setZk_final_price(String zk_final_price) {
		this.zk_final_price = zk_final_price;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getTk_rate() {
		return tk_rate;
	}

	public void setTk_rate(String tk_rate) {
		this.tk_rate = tk_rate;
	}

	public String getTk_money() {
		return tk_money;
	}

	public void setTk_money(String tk_money) {
		this.tk_money = tk_money;
	}

	public String getSeller_wanwan() {
		return seller_wanwan;
	}

	public void setSeller_wanwan(String seller_wanwan) {
		this.seller_wanwan = seller_wanwan;
	}

	public Long getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}

	public String getShop_title() {
		return shop_title;
	}

	public void setShop_title(String shop_title) {
		this.shop_title = shop_title;
	}

	public String getPlatform_type() {
		return platform_type;
	}

	public void setPlatform_type(String platform_type) {
		this.platform_type = platform_type;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public Long getCoupon_total_count() {
		return coupon_total_count;
	}

	public void setCoupon_total_count(Long coupon_total_count) {
		this.coupon_total_count = coupon_total_count;
	}

	public Long getCoupon_remain_count() {
		return coupon_remain_count;
	}

	public void setCoupon_remain_count(Long coupon_remain_count) {
		this.coupon_remain_count = coupon_remain_count;
	}

	public String getCoupon_info() {
		return coupon_info;
	}

	public void setCoupon_info(String coupon_info) {
		this.coupon_info = coupon_info;
	}

	public Date getCoupon_start_time() {
		return coupon_start_time;
	}

	public void setCoupon_start_time(Date coupon_start_time) {
		this.coupon_start_time = coupon_start_time;
	}

	public Date getCoupon_end_time() {
		return coupon_end_time;
	}

	public void setCoupon_end_time(Date coupon_end_time) {
		this.coupon_end_time = coupon_end_time;
	}

	public String getCoupon_url() {
		return coupon_url;
	}

	public void setCoupon_url(String coupon_url) {
		this.coupon_url = coupon_url;
	}

	public String getCoupon_click_url() {
		return coupon_click_url;
	}

	public void setCoupon_click_url(String coupon_click_url) {
		this.coupon_click_url = coupon_click_url;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	public TaobaoDailyChooiseItem() { 
		
	}

	@Override
	public String toString() {
		return "TaobaoDailyChooiseItem [num_iid=" + num_iid + ", title=" + title + ", pict_url=" + pict_url
				+ ", item_url=" + item_url + ", category=" + category + ", click_url=" + click_url + ", zk_final_price="
				+ zk_final_price + ", volume=" + volume + ", tk_rate=" + tk_rate + ", tk_money=" + tk_money
				+ ", seller_wanwan=" + seller_wanwan + ", seller_id=" + seller_id + ", shop_title=" + shop_title
				+ ", platform_type=" + platform_type + ", coupon_id=" + coupon_id + ", coupon_total_count="
				+ coupon_total_count + ", coupon_remain_count=" + coupon_remain_count + ", coupon_info=" + coupon_info
				+ ", coupon_start_time=" + coupon_start_time + ", coupon_end_time=" + coupon_end_time + ", coupon_url="
				+ coupon_url + ", coupon_click_url=" + coupon_click_url + ", create_time=" + create_time
				+ ", last_update_time=" + last_update_time + "]";
	}
	

}
