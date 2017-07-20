package com.timorjun.taobao.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.timorjun.taobao.model.TaobaoDailyChooiseItem;
import com.timorjun.taobao.model.TaobaoFavoriteItem;

public interface IDataImportService {
	
	public List<TaobaoFavoriteItem> saveImportDatas(List<TaobaoFavoriteItem> items) ;
	
	public List<TaobaoDailyChooiseItem> saveImportDailyChooseDatas(List<TaobaoDailyChooiseItem> items) ;
	
	
	public TaobaoDailyChooiseItem save(TaobaoDailyChooiseItem t);
	
	
	
	
	public Page<TaobaoDailyChooiseItem> queryTaobaoDailyChooiseItemList(Pageable pageable) ;
	
	
	
	
	
	public List<String> getGoodsDetailImages() ;
	
	

}
