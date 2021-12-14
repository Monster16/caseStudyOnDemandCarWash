package com.ondemandcarwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ondemandcarwash.model.Address;

public interface AddressRepository extends MongoRepository<Address, Integer>{

}
