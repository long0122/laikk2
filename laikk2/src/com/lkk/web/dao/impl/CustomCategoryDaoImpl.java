package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.ICustomCategoryDao;
import com.lkk.web.model.CustomCategory;
import com.lkk.web.model.User;

/**
 * @author Warren
 */
@Component("customCategoryDao")
public class CustomCategoryDaoImpl extends BasicDaoImpl<CustomCategory, String> implements
		ICustomCategoryDao {

	public List<CustomCategory> findByUnitId(int id) {
		String hql = "from CustomCategory c where c.unit.id= '" + id + "'";
		return getSession().createQuery(hql).list();
	}


}
