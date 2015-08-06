package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class MySQLConnection {
	private static final String DB_MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_MYSQL_URL = "jdbc:mysql://localhost/";
	private static final String DB_MYSQL_DATABASE = "hoteldb";
	private static final String DB_MYSQL_USER = "admin";
	private static final String DB_MYSQL_PASSWORD = "admin";
	
	private static MySQLConnection singleton;
	private BasicDataSource ds;
	
	private MySQLConnection(){
		
		ds = new BasicDataSource();
		ds.setDriverClassName(DB_MYSQL_DRIVER);
		ds.setUrl(DB_MYSQL_URL+DB_MYSQL_DATABASE);
		ds.setUsername(DB_MYSQL_USER);
		ds.setPassword(DB_MYSQL_PASSWORD);
		
	}
	
	public static MySQLConnection getSingleton(){
		if(singleton == null){
			singleton = new MySQLConnection();
		}
		return singleton;
	}
	
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public void closeConnection(Connection c){
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
