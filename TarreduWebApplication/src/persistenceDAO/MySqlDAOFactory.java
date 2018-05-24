package persistenceDAO;

import persistenceJDBC.CarrelloDaoJDBC;
import persistenceJDBC.CommentoDaoJDBC;
import persistenceJDBC.PreventivoDaoJDBC;
import persistenceJDBC.ProdottoDaoJDBC;
import persistenceJDBC.UtenteDaoJDBC;
import persistenceJDBC.VenditoreDaoJDBC;

@SuppressWarnings("deprecation")
public class MySqlDAOFactory extends DAOFactory {

	private static DataSource dataSource;

	// --------------------------------------------

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			setDataSource(new DataSource("jdbc:mysql://tarredudb.c8me4gj6vybs.eu-west-1.rds.amazonaws.com:3306/tarreduDB?autoReconnect=true&useSSL=false","tarredu","tarredu01"));
		} 
		catch (Exception e) {
			System.err.println("MySqlDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		MySqlDAOFactory.dataSource = dataSource;
	}

	// --------------------------------------------

	@Override
	public UtilDAO getUtilDAO() {

		return new UtilDAO(dataSource);

	}

	@Override
	public PreventivoDAO getPreventivoDAO() {

		return new PreventivoDaoJDBC(dataSource);

	}


	@Override
	public UtenteDAO getUtenteDAO() {
		
		return new UtenteDaoJDBC(dataSource);
	}

	@Override
	public VenditoreDAO getVenditoreDAO() {

		return new VenditoreDaoJDBC(dataSource);
		
	}

	@Override
	public ProdottoDAO getProdottoDAO() {

		return new ProdottoDaoJDBC(dataSource);
		
	}

	@Override
	public CarrelloDAO getCarrelloDAO() {
		return new CarrelloDaoJDBC(dataSource);
	}

	@Override
	public CommentoDAO getCommentoDAO() {
		return new CommentoDaoJDBC(dataSource);
	}
	
	
	
	
}