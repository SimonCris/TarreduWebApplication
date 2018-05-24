package persistenceDAO;

import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.ProdottoConImmagini;

public interface ProdottoDAO {
	public void save(Prodotto prodotto); // Create

	public Prodotto findByPrimaryKey(Integer idProdotto); // Retrieve

	public List<Prodotto> findAll();

	public List<ProdottoConImmagini> findAllProductWithImages();

	public void update(Prodotto prodotto); // Update

	public void delete(Prodotto prodotto); // Delete

	public void cambioOfferta(Prodotto prodotto, boolean disponibilità);// cambia la disponibilità del prodotto

	public List<String> getImages(Integer idProdotto);

	public Boolean deleteImage(Integer idProdotto, String urlImmagine);

	public Boolean isImmaginePrincipale(Integer idProdotto, String urlImmagine);

	public Integer countImages(Integer idProdotto);

	public String getPrimaImmagine(Integer idProdotto);

	public void setImmaginePrincipale(Integer idProdotto, String urlImmagine);

	public Integer getNumberOfvisit(Integer idProdotto);

	public void visitPlusPlus(Integer idProdotto);

	public ProdottoConImmagini findByPrimaryKeyProdottoConImmagini(Integer idProdotto); // Retrieve

	public List<ProdottoConImmagini> findProductsByVenditoreProdottoConImmagini(String emailVenditore);

	public List<ProdottoConImmagini> findProductsByCarrelloProdottiConImmagini(Carrello carrello);

	public List<ProdottoConImmagini> findProductsByPrenventivoProdottiConImmagini(Integer idPreventivo);

	public List<ProdottoConImmagini> prodottiInOfferta();

	public List<ProdottoConImmagini> prodottiPerVisibilità();
	
	public List<String> getColoriprodotto(Integer idProdotto);
   
	public void removeAllColors(Integer idProdotto);
	
	public void addColors(Integer idProdotto, List<String> colori);
	
	public void addImagesToProduct(Integer idProdotto, List<String> images);
	
	public ProdottoConImmagini getProdottoPerPreventivo(Integer idProdotto);

	public List<String> getTutteLeMarche();

	public List<String> getMarchePerAmbiente(String ambiente);

}
