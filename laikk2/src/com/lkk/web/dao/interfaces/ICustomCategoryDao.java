package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.CustomCategory;
import com.lkk.web.model.User;

public interface ICustomCategoryDao extends IBasicDao<CustomCategory, Serializable>{
	/**
	 * 通过企业获得
	 * @param name
	 * @param password
	 * @return
	 */
	public List<CustomCategory> findByUnitId(int id);
}
