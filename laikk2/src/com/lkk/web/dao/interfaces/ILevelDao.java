package com.lkk.web.dao.interfaces;

import java.io.Serializable;

import com.lkk.web.model.Level;
import com.lkk.web.model.Role;

public interface ILevelDao extends IBasicDao<Level, Serializable>{
	

	/**
	 * 根据编号查找
	 * @param code
	 * @return
	 */
	public Level findByCode(String code);
}
