package mum.ea.movie.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 2323057889877617972L;

	@Id
	@GeneratedValue
	@Column(name = "commentId", nullable = false)
	private int commentId;

	@Column(name = "movieId")
	private int movieId;

	@Column(name = "userId")
	private int userId;

	@Column(name = "content")
	private String content;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Movie movie;	
	
	public Comment() {
	
	}

	public Comment(int movieId, int userId, String content) {
		this.movieId = movieId;
		this.userId = userId;
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.commentId = id;
	}

	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}	
}
