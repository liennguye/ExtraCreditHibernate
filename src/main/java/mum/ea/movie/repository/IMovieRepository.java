package mum.ea.movie.repository;

import java.util.List;

import mum.ea.movie.domain.Movie;

public interface IMovieRepository extends IBaseRepository<Movie> {
	public List<Movie> getAll();
	
	public List<Movie> searchByName(String key);
	
	public List<Movie> searchByGenre(String key);
	
	public List<Movie> searchByRating(String key);
	
	public List<Movie> searchByYear(String key);
	
	public List<Movie> searchByNameOfActor(String key);
	
	public List<Movie> searchByNameOfDirector (String key);
	
}
