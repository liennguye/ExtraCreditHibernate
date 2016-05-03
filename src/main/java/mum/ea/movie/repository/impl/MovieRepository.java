package mum.ea.movie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mum.ea.movie.domain.Movie;
import mum.ea.movie.repository.IMovieRepository;

@SuppressWarnings("unchecked")
public class MovieRepository extends BaseRepository<Movie> implements IMovieRepository {

	public MovieRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Movie> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Movie");
		return new ArrayList<Movie>(query.list());
	}

	@Override
	public List<Movie> searchByName(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Movie m where m.name = :name");
		query.setString("name", key);
		return new ArrayList<Movie>(query.list());
	}

	@Override
	public List<Movie> searchByGenre(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Movie m where m.genre = :genre");
		query.setString("genre", key);
		return new ArrayList<Movie>(query.list());
	}

	@Override
	public List<Movie> searchByRating(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Movie m where m.rating = :rating");
		query.setString("rating", key);
		return new ArrayList<Movie>(query.list());
	}

	@Override
	public List<Movie> searchByYear(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Movie m where m.year = :year");
		query.setString("year", key);
		return new ArrayList<Movie>(query.list());
	}

	@Override
	public List<Movie> searchByNameOfActor(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Movie m join m.actors a where a.firstName = :name OR a.lastName = :name");
		query.setString("name", key);
		return new ArrayList<Movie>(query.list());
	}

	@Override
	public List<Movie> searchByNameOfDirector(String key) {
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Movie m join m.directors d where d.firstName = :name OR d.lastName = :name");
		query.setString("name", key);
		return new ArrayList<Movie>(query.list());
	}
}