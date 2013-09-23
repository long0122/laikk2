package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IAreaDao;
import com.lkk.web.model.Area;
import com.lkk.web.model.City;

/**
 * @author Warren
 */
@Component("areaDao")
public class AreaDaoImpl extends BasicDaoImpl<Area, String> implements IAreaDao {

	public List<Area> findByCity(String cityId) {
		String hql = "from Area a where a.city.cityId = '" + cityId + "'";
		List<Area> list = getHibernateTemplate().find(hql);
		return list;
	}

	public Area findByCode(String areaId) {
		String hql = "from Area a where a.areaId = '" + areaId + "'";
		Area a = (Area) getSession().createQuery(hql).uniqueResult();
		return a;
	}

}
