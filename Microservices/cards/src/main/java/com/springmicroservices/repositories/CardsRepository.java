package com.springmicroservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmicroservices.models.Cards;


@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> {
	
	@Query(value="select c from Cards c where c.customerId =:customerId")
	List<Cards> findByCustomerId(int customerId);
	
	
}
