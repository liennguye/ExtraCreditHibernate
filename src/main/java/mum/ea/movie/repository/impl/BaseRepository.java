package mum.ea.movie.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mum.ea.movie.repository.IBaseRepository;

public abstract class BaseRepository<T> implements IBaseRepository<T> {

	protected SessionFactory sessionFactory;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseRepository() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public T add(T type) {		
		Session session = this.sessionFactory.getCurrentSession();		
		session.beginTransaction();
		session.save(type);
		return type;
	}

	public T update(T type) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(type);
		return type;
	}

	public boolean delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(this.load(id));
		return true;
	}

	@SuppressWarnings("unchecked")
	public T get(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		return (T) session.get(type, id);
	}

	@SuppressWarnings("unchecked")
	public T load(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		return (T) session.load(type, id);
	}
}

