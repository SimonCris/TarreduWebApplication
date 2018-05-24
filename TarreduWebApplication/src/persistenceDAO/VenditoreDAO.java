package persistenceDAO;

import java.util.List;

import model.Preventivo;
import model.Venditore;


public interface VenditoreDAO {

	public void save(Venditore venditore);  // Create
	public Venditore findByPrimaryKey(String emailVenditore);     // Retrieve
	public List<Venditore> findAll();       
	public void update(Venditore venditore); //Update
	public void delete(Venditore venditore); //Delete	
	
	public List<Venditore> findVenditoriByPreventivo(Integer codicePreventivo);// Trova tutti i venditori di un preventivo
	
	public List <String> venditoriCheNonRicevonoPreventiviDa30Giorni();
	public boolean credenzialiVenditoreGiaPresenti(String email, String passw);
	public List<Preventivo> getPreventiviVenditore(String emailVenditore);
	public void rimuoviProdottoDelVenditore(Integer idProdotto);
	public void changePassword(String venditore, String password);
	
	public boolean giaRegistrato(String email);
	
	
}
