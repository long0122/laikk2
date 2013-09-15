package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.ICityDao;
import com.lkk.web.model.City;

@Component("cityDao")
public class CityDaoImpl extends BasicDaoImpl<City, String> implements ICityDao {

	public List<City> findByProvince(String provinceId) {
		String hql = "from City c where c.province.provinceId = '" + provinceId + "'";
		List<City> list = getHibernateTemplate().find(hql);
		return list;
	}

	public City findByCode(String cityId) {
		String hql = "from City c where c.cityId = '" + cityId + "'";
		City city = (City)getSession().createQuery(hql).uniqueResult();
		return city;
	}

}
