package mum.ea.movie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import mum.ea.movie.domain.Actor;
import mum.ea.movie.repository.IActorRepository;

@SuppressWarnings("unchecked")
public class ActorRepository extends BaseRepository<Actor> implements IActorRepository {

	public ActorRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Actor> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Actor");
		return new ArrayList<Actor>(query.list());
	}
}
