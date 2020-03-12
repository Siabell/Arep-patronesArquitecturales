package edu.escuelaing.arep.service;

import java.util.List;

import edu.escuelaing.arep.model.User;
import edu.escuelaing.arep.persistence.UserPersistence;

public class UserServiceImpl implements UserService{
	
	private UserPersistence persistence = new UserPersistence();

	@Override
	public User addUser(User user) {
		return persistence.addUser(user);
	}

	@Override
	public User update(User user) {
		User newUser = persistence.updateUser(user);
		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users= persistence.getAllUsers();
		return users;
	}

}
