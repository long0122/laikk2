package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.Area;
import com.lkk.web.model.City;

public interface IAreaDao extends IBasicDao<Area, Serializable>{
	
	/**
	 * 根据省找城市
	 * @param provinceId
	 * @return
	 */
	public List<Area> findByCity(String cityId);
	
	/**
	 * 根据编号查找
	 * @param cityId
	 * @return
	 */
	public Area findByCode(String code);
}
