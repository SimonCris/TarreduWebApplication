package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import model.Venditore;
import persistenceDAO.DAOFactory;
import persistenceDAO.DataBaseManager;
import persistenceDAO.UtenteDAO;
import persistenceDAO.VenditoreDAO;

public class ValidaCredenzialiVenditore extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("emailVenditore");
		String passw = req.getParameter("passwordVenditore");

		HttpSession session = req.getSession();

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VenditoreDAO venditoreDao = factory.getVenditoreDAO();
		Venditore venditore = venditoreDao.findByPrimaryKey(email);

		if (venditoreDao.credenzialiVenditoreGiaPresenti(email, passw)) {
			session.setAttribute("venditoreLoggato", true);
			session.setAttribute("nomeVenditore", venditore.getNomeTitolare());
			session.setAttribute("emailVenditoreLoggato", venditore.getEmailVenditore());

		} else {

			req.setAttribute("passwordCorretta", false);
			session.setAttribute("venditoreLoggato", false);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(req, resp);

		}

		resp.sendRedirect("profiloVenditore");

	}
}
