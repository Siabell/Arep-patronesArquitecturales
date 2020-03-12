package edu.escuelaing.arep.persistence;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.escuelaing.arep.model.User;

public class UserPersistence {
	
	private Map<Long, User> users =  new HashMap<Long, User>();
	
	public UserPersistence() {
		
		User user1 = new User(1,"valentina siabatto","valentina@mail.com","valentina");
		User user2 = new User(2,"andres villamil","andres@mail.com","andres");
		User user3 = new User(3,"willson melo","willson@mail.com","willson");
		User user4 = new User(4,"amalia Alfonso","amalia@mail.com","amalia");
		users.put(user1.getUserId(), user1);
		users.put(user2.getUserId(), user2);
		users.put(user3.getUserId(), user3);
		users.put(user4.getUserId(), user4);
		
		
	}
	
	public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();
        for (long key : users.keySet()) {
        	System.out.println("key");
            listUsers.add(users.get(key));
        }
        return listUsers;
    }
	
	public User addUser(User newUser) {
        users.put(newUser.getUserId(), newUser);
        return newUser;
    }
	
	public User updateUser(User updateUser) {
        users.replace(updateUser.getUserId(), updateUser);
        return updateUser;
    }

	
	

}
