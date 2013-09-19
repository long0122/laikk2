package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.User;
import com.lkk.web.vo.UserInfo;

public interface IUserDao extends IBasicDao<User, Serializable>{
	
	/**
	 * 用户名是否重复
	 * @param username
	 * @return
	 */
	public boolean checkUserExistsWithName(String username);  
	
	/**
	 * 用户是否存在
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean isExist(String name, String password);
	/**
	 * 通过用户密码查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	public User loadByCodePwd(String name, String password);
	/**
	 * 通过用户名查找
	 * @param name
	 * @return
	 */
	public User loadByUname(String name);
	/**
	 * 查询
	 * @param startIndex
	 * @param pageSize
	 * @param userInfo
	 * @return
	 */
	public List<User> search(int startIndex, int pageSize, UserInfo userInfo);
	/**
	 * 查询数量
	 * @param userInfo
	 * @return
	 */
	public long countSearch(UserInfo userInfo);
}
