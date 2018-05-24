package persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* Per ovviare all'assenza di sequence in MYSQL,
 * abbiamo creato una tabella my_sequence e una funzione nextval
 * che incrementa di 1 l'iD della nuova istanza creata.
 */



public class IdBuilder {

	private static final String query = "SELECT nextval('sq_my_sequence') AS id";

	public static Integer getId(Connection connection) {
		Integer id = null;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			result.next();
			id = result.getInt("id");
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return id;
	}
}
	

