package edu.escuelaing.arep.dao;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.escuelaing.arep.model.User;

public class ConnectionDao {
	
	Connection con = null;
	public Connection RetriveConnection() {
		try { 
		    String dbName = "databaseA";
            String user = "admin";
            String password = "databaseArep";
            String host = "database-1.c0heyk0s1a4l.us-east-1.rds.amazonaws.com";
            String port = "3306";
            String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?user=" + user + "&password=" + password;
			/*con=DriverManager.getConnection(  
			"jdbc:mysql://database-1.c0heyk0s1a4l.us-east-1.rds.amazonaws.com:3306/databaseA","admin","databaseArep");*/
            System.out.println("antes de conectarme");
            con=DriverManager.getConnection(jdbcUrl);
            System.out.println("me conecto");
			}catch(Exception e){ System.out.println(e);}
		return con;  
		}
	
	public List<User> getAllUsers(Connection conn){
		if(conn == null) {
			conn = RetriveConnection();
		}
		List<User> userList = new ArrayList<>();
		try {
		Statement stmt=conn.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from User");  
		System.out.println("hice consulta");
		while(rs.next())  {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setUserName(rs.getString(4));
			userList.add(user);
		}
		System.out.println("list is: "+userList.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
	}
	
	public User addUser(Connection conn,User newUser) {
		if(conn == null) {
			conn = RetriveConnection();
		}
		try {
			Statement stmt=conn.createStatement();  
			String sql = "INSERT INTO User ( name, email, userName)\r\n" + 
					"VALUES ('"+newUser.getName()+"', '"+newUser.getEmail()+"','"+newUser.getUserName()+"')";
			stmt.executeUpdate(sql);  
			System.out.println("User: "+newUser.getName());
			return newUser;
		}catch(Exception e) {
			e.printStackTrace();
		}
        return null;
    }

	
	
}
