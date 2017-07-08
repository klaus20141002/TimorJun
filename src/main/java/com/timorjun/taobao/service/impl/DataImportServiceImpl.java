package com.timorjun.taobao.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.timorjun.taobao.service.IDataImportService;


@Service
public class DataImportServiceImpl implements IDataImportService{
	
	private static final Logger logger = LoggerFactory.getLogger( DataImportServiceImpl.class );
	

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月8日
	 * @see com.timorjun.taobao.service.IDataImportService#saveImportDatas()
	**/
	@Override
	public int saveImportDatas() {
		logger.info("saveImportDatas start {}" , new Date());
		
		
		
		
		return 0;
	}
	
	
	

}
