package mum.ea.movie.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable {

	private static final long serialVersionUID = -622855600192016623L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int userId;

	@Column(name = "username", unique = true, length = 50)
	private String username;

	@Column(name = "Password")
	private String password;

	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	public User() {
		this.password = "password";
		this.comments = new ArrayList<>();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 *
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId the userId to set
	 *            
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 *
	 * @param username the username to set
	 *            
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 * @param password the password to set
	 *            
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the list comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param set the list comments
	 *            
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
