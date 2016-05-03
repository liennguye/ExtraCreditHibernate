package mum.ea.movie.repository;

import java.util.List;

import mum.ea.movie.domain.Director;

public interface IDirectorRepository extends IBaseRepository<Director> {
	public List<Director> getAll();
}
