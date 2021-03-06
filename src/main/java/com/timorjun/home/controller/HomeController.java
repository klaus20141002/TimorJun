package com.timorjun.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timorjun.base.common.dto.JsonData;
import com.timorjun.base.service.IRedisService;
import com.timorjun.home.dto.BannerInfoDto;
import com.timorjun.home.dto.HomeInfoDto;
import com.timorjun.taobao.model.TaobaoDailyChooiseItem;
import com.timorjun.taobao.service.IDataImportService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger( HomeController.class );
	
	@Autowired
	private IDataImportService dataImportService ;
	
	@Autowired
	private IRedisService redisService ;
	
	@Autowired  
    private JedisPool jedisPool;
	
	@RequestMapping("/redis/set")  
	public JsonData redisSet(@RequestParam("value")String value){  
	    redisService.set("name", value);
	    
	    Jedis reids  = jedisPool.getResource() ;
//	    reids.s
	    return JsonData.success(null, "success", 0)  ;
	}  
	
	@RequestMapping("/redis/get")  
	public JsonData redisGet(){  
	    String name = redisService.get("name");  
	    return JsonData.success(name, "success", 0)  ; 
	}  
	
	
	/**
	 * @return BannerInfoDto
	 */
	@RequestMapping("/load/banner")
	public JsonData loadHomeBanners() {
		BannerInfoDto banner = new BannerInfoDto();
		logger.info("loading banner");
		return JsonData.success(banner, "", 0) ;
	}
	
	
	
	/**
	 * @param t
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	@RequestMapping("/load/goods")
	public JsonData loadHomeGoods(@RequestParam(name = "t", required = false) String  t , // 商品类型
			@RequestParam(name = "pageNo" , required = false , defaultValue = "1") int pageNo , //页号
			@RequestParam(name = "pageSize" , required = false, defaultValue ="20") int pageSize , //每页大小
			@RequestParam(name = "sortBy" , required = false) String sortBy // 排序字段
			) {
		HomeInfoDto result = new HomeInfoDto();
		
		PageRequest page = new PageRequest(pageNo, pageSize) ;
		logger.info("loading goods {}" , result);
		try {
			Page<TaobaoDailyChooiseItem>  goods = dataImportService.queryTaobaoDailyChooiseItemList(page) ;
			return JsonData.success(goods, "success", 0) ;
		} catch (Exception e) {
			logger.error("QueryTaobaoDailyChooiseItemList ERROR",e);
			return JsonData.success(null, "failure", -1) ;
		}
	}
	
	
	
	
	
	
	
	

}
