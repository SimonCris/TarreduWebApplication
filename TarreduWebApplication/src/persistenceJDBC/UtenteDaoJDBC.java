package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Preventivo;
import model.Prodotto;
import model.ProdottoConImmagini;
import model.Utente;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.UtenteDAO;

public class UtenteDaoJDBC implements UtenteDAO {

	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public void save(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String insert = "insert into utente(utente_id, nome, cognome, dataNascita, email, numeroTelefonico, passwordUtente) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			Integer id = IdBuilder.getId(connection);
			utente.setIdUtente(id);

			statement.setInt(1, id);
			statement.setString(2, utente.getNomeUtente());
			statement.setString(3, utente.getCognomeUtente());

			long secs = utente.getDatadiNascita().getTime();
			statement.setDate(4, new java.sql.Date(secs));

			statement.setString(5, utente.getEmailUtente());
			statement.setString(6, utente.getNumeroTelefonoUtente());
			statement.setString(7, utente.getPasswordUtente());

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
	public Utente findByPrimaryKey(String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setIdUtente(result.getInt("utente_id"));
				utente.setNomeUtente(result.getString("nome"));
				utente.setCognomeUtente(result.getString("cognome"));
				long secs = result.getDate("dataNascita").getTime();
				utente.setDatadiNascita(new java.util.Date(secs));
				utente.setEmailUtente(result.getString("email"));
				utente.setNumeroTelefonoUtente(result.getString("numeroTelefonico"));
				utente.setPasswordUtente(result.getString("passwordUtente"));

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
		return utente;
	}

	@Override
	public List<Utente> findAll() {
		return null;
	}

	@Override
	public void update(Utente utente, String vecchiaEmail) {

		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET nome = ?, cognome = ?, dataNascita = ?, email = ?, numeroTelefonico = ? WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getNomeUtente());
			statement.setString(2, utente.getCognomeUtente());
			long secs = utente.getDatadiNascita().getTime();
			statement.setDate(3, new java.sql.Date(secs));
			statement.setString(4, utente.getEmailUtente());
			statement.setString(5, utente.getNumeroTelefonoUtente());
			statement.setString(6, vecchiaEmail);
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
	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getEmailUtente());
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
	public void changePassword(String utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET passwordUtente = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, utente);
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
	public void aggiungiProdottoInPreferiti(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			String insert = "insert into prodottiPreferiti(id_prodotto, emailUtente) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
	public void rimuoviProdottoInPreferiti(Integer idProdotto, String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "delete FROM prodottiPreferiti WHERE id_prodotto = ? and emailUtente = ?";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
	public List<ProdottoConImmagini> getProdottiPreferitiConImmagini(String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new ArrayList<ProdottoConImmagini>();
		@SuppressWarnings("unused")
		ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);

		try {

			PreparedStatement statement;
			String query = "SELECT prodotto.id_prodotto, nomeProdotto, immaginePrincipale, descrizioneProdotto "
					+ "FROM tarreduDB.prodottiPreferiti JOIN tarreduDB.prodotto where "
					+ "prodottiPreferiti.id_prodotto = prodotto.id_prodotto and " + "prodottiPreferiti.emailUtente=?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				ProdottoConImmagini prodotto = new ProdottoConImmagini();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setDescrizioneProdotto(result.getString("descrizioneProdotto"));
				prodotto.setImmaginePrincipale(result.getString("immaginePrincipale"));

				prodotti.add(prodotto);
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

		return prodotti;
	}

	@Override
	public boolean giaPreferito(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			PreparedStatement statement;
			String query = "select id_prodotto from prodottiPreferiti where emailUtente = ? and id_prodotto = ? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);
			statement.setInt(2, idProdotto);

			ResultSet result = statement.executeQuery();

			if (!result.first() == false) {
				System.out.println("no data");
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

	@Override
	public boolean giaInCarrello(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			PreparedStatement statement;
			String query = "select id_prodottoInCarrello from prodottoInCarrello where email_utenteCarrello = ? and id_prodottoInCarrello = ? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);
			statement.setInt(2, idProdotto);

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

	@Override
	public boolean giaRegistrato(String email) {

		Connection connection = this.dataSource.getConnection();

		try {

			PreparedStatement statement;
			String query = "select email from utente where email = ?";
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

	@Override
	public boolean credenzialiUtenteGiaPresenti(String email, String password) {

		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;

		try {

			String query = "select * FROM utente WHERE email = ? and passwordUtente = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, email);
			statement.setString(2, password);

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
	public String getNomeUtente(String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;

		String nomeUtente = null;

		try {

			String query = "select nome FROM utente WHERE email = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				nomeUtente = result.getString("nome");
				return nomeUtente;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public void aggiungiProdottoInCarrello(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			String insert = "insert into prodottoInCarrello(id_prodottoInCarrello, email_utenteCarrello) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
	public void rimuoviProdottoInCarrello(Integer idProdotto, String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "delete FROM prodottoInCarrello WHERE id_prodottoInCarrello = ? and email_utenteCarrello = ?";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
	public List<Preventivo> getPreventiviUtente(String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;

		List<Preventivo> preventivi = new ArrayList<>();
		List<Integer> idPreventivi = new ArrayList<Integer>();

		try {

			String query = "select * FROM preventivo WHERE id_utente = ? order by data_ora_preventivo DESC";
			statement = connection.prepareStatement(query);

			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				idPreventivi.add(result.getInt("id_preventivo"));

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
						+ "venditorePerProdotto.emailVenditore = venditore.emailVenditore and preventivo.id_preventivo = ?";
				statement = connection.prepareStatement(query);

				statement.setInt(1, idPreventivo);

				ResultSet result = statement.executeQuery();

				while (result.next()) {
					p.setIdPreventivo(result.getInt("id_preventivo"));
					p.setDataOraPreventivo(result.getDate("data_ora_preventivo"));
					p.setUtente(result.getString("id_utente"));

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
	public Date dataNascitaUtente(String emailUtente) {
		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;
		try {

			String query = "select dataNascita FROM utente WHERE email = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = format.parse(result.getString("dataNascita"));
					return date;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		return null;
	}

	@Override
	public void updateLoginData(String utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente set dataUltimoAccesso = CURDATE()  where email = ?;";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente);

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
	public List<String> utentiCheNonSiLogganoDa30Giorni() {
		Connection connection = this.dataSource.getConnection();
		List<String> emails = new ArrayList<String>();
		try {
			String query = "select email from utente where dataUltimoAccesso <(curdate()- INTERVAL 30 DAY);";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				emails.add(result.getString("email"));
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
	public List<Prodotto> getProdottiPerConfronto(String emailUtente) {

		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		@SuppressWarnings("unused")
		ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);

		try {

			PreparedStatement statement;
			String query = "SELECT prod.id_prodotto, prod.nomeProdotto, prod.marcaProdotto, "
					+ "prod.tipoProdotto, prod.ambienteProdotto, prod.misureProdotto, "
					+ "prod.prezzoProdotto FROM tarreduDB.prodotto as prod JOIN "
					+ "tarreduDB.prodottiPerConfronto as conf WHERE "
					+ "prod.id_prodotto = conf.id_prodotto and conf.emailUtente = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Prodotto prodotto = new Prodotto();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setTipoProdotto(result.getString("tipoProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setMisureProdotto(result.getString("misureProdotto"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));

				prodotti.add(prodotto);
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

		return prodotti;

	}

	@Override
	public boolean giaAConfronto(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			PreparedStatement statement;
			String query = "select id_prodotto from prodottiPerConfronto where emailUtente = ? and id_prodotto = ? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);
			statement.setInt(2, idProdotto);

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

	@Override
	public void aggiungiProdottoAConfronto(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			String insert = "insert into prodottiPerConfronto(id_prodotto, emailUtente) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
	public void rimuoviProdottoDaConfronto(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "delete FROM prodottiPerConfronto WHERE id_prodotto = ? and emailUtente = ?";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
