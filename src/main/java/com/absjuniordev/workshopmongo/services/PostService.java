package com.absjuniordev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absjuniordev.workshopmongo.domain.Post;
import com.absjuniordev.workshopmongo.repository.PostRepository;
import com.absjuniordev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}	
	
//	public List<Post> findByTitle(String text){
//		return repository.findByTitleContainingIgnoreCase(text);
//	}
	
	public List<Post> findByTitle(String text){
		return repository.seachTitle(text);
	}
	 
}
