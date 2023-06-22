package com.springmicroservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmicroservices.models.Loans;

@Repository
public interface LoansRepository extends CrudRepository<Loans, Integer> {

	@Query(value="select l from Loans l where l.customerId =:customerId")
	List<Loans> findByCustomerId(int customerId);
}
