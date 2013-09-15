package com.lkk.web.dao.impl;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IRoleDao;
import com.lkk.web.model.Role;

@Component("roleDao")
public class RoleDaoImpl extends BasicDaoImpl<Role, String> implements IRoleDao {

	public Role findByCode(String code) {
		String hql ="from Role r where r.code = '" + code + "'";
		Role r = (Role)getSession().createQuery(hql).uniqueResult();
		return r;
	}

}
