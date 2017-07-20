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

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 */

@Entity
public class TaobaoFavoriteItem {
	
	@Id
	private long num_iid; // 商品id
	private String title; // 商品title
	@Column(name="pict_url",length=500)
	private String pict_url; // 商品主图
	@Column(name="item_url",length=500)
	private String item_url; // 商品地址
	private String category; // 后台一级类目
	@Column(name="click_url",length=2000)
	private String click_url; // 淘客地址 实际分销地址
	private String zk_final_price; // 商品折扣价格
	private Integer volume; // 30天销量
	private String tk_rate; // 收入比例，举例，取值为20.00，表示比例20.00%
	private String tk_money; // 活动佣金
	private String seller_wanwan; // 卖家旺旺
	private Long seller_id; // 卖家id
	private String shop_title; // 店名
	@Column(name="coupon_click_url",length=2000)
	private String coupon_click_url;// 商品优惠券推广链接
	@Column(name="coupon_click_long_url",length=2000)
	private String coupon_click_long_url;// 商品优惠券推广链接
	private String coupon_taokouling;// 优惠券淘口令(30天内有效)
	private String coupon_info;// 优惠券面额
	private Long coupon_total_count;// 优惠券总量
	private Long coupon_remain_count;// 优惠券剩余量
	private Date coupon_start_time;// 优惠券开始时间
	private Date coupon_end_time;// 优惠券结束时间
	private String reserve_price; // 商品一口价格
	private String zk_final_price_wap; // 无线折扣价，即宝贝在无线上的实际售卖价格。
	private String user_type; // 卖家类型，0表示集市，1表示商城
	private String provcity; // 宝贝所在地， 杭州
	private String nick; // 卖家昵称
	private String commission_rate; // 佣金比率(%)
	private String commission_money; // 通用佣金
	private String event_state ;
	private Date event_start_time; // 2015-01-01 00:00:00 招商活动开始时间； 如果该宝贝取自普通选品组，则取值为1970-01-01 00:00:00；
	private Date event_end_time; // 2015-01-01 00:00:00 招行活动的结束时间；
	@Column(name="click_long_url",length=2000)
	private String click_long_url; // 淘客地址 实际分销地址 如果该宝贝取自普通的选品组，则取值为1970-01-01 00:00:00
	private String status; // 宝贝状态，0失效，1有效；注：失效可能是宝贝已经下线或者是被处罚不能在进行推广
	private String type; // 宝贝类型，1 普通商品 2 鹊桥高佣金商品，3 定向招商商品
	private String taokouling; // 淘口令(30天内有效)
	private Date create_time;// add to database时间
	private Date last_update_time;// last update 时间
	private long favorites_id; // 选品库id
	
	public TaobaoFavoriteItem() { 
		
	}
	

	/**
	 * @Date        :      2017年7月8日
	 * @param num_iid
	 * @param favorites_id
	 * @param title
	 * @param pict_url
	 * @param reserve_price
	 * @param zk_final_price
	 * @param zk_final_price_wap
	 * @param user_type
	 * @param provcity
	 * @param item_url
	 * @param click_url
	 * @param shop_title
	 * @param seller_id
	 * @param nick
	 * @param volume
	 * @param tk_rate
	 * @param commission_rate
	 * @param event_start_time
	 * @param event_end_time
	 * @param status
	 * @param type
	 * @param category
	 * @param coupon_click_url
	 * @param coupon_info
	 * @param coupon_total_count
	 * @param coupon_remain_count
	 * @param coupon_start_time
	 * @param coupon_end_time
	 * @param create_time
	 * @param last_update_time
	 */
	public TaobaoFavoriteItem(long num_iid, long favorites_id, String title, String pict_url, String reserve_price,
			String zk_final_price, String zk_final_price_wap, String user_type, String provcity, String item_url,
			String click_url, String shop_title, Long seller_id, String nick, Integer volume, String tk_rate,
			String commission_rate, Timestamp event_start_time, Timestamp event_end_time, String status, String type,
			String category, String coupon_click_url, String coupon_info, Long coupon_total_count,
			Long coupon_remain_count, Date coupon_start_time, Date coupon_end_time, Date create_time,
			Date last_update_time) {
		super();
		this.num_iid = num_iid;
		this.favorites_id = favorites_id;
		this.title = title;
		this.pict_url = pict_url;
		this.reserve_price = reserve_price;
		this.zk_final_price = zk_final_price;
		this.zk_final_price_wap = zk_final_price_wap;
		this.user_type = user_type;
		this.provcity = provcity;
		this.item_url = item_url;
		this.click_url = click_url;
		this.shop_title = shop_title;
		this.seller_id = seller_id;
		this.nick = nick;
		this.volume = volume;
		this.tk_rate = tk_rate;
		this.commission_rate = commission_rate;
		this.event_start_time = event_start_time;
		this.event_end_time = event_end_time;
		this.status = status;
		this.type = type;
		this.category = category;
		this.coupon_click_url = coupon_click_url;
		this.coupon_info = coupon_info;
		this.coupon_total_count = coupon_total_count;
		this.coupon_remain_count = coupon_remain_count;
		this.coupon_start_time = coupon_start_time;
		this.coupon_end_time = coupon_end_time;
		this.create_time = create_time;
		this.last_update_time = last_update_time;
	}


