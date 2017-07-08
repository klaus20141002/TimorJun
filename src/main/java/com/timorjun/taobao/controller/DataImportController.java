package com.timorjun.taobao.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timorjun.base.common.dto.JsonData;
import com.timorjun.taobao.dto.TaobaoFavoriteItemDto;




@Controller
@RequestMapping("/import")
public class DataImportController {
	private static final Logger logger = LoggerFactory.getLogger( DataImportController.class );
	
	@ResponseBody
	@RequestMapping("/taobao")
	public JsonData importTaobaoDailyGoodsByFilepath(@RequestParam(name="",required=true)String filepath) {
		String msg = "";
		// create a new file
		HSSFWorkbook book = null;
		try {
			List<TaobaoFavoriteItemDto> list = new ArrayList<TaobaoFavoriteItemDto>();

			book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("e://测试-2017-06-24.xls")));

			HSSFSheet sheet = book.getSheetAt(0);

			for(int i=1; i<sheet.getLastRowNum()+1; i++) {
			    HSSFRow row = sheet.getRow(i);
			    String num_iid = row.getCell(0).getStringCellValue(); 
			    String title = row.getCell(1).getStringCellValue(); 
			    String pict_url = row.getCell(2).getStringCellValue();
			    String item_url = row.getCell(3).getStringCellValue();
			    String shop_title = row.getCell(4).getStringCellValue();
			    String zk_final_price = row.getCell(5).getStringCellValue();
			    String volume = row.getCell(6).getStringCellValue();
			    String commission_rate = row.getCell(7).getStringCellValue();
			    String commission_money = row.getCell(8).getStringCellValue();
			    String event_state = row.getCell(9).getStringCellValue();
			    String tk_rate = row.getCell(10).getStringCellValue();
			    String tk_money = row.getCell(1).getStringCellValue();
			    String event_start_time = row.getCell(12).getStringCellValue();
			    String event_end_time = row.getCell(13).getStringCellValue();
			    String seller_wanwan = row.getCell(14).getStringCellValue();
			    String click_url = row.getCell(15).getStringCellValue();
			    String click_long_url = row.getCell(16).getStringCellValue();
			    String taokouling = row.getCell(17).getStringCellValue();
			    String coupon_total_count = row.getCell(18).getStringCellValue();
			    String coupon_remain_count = row.getCell(19).getStringCellValue();
			    String coupon_info = row.getCell(20).getStringCellValue();
			    String coupon_start_time = row.getCell(21).getStringCellValue();
			    String coupon_end_time = row.getCell(22).getStringCellValue();
			    String coupon_click_long_url = row.getCell(23).getStringCellValue();
			    String coupon_taokouling = row.getCell(24).getStringCellValue();
			    String coupon_click_url = row.getCell(25).getStringCellValue();
			    list.add(new TaobaoFavoriteItemDto(num_iid, title, pict_url, item_url, shop_title,
						zk_final_price, volume, commission_rate, commission_money, event_state,
						tk_rate, tk_money, event_start_time, event_end_time, seller_wanwan,
						click_url, click_long_url, taokouling, coupon_total_count,
						coupon_remain_count, coupon_info, coupon_start_time, coupon_end_time,
						coupon_click_long_url, coupon_taokouling, coupon_click_url));
			}

			System.out.println("共有 " + list.size() + " 条数据：");
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			logger.error("导入Excel FileNotFoundException {}",e);
			msg = "参数错误，文件路径找不到或文件格式错误，只支持xls";
		} catch (IOException e) {
			logger.error("导入Excel IOException {}",e);
			msg = "文件处理出错";
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
