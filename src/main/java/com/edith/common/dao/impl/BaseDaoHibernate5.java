package com.edith.common.dao.impl;

import com.edith.common.dao.BaseDao;
import com.edith.common.dao.Page;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;
import java.io.Serializable;



/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BaseDaoHibernate5<T> implements BaseDao<T>
{
	// DAO组件进行持久化操作底层依赖的SessionFactory组件
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	// 依赖注入SessionFactory所需的setter方法
	public SessionFactory getSessionFactory()
	{
		return this.sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	// 根据ID加载实体
	public T get(Class<T> entityClazz , Serializable id)
	{
		return (T)getSessionFactory().getCurrentSession()
			.get(entityClazz , id);
	}
	// 保存实体
	public Serializable save(T entity)
	{
		return getSessionFactory().getCurrentSession()
			.save(entity);
	}
	// 更新实体
	public void update(T entity)
	{
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}
	// 删除实体
	public void delete(T entity)
	{
		getSessionFactory().getCurrentSession().delete(entity);
	}
	// 根据ID删除实体
	public void delete(Class<T> entityClazz , Serializable id)
	{
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName()
				+ " en where en.id = ?0")
			.setParameter(0 , id)
			.executeUpdate();
	}
	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("select en from "
			+ entityClazz.getSimpleName() + " en");
	}
	// 获取实体总数

	public long findCount(Class<T> entityClazz)
	{
		List<?> l = find("select count(*) from "
			+ entityClazz.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1 )
		{
			return (Long)l.get(0);
		}
		return 0;
	}

	// 根据HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql)
	{
		return (List<T>)getSessionFactory().getCurrentSession()
			.createQuery(hql)
			.getResultList();
	}
	// 根据带占位符参数HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql , Object... params)
	{
		// 创建查询
		Query<T> query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for(int i = 0 , len = params.length ; i <len ; i++)
		{
			query.setParameter(i , params[i]);
		}
		return (List<T>)query.getResultList();
	}
	/**
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql,
		 int pageNo, int pageSize)
	{
		// 创建查询
		return getSessionFactory().getCurrentSession()
			.createQuery(hql)
			// 执行分页
			.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.getResultList();
	}
	/**
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param params 如果hql带占位符参数，params用于传入占位符参数
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql , int pageNo, int pageSize
		, Object... params)
	{
		// 创建查询
		Query<T> query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for(int i = 1 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i + "" , params[i-1]);
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		return (List<T>)hibernateTemplate.findByCriteria(detachedCriteria);
	}

	public Page<T> findByCriteriaWithPage(DetachedCriteria detachedCriteria,int pageNumber,int pageSize) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> total = ((List<Long>)hibernateTemplate.findByCriteria(detachedCriteria));
		detachedCriteria.setProjection(null);
		List<T> rows=(List<T>)hibernateTemplate.findByCriteria(detachedCriteria, (pageNumber - 1) * pageSize, pageSize);


		Page<T> page = new Page<>((pageNumber - 1) * pageSize,total.get(0),pageSize,rows);
		return page;
	}

}
