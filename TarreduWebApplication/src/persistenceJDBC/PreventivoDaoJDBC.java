package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Preventivo;
import model.ProdottoConImmagini;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.PreventivoDAO;

public class PreventivoDaoJDBC implements PreventivoDAO {

	private DataSource dataSource;

	public PreventivoDaoJDBC(DataSource dataSource) {

		this.dataSource = dataSource;

	}

	@Override
	public void save(Preventivo preventivo) {

		Connection connection = dataSource.getConnection();

		try {

			String save = " insert into preventivo (id_preventivo, data_ora_preventivo, id_utente) values (?,?,?) ";

			PreparedStatement statement = connection.prepareStatement(save);

			statement.setInt(1, preventivo.getIdPreventivo());

			
		    java.sql.Date sqlDate = new java.sql.Date(preventivo.getDataOraPreventivo().getTime());
			
			statement.setDate(2,sqlDate);

		
			statement.setString(3, preventivo.getUtente());

			statement.executeUpdate();

			for(ProdottoConImmagini p : preventivo.getListaProdotti()) {
				addProductToPreventivo(p, preventivo.getIdPreventivo());
			}
			
			for(String s : preventivo.getListaVenditori()) {
				addVenditoreToPreventivo(s, preventivo);
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

	}

	@Override
	public Preventivo findByPrimaryKey(Integer codicePreventivo) {
		
		return null;
		}

	@Override
	public void update(Preventivo preventivo) {

		Connection connection = this.dataSource.getConnection();

		try {

			String update = "update preventivo SET data_ora_preventivo = ?, id_utente = ? WHERE id_preventivo = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			long secs = preventivo.getDataOraPreventivo().getTime();
			statement.setDate(1, new java.sql.Date(secs));

			statement.setString(2, preventivo.getUtente());
			statement.setInt(3, preventivo.getIdPreventivo());

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
	public void delete(Preventivo preventivo) {

		Connection connection = this.dataSource.getConnection();

		try {

			// Prima di eliminare un preventivo, elimino i riferimenti nelle tabelle
			// prodottoInPreventivo
			// e venditoreInPreventivo
			String delete = "delete FROM prodottoInPreventivo WHERE preventivoID = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, preventivo.getIdPreventivo());

			statement.executeUpdate();

			delete = "delete FROM venditoreInPreventivo WHERE preventivoID = ? ";
			statement = connection.prepareStatement(delete);

			statement.setInt(1, preventivo.getIdPreventivo());

			statement.executeUpdate();

			delete = "delete FROM preventivo WHERE id_preventivo = ? ";
			statement = connection.prepareStatement(delete);

			statement.setInt(1, preventivo.getIdPreventivo());

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
	public List<Preventivo> findAll() {

return null;
	}

	


	@Override
	public void addProductToPreventivo(ProdottoConImmagini prodotto, Integer  idPreventivo) {

		Connection connection = dataSource.getConnection();

		try {

			String addProduct = "insert into prodottoInPreventivo (id_prodottoInPreventivo, preventivoID, "
					+ "prodottoID, richiestaAggiuntiva) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(addProduct);

			Integer id = IdBuilder.getId(connection);
			statement.setInt(1, id);

			statement.setInt(2, idPreventivo);
			statement.setInt(3, prodotto.getIdProdotto());
			statement.setString(4, prodotto.getRichiestaAggiuntivaInPreventivo());

			statement.executeUpdate();

//			preventivo.addProdotto(prodotto);

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
	public void addVenditoreToPreventivo(String venditore, Preventivo preventivo) {

		Connection connection = dataSource.getConnection();

		try {

			String addVenditore = "insert into venditoreInPreventivo (id_venditoreInPreventivo, venditoreEmail, "
					+ "preventivoID) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(addVenditore);

			Integer id = IdBuilder.getId(connection);
			statement.setInt(1, id);

			statement.setString(2, venditore);
			statement.setInt(3, preventivo.getIdPreventivo());

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
