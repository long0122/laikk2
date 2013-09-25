package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.Attention;
import com.lkk.web.model.Unit;

public interface IAttentionDao extends IBasicDao<Attention, Serializable>{
	
	public List<Attention> findAttByUnitId(int unitId)throws Exception;
}
