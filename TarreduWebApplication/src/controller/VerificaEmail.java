package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;
import persistenceDAO.UtenteDAO;

/**
 * Questa servlet al momento della registrazione
 * verifica che la mail non sia già in uso da un altro utente.
 */

public class VerificaEmail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailDaVerificare = req.getParameter("email");

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		UtenteDAO utenteDao = factory.getUtenteDAO();
		PrintWriter out = resp.getWriter();

		if (utenteDao.giaRegistrato(emailDaVerificare)) {
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
