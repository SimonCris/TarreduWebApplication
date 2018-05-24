package model;

import java.sql.Connection;

import persistenceDAO.IdBuilder;
import persistenceDAO.MySqlDAOFactory;

public class Commento {
	private Integer idCommento;
	private String emailUtente;
	private String nomeUtente;
	private Integer idProdotto;
	private Integer valutazione;
	private String commento;

	public Commento() {

		Connection connection = MySqlDAOFactory.getDataSource().getConnection();

		Integer id = IdBuilder.getId(connection);
		setIdCommento(id);

	}

	public Integer getIdCommento() {
		return idCommento;
	}

	public void setIdCommento(Integer idCommento) {
		this.idCommento = idCommento;
	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

	public Integer getValutazione() {
		return valutazione;
	}

	public void setValutazione(Integer valutazione) {
		this.valutazione = valutazione;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public void stampaCommento() {

		System.out.println("idCommento : " + idCommento);
		System.out.println("idProdotto : " + idProdotto);
		System.out.println("emailUtente : " + emailUtente);
		System.out.println("nomeUtente : " + nomeUtente);
		System.out.println("Commento : " + commento);
		System.out.println("Valutazione : " + valutazione + "/5");

	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

}
