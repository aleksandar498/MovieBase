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

import com.example.movieTracker.models.Genre;
import com.example.movieTracker.repository.GenreRepository;



@RestController
public class GenreRESTController {

	@Autowired
	private GenreRepository genreRepository;
	
	@CrossOrigin
	@GetMapping("genre")
	public Collection<Genre> getGenres(){
		return genreRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("genre/{id}")
	public Genre getGenre(@PathVariable ("id")Integer id){
		return genreRepository.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("genreName/{name}")
	public Collection<Genre> getGenreByName(@PathVariable ("name") String genreName){
		return genreRepository.findByGenreNameContainingIgnoreCase(genreName);
	}
	
	@CrossOrigin
	@DeleteMapping("genre/{id}")
	public ResponseEntity<Genre> deleteGenre(@PathVariable ("id") Integer id){
		if(!genreRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		genreRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("genrePost")
	public ResponseEntity<Genre> insertGenre(@RequestBody Genre genre){
		if(!genreRepository.existsById(genre.getId())){
			genreRepository.save(genre);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@CrossOrigin
	@PutMapping("genrePut")
	public ResponseEntity<Genre> updateGenre(@RequestBody Genre genre){
		if(!genreRepository.existsById(genre.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		genreRepository.save(genre);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
