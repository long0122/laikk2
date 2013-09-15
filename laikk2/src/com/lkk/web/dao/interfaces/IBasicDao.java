package com.lkk.web.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IBasicDao<T, ID extends Serializable> {
	public void add(T entity)throws Exception;
	public void update(T entity)throws Exception;
	public void delete(T entity)throws Exception;
	public void deleteById(Integer id)throws Exception;
	public void saveOrUpdate(T entity)throws Exception;
	public long countAll()throws Exception;
	public T findById(int id)throws Exception;
	public List<T> findAll()throws Exception;
	
	/**
	 * 列出所有 （分页）
	 * @param s
	 */
	public List<T> findAll (int startIndex, int pageSize)throws Exception;
}
