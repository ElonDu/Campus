package com.huifu.auth.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;  
import java.util.List;  
  
import javax.annotation.Resource;  
  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")  
public class BaseDAOImpl<T> implements BaseDAO<T> {
    private Class<T> clazz; 
    
    /** 
     * 通过构造方法指定DAO的具体实现类 
     */  
    public BaseDAOImpl() {  
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
        clazz = (Class<T>) type.getActualTypeArguments()[0];  
        System.out.println("DAO的真实实现类是：" + this.clazz.getName());  
    }  
  
    /** 
     * 向DAO层注入SessionFactory 
     */  
    @Resource  
    private SessionFactory sessionFactory;  
  
    /** 
     * 获取当前工作的Session 
     */  
    protected Session getSession() {  
        return this.sessionFactory.getCurrentSession();  
    }  
  
    public void save(T entity) {  
        this.getSession().save(entity);  
    }  
  
    public void update(T entity) {  
        this.getSession().update(entity);  
    }  
  
    public void delete(Serializable id) {  
        this.getSession().delete(this.findById(id));  
    }  
  
    public T findById(Serializable id) {  
        return (T) this.getSession().get(this.clazz, id);  
    }  
  
    public List<T> findByHQL(String hql, Object... params) {  
        Query query = this.getSession().createQuery(hql);  
        for (int i = 0; params != null && i < params.length; i++) {  
            query.setParameter(i, params);  
        }  
        return query.list();  
    }  

	
}
