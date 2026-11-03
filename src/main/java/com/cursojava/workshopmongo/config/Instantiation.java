package com.cursojava.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;

import com.cursojava.workshopmongo.domain.Post;
import com.cursojava.workshopmongo.domain.User;
import com.cursojava.workshopmongo.repository.PostRepository;
import com.cursojava.workshopmongo.repository.UserRepository;

@Configurable
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	userRepository.deleteAll();
	postRepository.deleteAll();
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob grey", "bob@gmail.com");
		
		Post post1 =  new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 =  new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei Feliz hoje!!", maria);
		
		userRepository.save(Arrays.asList(maria, alex, bob));
		postRepository.save(Arrays.asList(post1,post2));
		
	}
	

}
