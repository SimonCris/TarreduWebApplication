package persistenceDAO;

import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.ProdottoConImmagini;

public interface CarrelloDAO {

	//public void save(Carrello carrello);  // Create
	public Carrello findByPrimaryKey(String utenteCarrello);     // Retrieve
	
	//public List<Carrello> findAll();       
	
	public void addProduct(Prodotto p, Carrello c);
	public void removeProduct(Prodotto p, Carrello c);
	
	public void delete(Carrello carrello); //Delete	
	
	public void rimuoviProdotti(List<ProdottoConImmagini> listaP, String emailUtente);
	
	

   	
	
	
}
