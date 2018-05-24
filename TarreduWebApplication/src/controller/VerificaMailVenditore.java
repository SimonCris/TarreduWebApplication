package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;
import persistenceDAO.VenditoreDAO;

/**
 * Questa servlet al momento della registrazione
 * verifica che la mail non sia già in uso da un altro utente.
 */

public class VerificaMailVenditore extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailDaVerificare = req.getParameter("email");
		
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		VenditoreDAO v = factory.getVenditoreDAO();
		PrintWriter out = resp.getWriter();

		if (v.giaRegistrato(emailDaVerificare)) {
			out.write("true");
		} else {
			out.write("false");

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
