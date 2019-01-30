package com.baeldung.springboot.service;

import java.util.List;

import com.baeldung.springboot.entity.ParkRunner;
import com.baeldung.springboot.exception.ParkRunException;
import com.baeldung.springboot.model.ParkRunResponse;

public interface PersonService {

	public ParkRunResponse registerRunner(ParkRunner toBeparkRunner);
	
	public ParkRunner getParkRunnerById(Long parkRunnerId) throws ParkRunException;
	
	public List<ParkRunner> getAllParkRunners();
	
	public ParkRunResponse updateRunnerProfile(Long parkRunId, ParkRunner runnerProfile) throws ParkRunException;
	
}
