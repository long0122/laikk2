package com.lkk.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicAction;
import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.model.Unit;

/**
 * @author Warren
 */
@Component("index")
@Scope("prototype")
public class IndexAction extends BasicAction {
	private IUnitDao unitDao;
	private List<Unit> unitList = new ArrayList<Unit>();
	@Override
	public String execute() throws Exception {
		
		unitList = unitDao.findAll();
		
		return "indexPage";
	}
	
	
	public IUnitDao getUnitDao() {
		return unitDao;
	}

	@Resource
	public void setUnitDao(IUnitDao unitDao) {
		this.unitDao = unitDao;
	}


	public List<Unit> getUnitList() {
		return unitList;
	}
	
	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}

}
