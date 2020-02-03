package com.example.movieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieTracker.models.Rate;

public interface RateRepository extends JpaRepository<Rate, Integer> {

}
