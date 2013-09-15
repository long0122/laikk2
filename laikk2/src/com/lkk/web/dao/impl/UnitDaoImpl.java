package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.model.Unit;

@Component("unitDao")
public class UnitDaoImpl extends BasicDaoImpl<Unit, String> implements IUnitDao {


}
