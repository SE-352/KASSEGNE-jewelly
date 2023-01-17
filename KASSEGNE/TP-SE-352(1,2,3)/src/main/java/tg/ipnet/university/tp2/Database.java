package tg.ipnet.university.tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

	Properties pro = new Properties();
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	private static final String databaseUrl = "jdbc:mysql://localhost/federations";
	private static final String username = "root";
	private static final String password = "";
	
	public Database() {
		try {
			Class.forName(driverPath);
		}catch(Exception e) {
			throw new RuntimeException("Erreur");
		}
		
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(databaseUrl, username, password);
	}

} 