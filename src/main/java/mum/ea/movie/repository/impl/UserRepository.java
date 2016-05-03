package mum.ea.movie.repository.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import mum.ea.movie.domain.User;
//import mum.ea.movie.repository.contract.IUserRepository;

public class UserRepository extends BaseRepository<User> {//implements IUserRepository {
	
	public UserRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//@Override
	public User getByUserName(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username = :username");
		query.setString("username", username);
		return (User) query.uniqueResult();
	}
}
