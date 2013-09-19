package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.User;
import com.lkk.web.vo.UserInfo;

@Component("userDao")
public class UserDaoImpl extends BasicDaoImpl<User, String> implements IUserDao {

	public boolean checkUserExistsWithName(String username) {
		List<User> users = getHibernateTemplate().find(
				"from User u where u.username = '" + username + "'");
		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean isExist(String name, String password) {
		String hql = "from User u where u.username = '" + name
				+ "' and u.password = '" + password + "'";
		List<User> list = getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public User loadByUname(String name) {
		String hql = "from User u where u.username = '" + name.trim() + "'";
		Object _user = getSession().createQuery(hql).uniqueResult();
		if (_user != null) {
			return (User) _user;
		} else {
			return null;
		}
	}

	public List<User> search(int startIndex, int pageSize, UserInfo userInfo) {
		String hql = "from User u where 1=1";
		if (userInfo.getUsername() != null
				&& !"".equals(userInfo.getUsername())) {
			hql += " and u.username like '%" + userInfo.getUsername().trim()
					+ "%'";
		} else if (userInfo.getNickname() != null
				&& !"".equals(userInfo.getNickname())) {
			hql += " and u.nickname like '%" + userInfo.getNickname().trim()
					+ "%'";
		} else if (userInfo.getCity() != null && !"".equals(userInfo.getCity())) {
			hql += " and u.city.cityId = " + userInfo.getCity();
		} else if (userInfo.getRole() != null && !"".equals(userInfo.getRole())) {
			hql += " and u.role.id = " + userInfo.getRole();
		} else if (userInfo.getState() != null
				&& !"".equals(userInfo.getState())) {
			hql += " and u.state =" + userInfo.getState();
		}
		hql += " order by u.role.code asc";
		List<User> list = getSession().createQuery(hql).setFirstResult(
				startIndex).setMaxResults(pageSize).list();
		return list;
	}

	public long countSearch(UserInfo userInfo) {
		String hql = "select count(u) from User u where 1=1";
		if (userInfo.getUsername() != null
				&& !"".equals(userInfo.getUsername())) {
			hql += " and u.username like '%" + userInfo.getUsername() + "%'";
		} else if (userInfo.getCity() != null && !"".equals(userInfo.getCity())) {
			hql += " and u.city.id = " + userInfo.getCity();
		} else if (userInfo.getRole() != null && !"".equals(userInfo.getRole())) {
			hql += " and u.role.id = " + userInfo.getRole();
		} else if (userInfo.getState() != null
				&& !"".equals(userInfo.getState())) {
			hql += " and u.state =" + userInfo.getState();
		}
		long count = ((Long) getSession().createQuery(hql).uniqueResult())
				.intValue();
		return count;
	}

}
