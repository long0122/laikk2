package com.lkk.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lkk.web.action.basic.BasicAction;
import com.lkk.web.dao.interfaces.ICategoryDao;
import com.lkk.web.dao.interfaces.ILevelDao;
import com.lkk.web.dao.interfaces.IProvinceDao;
import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.model.Category;
import com.lkk.web.model.Level;
import com.lkk.web.model.Province;
import com.lkk.web.model.Unit;
import com.lkk.web.vo.CategorysInfo;

/**
 * @author Warren
 */
@Component("index")
@Scope("prototype")
public class IndexAction extends BasicAction {
	private IUnitDao unitDao;
	private ICategoryDao categoryDao;
	private ILevelDao levelDao;
	private IProvinceDao provinceDao;
	private List<Unit> unitList = new ArrayList<Unit>();
	private List<Level> levelList = new ArrayList<Level>();
	private List<Province> provinceList = new ArrayList<Province>();
	private List<CategorysInfo> categoryList = new ArrayList<CategorysInfo>();
	@Override
	public String execute() throws Exception {
		
		return "indexPage";
	}
	
	public String gotoReg() throws Exception {
		setCategory();
		levelList = levelDao.findAll();
		provinceList = provinceDao.findAll();
		return "regPage";
	}
	
	private void setCategory() {

		try {
			List<Category> topCategorys = categoryDao.findTopCategories(true);
			if (topCategorys != null) {
				for (Category top : topCategorys) {
					CategorysInfo info = new CategorysInfo();
					info.setCategory(top);
					List<Category> childrenCategorys = categoryDao
							.findByParentId(top.getId(), true);
					if (childrenCategorys != null) {
						info.setChildrenList(childrenCategorys);
					}
					categoryList.add(info);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	@Resource
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public IUnitDao getUnitDao() {
		return unitDao;
	}

	@Resource
	public void setUnitDao(IUnitDao unitDao) {
		this.unitDao = unitDao;
	}


	public ILevelDao getLevelDao() {
		return levelDao;
	}
	@Resource
	public void setLevelDao(ILevelDao levelDao) {
		this.levelDao = levelDao;
	}

	public List<Unit> getUnitList() {
		return unitList;
	}
	
	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}

	public List<CategorysInfo> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategorysInfo> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Level> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<Level> levelList) {
		this.levelList = levelList;
	}

	public IProvinceDao getProvinceDao() {
		return provinceDao;
	}
	@Resource
	public void setProvinceDao(IProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

}
