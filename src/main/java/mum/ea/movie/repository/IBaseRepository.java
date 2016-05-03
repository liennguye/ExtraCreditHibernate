package mum.ea.movie.repository;

public interface IBaseRepository<T> {

	T add(T t);

	T update(T t);

	boolean delete(int id);

	T get(int id);

}

