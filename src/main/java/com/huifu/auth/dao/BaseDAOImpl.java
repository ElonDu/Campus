package com.huifu.auth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("baseDao")
public class BaseDAOImpl<T> implements BaseDAO<T> {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void add(T t) {
		hibernateTemplate.save(t);
	}

	public void edit(T t) {
		hibernateTemplate.update(t);
	}

	public void remove(T t) {
		hibernateTemplate.delete(t);
	}

	public T get(Class<T> entityClass, long id) {
		return hibernateTemplate.get(entityClass, id);
	}

	public T load(Class<T> entityClass, long id) {
		return hibernateTemplate.load(entityClass, id);
	}

}
