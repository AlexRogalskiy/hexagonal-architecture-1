package com.baeldung.springboot.service;

import java.util.Optional;

import com.baeldung.springboot.entity.Person;
import com.baeldung.springboot.model.dto.PersonDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baeldung.springboot.exception.ParkRunException;
import com.baeldung.springboot.model.PersonResponse;
import com.baeldung.springboot.respository.ParkRunnerRepository;


@Service
public class PersonServiceImpl implements PersonService {

	private final ParkRunnerRepository parkRunnerRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public PersonServiceImpl(ParkRunnerRepository parkRunnerRepository, ModelMapper modelMapper) {

		this.parkRunnerRepository = parkRunnerRepository;

		this.modelMapper = modelMapper;
	}

	@Override
	public PersonResponse createPerson(PersonDto personDto) {

		Person personEntity = modelMapper.map(personDto, Person.class);

		Person person =  parkRunnerRepository.save(personEntity);

		return new PersonResponse("Registration Success.", String.valueOf(person.getId()));
	}

	@Override
	public Person getParkRunnerById(Long parkRunnerId) throws ParkRunException {

		Optional<Person> parkRunnerOptional = parkRunnerRepository.findById(parkRunnerId);

		return parkRunnerOptional.orElseThrow(() -> new ParkRunException(parkRunnerId.toString(), "404", "Runner Not Found"));

	}

}
