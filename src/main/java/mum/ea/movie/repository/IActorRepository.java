package mum.ea.movie.repository;

import java.util.List;

import mum.ea.movie.domain.Actor;

public interface IActorRepository extends IBaseRepository<Actor> {
	public List<Actor> getAll();
}
