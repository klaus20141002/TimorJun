/******************************************************************************
 * @File name   :      WechatConfig.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月13日
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
 * 2017年7月13日 上午2:01:27        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.base.config;

/**
 *
 */
//@Component
//@Configuration(value="")
public class WechatConfig {
	
	private String appId ;
	private String appSecret ;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	

}
