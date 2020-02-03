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

import com.example.movieTracker.models.Actor;
import com.example.movieTracker.repository.ActorRepository;

@RestController
public class ActorRESTController {


	@Autowired
	private ActorRepository actorRepository;
	
	@CrossOrigin
	@GetMapping("actor")
	public Collection<Actor> getactors(){
		return actorRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("actor/{id}")
	public Actor getactor(@PathVariable ("id")Integer id){
		return actorRepository.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("actorName/{name}")
	public Collection<Actor> getactorByName(@PathVariable ("name") String actorName){
		return actorRepository.findByNameContainingIgnoreCase(actorName);
	}
	
	@CrossOrigin
	@DeleteMapping("actor/{id}")
	public ResponseEntity<Actor> deleteactor(@PathVariable ("id") Integer id){
		if(!actorRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		actorRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("actorPost")
	public ResponseEntity<Actor> insertactor(@RequestBody Actor actor){
		if(!actorRepository.existsById(actor.getId())){
			actorRepository.save(actor);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@CrossOrigin
	@PutMapping("actorPut")
	public ResponseEntity<Actor> updateactor(@RequestBody Actor actor){
		if(!actorRepository.existsById(actor.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		actorRepository.save(actor);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
