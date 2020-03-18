package edu.escuelaing.arep.service;

import java.sql.Connection;
import java.util.List;

import edu.escuelaing.arep.dao.ConnectionDao;
import edu.escuelaing.arep.model.User;
import edu.escuelaing.arep.persistence.UserPersistence;

public class UserServiceImpl implements UserService{
	
	
	private static List<User> users;
	ConnectionDao connDao = new ConnectionDao();
	Connection conn = null;
	
	/**
	 * Agregar un usuario
	 */
	@Override
	public User addUser(User user) {
		/*List<User> users= persistence.getAllUsers();*/
		long newId = users.get(users.size()-1).getUserId() + 1;
		user.setUserId(newId);
		connDao.RetriveConnection();
		User newUser= connDao.addUser(conn, user);
		users.add(user);
		return newUser;
	}

	@Override
	/**
	 * Obtener una lista con todos los usuarios
	 */
	public List<User> getAllUsers() {
		/*List<User> users= persistence.getAllUsers();
		return users;*/
		connDao.RetriveConnection();
		users= connDao.getAllUsers(conn);
		return users;
	}

}
