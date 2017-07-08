/******************************************************************************
 * @File name   :      BaseResultDto.java
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
 * 2017年7月8日 上午11:26:01        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.base.common.dto;

/**
 * base result 
 */
public class JsonData {
    private final boolean ret; //接口请求状态
    private String msg;// 错误描述
    private int code; // 错误code
    private Object data;//接口实际返回数据

    private JsonData(boolean ret , int code) {
        this.ret = ret;
        this.code = code;
    }

    public static JsonData error(String message,int code) {
        JsonData result = new JsonData(false,code);
        result.msg = message;
        return result;
    }

    public static JsonData success(Object object, String msg, int code) {
        JsonData result = new JsonData(true,code);
        result.data = object;
        result.msg = msg;
        return result;
    }

    public static JsonData success(Object object) {
        return success(object, null, 0);
    }

    public static JsonData success() {
        return success(null, null, 0);
    }

    public boolean getRet() {
        return ret;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
    
    public Object getData() {
        return data;
    }
	

}
