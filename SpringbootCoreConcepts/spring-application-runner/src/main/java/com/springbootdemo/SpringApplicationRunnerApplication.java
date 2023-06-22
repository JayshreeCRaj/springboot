package com.springbootdemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationRunnerApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationRunnerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Application runner is executing");
		var optionsName= args.getOptionNames();
		System.out.println("args.getOptionName->"+optionsName);
		System.out.println(args.containsOption("first-argument"));
		System.out.println(args.getOptionValues("second-argument"));
		System.out.println(args.getNonOptionArgs());
	}
	

}
