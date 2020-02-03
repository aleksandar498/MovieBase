package com.example.movieTracker.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name="image_url")
	private String imageUrl;

	private BigDecimal length;

	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="release_date")
	private Date releaseDate;

	//bi-directional many-to-many association to Actor
	@ManyToMany
	@JoinTable(
		name="actormovie"
		, joinColumns={
			@JoinColumn(name="idM")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idA")
			}
		)
	private List<Actor> actors;

	//bi-directional many-to-one association to Director
	@ManyToOne
	@JoinColumn(name="director")
	private Director directorBean;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="genre")
	private Genre genreBean;

	//bi-directional many-to-many association to Rate
	@ManyToMany(mappedBy="movies")
	private List<Rate> rates;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="movies")
	private List<User> users;

	public Movie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Actor> getActors() {
		return this.actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Director getDirectorBean() {
		return this.directorBean;
	}

	public void setDirectorBean(Director directorBean) {
		this.directorBean = directorBean;
	}

	public Genre getGenreBean() {
		return this.genreBean;
	}

	public void setGenreBean(Genre genreBean) {
		this.genreBean = genreBean;
	}

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}