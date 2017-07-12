package com.timorjun.taobao.service;

import java.util.List;

import com.timorjun.taobao.model.TaobaoDailyChooiseItem;
import com.timorjun.taobao.model.TaobaoFavoriteItem;

public interface IDataImportService {
	
	public List<TaobaoFavoriteItem> saveImportDatas(List<TaobaoFavoriteItem> items) ;
	
	public List<TaobaoDailyChooiseItem> saveImportDailyChooseDatas(List<TaobaoDailyChooiseItem> items) ;
	
	
	public TaobaoDailyChooiseItem save(TaobaoDailyChooiseItem t);

}
