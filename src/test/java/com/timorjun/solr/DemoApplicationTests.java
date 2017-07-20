package com.timorjun.solr;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.timorjun.base.common.dto.JsonData;
import com.timorjun.solr.domain.Goods;
import com.timorjun.solr.service.GoodsService;
import com.timorjun.solr.webmagic.JDPipeline;
import com.timorjun.solr.webmagic.JDProductProcessor;
import com.timorjun.taobao.model.TaobaoDailyChooiseItem;
import com.timorjun.taobao.service.IDataImportService;

import junit.framework.Assert;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	JDPipeline jdPipeline;
	
	
	
	@Autowired
	GoodsService goodsService ;
	
	@Autowired
	IDataImportService dataService ;
	
	
	@Test
	public void testAddGoodsToSolr() throws Exception{
		List<Goods> goods = new ArrayList<Goods>();
		
		PageRequest page = new PageRequest(1, 20) ;
		
		
		Page<TaobaoDailyChooiseItem> pageData =  dataService.queryTaobaoDailyChooiseItemList(page) ;
		
		for(TaobaoDailyChooiseItem i :pageData.getContent()) {
			Goods a = new Goods() ;
//			a.setCategory(null);
			a.setComment(0);
			a.setCoupon(0);
			a.setCreate(i.getCreate_time());
			a.setUpdate(i.getLast_update_time());
			a.setId(""+i.getNum_iid());
			a.setName(i.getTitle());
			a.setPrice(Double.parseDouble(i.getZk_final_price()));
			a.setVolume(i.getVolume());
			goods.add(a);
			
		}
		JsonData  result = goodsService.synGoodsToSolr(goods);
		
		Assert.assertEquals(0, result.getCode());
		
		
	}
	

	/**
	 * 京东爬虫
	 * @throws Exception
	 */
	@Test
	public void testJDProductProcessor() throws Exception{
		//chromedriver.exe需与浏览器版本对应
		String chromeDriverPath = JDProductProcessor.class.getClassLoader().getResource("chromedriver.exe").getFile();
		Spider jdSpider = Spider.create(new JDProductProcessor())
				.addUrl("http://www.jd.com/allSort.aspx")// JD全部分类
				.addPipeline(jdPipeline)
				.setDownloader(new SeleniumDownloader(chromeDriverPath))
				.thread(5);
		// 注册爬虫监控
		SpiderMonitor.instance().register(jdSpider);
		jdSpider.run();
	}

}
