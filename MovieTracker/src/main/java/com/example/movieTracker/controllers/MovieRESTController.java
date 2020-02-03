package com.example.movieTracker.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieTracker.models.Movie;
import com.example.movieTracker.repository.MovieRepository;
import com.example.movieTracker.repository.MovieRepository;
@RestController
public class MovieRESTController {


	@Autowired
	private MovieRepository movieRepository;
	
	@CrossOrigin
	@GetMapping("movie")
	public Collection<Movie> getMovies(){
		return movieRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("movie/{id}")
	public Movie getMovie(@PathVariable ("id")Integer id){
		return movieRepository.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("movieName/{name}")
	public Collection<Movie> getMovieByName(@PathVariable ("name") String movieName){
		return movieRepository.findByNameContainingIgnoreCase(movieName);
	}
	
	@CrossOrigin
	@DeleteMapping("movie/{id}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable ("id") Integer id){
		if(!movieRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		movieRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("moviePost")
	public ResponseEntity<Movie> insertMovie(@RequestBody Movie movie){
		if(!movieRepository.existsById(movie.getId())){
			movieRepository.save(movie);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@CrossOrigin
	@PutMapping("moviePut")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
		if(!movieRepository.existsById(movie.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		movieRepository.save(movie);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}