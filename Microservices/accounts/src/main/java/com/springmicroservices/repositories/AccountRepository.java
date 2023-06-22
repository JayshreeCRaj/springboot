package com.springmicroservices.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmicroservices.models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>  {
	
	@Query(value="select a from Account a where a.customerId =:customerId")
	Optional<Account> findByCustomerId(int customerId);
	
	@Transactional
	@Modifying
	@Query(value="delete from Account a where a.customerId =:customerId")
	public void deleteByCustomerId(int customerId);
	
}
