package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IAttentionDao;
import com.lkk.web.model.Attention;

@Component("attentionDao")
public class AttentionDaoImpl extends BasicDaoImpl<Attention, String> implements IAttentionDao {

	public List<Attention> findAttByUnitId(int unitId) throws Exception {
		String hql ="from Attention a where a.unit.id = '" + unitId + "'";
		return  getSession().createQuery(hql).list();
	}


}
