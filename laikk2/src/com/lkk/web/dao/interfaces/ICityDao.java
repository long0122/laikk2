package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.City;

public interface ICityDao extends IBasicDao<City, Serializable>{
	
	/**
	 * 根据省找城市
	 * @param provinceId
	 * @return
	 */
	public List<City> findByProvince(String provinceId);
	
	/**
	 * 根据编号查找
	 * @param cityId
	 * @return
	 */
	public City findByCode(String cityId);
}
