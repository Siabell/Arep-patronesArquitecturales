package edu.escuelaing.arep.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDao {
	
	Connection con = null;
	public Connection RetriveConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://awsrds.cuaofirbrh2o.us-west-2.rds.amazonaws.com:3306/user","username","password");
			}catch(Exception e){ System.out.println(e);}
		return con;  
		}
}
