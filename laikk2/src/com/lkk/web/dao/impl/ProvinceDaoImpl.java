package com.lkk.web.dao.impl;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IProvinceDao;
import com.lkk.web.model.Province;

@Component("provinceDao")
public class ProvinceDaoImpl extends BasicDaoImpl<Province, String> implements IProvinceDao {

}
