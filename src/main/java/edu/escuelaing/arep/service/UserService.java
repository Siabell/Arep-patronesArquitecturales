package edu.escuelaing.arep.service;

import java.util.List;

import edu.escuelaing.arep.model.User;

public interface UserService {

	public User addUser(User user);
	
	public User update (User user);
	
	public List<User> getAllUsers();
	
}
