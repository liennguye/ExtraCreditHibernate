package mum.ea.movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mum.ea.movie.domain.Actor;
import mum.ea.movie.domain.Comment;
import mum.ea.movie.domain.Director;
import mum.ea.movie.domain.Genre;
import mum.ea.movie.domain.Movie;
import mum.ea.movie.domain.User;
import mum.ea.movie.repository.impl.ActorRepository;
import mum.ea.movie.repository.impl.CommentRepository;
import mum.ea.movie.repository.impl.DirectorRepository;
import mum.ea.movie.repository.impl.MovieRepository;
import mum.ea.movie.repository.impl.UserRepository;

@SpringBootApplication
public class MovieApplication {

	private static final SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);

		Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// Add User
			UserRepository userRepository = new UserRepository(sessionFactory);
			User user1 = new User("user1", "password");	
			User user2 = new User("user2", "password");			
			userRepository.add(user1);
			userRepository.add(user2);
			
			// Add Actor
			ActorRepository artistRepository = new ActorRepository(sessionFactory);
			Actor actor1 = new Actor("Leah", "Nguyen", LocalDate.parse("1980-12-08"), "Female", "A link to the picture of Leah", "IA"
					, "Leah Nguyen has stated that she now plans to spend most of her time in humanitarian efforts, to be financed by her actress salary. She devotes one third of her income to savings, one third to living expenses and one third to charity.");
			Actor actor2 = new Actor("Michael", "Lam", LocalDate.parse("1972-04-12"), "Male", "A link to the pictue of Micheal", "LA"
					, "Micheal Lam began his acting career in typical fashion: performing in school productions and community theater.");
			artistRepository.add(actor1);
			artistRepository.add(actor2);
			
			// Add Comment
			CommentRepository commentRepository = new CommentRepository(sessionFactory);
			Comment comment1 = new Comment(1,1,"With its sheer warmth and likability, this good-natured documentary won my heart.");	
			Comment comment2 = new Comment(1,2,"A heartwarming true story that has been expertly crafted into an irresistible, emotion-charged documentary.");				
			commentRepository.add(comment1);
			commentRepository.add(comment2);	
			
			// Add Director
			DirectorRepository directorRepository = new DirectorRepository(sessionFactory);
			Director director1 = new Director("Tom", "Smith", LocalDate.parse("1965-10-12"));
			Director director2 = new Director("Viktor", "Vu", LocalDate.parse("1973-09-19"));
			directorRepository.add(director1);
			directorRepository.add(director2);	
			
			// Add new Movie (String title, int year, int rating, String poster, String briefSummary, List<Comment> comments,
			//Genre genre, List<Director> directors, List<Artist> actors)
			List<Comment> comments = new ArrayList<Comment>();
			comments.add(comment1);
			comments.add(comment2);
			Genre genre = Genre.ACTION;
			List<Director> directors = new ArrayList<Director>();
			directors.add(director1);
			directors.add(director2);
			List<Actor> actors = new ArrayList<Actor>();
			actors.add(actor1);
			actors.add(actor2);
			String briefSummary = "The story of Michael Oher, a homeless and traumatized boy who became an All American football player and first round NFL draft pick with the help of a caring woman and her family.";
			MovieRepository movieRepository = new MovieRepository(sessionFactory);
			Movie movie = new Movie("The Blind Side", 2009, 5, "Link to the poster",
										briefSummary, comments, genre, directors, actors);
			
			movieRepository.add(movie);			
			
			// See information about movie
			List<Movie> movies = movieRepository.getAll();
			for(Movie movieInfo : movies){
				System.out.println(movieInfo.toString());
				
				for(Actor actor : movieInfo.getActors()){
					System.out.println(actor.getFirstname() + " " +  actor.getLastname());				
				}
			}
			
			/*
				Search the database by different criteria like:
					Name of the movie
					Genre of the movie
					Rating of the movie
					Year of the movie
					Name of the artist
					Name of the character on the movie
					Director of the movie
			*/
			// Search by Name of the movie
			
			List<Movie> movies1 = movieRepository.searchByName("The Blind Side");
			for(Movie movieInfo : movies1){
				System.out.println("Lien test"+ movieInfo.toString());				
			}/*
			//Search by Genre of the movie
			List<Movie> movies2 = movieRepository.searchByGenre("ACTION");
			for(Movie movieInfo : movies2){
				System.out.println(movieInfo.toString());				
			}
			//Search by Rating of the movie
			List<Movie> movies3 = movieRepository.searchByRating("5");
			for(Movie movieInfo : movies3){
				System.out.println(movieInfo.toString());				
			}
			//Search by Year of the movie
			List<Movie> movies6 = movieRepository.searchByYear("2014");
			for(Movie movieInfo : movies6){
				System.out.println(movieInfo.toString());				
			}
			//Search by Name of the artist
			List<Movie> movies4 = movieRepository.searchByNameOfActor("Leah");
			for(Movie movieInfo : movies4){
				System.out.println(movieInfo.toString());				
			}
			
			///*Search by Name of the character on the movie: not implemented yet
			
			//Search by Director of the movie
			List<Movie> movies5 = movieRepository.searchByNameOfDirector("Tom");
			for(Movie movieInfo : movies5){
				System.out.println(movieInfo.toString());				
			}
			//*/
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace(System.err);
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
