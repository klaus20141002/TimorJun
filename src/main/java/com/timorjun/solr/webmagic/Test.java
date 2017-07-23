/******************************************************************************
 * @File name   :      Test.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月24日
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
 * 2017年7月24日 上午1:05:35        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.solr.webmagic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java 正则表达式
 */
public class Test {

	public static void main(String[] args) {
		 // 按指定模式在字符串查找
//	      String line = "This order was placed for QT3000! OK?";
//	      String pattern  = "(\\D*)(\\d+)(.*)";
//	      // 创建 Pattern 对象
//	      Pattern r = Pattern.compile(pattern);
//	      
//	      // 现在创建 matcher 对象
//	      Matcher m = r.matcher(line);
//	      if (m.find( )) {
//	    	  System.out.println("Found value: " + m.group(0) );
//	    	  System.out.println("Found value: " + m.group(1) );
//	    	  System.out.println("Found value: " + m.group(2) );
//	    	  System.out.println("Found value: " + m.group(3) ); 
//	      } else {
//	    	  System.out.println("NO MATCH");
//	      }
//	      
	      
	      String tm_goods_pattren = "src=\"(https://img\\S+?[jpgifn]+?)\"";
	      
	      Pattern r1 = Pattern.compile(tm_goods_pattren);
	      
	      // 现在创建 matcher 对象
	      Matcher m1 = r1.matcher("src=\"https://img.alicdn.com/imgextra/i1/1041248422/TB2R6aMlFXXXXXtXXXXXXXXXXXX_!!1041248422.jpg\"");
	      
	      if(m1.find()) {
	    	  System.out.println("Found value: " + m1.group(0) );
	    	  
	      }
	 
	}

}
