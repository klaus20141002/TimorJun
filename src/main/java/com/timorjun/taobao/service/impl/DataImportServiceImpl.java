package com.timorjun.taobao.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timorjun.taobao.model.TaobaoFavoriteItem;
import com.timorjun.taobao.repository.TaobaoFavoriteRepository;
import com.timorjun.taobao.service.IDataImportService;


@Service
public class DataImportServiceImpl implements IDataImportService{
	
	private static final Logger logger = LoggerFactory.getLogger( DataImportServiceImpl.class );
	
	@Autowired
	private TaobaoFavoriteRepository taobaoFavoriteRepository; 
	
	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月8日
	 * @see com.timorjun.taobao.service.IDataImportService#saveImportDatas()
	**/
	@Override
	public List<TaobaoFavoriteItem> saveImportDatas(List<TaobaoFavoriteItem> items) {
		logger.info("saveImportDatas start {}" , new Date());
		return taobaoFavoriteRepository.save(items);
	}
	
	
	

}
