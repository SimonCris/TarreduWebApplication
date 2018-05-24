package model;

import java.util.Date;

public class Utente {

	private Integer idUtente;
	private String nomeUtente;
	private String cognomeUtente;
	private Date datadiNascita;
	private String emailUtente;
	private String numeroTelefonoUtente;
	private String passwordUtente;

	// costruttore senza parametri
	public Utente() {

	}

	public void stampaUtente() {

		System.out.println("UTENTE");
		System.out.println("id -> " + idUtente);
		System.out.println("nome -> " + nomeUtente);
		System.out.println("cognome -> " + cognomeUtente);
		System.out.println("data -> " + datadiNascita);
		System.out.println("email -> " + emailUtente);
		System.out.println("tel -> " + numeroTelefonoUtente);
		System.out.println("passw -> " + passwordUtente);

	}

	// Get & set

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public Date getDatadiNascita() {
		return datadiNascita;
	}

	public void setDatadiNascita(Date datadiNascita) {
		this.datadiNascita = datadiNascita;
	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getPasswordUtente() {
		return passwordUtente;
	}

	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}

	public String getNumeroTelefonoUtente() {
		return numeroTelefonoUtente;
	}

	public void setNumeroTelefonoUtente(String numeroTelefonoUtente) {
		this.numeroTelefonoUtente = numeroTelefonoUtente;
	}
}
