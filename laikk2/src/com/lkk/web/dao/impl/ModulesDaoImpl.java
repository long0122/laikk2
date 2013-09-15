package com.lkk.web.dao.impl;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IModulesDao;
import com.lkk.web.model.Modules;

@Component("modulesDao")
public class ModulesDaoImpl extends BasicDaoImpl<Modules, String> implements IModulesDao {


}
