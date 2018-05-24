package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venditore;
import persistenceDAO.DAOFactory;

/**
 * Questa servlet riceve i vari dati del venditore e li aggiorna sul db.
 */

public class AggiornaDatiPersonaliVenditore extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Venditore venditore = new Venditore();

		venditore.setNomeTitolare(req.getParameter("nome"));
		venditore.setCognomeTitolare(req.getParameter("cognome"));
		venditore.setNomeNegozio(req.getParameter("negozio"));
		venditore.setEmailVenditore(req.getParameter("email"));
		venditore.setIndirizzoVenditore(req.getParameter("indirizzoVenditore"));
		venditore.setNumeroTelefonicoVenditore(req.getParameter("recapitoTelefonicoVenditore"));
		venditore.setDescrizioneVenditore(req.getParameter("descrizioneVenditore"));

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		factory.getVenditoreDAO().update(venditore);

		req.getSession().setAttribute("emailVenditoreLoggato", venditore.getEmailVenditore());

		resp.sendRedirect("profiloVenditore");

	}

}
