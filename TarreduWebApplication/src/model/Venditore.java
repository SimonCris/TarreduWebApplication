package model;

import java.util.ArrayList;

public class Venditore {

	private Integer idVenditore;
	private String nomeTitolare;
	private String cognomeTitolare;
	private String nomeNegozio;
	private String indirizzoVenditore;
	private String emailVenditore;
	private String numeroTelefonicoVenditore;
	private String descrizioneVenditore;
	private String latitudineVenditore;
	private String longitudineVenditore;
	private String passwordVenditore;

	private ArrayList<ProdottoConImmagini> prodottiInPreventivo;

	// costruttore senza parametri
	public Venditore() {
		setProdottiInPreventivo(new ArrayList<ProdottoConImmagini>());

	}

	public Venditore(String emailVenditore) {

		this.emailVenditore = emailVenditore;

	}

	// getter & setter

	public Integer getIdVenditore() {
		return idVenditore;
	}

	public void setIdVenditore(Integer idVenditore) {
		this.idVenditore = idVenditore;
	}

	public String getNomeTitolare() {
		return nomeTitolare;
	}

	public void setNomeTitolare(String nomeTitolare) {
		this.nomeTitolare = nomeTitolare;
	}

	public String getCognomeTitolare() {
		return cognomeTitolare;
	}

	public void setCognomeTitolare(String cognomeTitolare) {
		this.cognomeTitolare = cognomeTitolare;
	}

	public String getNomeNegozio() {
		return nomeNegozio;
	}

	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}

	public String getIndirizzoVenditore() {
		return indirizzoVenditore;
	}

	public void setIndirizzoVenditore(String indirizzoVenditore) {
		this.indirizzoVenditore = indirizzoVenditore;
	}

	public String getEmailVenditore() {
		return emailVenditore;
	}

	public void setEmailVenditore(String emailVenditore) {
		this.emailVenditore = emailVenditore;
	}

	public String getNumeroTelefonicoVenditore() {
		return numeroTelefonicoVenditore;
	}

	public void setNumeroTelefonicoVenditore(String numeroTelefonicoVenditore) {
		this.numeroTelefonicoVenditore = numeroTelefonicoVenditore;
	}

	public ArrayList<ProdottoConImmagini> getProdottiInPreventivo() {
		return prodottiInPreventivo;
	}

	public void setProdottiInPreventivo(ArrayList<ProdottoConImmagini> prodottiInPreventivo) {
		this.prodottiInPreventivo = prodottiInPreventivo;
	}

	public String getDescrizioneVenditore() {
		return descrizioneVenditore;
	}

	public void setDescrizioneVenditore(String descrizioneVenditore) {
		this.descrizioneVenditore = descrizioneVenditore;
	}

	public String getLatitudineVenditore() {
		return latitudineVenditore;
	}

	public void setLatitudineVenditore(String latitudineVenditore) {
		this.latitudineVenditore = latitudineVenditore;
	}

	public String getLongitudineVenditore() {
		return longitudineVenditore;
	}

	public void setLongitudineVenditore(String longitudineVenditore) {
		this.longitudineVenditore = longitudineVenditore;
	}

	public String getPasswordVenditore() {
		return passwordVenditore;
	}

	public void setPasswordVenditore(String passwordVenditore) {
		this.passwordVenditore = passwordVenditore;
	}

	public void stampaVenditore() {
		System.out.println("Nome Titolare : " + nomeTitolare + "\n" + "Cognome Titolare : " + cognomeTitolare + "\n"
				+ "Nome Negozio : " + nomeNegozio + "\n" + "Indirizzo : " + indirizzoVenditore + "\n" + "Descrizione : "
				+ descrizioneVenditore + "\n" + "Email : " + emailVenditore + "\n" + "Password : " + passwordVenditore
				+ "\n" + "Latitudine : " + latitudineVenditore + "\n" + "Longitudine : " + longitudineVenditore);

	}

}
