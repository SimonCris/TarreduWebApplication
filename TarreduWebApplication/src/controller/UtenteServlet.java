package controller;

import java.io.IOException;



import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Preventivo;
import model.Prodotto;
import model.ProdottoConImmagini;
import model.Utente;
import persistenceDAO.DAOFactory;


/**
 * Questa servlet reperisce i vari dati dell'utente loggato
 * e ne genera la pagina personale.
 */


public class UtenteServlet extends HttpServlet {

	
	private static final long serialVersionUID = 7606660061220323902L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String emailUtente = (String) req.getSession().getAttribute("emailUtenteLoggato");

		Utente utente = new Utente();

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		utente = factory.getUtenteDAO().findByPrimaryKey(emailUtente);
		req.setAttribute("utente", utente);

		List<ProdottoConImmagini> prodottiPreferiti = factory.getUtenteDAO()
				.getProdottiPreferitiConImmagini(emailUtente);
		req.setAttribute("prodottiPreferiti", prodottiPreferiti);
		
		List<Prodotto> prodottiPerConfronto = factory.getUtenteDAO()
				.getProdottiPerConfronto(emailUtente);
		req.setAttribute("prodottiPerConfronto", prodottiPerConfronto);

		List<Preventivo> listaPreventivi = factory.getUtenteDAO().getPreventiviUtente(emailUtente);
		req.setAttribute("listaPreventivi", listaPreventivi);

		RequestDispatcher dispacher = req.getRequestDispatcher("profiloUtente.jsp");
		dispacher.forward(req, resp);

	}

}