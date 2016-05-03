package mum.ea.movie.repository;

import mum.ea.movie.domain.User;

public interface IUserRepository extends IBaseRepository<User> {

	/**
	 * 
	 * @param username
	 * @return
	 */
	public User getByUserName(String userName);
}

