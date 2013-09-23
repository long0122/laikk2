package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.Advertisement;
import com.lkk.web.vo.AdvertisementInfo;

public interface IAdvertisementDao extends IBasicDao<Advertisement, Serializable>{
	
	
	/**
	 * 列表
	 * @param adInfo
	 * @return
	 */
	public List<Advertisement> findAll (AdvertisementInfo adInfo,int startIndex, int pageSize)throws Exception;
	
	/**
	 * 统计列表
	 * @param adInfo
	 * @return
	 */
	public long countAll (AdvertisementInfo adInfo)throws Exception;
	
	
	
	

	
}
