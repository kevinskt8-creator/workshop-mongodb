package com.cursojava.workshopmongo.resources;

import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.net.URI;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cursojava.workshopmongo.domain.User;
import com.cursojava.workshopmongo.dto.UserDTO;
import com.cursojava.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value"/{id}"=RequestMethod.GET)
	public ResponseEntity<UserDTO>entity insert(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>entity insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.inser(obj);
		URI uri = ServeletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		
	}
	
	@RequestMapping(value"/{id}"=RequestMethod.DELETE)
	public ResponseEntity<Void>entity delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	
	
}