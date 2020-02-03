package com.example.movieTracker.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieTracker.models.Movie;
import com.example.movieTracker.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Collection<User>findByNameContainingIgnoreCase(String name);

}
