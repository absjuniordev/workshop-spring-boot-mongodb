package com.absjuniordev.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.absjuniordev.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users" )
public class UserResource {

	@GetMapping
	public ResponseEntity< List<User>> findAll() {
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("1", "Alex Brown", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(alex,maria));
		return ResponseEntity.ok().body(list);
	}
}
