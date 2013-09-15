package com.lkk.web.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.lkk.web.dao.MyHibernateDaoSupport;
import com.lkk.web.dao.interfaces.IBasicDao;

/**
 * @author wgl
 * 
 */
@SuppressWarnings("unchecked")
public class BasicDaoImpl<T, ID extends Serializable> extends
		MyHibernateDaoSupport implements IBasicDao<T, Serializable> {
	protected Class<T> persistentClass;
	protected Class<ID> idClass;

	/**
	 * Constructor, instantiate the DAO class
	 */
	public BasicDaoImpl() {

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.idClass = (Class<ID>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}

	/**
	 * Constructor, instantiate the DAO class
	 * 
	 * @param persistentClass
	 */
	public BasicDaoImpl(T persistentClass) {
		if (persistentClass == null)
			this.persistentClass = (Class<T>) (this.getClass()
					.getTypeParameters()[0].getGenericDeclaration());
		else
			this.persistentClass = (Class<T>) persistentClass.getClass();
		// this.idClass = (Class<ID>) ((ParameterizedType)
		// getClass().getTypeParameters()
		// .getGenericSuperclass()).getActualTypeArguments()[1];

		this.idClass = (Class<ID>) (getClass().getTypeParameters()[1]
				.getGenericDeclaration());
	}

	public T findById(int id)throws Exception {
		return (T) getHibernateTemplate().load(persistentClass, id);
	}

	public void add(T entity) throws Exception{
		getHibernateTemplate().save(entity);
	}

	public void delete(T entity) throws Exception{
		getHibernateTemplate().delete(entity);

	}

	public void deleteById(Integer id) throws Exception{
		getHibernateTemplate().delete(this.findById(id));
	}

	public void update(T entity)throws Exception {
		getHibernateTemplate().merge(entity);

	}

	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);

	}

	public List<T> findAll() throws Exception{
		return (List<T>) getHibernateTemplate().find(
				"from " + persistentClass.getSimpleName());
	}

	public long countAll()throws Exception {
		return ((Long) this.getSession().createQuery(
				"select count(t) from " + persistentClass.getSimpleName()
						+ " t").uniqueResult()).intValue();
	}

	public List<T> findAll(final int startIndex, final int pageSize)throws Exception {
		// 调用模板的execute方法，参数是实现了HibernateCallback接口的匿名类，
		return (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					// 重写其doInHibernate方法返回一个object对象，
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// 创建query对象
						Query query = session.createQuery("from "
								+ persistentClass.getSimpleName());
						// 返回其执行了分布方法的list
						return query.setFirstResult(startIndex).setMaxResults(
								pageSize).list();

					}

				});
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Class<ID> getIdClass() {
		return idClass;
	}

	public void setIdClass(Class<ID> idClass) {
		this.idClass = idClass;
	}

}
