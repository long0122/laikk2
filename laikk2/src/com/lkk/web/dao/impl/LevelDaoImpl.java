package com.lkk.web.dao.impl;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.ILevelDao;
import com.lkk.web.model.Level;
import com.lkk.web.model.Role;

@Component("levelDao")
public class LevelDaoImpl extends BasicDaoImpl<Level, String> implements ILevelDao {

	public Level findByCode(String code) {
		String hql ="from Level l where l.code = '" + code + "'";
		Level l = (Level)getSession().createQuery(hql).uniqueResult();
		return l;
	}


}
