package mum.ea.movie.repository;

import java.util.List;

import mum.ea.movie.domain.Comment;

public interface ICommentRepository extends IBaseRepository<Comment> {
	public List<Comment> getAll();
}
