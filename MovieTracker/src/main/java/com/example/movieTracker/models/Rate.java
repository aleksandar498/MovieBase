package com.example.movieTracker.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the rate database table.
 * 
 */
@Entity
@NamedQuery(name="Rate.findAll", query="SELECT r FROM Rate r")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigDecimal rate;

	//bi-directional many-to-many association to Movie
	@ManyToMany
	@JoinTable(
		name="ratemovie"
		, joinColumns={
			@JoinColumn(name="idR")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idM")
			}
		)
	private List<Movie> movies;

	public Rate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}