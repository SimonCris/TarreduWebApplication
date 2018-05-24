package model;

import java.sql.Connection;
import java.util.ArrayList;

import persistenceDAO.IdBuilder;
import persistenceDAO.MySqlDAOFactory;

public class Prodotto {

	private Integer idProdotto;
	private String nomeProdotto;
	private String tipoProdotto;
	private String marcaProdotto;
	private String ambienteProdotto;
	private Double prezzoProdotto;
	private String misureProdotto;
	private Boolean inOfferta;
	private String descrizioneProdotto;
	private String urlImmaginePrincipale;
	private ArrayList<String> urlImmaginiProdotto;
	private ArrayList<String> coloriProdotto;
	private ArrayList<Venditore> venditoriProdotto;
	private Integer numeroVisite;
	private ArrayList<Commento> commentiProdotto;

	// costruttore senza Parametri
	public Prodotto() {

		Connection connection = MySqlDAOFactory.getDataSource().getConnection();

		Integer id = IdBuilder.getId(connection);
		setIdProdotto(id);

		urlImmaginiProdotto = new ArrayList<String>();
		coloriProdotto = new ArrayList<String>();
		venditoriProdotto = new ArrayList<Venditore>();
		setCommentiProdotto(new ArrayList<Commento>());
		numeroVisite = 0;

	}

	// Getter & Setter
	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getMarcaProdotto() {
		return marcaProdotto;
	}

	public void setMarcaProdotto(String marcaProdotto) {
		this.marcaProdotto = marcaProdotto;
	}

	public String getAmbienteProdotto() {
		return ambienteProdotto;
	}

	public void setAmbienteProdotto(String ambienteProdotto) {
		this.ambienteProdotto = ambienteProdotto;
	}

	public Double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(Double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public Boolean getOffertaProdotto() {
		return inOfferta;
	}

	public void setOffertaProdotto(Boolean offertaProdotto) {
		this.inOfferta = offertaProdotto;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public ArrayList<String> getUrlImmaginiProdotto() {
		return urlImmaginiProdotto;
	}

	public void setUrlImmaginiProdotto(ArrayList<String> urlImmaginiProdotto) {
		this.urlImmaginiProdotto = urlImmaginiProdotto;
	}

	public String getMisureProdotto() {
		return misureProdotto;
	}

	public void setMisureProdotto(String misureProdotto) {
		this.misureProdotto = misureProdotto;
	}

	public String getTipoProdotto() {
		return tipoProdotto;
	}

	public void setTipoProdotto(String tipoProdotto) {
		this.tipoProdotto = tipoProdotto;
	}

	public void stampaProdotto() {

		System.out.println("Id : " + idProdotto);
		System.out.println("Nome : " + nomeProdotto);
		System.out.println("Tipo : " + tipoProdotto);
		System.out.println("Marca : " + marcaProdotto);
		System.out.println("Ambiente : " + ambienteProdotto);
		System.out.println("Prezzo : " + prezzoProdotto);
		System.out.println("Misure : " + misureProdotto);
		System.out.println("Offerta : " + inOfferta);
		System.out.println("Descrizione : " + descrizioneProdotto);
		System.out.println("IMMAGINI : ");
		System.out.println("----------------");
		for (String s : urlImmaginiProdotto) {
			System.out.println(s);
		}
		System.out.println("----------------");
		System.out.println();

		System.out.println("COLORI : ");
		System.out.println("----------------");
		for (String s : coloriProdotto) {
			System.out.println(s);
		}
		System.out.println("----------------");
		System.out.println();
	}

	public ArrayList<String> getColoriProdotto() {
		return coloriProdotto;
	}

	public void setColoriProdotto(ArrayList<String> coloriProdotto) {
		this.coloriProdotto = coloriProdotto;
	}

	public ArrayList<Venditore> getVenditoriProdotto() {
		return venditoriProdotto;
	}

	public void setVenditoriProdotto(ArrayList<Venditore> venditoriProdotto) {
		this.venditoriProdotto = venditoriProdotto;
	}

	public Integer getNumeroVisite() {
		return numeroVisite;
	}

	public void setNumeroVisite(Integer numeroVisite) {
		this.numeroVisite = numeroVisite;
	}

	public String getUrlImmaginePrincipale() {
		return urlImmaginePrincipale;
	}

	public void setUrlImmaginePrincipale(String urlImmaginePrincipale) {
		this.urlImmaginePrincipale = urlImmaginePrincipale;
	}

	public ArrayList<Commento> getCommentiProdotto() {
		return commentiProdotto;
	}

	public void setCommentiProdotto(ArrayList<Commento> commentiProdotto) {
		this.commentiProdotto = commentiProdotto;
	}

	public void setValue(String name, String value) {

		switch (name) {
		case "idProdotto": {
			this.setIdProdotto(Integer.parseInt(value));;
			break;
		}
		case "nome": {
			this.setNomeProdotto(value);
			break;
		}
		case "marca": {
			this.setMarcaProdotto(value);
			break;
		}
		case "tipo": {
			this.setTipoProdotto(value);
			break;
		}

		case "ambiente": {
			this.setAmbienteProdotto(value);
			break;
		}

		case "prezzo": {
			this.setPrezzoProdotto(Double.parseDouble(value));
			break;
		}

		case "misure": {
			this.setMisureProdotto(value);
			break;

		}

		case "colori": {
			String colori = value;

			String[] coloriSingoli = colori.split(",");

			for (String s : coloriSingoli) {
				s = s.replaceAll("\\s", "");
				this.getColoriProdotto().add(s);

			}
			break;
		}

		case "descrizioneProdotto": {
			this.setDescrizioneProdotto(value);
			break;
		}

		case "prodottoInOfferta": {
			if (value.equals("1")) {
				this.setOffertaProdotto(true);
				break;
			} else {
				this.setOffertaProdotto(false);
				break;

			}

		}

		}

	}
}