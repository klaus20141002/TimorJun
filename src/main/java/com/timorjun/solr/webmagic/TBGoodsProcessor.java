/******************************************************************************
 * @File name   :      TBGoodsProcessor.java
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
 * 2017年7月20日 下午9:36:04        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.solr.webmagic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.management.JMException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.timorjun.home.controller.HomeController;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.utils.UrlUtils;

/**
 *
 */
public class TBGoodsProcessor implements PageProcessor {
	
	public static final String TM_GOODS_URL= "https://detail.tmall.com/item.htm?id=";
	private static final Logger logger = LoggerFactory.getLogger( HomeController.class );
		
	

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月20日
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.webmagic.Page)
	**/
	@Override
	public void process(Page page) {
		
		
		//logger.info("html is {}",page.getHtml());
		
//		page.setHtml(new Html(loadPageContent(page.getUrl().toString(),"Download TM goods")));
		
		
		Html html = page.getHtml();
		
		logger.info("start pring details ---------------------------------------");
		
//		logger.info("result is {} ",html.$("#description")) ;
		
		//匹配 商品详情图的正则
//		logger.info("result is {} ",html.regex("src=\"(https://img\\S+?[jpg]+?)\"").all());
		
		//匹配商品数据的正则
		logger.info("result is {} ",html.regex("Setup\\(([\\s\\S]+?)\\)"));
		
		JSONObject detail = JSON.parseObject(html.regex("Setup\\(([\\s\\S]+?)\\)").toString()) ;
		
		if(detail == null) {
			logger.error("爬去页面失败 ， {}", page.getUrl().toString());
		}
		String detailImgUrl = detail.getJSONObject("api").getString("httpsDescUrl") ;
		logger.info(detailImgUrl);
		logger.info(detail.getString("propertyPics"));
		logger.info(detail.getJSONObject("valItemInfo").getString("skuList"));
		String rawText = null;
		//http://desc.alicdn.com/i5/550/020/551026213720/TB1ZxM6RVXXXXXpXVXX8qtpFXlX.desc%7Cvar%5Edesc%3Bsign%5E7f9ce29736bceaabadcd8dbbaf53a88d%3Blang%5Egbk%3Bt%5E1500738777
		//http://desc.alicdn.com/i5/550/020/551026213720/TB1ZxM6RVXXXXXpXVXX8qtpFXlX.desc%7Cvar%5Edesc%3Bsign%5E7f9ce29736bceaabadcd8dbbaf53a88d%3Blang%5Egbk%3Bt%5E1500738777
		Html detailHtml = new Html(UrlUtils.fixAllRelativeHrefs(rawText, "http:"+detailImgUrl));
		
		List<String> details = detailHtml.regex("src=\"(https://img\\S+?[jpg]+?)\"").all() ;
		
		for(String i : details) {
			logger.info("img is :", i);
		}
		
		
	}

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月20日
	 * @see us.codecraft.webmagic.processor.PageProcessor#getSite()
	**/
	@Override
	public Site getSite() {
		return site;
	}
	
	
	
	public  String loadPageContent(String url, String taskDesc) {
		StringBuilder pageStr = new StringBuilder();
		try {
			URL page = new URL(url);
			URLConnection con = page.openConnection();
			
                        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
                        String inputLine = null;

			while ((inputLine = in.readLine()) != null) {
				pageStr.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			logger.error(" 异常！页面信息爬取失败 ！任务类型描述={},goodsUrl={}",taskDesc,url,e);
		}
		return pageStr.toString();
	}
	
	public Html downLoadHtml(String url, String taskDesc, String charset) {
		String pageStr = downLoadContent(url, taskDesc, charset);
		if( !StringUtils.isEmpty(pageStr)){
			return new Html( UrlUtils.fixAllRelativeHrefs(pageStr, url) );
		}else{
			return null;
		}
    }
	
	public String downLoadContent(String url, String taskDesc, String charset){
		// "gb2312"
        HttpClient client = new DefaultHttpClient(); // HttpClients.custom().setDefaultCookieStore( cookieStore ).build(); // new DefaultHttpClient();
        StringBuffer result = new StringBuffer();
        try {
			 HttpGet request = new HttpGet(url);
				request.addHeader("User-Agent" , ":Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36" );
				HttpResponse response = client.execute(request);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), charset));
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					result.append(line);
				}
		} catch (Exception e) {
			logger.error(" 异常！页面信息爬取失败 ！任务类型描述={},goodsUrl={} ,Exception {}",taskDesc,url , e);
			return null;
		} finally {
		}
       
		return result.toString();
    }
	
	
	public static void main(String[] args) {
		Spider jdSpider = null;
		try {
			String url = new String(TM_GOODS_URL+"551026213720") ;
			String chromeDriverPath = TBGoodsProcessor.class.getClassLoader().getResource("chromedriver.exe").getFile();
			
			TBGoodsProcessor processor =new TBGoodsProcessor() ;
			jdSpider = Spider.create(processor)
					.addUrl(url)
					.setDownloader(new SeleniumDownloader(chromeDriverPath))
					.thread(1);
			// 注册爬虫监控
			SpiderMonitor.instance().register(jdSpider);
			jdSpider.run();
			
			
		} catch (JMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdSpider.close();
		}
		
	
		
		
	}
	
	private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8")
            .addHeader("Referer", "http://www.example.com/")
//            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	.setUserAgent(":Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
}
