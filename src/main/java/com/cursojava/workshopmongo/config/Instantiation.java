package com.cursojava.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;

import com.cursojava.workshopmongo.domain.User;
import com.cursojava.workshopmongo.repository.UserRepository;

@Configurable
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	userRepository.deleteAll();
	
	@Override
	public void run(String... args) throws Exception {
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob grey", "bob@gmail.com");
		
		userRepository.save(Arrays.asList(maria, alex, bob));
		
	}
	

}
