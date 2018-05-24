package persistenceDAO;

import java.util.Date;
import java.util.List;

import model.Preventivo;
import model.Prodotto;
import model.ProdottoConImmagini;
import model.Utente;

public interface UtenteDAO {

	public void save(Utente utente); // Create

	public Utente findByPrimaryKey(String emailUtente); // Retrieve

	public List<Utente> findAll();

	public void update(Utente utente, String vecchiaEmail); // Update

	public void delete(Utente utente); // Delete

	public void changePassword(String utente, String password);

	public void aggiungiProdottoInPreferiti(Integer idProdotto, String emailUtente);

	public void rimuoviProdottoInPreferiti(Integer idProdotto, String emailUtente);

	public void aggiungiProdottoInCarrello(Integer idProdotto, String emailUtente);

	public void rimuoviProdottoInCarrello(Integer idProdotto, String emailUtente);

	public void updateLoginData(String utente);

	public List<String> utentiCheNonSiLogganoDa30Giorni();

	public List<ProdottoConImmagini> getProdottiPreferitiConImmagini(String emailUtente);

	public List<Preventivo> getPreventiviUtente(String emailUtente);

	public String getNomeUtente(String emailUtente);

	public boolean giaRegistrato(String email);

	public boolean credenzialiUtenteGiaPresenti(String email, String password);

	boolean giaPreferito(Integer idProdotto, String emailUtente);

	boolean giaInCarrello(Integer idProdotto, String emailUtente);

	public Date dataNascitaUtente(String emailUtente);

	public List<Prodotto> getProdottiPerConfronto(String emailUtente);

	public boolean giaAConfronto(Integer idProdotto, String emailUtente);

	public void aggiungiProdottoAConfronto(Integer idProdotto, String emailUtente);

	public void rimuoviProdottoDaConfronto(Integer idProdotto, String emailUtente);

}
