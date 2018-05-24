 package model;

public class ProdottoConImmagini {

	private Integer idProdotto;
	private String nomeProdotto;
	private Double prezzoProdotto;
	private String marcaProdotto;
	private Integer visiteProdotto;
	private String richiestaAggiuntivaInPreventivo;
	private String emailVenditore;
	private String nomeNegozioVenditore;
	private String immaginePrincipale;
	private String tipoProdotto;
	private String ambienteProdotto;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("----------\n");
		builder.append("Id Prodotto : " + idProdotto + "\n");
		builder.append("Nome Prodotto : " + nomeProdotto + "\n");
		builder.append("Prezzo Prodotto : " + prezzoProdotto + "\n");
		builder.append("Numero Visite : " + visiteProdotto + "\n");
		builder.append("Marca Prodotto : " + marcaProdotto + "\n");
		builder.append("Nome Negozio : " + nomeNegozioVenditore + "\n");
		builder.append("Email venditore : " + emailVenditore + "\n");
		builder.append("===IMMAGINE PRINCIPALE===\n");

		builder.append(immaginePrincipale + "\n");

		builder.append("RICHIESTA : " + richiestaAggiuntivaInPreventivo + "\n");
		builder.append("---------\n");

		return builder.toString();

	}

	

	public Integer getVisiteProdotto() {
		return visiteProdotto;
	}

	public void setVisiteProdotto(Integer visiteProdotto) {
		this.visiteProdotto = visiteProdotto;
	}

	private String descrizioneProdotto;

	public ProdottoConImmagini() {
		visiteProdotto = 0;
	}

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

	public void stampaProdotto() {
		System.out.println("----------");
		System.out.println("Id Prodotto : " + idProdotto);
		System.out.println("Nome Prodotto : " + nomeProdotto);
		System.out.println("Prezzo Prodotto : " + prezzoProdotto);
		System.out.println("Numero Visite : " + visiteProdotto);
		System.out.println("Marca Prodotto : " + marcaProdotto);
		System.out.println("Nome Negozio : " + nomeNegozioVenditore);
		System.out.println("Email venditore : " + emailVenditore);
		System.out.println("===IMMAGINE PRINCIPALE===");

		System.out.println(immaginePrincipale);

		System.out.println("RICHIESTA : " + richiestaAggiuntivaInPreventivo);
		System.out.println("---------");

	}

	public Double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(Double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public String getMarcaProdotto() {
		return marcaProdotto;
	}

	public void setMarcaProdotto(String marcaProdotto) {
		this.marcaProdotto = marcaProdotto;
	}

	public Integer getNumeroVisite() {
		return visiteProdotto;
	}

	public void setNumeroVisite(Integer visiteProdotto) {
		this.visiteProdotto = visiteProdotto;
	}

	public String getImmaginePrincipale() {
		return immaginePrincipale;
	}

	public void setImmaginePrincipale(String immaginePrincipale) {
		this.immaginePrincipale = immaginePrincipale;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public String getRichiestaAggiuntivaInPreventivo() {
		return richiestaAggiuntivaInPreventivo;
	}

	public void setRichiestaAggiuntivaInPreventivo(String richiestaAggiuntivaInPreventivo) {
		this.richiestaAggiuntivaInPreventivo = richiestaAggiuntivaInPreventivo;
	}

	public String getEmailVenditore() {
		return emailVenditore;
	}

	public void setEmailVenditore(String emailVenditore) {
		this.emailVenditore = emailVenditore;
	}

	public String getNomeNegozioVenditore() {
		return nomeNegozioVenditore;
	}

	public void setNomeNegozioVenditore(String nomeNegozioVenditore) {
		this.nomeNegozioVenditore = nomeNegozioVenditore;
	}



	public String getAmbienteProdotto() {
		return ambienteProdotto;
	}



	public void setAmbienteProdotto(String ambienteProdotto) {
		this.ambienteProdotto = ambienteProdotto;
	}



	public String getTipoProdotto() {
		return tipoProdotto;
	}



	public void setTipoProdotto(String tipoProdotto) {
		this.tipoProdotto = tipoProdotto;
	}

}
