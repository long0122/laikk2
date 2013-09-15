package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.ICategoryDao;
import com.lkk.web.model.Category;

@Component("categoryDao")
public class CategoryDaoImpl extends BasicDaoImpl<Category, String> implements
		ICategoryDao {

	public List<Category> findAll(boolean isOnlyShowEnabled) throws Exception {
		String hql = "from Category c";
		if (isOnlyShowEnabled) {
			hql += " where c.state = 1";
		}
		hql += " order by c.orderIndex asc";
		List<Category> list = getSession().createQuery(hql).list();
		return list;
	}

	public List<Category> findTopCategories(boolean isOnlyShowEnabled)
			throws Exception {
		String hql = "from Category c where c.parent='0'";
		if (isOnlyShowEnabled) {
			hql += " and c.state = 1";
		}
		hql += " order by c.orderIndex asc";
		List<Category> list = getSession().createQuery(hql).list();
		return list;
	}

	public List<Category> findTopCategories(int size, boolean isOnlyShowEnabled)
			throws Exception {
		String hql = "from Category c where c.parent='0'";
		if (isOnlyShowEnabled) {
			hql += " and c.state = 1";
		}
		hql += " order by c.orderIndex asc";
		List<Category> list = getSession().createQuery(hql).setMaxResults(size).list();
		return list;
	}

	public List<Category> findByParentId(Integer pId, int size,
			boolean isOnlyShowEnabled) throws Exception {
		String hql = "from Category c where c.parent.id="+pId;
		if (isOnlyShowEnabled) {
			hql += " and c.state = 1";
		}
		hql += " order by c.orderIndex asc";
		List<Category> list = getSession().createQuery(hql).setMaxResults(size).list();
		return list;
	}

	public List<Category> findByParentId(Integer pId,
			boolean isOnlyShowEnabled) throws Exception {
		String hql = "from Category c where c.parent.id="+pId;
		if (isOnlyShowEnabled) {
			hql += " and c.state = 1";
		}
		hql += " order by c.orderIndex asc";
		List<Category> list = getSession().createQuery(hql).list();
		return list;
	}

	public Integer findParentIdById(Integer id) throws Exception {
		Category category = this.findById(id);
		return category.getParent().getId();
	}

}
