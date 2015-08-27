package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class MySQLConnection {
	private static final Logger logger = LogManager.getLogger(MySQLConnection.class.getName());

	private static MySQLConnection singleton;
	private BasicDataSource ds;
	
	private MySQLConnection(){

		Properties prop = new Properties();
		InputStream input = null;

		try {
			
			input = this.getClass().getResourceAsStream("../Resources/dbConfig.properties");
			prop.load(input);
			
			ds = new BasicDataSource();
			ds.setDriverClassName(prop.getProperty("MYSQL_DRIVER"));
			ds.setUrl(prop.getProperty("MYSQL_URL")+prop.getProperty("MYSQL_DATABASE")+prop.getProperty("UTF8"));
			ds.setUsername(prop.getProperty("MYSQL_USER"));
			ds.setPassword(prop.getProperty("MYSQL_PASSWORD"));
			

		} catch (IOException ex) {
			logger.error("Cannot access properties file", ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("Property file closing falied", e);
				}
			}
		}
		

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
			logger.error("SQL ERROR", e);
		}
	}

}
