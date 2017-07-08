/******************************************************************************
 * @File name   :      FileUtil.java
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
 * 2017年7月8日 上午11:50:12        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.base.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.timorjun.home.controller.HomeController;

/**
 *
 */
public class FileUtil {
	
	private static final Logger logger = LoggerFactory.getLogger( HomeController.class );
	//读取文本文件
    public static String readFile(URL url) throws Exception {
    	long start = System.currentTimeMillis() ;
    	logger.info("try to read file, {}, start time is {},{}", url.toString(),start,new Date());
        BufferedReader br = null;
        try {
            File file = new File(url.toURI());
            br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            logger.info("read file succeed, {} , time used ", url.toString() ,System.currentTimeMillis()-start);
            return sb.toString();
        } catch (Exception e) {
        	logger.info("read file error, {}", url.toString(), e);
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
    
    
    
    public static String readExcel(String url) {
    	
//    	ExcelExportUtil
    	
    	
    	return "";
    }
    
    
	
	

}
