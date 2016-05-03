package mum.ea.movie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import mum.ea.movie.domain.Director;
import mum.ea.movie.repository.IDirectorRepository;

@SuppressWarnings("unchecked")
public class DirectorRepository extends BaseRepository<Director> implements IDirectorRepository {

	public DirectorRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Director> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Director");
		return new ArrayList<Director>(query.list());
	}
}