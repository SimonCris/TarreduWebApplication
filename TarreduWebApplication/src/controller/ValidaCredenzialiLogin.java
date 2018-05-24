package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistenceDAO.DataBaseManager;
import persistenceDAO.UtenteDAO;



/**
 * Questa servlet verifica le credenziali inserite per il login :
 * - Se vere effettua il login 
 * - Se non presenti nel db notifica l'errore.
 */


public class ValidaCredenzialiLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("emailUtente");
		String passw = req.getParameter("psw");

		HttpSession session = req.getSession();

		DataBaseManager dbManager = new DataBaseManager();
		UtenteDAO utenteDao = dbManager.getUtenteDao();
		Utente utente = new Utente();

		utente = utenteDao.findByPrimaryKey(email);
		utenteDao.updateLoginData(email);

		if (utenteDao.credenzialiUtenteGiaPresenti(email, passw)) {
			session.setAttribute("utenteLoggato", true);
			session.setAttribute("nomeUtente", utente.getNomeUtente());
			session.setAttribute("cognomeUtente", utente.getCognomeUtente());
			session.setAttribute("emailUtenteLoggato", utente.getEmailUtente());

			
		} else {

			req.setAttribute("passwordCorretta", false);
			session.setAttribute("utenteLoggato", false);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(req, resp);

		}

		resp.sendRedirect("index.jsp");

	}
}
