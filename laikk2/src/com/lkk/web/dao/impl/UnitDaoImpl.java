package com.lkk.web.dao.impl;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.model.Unit;

@Component("unitDao")
public class UnitDaoImpl extends BasicDaoImpl<Unit, String> implements IUnitDao {

	public Unit findByUserId(int uId) {
		String hql ="from Unit u where u.manager.id = '" + uId + "'";
		Unit u = (Unit)getSession().createQuery(hql).uniqueResult();
		return u;
	}


}
