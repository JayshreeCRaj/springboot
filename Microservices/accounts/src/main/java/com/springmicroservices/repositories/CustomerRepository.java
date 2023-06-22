package com.springmicroservices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmicroservices.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	
}
