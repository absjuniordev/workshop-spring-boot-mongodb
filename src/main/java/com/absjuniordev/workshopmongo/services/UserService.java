package com.absjuniordev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absjuniordev.workshopmongo.domain.User;
import com.absjuniordev.workshopmongo.dto.UserDTO;
import com.absjuniordev.workshopmongo.repository.UserRepository;
import com.absjuniordev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}	
		
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User update(User obj) {
		User newUser = repository.findById(obj.getId()).get();
		updateUser(newUser, obj);
		return repository.save(newUser);
	}
	
	private void updateUser(User newUser, User obj) {
		newUser.setEmail(obj.getEmail());
		newUser.setName(obj.getName());
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
