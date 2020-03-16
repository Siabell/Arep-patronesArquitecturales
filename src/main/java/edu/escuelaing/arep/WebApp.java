package edu.escuelaing.arep;
import static spark.Spark.*;

import edu.escuelaing.arep.model.User;
import edu.escuelaing.arep.service.UserService;
import edu.escuelaing.arep.service.UserServiceImpl;

import com.google.gson.Gson;

public class WebApp {
	
	public static void main(String[] args) {
		port(getPort());
		staticFiles.location("/web");
		
		final Gson gson = new Gson();
		UserService  userService = new UserServiceImpl();
		System.out.println("entra antes post y get");
		
		post("/users", (request, response) -> {
		    response.type("application/json");
		    User user = new Gson().fromJson(request.body(), User.class);
		    //userService.addUser(user);
		 
		    return new Gson().toJson(
				      new StandardResponse(StatusResponse.SUCCESS,new Gson()
				        .toJsonTree(userService.addUser(user))));
		});
		get("/users", (request, response) -> {
		    response.type("application/json");
		    System.out.println("en get");
		    return new Gson().toJson(
		      new StandardResponse(StatusResponse.SUCCESS,new Gson()
		        .toJsonTree(userService.getAllUsers())));
		});
		

	}
		

	
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
			}
			return 4567; 
			 //returns default port if heroku-port isn't set (i.e. on localhost)
	}
}