	public long getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(long num_iid) {
		this.num_iid = num_iid;
	}
	public long getFavorites_id() {
		return favorites_id;
	}
	public void setFavorites_id(long favorites_id) {
		this.favorites_id = favorites_id;
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
	public String getReserve_price() {
		return reserve_price;
	}
	public void setReserve_price(String reserve_price) {
		this.reserve_price = reserve_price;
	}
	public String getZk_final_price() {
		return zk_final_price;
	}
	public void setZk_final_price(String zk_final_price) {
		this.zk_final_price = zk_final_price;
	}
	public String getZk_final_price_wap() {
		return zk_final_price_wap;
	}
	public void setZk_final_price_wap(String zk_final_price_wap) {
		this.zk_final_price_wap = zk_final_price_wap;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getProvcity() {
		return provcity;
	}
	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}
	public String getItem_url() {
		return item_url;
	}
	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}
	public String getClick_url() {
		return click_url;
	}
	public void setClick_url(String click_url) {
		this.click_url = click_url;
	}
	public String getShop_title() {
		return shop_title;
	}
	public void setShop_title(String shop_title) {
		this.shop_title = shop_title;
	}
	public Long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getCommission_rate() {
		return commission_rate;
	}
	public void setCommission_rate(String commission_rate) {
		this.commission_rate = commission_rate;
	}
	public Date getEvent_start_time() {
		return event_start_time;
	}
	public void setEvent_start_time(Date event_start_time) {
		this.event_start_time = event_start_time;
	}
	public Date getEvent_end_time() {
		return event_end_time;
	}
	public void setEvent_end_time(Date event_end_time) {
		this.event_end_time = event_end_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCoupon_click_url() {
		return coupon_click_url;
	}
	public void setCoupon_click_url(String coupon_click_url) {
		this.coupon_click_url = coupon_click_url;
	}
	public String getCoupon_info() {
		return coupon_info;
	}
	public void setCoupon_info(String coupon_info) {
		this.coupon_info = coupon_info;
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

	public String getSeller_wanwan() {
		return seller_wanwan;
	}

	public void setSeller_wanwan(String seller_wanwan) {
		this.seller_wanwan = seller_wanwan;
	}

	public String getCommission_money() {
		return commission_money;
	}

	public void setCommission_money(String commission_money) {
		this.commission_money = commission_money;
	}

	public String getTk_money() {
		return tk_money;
	}

	public void setTk_money(String tk_money) {
		this.tk_money = tk_money;
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


	public String getEvent_state() {
		return event_state;
	}


	public void setEvent_state(String event_state) {
		this.event_state = event_state;
	}


	@Override
	public String toString() {
		return "TaobaoFavoriteItem [num_iid=" + num_iid + ", favorites_id=" + favorites_id + ", title=" + title
				+ ", pict_url=" + pict_url + ", item_url=" + item_url + ", shop_title=" + shop_title
				+ ", reserve_price=" + reserve_price + ", zk_final_price=" + zk_final_price + ", zk_final_price_wap="
				+ zk_final_price_wap + ", user_type=" + user_type + ", provcity=" + provcity + ", seller_id="
				+ seller_id + ", seller_wanwan=" + seller_wanwan + ", nick=" + nick + ", volume=" + volume
				+ ", commission_rate=" + commission_rate + ", commission_money=" + commission_money + ", tk_rate="
				+ tk_rate + ", tk_money=" + tk_money + ", event_state=" + event_state + ", event_start_time="
				+ event_start_time + ", event_end_time=" + event_end_time + ", click_url=" + click_url
				+ ", click_long_url=" + click_long_url + ", status=" + status + ", type=" + type + ", category="
				+ category + ", taokouling=" + taokouling + ", coupon_click_url=" + coupon_click_url
				+ ", coupon_click_long_url=" + coupon_click_long_url + ", coupon_taokouling=" + coupon_taokouling
				+ ", coupon_info=" + coupon_info + ", coupon_total_count=" + coupon_total_count
				+ ", coupon_remain_count=" + coupon_remain_count + ", coupon_start_time=" + coupon_start_time
				+ ", coupon_end_time=" + coupon_end_time + ", create_time=" + create_time + ", last_update_time="
				+ last_update_time + "]";
	}


	

}
