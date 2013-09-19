package com.lkk.web.dao.interfaces;

import java.io.Serializable;

import com.lkk.web.model.Unit;

public interface IUnitDao extends IBasicDao<Unit, Serializable>{
	/**
	 * 根据用户ID查找
	 * @param uId
	 * @return
	 */
	public Unit findByUserId(int uId);
}
