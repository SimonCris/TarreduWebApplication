package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;

/**
 *Questa servlet si occupa di aggiornare la password Venditore.
 */


public class CambiaPasswordVenditore extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nuovaPassword = req.getParameter("nuovaPassword");
		String emailVenditore = (String) req.getSession().getAttribute("emailVenditoreLoggato");
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		factory.getVenditoreDAO().changePassword(emailVenditore, nuovaPassword);
		

	}

}
