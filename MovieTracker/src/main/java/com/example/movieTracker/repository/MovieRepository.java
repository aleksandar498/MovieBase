package com.example.movieTracker.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieTracker.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	Collection<Movie>findByNameContainingIgnoreCase(String name);

}
