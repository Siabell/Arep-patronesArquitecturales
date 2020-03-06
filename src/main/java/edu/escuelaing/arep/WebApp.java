package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;

public class WebApp {
	
	public static void main(String[] args) {
		port(getPort());
		final Gson gson = new Gson();
		
		get("/hello", (request, response) -> {
			
			response.type("application/json");
			String hello ="{\"lista\":\"hola\"}";
			response.status(200);
			return gson.toJsonTree(hello);
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
