package com.example.movieTracker.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieTracker.models.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	Collection<Actor>findByNameContainingIgnoreCase(String name);
}
