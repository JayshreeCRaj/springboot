package com.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootdemo.models.UserInfo;
import com.springbootdemo.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringJpaCrudDemoApplication implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaCrudDemoApplication.class, args);
	}

	@Override
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//saveUserInfo();
		//getUserInfo();
		//updateUserInfo();
		//deleteUserInfo();
		//retrieveUserInfo();
		//log.info("Total number of users in Database", userRepository.count());
		
		userRepository.deleteAll();
	}

	private void retrieveUserInfo() {
		var usersList = userRepository.findAll();
		usersList.forEach(userInfo -> System.out.println(userInfo));
	}

	private void deleteUserInfo() {
		var optional= userRepository.findById(3);
		if(optional.isPresent())
		{
			var dbUser = optional.get();
			userRepository.delete(dbUser);
			
		}
		else
			throw new RuntimeException("Record does not exist in database");
	}

	private void updateUserInfo() {
		var optional= userRepository.findById(2);
		if(optional.isPresent())
		{
			var dbUser = optional.get();
			dbUser.setPhoneNo(24566987);
			userRepository.save(dbUser);
			
		}
		else
			throw new RuntimeException("Record does not exist in database");
	}

	private void getUserInfo() {
		var optional= userRepository.findById(2);
		if(optional.isPresent())
		{
			//System.out.println(optional.get());
			log.info("Optional object {}", optional.get());
		}
		else
			throw new RuntimeException("Record does not exist in database");
	}

	private void saveUserInfo() {
		UserInfo userInfo = new UserInfo();
		
		userInfo.setEmailID("aronjackson@yahoo.com");
		userInfo.setPassword("@r0nJack");
		userInfo.setUsername("Aron");
		userInfo.setPhoneNo(984567890);
		
		userRepository.save(userInfo);
	}

}
