package com.lkk.web.dao.impl;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.ILevelDao;
import com.lkk.web.model.Level;

@Component("levelDao")
public class LevelDaoImpl extends BasicDaoImpl<Level, String> implements ILevelDao {


}
