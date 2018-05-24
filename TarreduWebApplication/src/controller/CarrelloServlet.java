package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import persistenceDAO.DAOFactory;

/**Questa servlet ricevuta un email utente reperisce tutti i 
 * prodotti dentro il suo carrello e genera la pagina corrispondente.
 */



public class CarrelloServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String emailUtente = (String) session.getAttribute("emailUtenteLoggato");
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		Carrello carrello = factory.getCarrelloDAO().findByPrimaryKey(emailUtente);
		
		req.setAttribute("prodottiNelCarrello", carrello.getProdottiNelCarrello());

		RequestDispatcher dispacher = req.getRequestDispatcher("carrello.jsp");
		dispacher.forward(req, resp);

	}

}
