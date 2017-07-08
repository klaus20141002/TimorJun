package com.timorjun.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timorjun.home.dto.BannerInfoDto;
import com.timorjun.home.dto.HomeInfoDto;

@RestController
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger( HomeController.class );
	
	/**
	 * @return BannerInfoDto
	 */
	@RequestMapping("/load/banner")
	public BannerInfoDto loadHomeBanners() {
		BannerInfoDto result = new BannerInfoDto();
		logger.info("loading banner");
		
		
		return result;
	}
	
	
	
	/**
	 * @param t
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	@RequestMapping("/load/goods")
	public HomeInfoDto loadHomeGoods(@RequestParam(name = "t") String  t , // 商品类型
			@RequestParam(name = "pageNo" , required = false) int pageNo , //页号
			@RequestParam(name = "pageSize" , required = false) int pageSize , //每页大小
			@RequestParam(name = "sortBy" , required = false) String sortBy // 排序字段
			) {
		HomeInfoDto result = new HomeInfoDto();
		
		
		
		
		return result;
	}
	
	

}
