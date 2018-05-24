package persistenceDAO;

import java.sql.*;

public class DataSource {

	final private String dbURI;// = "jdbc:mysql://tarredudb.c6p6ctnyivkj.us-east-2.rds.amazonaws.com:3306/?user=tarredu";
	final private String userName;// = "tarredu";
	final private String password;// = "tarredu01";
	

	public DataSource(String dbURI, String userName, String password) {
		this.dbURI=dbURI;
		this.userName=userName;
		this.password=password;
	}

	public Connection getConnection() throws PersistenceException {
		Connection connection = null;
		try {
		    connection = DriverManager.getConnection(dbURI,userName, password);
			
		
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return connection;
	}
}
