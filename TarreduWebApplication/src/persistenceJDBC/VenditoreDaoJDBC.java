package persistenceJDBC;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import model.Preventivo;
import model.ProdottoConImmagini;
import model.Utente;
import model.Venditore;
import persistenceDAO.DAOFactory;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.VenditoreDAO;

public class VenditoreDaoJDBC implements VenditoreDAO {
	private DataSource dataSource;

	public VenditoreDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Venditore venditore) {

		Connection connection = dataSource.getConnection();

		try {

			String save = " insert into venditore(id_venditore, nomeTitolare, cognomeTitolare, "
					+ "nomeNegozio, indirizzoVenditore, emailVenditore, passwordVenditore, numeroTelefonicoVenditore, descrizioneVenditore, latitudineVenditore, longitudineVenditore) values"
					+ "(?,?,?,?,?,?,?,?,?,?,?) ";

			PreparedStatement statement = connection.prepareStatement(save);

			Integer id = IdBuilder.getId(connection);
			venditore.setIdVenditore(id);

			statement.setInt(1, id);
			statement.setString(2, venditore.getNomeTitolare());
			statement.setString(3, venditore.getCognomeTitolare());
			statement.setString(4, venditore.getNomeNegozio());
			statement.setString(5, venditore.getIndirizzoVenditore());
			statement.setString(6, venditore.getEmailVenditore());
			statement.setString(7, venditore.getPasswordVenditore());
			statement.setString(8, venditore.getNumeroTelefonicoVenditore());
			statement.setString(9, venditore.getDescrizioneVenditore());
			statement.setString(10, venditore.getLatitudineVenditore());
			statement.setString(11, venditore.getLongitudineVenditore());

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
	public Venditore findByPrimaryKey(String emailVenditore) {

		Connection connection = dataSource.getConnection();
		Venditore venditore = new Venditore();

		try {

			String find = " select * from venditore where emailVenditore = ? ";

			PreparedStatement statement = connection.prepareStatement(find);

			statement.setString(1, emailVenditore);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				venditore.setIdVenditore(result.getInt("id_venditore"));
				venditore.setNomeTitolare(result.getString("nomeTitolare"));
				venditore.setCognomeTitolare(result.getString("cognomeTitolare"));
				venditore.setNomeNegozio(result.getString("nomeNegozio"));
				venditore.setIndirizzoVenditore(result.getString("indirizzoVenditore"));
				venditore.setEmailVenditore(result.getString("emailVenditore"));
				venditore.setNumeroTelefonicoVenditore(result.getString("numeroTelefonicoVenditore"));
				venditore.setDescrizioneVenditore(result.getString("descrizioneVenditore"));
				venditore.setLatitudineVenditore(result.getString("latitudineVenditore"));
				venditore.setLongitudineVenditore(result.getString("longitudineVenditore"));
				venditore.setPasswordVenditore(result.getString("passwordVenditore"));

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

		return venditore;
	}

	@Override
	public List<Venditore> findAll() {

		Connection connection = this.dataSource.getConnection();
		List<Venditore> venditori = new LinkedList<>();

		try {

			Venditore venditore;

			String query = "select * from venditore";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				venditore = new Venditore();

				venditore.setIdVenditore(result.getInt("id_venditore"));
				venditore.setNomeTitolare(result.getString("nomeTitolare"));
				venditore.setCognomeTitolare(result.getString("cognomeTitolare"));
				venditore.setNomeNegozio(result.getString("nomeNegozio"));
				venditore.setIndirizzoVenditore(result.getString("indirizzoVenditore"));
				venditore.setEmailVenditore(result.getString("emailVenditore"));
				venditore.setNumeroTelefonicoVenditore(result.getString("numeroTelefonicoVenditore"));
				venditore.setDescrizioneVenditore(result.getString("descrizioneVenditore"));
				venditore.setLatitudineVenditore(result.getString("latitudineVenditore"));
				venditore.setLongitudineVenditore(result.getString("longitudineVenditore"));
				venditore.setPasswordVenditore(result.getString("passwordVenditore"));

				venditori.add(venditore);

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

		return venditori;
	}

	@Override
	public List<Venditore> findVenditoriByPreventivo(Integer codicePreventivo) {

		Connection connection = this.dataSource.getConnection();
		List<Venditore> venditori = new LinkedList<>();

		try {

			PreparedStatement statement;
			String query = "select * from venditoreInPreventivo where preventivoID = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, codicePreventivo);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				venditori.add(findByPrimaryKey(result.getString("venditoreEmail")));

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
		return venditori;
	}

	@Override
	public void update(Venditore venditore) {

		Connection connection = this.dataSource.getConnection();

		try {

			String update = "update venditore SET nomeTitolare = ?, cognomeTitolare = ?, nomeNegozio = ?, "
					+ "indirizzoVenditore = ?, emailVenditore = ?, numeroTelefonicoVenditore = ?, descrizioneVenditore = ?, latitudineVenditore = ?,"
					+ "longitudineVenditore=? " + "WHERE emailVenditore = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			String latLongs[] = null;
			try {
				latLongs = getLatLongPositions(venditore.getIndirizzoVenditore());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			venditore.setLatitudineVenditore(latLongs[0]);
			venditore.setLongitudineVenditore(latLongs[1]);

			statement.setString(1, venditore.getNomeTitolare());
			statement.setString(2, venditore.getCognomeTitolare());
			statement.setString(3, venditore.getNomeNegozio());
			statement.setString(4, venditore.getIndirizzoVenditore());
			statement.setString(5, venditore.getEmailVenditore());
			statement.setString(6, venditore.getNumeroTelefonicoVenditore());
			statement.setString(7, venditore.getDescrizioneVenditore());
			statement.setString(8, venditore.getLatitudineVenditore());
			statement.setString(9, venditore.getLongitudineVenditore());
			statement.setString(10, venditore.getEmailVenditore());
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
	public void delete(Venditore venditore) {

		Connection connection = this.dataSource.getConnection();

		try {

			String delete = "delete FROM venditore WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, venditore.getEmailVenditore());

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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<String> venditoriCheNonRicevonoPreventiviDa30Giorni() {
		Connection connection = this.dataSource.getConnection();
		List<String> emails = new ArrayList<String>();
		try {
			String query = "SELECT venditoreEmail from venditoreInPreventivo as V, preventivo as P where V.preventivoID = P.id_preventivo AND P.data_ora_preventivo <(curdate()- INTERVAL 30 DAY);";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				emails.add(result.getString("venditoreEmail"));
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
		return emails;

	}

	@Override
	public boolean credenzialiVenditoreGiaPresenti(String email, String passw) {

		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;

		try {

			String query = "select id_venditore FROM venditore WHERE emailVenditore = ? and passwordVenditore = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, email);
			statement.setString(2, passw);

			ResultSet result = statement.executeQuery();

			if (!result.first() == false)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public List<Preventivo> getPreventiviVenditore(String emailVenditore) {

		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;

		List<Preventivo> preventivi = new ArrayList<>();
		List<Integer> idPreventivi = new ArrayList<Integer>();

		try {

			String query = "select preventivoID FROM venditoreInPreventivo WHERE venditoreEmail = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, emailVenditore);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				idPreventivi.add(result.getInt("preventivoID"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Integer idPreventivo : idPreventivi) {
			try {

				Preventivo p = new Preventivo();

				p.setListaProdotti(new ArrayList<ProdottoConImmagini>());

				String query = "SELECT preventivo.id_preventivo, preventivo.data_ora_preventivo, preventivo.id_utente, "
						+ "prodotto.id_prodotto, prodotto.nomeProdotto, prodotto.marcaProdotto,prodotto.immaginePrincipale,"
						+ "prodotto.prezzoProdotto, venditore.emailVenditore, "
						+ "venditore.nomeNegozio FROM tarreduDB.preventivo JOIN prodottoInPreventivo, prodotto, venditorePerProdotto, "
						+ "venditore where id_preventivo = preventivoID and prodottoID = prodotto.id_prodotto and "
						+ "prodotto.id_prodotto = venditorePerProdotto.id_prodotto and "
						+ "venditorePerProdotto.emailVenditore = venditore.emailVenditore and preventivo.id_preventivo = ? order by preventivo.data_ora_preventivo DESC";
				statement = connection.prepareStatement(query);

				statement.setInt(1, idPreventivo);

				ResultSet result = statement.executeQuery();

				while (result.next()) {
					p.setIdPreventivo(result.getInt("id_preventivo"));
					p.setDataOraPreventivo(result.getDate("data_ora_preventivo"));
					DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
					Utente u = factory.getUtenteDAO().findByPrimaryKey(result.getString("id_utente"));

					p.setUtente(u.getNomeUtente() + " " + u.getCognomeUtente());

					ProdottoConImmagini prod = new ProdottoConImmagini();
					prod.setIdProdotto(result.getInt("id_prodotto"));
					prod.setNomeProdotto(result.getString("nomeProdotto"));
					prod.setMarcaProdotto(result.getString("marcaProdotto"));
					prod.setEmailVenditore(result.getString("emailVenditore"));
					prod.setNomeNegozioVenditore(result.getString("nomeNegozio"));
					prod.setImmaginePrincipale(result.getString("immaginePrincipale"));
					prod.setPrezzoProdotto(result.getDouble("prezzoProdotto"));

					p.getListaProdotti().add(prod);

				}
				preventivi.add(p);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return preventivi;

	}

	@Override
	public void rimuoviProdottoDelVenditore(Integer idProdotto) {
		Connection connection = this.dataSource.getConnection();
		StringBuilder delete = new StringBuilder();
		delete.append("delete from prodotto where id_prodotto = ?");

		try {
			PreparedStatement statement = connection.prepareStatement(delete.toString());
			statement.setInt(1, idProdotto);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}

	}

	public String[] getLatLongPositions(String address) throws Exception {
		int responseCode = 0;
		String api = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8")
				+ "&key=AIzaSyAUvzMYr08iaxtaGH2K31C7lLifLHRL2g4";

		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			;
			Document document = builder.parse(httpConnection.getInputStream());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			String status = (String) expr.evaluate(document, XPathConstants.STRING);
			if (status.equals("OK")) {
				expr = xpath.compile("//geometry/location/lat");
				String latitude = (String) expr.evaluate(document, XPathConstants.STRING);
				expr = xpath.compile("//geometry/location/lng");
				String longitude = (String) expr.evaluate(document, XPathConstants.STRING);
				return new String[] { latitude, longitude };
			} else {
				throw new Exception("Error from the API - response status: " + status);
			}
		}
		return null;
	}

	@Override
	public void changePassword(String venditore, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update venditore SET passwordVenditore = ? WHERE emailVenditore = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, venditore);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());

		}
	}

	@Override
	public boolean giaRegistrato(String email) {
		Connection connection = this.dataSource.getConnection();

		try {

			PreparedStatement statement;
			String query = "select emailVenditore from venditore where emailVenditore = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);

			ResultSet result = statement.executeQuery();

			if (!result.first() == false) {
				return true;
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

		return false;

	}

}
