package com.springbootdemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringLombokLoggingApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringLombokLoggingApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Dev tools loaded");
		log.info("Application runner is executing");
		var optionsName= args.getOptionNames();
		log.info("args.getOptionName->"+optionsName);
		System.out.println(args.containsOption("first-argument"));
		System.out.println(args.getOptionValues("second-argument"));
		System.out.println(args.getNonOptionArgs());
	}
	

}
