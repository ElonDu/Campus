package com.huifu.auth.dao;

public interface BaseDAO<T> {

	public void add(T t);

	public void edit(T t);

	public void remove(T t);

	public T load(Class<T> entityClass, long id);

	public T get(Class<T> entityClass, long id);
}
