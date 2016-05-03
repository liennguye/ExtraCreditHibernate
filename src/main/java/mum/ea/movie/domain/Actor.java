package mum.ea.movie.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Actor")
public class Actor implements Serializable {

	private static final long serialVersionUID = 3362584978367242292L;

	@Id
	@GeneratedValue
	@Column(name = "actorId", nullable = false)
	private int actorId;

	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "dateOfBirth")
	private LocalDate dateOfBirth;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "picture")
	private String picture;

	@Column(name = "placeOfBirth")
	private String placeOfBirth;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "biography")
	private String biography;

	@ManyToMany(cascade=CascadeType.ALL, mappedBy="actors")	
	//@JoinTable(name="MovieActor")
	private List<Movie> movies = new ArrayList<Movie>();

	public Actor() {
		
	}

	public Actor(String firstName, String lastName, LocalDate dateOfBirth, String gender, String picture,
			String placeOfBirth, String biography) {
		this.firstname = firstName;
		this.lastname = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.picture = picture;
		this.placeOfBirth = placeOfBirth;
		this.biography = biography;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 *            
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 *            
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 *           
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
