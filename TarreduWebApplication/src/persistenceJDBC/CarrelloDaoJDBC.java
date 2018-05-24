package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.ProdottoConImmagini;
import persistenceDAO.CarrelloDAO;
import persistenceDAO.DAOFactory;
import persistenceDAO.DataSource;
import persistenceDAO.PersistenceException;

public class CarrelloDaoJDBC implements CarrelloDAO {

	private DataSource dataSource;

	public CarrelloDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public Carrello findByPrimaryKey(String emailUtenteCarrello) {
		Connection connection = this.dataSource.getConnection();
		Carrello carrello = null;
		try {
			PreparedStatement statement;
			String query = "select id_prodotto,nomeProdotto,marcaProdotto,prezzoProdotto,immaginePrincipale from prodottoInCarrello as ProdCarrello , prodotto as prod where email_utenteCarrello "
					+ "= ? and prod.id_prodotto = id_prodottoInCarrello";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtenteCarrello);
			ResultSet result = statement.executeQuery();

			@SuppressWarnings("unused")
			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

			carrello = new Carrello();
			carrello.setUtenteCarello(emailUtenteCarrello);

			while (result.next()) {
				ProdottoConImmagini p = new ProdottoConImmagini();
				p.setIdProdotto(result.getInt("id_prodotto"));
				p.setNomeProdotto(result.getString("nomeProdotto"));
				p.setMarcaProdotto(result.getString("marcaProdotto"));
				p.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				p.setImmaginePrincipale(result.getString("immaginePrincipale"));

				carrello.getProdottiNelCarrello().add(p);

			}

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return carrello;
	}

	
	@Override
	public void addProduct(Prodotto p, Carrello c) {

		Connection connection = dataSource.getConnection();
		try {
			String insert = "insert into prodottoInCarrello(email_utenteCarrello, id_prodottoInCarrello) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, c.getUtenteCarrello());
			statement.setInt(2, p.getIdProdotto());

			statement.executeUpdate();
		} catch (

		SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public void removeProduct(Prodotto p, Carrello c) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM prodottoInCarrello WHERE email_utenteCarrello  = ? and id_prodottoInCarrello = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, c.getUtenteCarrello());
			statement.setInt(2, p.getIdProdotto());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public void delete(Carrello carrello) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM prodottoInCarrello WHERE email_utenteCarrello  = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, carrello.getUtenteCarrello());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public void rimuoviProdotti(List<ProdottoConImmagini> listaP, String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		StringBuilder delete = new StringBuilder();
		delete.append("delete from prodottoInCarrello where email_utenteCarrello = ? and  id_prodottoInCarrello in (");
		for (int i = 0; i < listaP.size(); i++) {
			if (i == listaP.size() - 1) {
				delete.append("?);");
			} else {
				delete.append("?,");
			}

		}

		try {
			PreparedStatement statement = connection.prepareStatement(delete.toString());
			statement.setString(1, emailUtente);

			for (int i = 2; i < listaP.size() + 2; i++) {

				statement.setInt(i, listaP.get(i - 2).getIdProdotto());

			}
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

}
