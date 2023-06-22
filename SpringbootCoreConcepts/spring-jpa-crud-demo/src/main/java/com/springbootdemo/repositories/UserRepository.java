package com.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.models.UserInfo;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Integer> {
	
	
	

}
