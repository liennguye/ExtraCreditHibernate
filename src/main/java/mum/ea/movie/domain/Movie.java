package mum.ea.movie.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
public class Movie implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "movieId")
	private int movieId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "poster")
	private String poster;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "briefSummary")
	private String briefSummary;
	@OneToMany(mappedBy="movie")
	private List<Comment> comments = new ArrayList<Comment>();
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@ManyToMany
	@JoinTable(name="MovieDirector", 
	joinColumns = {@JoinColumn(name="movieId")},
	inverseJoinColumns = {@JoinColumn(name="directorId")})
	private List<Director> directors = new ArrayList<Director>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="MovieActor", 
	joinColumns = {@JoinColumn(name="movieId")},
	inverseJoinColumns = {@JoinColumn(name="actorId")})
	private List<Actor> actors = new ArrayList<Actor>();

	public Movie() {
		
	}
	
	public Movie(String title, int year, int rating, String poster, String briefSummary, List<Comment> comments,
			Genre genre, List<Director> directors, List<Actor> actors) {
		super();
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.poster = poster;
		this.briefSummary = briefSummary;
		this.comments = comments;
		this.genre = genre;
		this.directors = directors;
		this.actors = actors;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the directors
	 */
	public List<Director> getDirectors() {
		return directors;
	}

	/**
	 * @param directors the directors to set
	 */
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	/**
	 * @return the actors
	 */
	public List<Actor> getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	/**
	 * @param briefSummary the briefSummary to set
	 */
	public void setBriefSummary(String briefSummary) {
		this.briefSummary = briefSummary;
	}

	@Override
	public String toString() {
		return "Movie [Title = " + title + ", Year = " + year + ", Genre = " + genre + ", Rating = " + rating + ", Poster = " + poster
				+ ", BriefSummary = " + briefSummary + "]";
	}

	private static final long serialVersionUID = 1548724507423454366L;

	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}

	/**
	 * @param poster the poster to set
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}

	/**
	 * @return the content
	 */
	public String getBriefSummary() {
		return briefSummary;
	}

	/**
	 * @return the movieId
	 */
	public long getMovieId() {
		return movieId;
	}
	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
