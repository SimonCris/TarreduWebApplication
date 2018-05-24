package persistenceDAO;

public abstract class DAOFactory {

	// --- List of supported DAO types ---

	
	/**
	 * Numeric constant '1' corresponds to explicit MYSQL choice
	 */
	public static final int MYSQL = 1;
	
	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */
	public static final int POSTGRESQL = 2;
	
	
	// --- Actual factory method ---
	
	/**
	 * Depending on the input parameter
	 * this method returns one out of several possible 
	 * implementations of this factory spec 
	 */
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case MYSQL:
			return new MySqlDAOFactory();//new MysqldbDAOFactory();
		case POSTGRESQL:
			return null;
		default:
			return null;
		}
	}
	
	
	
	// --- Factory specification: concrete factories implementing this spec must provide this methods! ---
	
	/**
	 * Method to obtain a DATA ACCESS OBJECT
	 */

	public abstract CarrelloDAO getCarrelloDAO();

	public abstract PreventivoDAO getPreventivoDAO();
	
	public abstract VenditoreDAO getVenditoreDAO();
	
	public abstract ProdottoDAO getProdottoDAO();

	public abstract UtilDAO getUtilDAO();
	
	public abstract UtenteDAO getUtenteDAO();

	public abstract CommentoDAO getCommentoDAO();
	
}
