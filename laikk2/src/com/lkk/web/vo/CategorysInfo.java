package com.lkk.web.vo;

import java.util.List;

import com.lkk.web.model.Category;

/**
 * 类别 包含子类别
 * @author Warren
 *
 */
public class CategorysInfo {
	private Category category;
	private List<Category> childrenList;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getChildrenList() {
		return childrenList;
	}
	public void setChildrenList(List<Category> childrenList) {
		this.childrenList = childrenList;
	}
	
}
