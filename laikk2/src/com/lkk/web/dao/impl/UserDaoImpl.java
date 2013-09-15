package com.lkk.web.dao.impl;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IUserDao;
import com.lkk.web.model.User;

@Component("userDao")
public class UserDaoImpl extends BasicDaoImpl<User, String> implements IUserDao {


}
