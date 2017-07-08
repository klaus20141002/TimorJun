/******************************************************************************
 * @File name   :      TaobaoFavoriteItemDto.java
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
 * 2017年7月8日 下午4:31:15        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.taobao.dto;

/**
 * 选品库手动导出Excel对应的Dto
 */
public class TaobaoFavoriteItemDto {

	private String num_iid; // 商品id
	private String title; // 商品名称
	private String pict_url; // 商品主图
	private String item_url; // 商品详情页
	private String shop_title; // 店铺名称
	private String zk_final_price; // 商品价格(单位：元)
	private String volume; // 商品月销量
	private String commission_rate; // 通用收入比例
	private String commission_money; // 通用佣金
	private String event_state ;
	private String tk_rate; // 收入比例，举例，取值为20.00，表示比例20.00%
	private String tk_money; // 活动佣金
	private String event_start_time; // 2015-01-01 00:00:00 招商活动开始时间； 如果该宝贝取自普通选品组，则取值为1970-01-01 00:00:00；
	private String event_end_time; // 2015-01-01 00:00:00 招行活动的结束时间； 如果该宝贝取自普通的选品组，则取值为1970-01-01 00:00:00
	private String seller_wanwan; // 卖家旺旺
	private String click_url; // 淘宝客短链接(300天内有效)
	private String click_long_url; // 淘客地址 实际分销地址
	private String taokouling; // 淘口令(30天内有效)
	private String coupon_total_count;// 优惠券总量
	private String coupon_remain_count;// 优惠券剩余量
	private String coupon_info;// 优惠券面额
	private String coupon_start_time;// 优惠券开始时间
	private String coupon_end_time;// 优惠券结束时间
	private String coupon_click_long_url;// 商品优惠券推广链接
	private String coupon_taokouling;// 优惠券淘口令(30天内有效)	
	private String coupon_click_url; //优惠券短链接(300天内有效)
	
	/**
	 * @Date        :      2017年7月8日
	 * @param num_iid
	 * @param title
	 * @param pict_url
	 * @param item_url
	 * @param shop_title
	 * @param zk_final_price
	 * @param volume
	 * @param commission_rate
	 * @param commission_money
	 * @param event_state
	 * @param tk_rate
	 * @param tk_money
	 * @param event_start_time
	 * @param event_end_time
	 * @param seller_wanwan
	 * @param click_url
	 * @param click_long_url
	 * @param taokouling
	 * @param coupon_total_count
	 * @param coupon_remain_count
	 * @param coupon_info
	 * @param coupon_start_time
	 * @param coupon_end_time
	 * @param coupon_click_long_url
	 * @param coupon_taokouling
	 * @param coupon_click_url
	 */
	public TaobaoFavoriteItemDto(String num_iid, String title, String pict_url, String item_url, String shop_title,
			String zk_final_price, String volume, String commission_rate, String commission_money, String event_state,
			String tk_rate, String tk_money, String event_start_time, String event_end_time, String seller_wanwan,
			String click_url, String click_long_url, String taokouling, String coupon_total_count,
			String coupon_remain_count, String coupon_info, String coupon_start_time, String coupon_end_time,
			String coupon_click_long_url, String coupon_taokouling, String coupon_click_url) {
		super();
		this.num_iid = num_iid;
		this.title = title;
		this.pict_url = pict_url;
		this.item_url = item_url;
		this.shop_title = shop_title;
		this.zk_final_price = zk_final_price;
		this.volume = volume;
		this.commission_rate = commission_rate;
		this.commission_money = commission_money;
		this.event_state = event_state;
		this.tk_rate = tk_rate;
		this.tk_money = tk_money;
		this.event_start_time = event_start_time;
		this.event_end_time = event_end_time;
		this.seller_wanwan = seller_wanwan;
		this.click_url = click_url;
		this.click_long_url = click_long_url;
		this.taokouling = taokouling;
		this.coupon_total_count = coupon_total_count;
		this.coupon_remain_count = coupon_remain_count;
		this.coupon_info = coupon_info;
		this.coupon_start_time = coupon_start_time;
		this.coupon_end_time = coupon_end_time;
		this.coupon_click_long_url = coupon_click_long_url;
		this.coupon_taokouling = coupon_taokouling;
		this.coupon_click_url = coupon_click_url;
	}
	public String getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(String num_iid) {
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
	public String getShop_title() {
		return shop_title;
	}
	public void setShop_title(String shop_title) {
		this.shop_title = shop_title;
	}
	public String getZk_final_price() {
		return zk_final_price;
	}
	public void setZk_final_price(String zk_final_price) {
		this.zk_final_price = zk_final_price;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getCommission_rate() {
		return commission_rate;
	}
	public void setCommission_rate(String commission_rate) {
		this.commission_rate = commission_rate;
	}
	public String getCommission_money() {
		return commission_money;
	}
	public void setCommission_money(String commission_money) {
		this.commission_money = commission_money;
	}
	public String getEvent_state() {
		return event_state;
	}
	public void setEvent_state(String event_state) {
		this.event_state = event_state;
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
	public String getEvent_start_time() {
		return event_start_time;
	}
	public void setEvent_start_time(String event_start_time) {
		this.event_start_time = event_start_time;
	}
	public String getEvent_end_time() {
		return event_end_time;
	}
	public void setEvent_end_time(String event_end_time) {
		this.event_end_time = event_end_time;
	}
	public String getSeller_wanwan() {
		return seller_wanwan;
	}
	public void setSeller_wanwan(String seller_wanwan) {
		this.seller_wanwan = seller_wanwan;
	}
	public String getClick_url() {
		return click_url;
	}
	public void setClick_url(String click_url) {
		this.click_url = click_url;
	}
	public String getClick_long_url() {
		return click_long_url;
	}
	public void setClick_long_url(String click_long_url) {
		this.click_long_url = click_long_url;
	}
	public String getTaokouling() {
		return taokouling;
	}
	public void setTaokouling(String taokouling) {
		this.taokouling = taokouling;
	}
	public String getCoupon_total_count() {
		return coupon_total_count;
	}
	public void setCoupon_total_count(String coupon_total_count) {
		this.coupon_total_count = coupon_total_count;
	}
	public String getCoupon_remain_count() {
		return coupon_remain_count;
	}
	public void setCoupon_remain_count(String coupon_remain_count) {
		this.coupon_remain_count = coupon_remain_count;
	}
	public String getCoupon_info() {
		return coupon_info;
	}
	public void setCoupon_info(String coupon_info) {
		this.coupon_info = coupon_info;
	}
	public String getCoupon_start_time() {
		return coupon_start_time;
	}
	public void setCoupon_start_time(String coupon_start_time) {
		this.coupon_start_time = coupon_start_time;
	}
	public String getCoupon_end_time() {
		return coupon_end_time;
	}
	public void setCoupon_end_time(String coupon_end_time) {
		this.coupon_end_time = coupon_end_time;
	}
	public String getCoupon_click_long_url() {
		return coupon_click_long_url;
	}
	public void setCoupon_click_long_url(String coupon_click_long_url) {
		this.coupon_click_long_url = coupon_click_long_url;
	}
	public String getCoupon_taokouling() {
		return coupon_taokouling;
	}
	public void setCoupon_taokouling(String coupon_taokouling) {
		this.coupon_taokouling = coupon_taokouling;
	}
	public String getCoupon_click_url() {
		return coupon_click_url;
	}
	public void setCoupon_click_url(String coupon_click_url) {
		this.coupon_click_url = coupon_click_url;
	}

	
}
