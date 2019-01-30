package com.baeldung.springboot.controller;

import java.util.List;

import com.baeldung.springboot.entity.ParkRunner;
import com.baeldung.springboot.exception.ParkRunException;
import com.baeldung.springboot.model.dto.PartialUpdateDTO;
import com.baeldung.springboot.model.dto.PersonDto;
import com.baeldung.springboot.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.springboot.model.ParkRunResponse;

@RestController
@RequestMapping("/api/v1/runners")
public class ParkRun {

	private PersonService parkRunService;
	private ModelMapper modelMapper;
	
	@Autowired
	public ParkRun(PersonService personService, ModelMapper modelMapper) {
		
		this.parkRunService = personService;
		this.modelMapper = modelMapper;
		
	}
	
	@GetMapping
	public ResponseEntity<List<ParkRunner>> geAllParkRunners() {

		return new ResponseEntity<>(parkRunService.getAllParkRunners(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{parkRunId}")
	public ResponseEntity<ParkRunner> getParkRunner(@PathVariable Long parkRunId) throws ParkRunException {
		
		return new ResponseEntity<>(parkRunService.getParkRunnerById(parkRunId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<ParkRunResponse> registerRunner(@RequestBody PersonDto personDto) {
		
		ParkRunner parkRunnerEntity = modelMapper.map(personDto, ParkRunner.class);
		return new ResponseEntity<>(parkRunService.registerRunner(parkRunnerEntity), HttpStatus.CREATED);
	}
	
	@PatchMapping("/{parkRunId}")
	public ResponseEntity<ParkRunResponse> partialProfileUpdate(@PathVariable Long parkRunId, @RequestBody PartialUpdateDTO updateRunnerProfile) throws ParkRunException {
		
		ParkRunner parkRunnerEntity = modelMapper.map(updateRunnerProfile, ParkRunner.class);
		return new ResponseEntity<>(parkRunService.updateRunnerProfile(parkRunId, parkRunnerEntity), HttpStatus.OK);
		
	}
	
}
