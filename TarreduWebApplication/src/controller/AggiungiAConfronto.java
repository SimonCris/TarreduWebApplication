package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;
import persistenceDAO.UtenteDAO;

public class AggiungiAConfronto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		Integer idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
		String emailUtente = req.getParameter("emailUtente");

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		UtenteDAO utenteDao = factory.getUtenteDAO();

		utenteDao.aggiungiProdottoAConfronto(idProdotto, emailUtente);
	}

}
