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

import com.example.movieTracker.models.Rate;
import com.example.movieTracker.repository.RateRepository;
import com.example.movieTracker.repository.RateRepository;
@RestController
public class RateRESTController {


	@Autowired
	private RateRepository rateRepository;
	
	@CrossOrigin
	@GetMapping("rate")
	public Collection<Rate> getRates(){
		return rateRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("rate/{id}")
	public Rate getRate(@PathVariable ("id")Integer id){
		return rateRepository.getOne(id);
	}
	

	
	@CrossOrigin
	@DeleteMapping("rate/{id}")
	public ResponseEntity<Rate> deleteRate(@PathVariable ("id") Integer id){
		if(!rateRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		rateRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("ratePost")
	public ResponseEntity<Rate> insertRate(@RequestBody Rate rate){
		if(!rateRepository.existsById(rate.getId())){
			rateRepository.save(rate);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@CrossOrigin
	@PutMapping("ratePut")
	public ResponseEntity<Rate> updateRate(@RequestBody Rate rate){
		if(!rateRepository.existsById(rate.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		rateRepository.save(rate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
