package com.example.movieTracker.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieTracker.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
	Collection<Director>findByNameContainingIgnoreCase(String name);

}
