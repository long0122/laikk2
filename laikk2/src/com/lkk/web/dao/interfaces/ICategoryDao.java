package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.lkk.web.model.Category;

public interface ICategoryDao extends IBasicDao<Category, Serializable> {
	/**
	 * 根据state获得所有list
	 * 
	 * @param isOnlyShowEnabled
	 *            true-只显示state=1的数据;false-全部显示
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll(boolean isOnlyShowEnabled) throws Exception;

	/**
	 * 获得顶层种类列表
	 * 
	 * @param isOnlyShowEnabled
	 *            true-只显示state=1的数据;false-全部显示
	 * @return
	 * @throws Exception
	 */
	public List<Category> findTopCategories(boolean isOnlyShowEnabled)
			throws Exception;

	/**
	 * 获得顶层种类列表
	 * 
	 * @param size
	 *            返回数量
	 * @param isOnlyShowEnabled
	 *            true-只显示state=1的数据;false-全部显示
	 * @return
	 * @throws Exception
	 */
	public List<Category> findTopCategories(int size, boolean isOnlyShowEnabled)
			throws Exception;

	/**
	 * 根据父类别查找子类别
	 * 
	 * @param size
	 * @param isOnlyShowEnabled
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(Integer pId, int size,
			boolean isOnlyShowEnabled) throws Exception;

	/**
	 * 根据父类别查找所有子类别
	 * 
	 * @param size
	 * @param isOnlyShowEnabled
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(Integer pId, boolean isOnlyShowEnabled)
			throws Exception;

	/**
	 * 根据ID返回父数据id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer findParentIdById(Integer id) throws Exception;
}
