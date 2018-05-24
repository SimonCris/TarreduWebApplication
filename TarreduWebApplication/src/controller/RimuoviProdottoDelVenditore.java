package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;
import persistenceDAO.UtenteDAO;
import persistenceDAO.VenditoreDAO;

public class RimuoviProdottoDelVenditore extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idProdotto = Integer.parseInt(req.getParameter("idProdotto"));

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		VenditoreDAO venditoreDao = factory.getVenditoreDAO();

		venditoreDao.rimuoviProdottoDelVenditore(idProdotto);

	}

}
