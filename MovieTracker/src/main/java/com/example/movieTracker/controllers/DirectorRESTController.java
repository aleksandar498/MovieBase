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

import com.example.movieTracker.models.Director;
import com.example.movieTracker.repository.ActorRepository;
import com.example.movieTracker.repository.DirectorRepository;
@RestController
public class DirectorRESTController {

	@Autowired
	private DirectorRepository directorRepository;
	
	@CrossOrigin
	@GetMapping("director")
	public Collection<Director> getDirectors(){
		return directorRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("director/{id}")
	public Director getDirector(@PathVariable ("id")Integer id){
		return directorRepository.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("directorName/{name}")
	public Collection<Director> getDirectorByName(@PathVariable ("name") String directorName){
		return directorRepository.findByNameContainingIgnoreCase(directorName);
	}
	
	@CrossOrigin
	@DeleteMapping("director/{id}")
	public ResponseEntity<Director> deleteDirector(@PathVariable ("id") Integer id){
		if(!directorRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		directorRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("directorPost")
	public ResponseEntity<Director> insertDirector(@RequestBody Director director){
		if(!directorRepository.existsById(director.getId())){
			directorRepository.save(director);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@CrossOrigin
	@PutMapping("directorPut")
	public ResponseEntity<Director> updateDirector(@RequestBody Director director){
		if(!directorRepository.existsById(director.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		directorRepository.save(director);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
