package com.timorjun.taobao.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timorjun.base.common.dto.JsonData;
import com.timorjun.base.util.DateUtil;
import com.timorjun.taobao.model.TaobaoDailyChooiseItem;
import com.timorjun.taobao.model.TaobaoFavoriteItem;
import com.timorjun.taobao.service.IDataImportService;




@Controller
@RequestMapping("/import")
public class DataImportController {
	private static final Logger logger = LoggerFactory.getLogger( DataImportController.class );
	
	@Autowired
	private IDataImportService dataImportService ;
	
	
	/**
	 * @Date        :      2017年7月11日
	 * 导入淘宝每日精选数据
	 * @param filename
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/taobao/dailychoose")
	public JsonData importTaobaoDailyGoodsByFilepath(@RequestParam(name="filename",required=true)String filename) {
		String msg = "";
		HSSFWorkbook book = null;
		try {
			List<TaobaoDailyChooiseItem> list = new ArrayList<TaobaoDailyChooiseItem>();

			book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("e://精选优质商品清单(内含优惠券)-2017-07-10.xls")));

			HSSFSheet sheet = book.getSheetAt(0);

			for(int i=1; i<sheet.getLastRowNum()+1; i++) {
				TaobaoDailyChooiseItem t = new TaobaoDailyChooiseItem();
			    HSSFRow row = sheet.getRow(i);
			    String num_iid = row.getCell(0).getStringCellValue();//商品ID
			    t.setNum_iid(Long.parseLong(num_iid));
			    String title = row.getCell(1).getStringCellValue(); //商品名称
			    t.setTitle(title);
			    String pict_url = row.getCell(2).getStringCellValue();//商品主图
			    t.setPict_url(pict_url);
			    String item_url = row.getCell(3).getStringCellValue();//商品详情页
			    t.setItem_url(item_url);
			    String shop_category = row.getCell(4).getStringCellValue(); //商品一级类目
			    t.setCategory(shop_category);
			    String click_url = row.getCell(5).getStringCellValue(); //淘宝客链接
			    if(click_url!=null&&click_url.length()>2000) {
			    	continue;
			    }
			    t.setClick_url(click_url);
			    String zk_final_price = row.getCell(6).getStringCellValue();//商品价格(单位：元)
			    t.setZk_final_price(zk_final_price);
			    String volume = row.getCell(7).getStringCellValue();//商品月销量
			    t.setVolume(Integer.parseInt(volume));
			    String tk_rate = row.getCell(8).getStringCellValue();//收入比率(%)
			    t.setTk_rate(tk_rate);
			    String tk_money = row.getCell(9).getStringCellValue();//佣金
			    t.setTk_money(tk_money);
			    String seller_wanwan = row.getCell(10).getStringCellValue();//卖家旺旺
			    t.setSeller_wanwan(seller_wanwan);
			    String seller_id = row.getCell(11).getStringCellValue();//卖家id
			    t.setSeller_id(Long.parseLong(seller_id));
			    String shop_title = row.getCell(12).getStringCellValue();//店铺名称
			    t.setShop_title(shop_title);
			    String platform_type = row.getCell(13).getStringCellValue();//平台类型
			    t.setPlatform_type(platform_type);
			    String coupon_id = row.getCell(14).getStringCellValue();//优惠券id
			    t.setCoupon_id(coupon_id);
			    String coupon_total_count = row.getCell(15).getStringCellValue();//优惠券总量
			    t.setCoupon_total_count(Long.parseLong(coupon_total_count));
			    String coupon_remain_count = row.getCell(16).getStringCellValue();//优惠券剩余量
			    t.setCoupon_remain_count(Long.parseLong(coupon_remain_count));
			    String coupon_info = row.getCell(17).getStringCellValue();//优惠券面额
			    t.setCoupon_info(coupon_info);
			    String coupon_start_time = row.getCell(18)!=null?row.getCell(18).getStringCellValue():null;//优惠券开始时间
			    if(!StringUtils.isEmpty(coupon_start_time)) {
			    	t.setCoupon_start_time(DateUtil.parseDate(coupon_start_time, DateUtil.YYYY_MM_DD));
			    }
			    String coupon_end_time = row.getCell(19)!=null?row.getCell(19).getStringCellValue():null;//优惠券结束时间
			    if(!StringUtils.isEmpty(coupon_start_time)) {
			    	t.setCoupon_end_time(DateUtil.parseDate(coupon_end_time, DateUtil.YYYY_MM_DD));
			    }
			    String coupon_url = row.getCell(20)!=null?row.getCell(20).getStringCellValue():null;//优惠券链接
			    t.setCoupon_url(coupon_url);
			    String coupon_click_url = row.getCell(21)!=null?row.getCell(21).getStringCellValue():null;//优惠券链接
			    t.setCoupon_click_url(coupon_click_url);
			    t.setLast_update_time(new Date());
			    list.add(t);
			}

			logger.info("共有 " + list.size() + " 条数据：");
			int i=0 ;
			for( ;!list.isEmpty()&&i<list.size()/100;i++) {
				List<TaobaoDailyChooiseItem> items ;
				if(list.size()<100) {
					items = list;
				} else {
					items = list.subList(i*100, (i+1)*100);
				}
				dataImportService.saveImportDailyChooseDatas(items);
			}
			if(list.size()%100!=0) {
				dataImportService.saveImportDailyChooseDatas(list.subList(i*100,list.size() ));
			}
			
		} catch (FileNotFoundException e) {
			logger.error("导入Excel FileNotFoundException {}",e);
			msg = "参数错误，文件路径找不到或文件格式错误，只支持xls";
		} catch (IOException e) {
			logger.error("导入Excel IOException {}",e);
			msg = "文件处理出错";
		} catch (Exception e) {
			logger.error("导入Excel IOException {}",e);
			msg = "发生错误";
		} finally {
			try {
				book.close();
			} catch (IOException e) {
				logger.error("close book {}",e);
			}
		}
		
		
		return JsonData.success(null, msg, 0);
		
		
		
	}
	
	
	
	
	/**
	 * @Date        :      2017年7月11日
	 * 导入选品库数据
	 * @param filename
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/taobao/favorite")
	public JsonData importTaobaoFavoriteByFilepath(@RequestParam(name="filename",required=true)String filename) {
		String msg = "";
		// create a new file
		HSSFWorkbook book = null;
		try {
			List<TaobaoFavoriteItem> list = new ArrayList<TaobaoFavoriteItem>();

			book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("e://测试-2017-07-08.xls")));

			HSSFSheet sheet = book.getSheetAt(0);

			for(int i=1; i<sheet.getLastRowNum()+1; i++) {
				TaobaoFavoriteItem t = new TaobaoFavoriteItem();
			    HSSFRow row = sheet.getRow(i);
			    String num_iid = row.getCell(0).getStringCellValue();//商品ID
			    t.setNum_iid(Long.parseLong(num_iid));
			    String title = row.getCell(1).getStringCellValue(); //商品名称
			    t.setTitle(title);
			    String pict_url = row.getCell(2).getStringCellValue();//商品主图
			    t.setPict_url(pict_url);
			    String item_url = row.getCell(3).getStringCellValue();//商品详情页
			    t.setItem_url(item_url);
			    String shop_title = row.getCell(4).getStringCellValue(); //商品一级类目
			    t.setShop_title(shop_title);
			    String zk_final_price = row.getCell(5).getStringCellValue(); //淘宝客链接
			    t.setZk_final_price(zk_final_price);
			    String volume = row.getCell(6).getStringCellValue();//商品价格(单位：元)
			    t.setVolume(Integer.parseInt(volume));
			    String commission_rate = row.getCell(7).getStringCellValue();//商品月销量
			    t.setCommission_rate(commission_rate);
			    String commission_money = row.getCell(8).getStringCellValue();//收入比率(%)
			    t.setCommission_money(commission_money);
			    String event_state = row.getCell(9).getStringCellValue();//佣金
			    t.setEvent_state(event_state);
			    String tk_rate = row.getCell(10).getStringCellValue();//卖家旺旺
			    t.setTk_rate(tk_rate);
			    String tk_money = row.getCell(1).getStringCellValue();//卖家id
			    t.setTk_money(tk_money);
			    String event_start_time = row.getCell(12).getStringCellValue();//店铺名称
			    if(!StringUtils.isEmpty(event_start_time)) {
			    	t.setEvent_start_time(DateUtil.parseDate(event_start_time, DateUtil.YYYY_MM_DD_HH_MM_SS));
			    }
			    String event_end_time = row.getCell(13).getStringCellValue();//平台类型
			    if(!StringUtils.isEmpty(event_end_time)) {
			    	t.setEvent_end_time(DateUtil.parseDate(event_end_time, DateUtil.YYYY_MM_DD_HH_MM_SS));
			    }
			    String seller_wanwan = row.getCell(14).getStringCellValue();//优惠券id
			    t.setSeller_wanwan(seller_wanwan);
			    String click_url = row.getCell(15).getStringCellValue();//优惠券总量
			    t.setClick_url(click_url);
			    String click_long_url = row.getCell(16).getStringCellValue();//优惠券剩余量
			    t.setClick_long_url(click_long_url);
			    String taokouling = row.getCell(17).getStringCellValue();//优惠券面额
			    t.setTaokouling(taokouling);
			    String coupon_total_count = row.getCell(18)!=null?row.getCell(18).getStringCellValue():null;//优惠券开始时间
			    t.setCoupon_total_count(Long.parseLong(coupon_total_count));
			    String coupon_remain_count = row.getCell(19)!=null?row.getCell(19).getStringCellValue():null;//优惠券结束时间
			    t.setCoupon_remain_count(Long.parseLong(coupon_remain_count));
			    String coupon_info = row.getCell(20)!=null?row.getCell(20).getStringCellValue():null;//优惠券链接
			    t.setCoupon_info(coupon_info);
			    String coupon_start_time = row.getCell(21)!=null?row.getCell(21).getStringCellValue():null;//商品优惠券推广链接
			    if(!StringUtils.isEmpty(coupon_start_time)) {
			    	t.setCoupon_start_time(DateUtil.parseDate(coupon_start_time, DateUtil.YYYY_MM_DD));
			    }
			    String coupon_end_time = row.getCell(22)!=null?row.getCell(22).getStringCellValue():null;
			    if(!StringUtils.isEmpty(coupon_start_time)) {
			    	t.setCoupon_end_time(DateUtil.parseDate(coupon_end_time, DateUtil.YYYY_MM_DD));
			    }
			    String coupon_click_long_url = row.getCell(23)!=null?row.getCell(23).getStringCellValue():null;
			    t.setCoupon_click_long_url(coupon_click_long_url);
			    String coupon_taokouling = row.getCell(24)!=null?row.getCell(24).getStringCellValue():null;
			    t.setCoupon_taokouling(coupon_taokouling);
			    String coupon_click_url = row.getCell(25)!=null?row.getCell(25).getStringCellValue():null;
			    t.setCoupon_click_url(coupon_click_url);
			    list.add(t);
			}

			logger.info("共有 " + list.size() + " 条数据：");
			
			dataImportService.saveImportDatas(list);
			
			
			
			
		} catch (FileNotFoundException e) {
			logger.error("导入Excel FileNotFoundException {}",e);
			msg = "参数错误，文件路径找不到或文件格式错误，只支持xls";
		} catch (IOException e) {
			logger.error("导入Excel IOException {}",e);
			msg = "文件处理出错";
		} catch (Exception e) {
			logger.error("导入Excel IOException {}",e);
			msg = "发生错误";
		} finally {
			try {
				book.close();
			} catch (IOException e) {
				logger.error("close book {}",e);
			}
		}
		
		
		return JsonData.success(null, msg, 0);
		
		
		
	}
	
	

}
