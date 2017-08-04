package com.timorjun.taobao.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.timorjun.taobao.model.TaobaoDailyChooiseItem;
import com.timorjun.taobao.model.TaobaoDailyChooiseItemCache;
import com.timorjun.taobao.model.TaobaoFavoriteItem;
import com.timorjun.taobao.repository.TaobaoDailyChooseRepository;
import com.timorjun.taobao.repository.TaobaoDailyChooseRepositoryCache;
import com.timorjun.taobao.repository.TaobaoFavoriteRepository;
import com.timorjun.taobao.service.IDataImportService;


@Service
public class DataImportServiceImpl implements IDataImportService{
	
	private static final Logger logger = LoggerFactory.getLogger( DataImportServiceImpl.class );
	
	@Autowired
	private TaobaoFavoriteRepository taobaoFavoriteRepository; 
	@Autowired
	private TaobaoDailyChooseRepository taobaoDailyChooseRepository; 
	@Autowired
	private TaobaoDailyChooseRepositoryCache taobaoDailyChooseRepositoryCache ;
	
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
	
	
	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月8日
	 * @see com.timorjun.taobao.service.IDataImportService#saveImportDatas()
	**/
	@Override
	public List<TaobaoDailyChooiseItem> saveImportDailyChooseDatas(List<TaobaoDailyChooiseItem> items) {
		logger.info("saveImportDatas start {}" , new Date());
		return taobaoDailyChooseRepository.save(items);
	}


	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月12日
	 * @see com.timorjun.taobao.service.IDataImportService#save()
	**/
	@Override
	public TaobaoDailyChooiseItem save(TaobaoDailyChooiseItem t) {
		// TODO Auto-generated method stub
		return taobaoDailyChooseRepository.save(t);
	}


	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月12日
	 * @see com.timorjun.taobao.service.IDataImportService#queryTaobaoDailyChooiseItemList()
	**/
	@Override
	public Page<TaobaoDailyChooiseItem> queryTaobaoDailyChooiseItemList(Pageable pageable) {
//		Order order = new Order(Direction.DESC,"tk_money");
//		Sort sort = new Sort(order);
		if(pageable==null) {
			pageable = new PageRequest(1, 20) ;
		}
		Page<TaobaoDailyChooiseItem> goods = taobaoDailyChooseRepository.findAll(pageable);
		
		//return taobaoDailyChooseRepository.findAll(sort) ;
		
		return goods;
		
	}


	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年7月20日
	 * @see com.timorjun.taobao.service.IDataImportService#getGoodsDetailImages()
	**/
	@Override
	public List<String> getGoodsDetailImages() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年8月5日
	 * @see com.timorjun.taobao.service.IDataImportService#cacheDailyGoods(com.timorjun.taobao.model.TaobaoDailyChooiseItemCache)
	**/
	@Override
	public boolean cacheDailyGoods(TaobaoDailyChooiseItemCache entity) {
		TaobaoDailyChooiseItemCache result = taobaoDailyChooseRepositoryCache.save(entity);
		logger.info("result is {}" , result);
		return true;
	}
	
	
	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年8月5日
	 * @see com.timorjun.taobao.service.IDataImportService#getDailyGoodsFromCache(java.lang.String)
	**/
	@Override
	public TaobaoDailyChooiseItemCache getDailyGoodsFromCache(String id) {
		
		logger.info("result is {}" , taobaoDailyChooseRepositoryCache.findOne(id));
		return taobaoDailyChooseRepositoryCache.findOne(id);
	}
	

}
