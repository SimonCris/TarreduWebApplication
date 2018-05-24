package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	

	public String getUtenteCarello() {
		return utenteCarello;
	}

	private String utenteCarello;
	private List<ProdottoConImmagini> prodottiNelCarrello;
	
	//costruttore senza parametri
	public Carrello() {
		prodottiNelCarrello = new ArrayList<ProdottoConImmagini>();
	}
	


	public String getUtenteCarrello() {
		return utenteCarello;
	}

	public void setUtenteCarello(String utenteCarello) {
		this.utenteCarello = utenteCarello;
	}

	public List<ProdottoConImmagini> getProdottiNelCarrello() {
		return prodottiNelCarrello;
	}

	public void setProdottiNelCarrello(List<ProdottoConImmagini> prodottiNelCarrello) {
		this.prodottiNelCarrello = prodottiNelCarrello;
	}
	
	
	
	
	

}
