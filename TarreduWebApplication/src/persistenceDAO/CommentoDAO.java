package persistenceDAO;

import java.util.List;

import model.Commento;

public interface CommentoDAO {
	
	public void save(Commento commento); // Create

	public Commento findByPrimaryKey(Integer idCommento); // Retrieve

	public List<Commento> findByProduct(Integer idProdotto);

	public void update(Commento commento); // Update

	public void delete(Integer idCommento); // Delete
	
	public Commento getCommentoUtentePerProdotto(Integer idProdotto, String emailUtente);

}
