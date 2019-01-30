package com.baeldung.springboot.respository;

import com.baeldung.springboot.entity.ParkRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRunnerRepository extends CrudRepository<ParkRunner, Long >{

}
