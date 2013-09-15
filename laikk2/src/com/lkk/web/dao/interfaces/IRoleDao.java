package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.Role;
import com.lkk.web.model.User;

public interface IRoleDao extends IBasicDao<Role, Serializable>{
	
	/**
	 * 根据编号查找
	 * @param code
	 * @return
	 */
	public Role findByCode(String code);
}
