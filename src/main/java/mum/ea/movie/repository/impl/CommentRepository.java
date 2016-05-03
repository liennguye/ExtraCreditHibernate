package mum.ea.movie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import mum.ea.movie.domain.Comment;
import mum.ea.movie.repository.ICommentRepository;

@SuppressWarnings("unchecked")
public class CommentRepository extends BaseRepository<Comment> implements ICommentRepository {

	public CommentRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Comment> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Comment");
		return new ArrayList<Comment>(query.list());
	}
}

