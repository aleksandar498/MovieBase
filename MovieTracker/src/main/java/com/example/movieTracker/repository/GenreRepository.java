package com.example.movieTracker.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieTracker.models.Genre;

public interface GenreRepository  extends JpaRepository<Genre, Integer> {
	Collection<Genre>findByGenreNameContainingIgnoreCase(String genreName); 

}
