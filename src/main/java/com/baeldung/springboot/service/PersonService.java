package com.baeldung.springboot.service;

import com.baeldung.springboot.entity.Person;
import com.baeldung.springboot.exception.ParkRunException;
import com.baeldung.springboot.model.PersonResponse;
import com.baeldung.springboot.model.dto.PersonDto;

public interface PersonService {

	public PersonResponse createPerson(PersonDto personDto);
	
	public Person getParkRunnerById(Long parkRunnerId) throws ParkRunException;

}
