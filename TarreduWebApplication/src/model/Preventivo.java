package model;

import java.sql.Connection;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import persistenceDAO.IdBuilder;
import persistenceDAO.MySqlDAOFactory;

public class Preventivo {

	private Integer idPreventivo;
	private Date dataOraPreventivo;
	private String utente;
	private List<ProdottoConImmagini> listaProdotti;
	private HashSet<String> listaVenditori;

	public Preventivo() {

		Connection connection = MySqlDAOFactory.getDataSource().getConnection();

		Integer id = IdBuilder.getId(connection);
		setIdPreventivo(id);
		dataOraPreventivo = new Date();
		

	}

	public Integer getIdPreventivo() {
		return idPreventivo;
	}

	public void setIdPreventivo(Integer idPreventivo) {
		this.idPreventivo = idPreventivo;
	}

	public Date getDataOraPreventivo() {
		return dataOraPreventivo;
	}

	public void setDataOraPreventivo(Date dataOraPreventivo) {
		this.dataOraPreventivo = dataOraPreventivo;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String idUtente) {
		this.utente = idUtente;
	}

	public List<ProdottoConImmagini> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<ProdottoConImmagini> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public void addProdotto(ProdottoConImmagini prodotto) {

		listaProdotti.add(prodotto);

	}

	public HashSet<String> getListaVenditori() {
		return listaVenditori;
	}

	public void setListaVenditori(HashSet<String> listaVenditori) {
		this.listaVenditori = listaVenditori;
	}

}
